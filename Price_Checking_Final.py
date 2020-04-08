# Importing Libraries
import math
from shapely.geometry import Polygon
import numpy as np
import os,io
from google.cloud import vision
from google.cloud.vision import types
import json
from google.protobuf.json_format import MessageToJson
import re



detected_obj = {'puffed_wheat': [[412,235,410,390,518,391,523,237]],
        
 'nature_promise_raisin': [[519,58,514,203,615,200,619,60]],
 'nature_promise_nut': [[399,56,396,208,500,206,497,57]],
 'puffed_rice': [[298,236,296,389,405,392,407,235]],
 'shredded_wheat': [[388,598,389,731,479,733,487,599],
  [523,242,518,393,619,390,623,246]],
 'oats': [[191,241,194,388,293,390,292,240]],
 'chocos_125g': [[194,790,191,898,284,896,280,789], [304,809,302,892,372,891,372,810]]
       }

# Image Location
file_name='test1.jpg'
folder_path=r'C:\Ahold'

# Get all Text Coordinates from GCP
def google_text_detection(file_name, folder_path):
    os.environ['GOOGLE_APPLICATION_CREDENTIALS']=r'unified-skein-267807-7e4a724af631.json'
    client=vision.ImageAnnotatorClient()
    
    with io.open(os.path.join(folder_path,file_name),'rb') as image_file:
        content = image_file.read()
    
    image=vision.types.Image(content=content)
    response=client.text_detection(image=image)
    
    texts = response.text_annotations
    
    all_str = ''
    
    for text in texts:
        all_str = all_str + '\n"{}"'.format(text.description)
        vertices = (['({},{})'.format(vertex.x, vertex.y)
        for vertex in text.bounding_poly.vertices])
        all_str = all_str + 'bounds: {}'.format(','.join(vertices))
        
    return all_str


# String Manupulation
all_str = google_text_detection(file_name, folder_path)

all_str = all_str.replace('\n', '')


list_text = []
i = 0
while i<len(all_str):
    if all_str[i] == '"':
        i += 1
        temp1 = i
        j = i
        while j<len(all_str):
            if all_str[j] == '"':
                temp2 = j
                i = j
                list_text.append(all_str[temp1:temp2])
                break
            j += 1
    i += 1
    

list_text.pop(0)



list_bounds = []
i = 0
while i<len(all_str):
    if all_str[i:i+6] == 'bounds':
        i += 1
        temp1 = i
        j = i
        while j<len(all_str):
            if all_str[j] == '"' or j == len(all_str) - 1:
                temp2 = j
                i = j
                list_bounds.append(all_str[temp1:temp2])
                break
            j += 1
    i += 1
    
list_bounds.pop(0)



for i in range(len(list_bounds)):
    list_bounds[i] = list_bounds[i].replace('ounds:', '')
    list_bounds[i] = list_bounds[i].replace(' ', '')
    list_bounds[i] = list_bounds[i].replace('(', '')
    list_bounds[i] = list_bounds[i].replace(')', '')
    
    
for i in range(len(list_bounds)):
    list_bounds[i] = list_bounds[i].split(',')
    
    
for i in range(len(list_bounds)):
    for j in range(len(list_bounds[i])):
        list_bounds[i][j] = int(list_bounds[i][j])
        
        
        
for i in range(len(list_bounds)):
    list_bounds[i] = [(list_bounds[i][0], list_bounds[i][1]),(list_bounds[i][2], list_bounds[i][3]),(list_bounds[i][4], list_bounds[i][5]),(list_bounds[i][6], list_bounds[i][7])]



# Storing all coordinates in dictionary with their respective texts 
dict_all_text_cood = {}
for i in range(len(list_bounds)):
    if list_text[i] in dict_all_text_cood.keys():
        dict_all_text_cood[list_text[i]].append(list_bounds[i])
        continue
    dict_all_text_cood[list_text[i]] = [list_bounds[i]]
    
  
actual_obj_length = {
    'rack': 2.5,
    'nature_promise_nut': 12,
    'nature_promise_raisin': 12,
    'oats': 12,
    'puffed_rice': 12,
    'puffed_wheat': 12,
    'shredded_wheat': 12,
    'chocos_125g': 9
}


rack = actual_obj_length['rack']
del actual_obj_length['rack']


# Euclidian Distance
def distance_cood(list_of_coods):
    p1 = (list_of_coods[0], list_of_coods[2])
    p2 = (list_of_coods[1], list_of_coods[3])
    height = math.sqrt(((abs(p1[0] - p1[1]))**2) + ((abs(p2[0] - p2[1]))**2))
    
    return height


# Calculate height of the products from detected objects
def calc_length(detected_obj):
    dict_lengths = {}
    for key in detected_obj.keys():
        length_of_all = []
        l = detected_obj[key]
        for i in range(len(l)):
            list_of_coods_left = l[i][0:4]
            list_of_coods_right = l[i][4:8]
            length = [distance_cood(list_of_coods_left), distance_cood(list_of_coods_right)]
            length_of_all.append(length)
        dict_lengths[key] = length_of_all
    return dict_lengths




detected_obj_length = calc_length(detected_obj)


# Calculate the ratio for each product
def ratios(detected_obj_length, actual_obj_length):
    dict_ratios = {}
    for key in detected_obj_length.keys():
        ratio_of_all = []
        l = detected_obj_length[key]
        for i in range(len(l)):
            ratio1 = l[i][0]/actual_obj_length[key]
            ratio2 = l[i][1]/actual_obj_length[key]
            ratios = [ratio1, ratio2]
            ratio_of_all.append(ratios)
        dict_ratios[key] = ratio_of_all
    return dict_ratios



detected_obj_ratios = ratios(detected_obj_length, actual_obj_length)


# Getting the median of all the ratios
def calc_median(detected_obj_ratios):
    l_left = []
    l_right = []
    for key in detected_obj_ratios:
        l = detected_obj_ratios[key]
        for i in range(len(l)):
            l_left.append(l[i][0])
            l_right.append(l[i][1])
    sorted(l_left)
    sorted(l_right)
    return [l_left[len(l_left)//2], l_right[len(l_right)//2]]


median = calc_median(detected_obj_ratios)


rack = [rack*median[0], rack*median[1]]


# Calculating Respective Rack Coordinates of the products
def rack_cood(detected_obj, rack):
    dict_rack = {}
    for key in detected_obj.keys():
        cood_of_rack = []
        l = detected_obj[key]
        for i in range(len(l)):
            cood_of_single_rack = [[max(l[i][0], l[i][2]), l[i][3]], [max(l[i][0], l[i][2]), (l[i][3] + rack[0])], [max(l[i][4], l[i][6]), (l[i][5] + rack[1])], [max(l[i][4], l[i][6]), l[i][5]]]
            
            cood_of_rack.append(cood_of_single_rack)
        dict_rack[key] = cood_of_rack
    return dict_rack



res_cood = rack_cood(detected_obj, rack)


# Euclidian Distance and returning 10% of length
def distance_length_cood(list_of_coods):
    p1 = (list_of_coods[0][0], list_of_coods[3][0])
    p2 = (list_of_coods[0][1], list_of_coods[3][1])
    length = math.sqrt(((abs(p1[0] - p1[1]))**2) + ((abs(p2[0] - p2[1]))**2))
    
    length = 0.1*length
    
    return length

# Increasing the rack coordinates by extra 10% of their length 
res_cood_1 = rack_cood(detected_obj, rack)
for key in res_cood.keys():
    l = res_cood_1[key]
    for i in range(len(l)):
        length = distance_length_cood(l[i])
        l[i] = [[l[i][0][0] - length, l[i][0][1]], [l[i][1][0] - length, l[i][1][1]], [l[i][2][0] + length, l[i][2][1]], [l[i][3][0] + length, l[i][3][1]]]


# Getting the price coordinates from GCP
text_cood = {}
for key in dict_all_text_cood.keys():
    if key[0] == '$':
        text_cood[key] = dict_all_text_cood[key]


# Calculating intersection area
def calculate_intersection(box_1, box_2):
    poly_1 = Polygon(box_1)
    poly_2 = Polygon(box_2)
    intersection_area = poly_1.intersection(poly_2).area
    return intersection_area


# Euclidian Distance and returning n% of length
def distance_length_rack_cood(list_of_coods, n):
    p1 = (list_of_coods[0][0], list_of_coods[3][0])
    p2 = (list_of_coods[0][1], list_of_coods[3][1])
    length = math.sqrt(((abs(p1[0] - p1[1]))**2) + ((abs(p2[0] - p2[1]))**2))  
    length = n*length  
    return length

# Decreasing the length of rack by n%
def set_cood(l, n):
    length = distance_length_rack_cood(l, n)
    l = [[l[0][0] + length, l[0][1]], [l[1][0] + length, l[1][1]], [l[2][0] - length, l[2][1]], [l[3][0] - length, l[3][1]]]
    return l

# Checking overlap of the rack and text area and decreasing the length until intersection area is zero
def check_overlap_rack(res_cood):
    rack_list = []
    l_of_rack = []
    l_of_rack_cood = []
    final_dict = {}

    for key in res_cood.keys():
        l = res_cood[key]
        for i in range(len(l)):
            l_of_rack.append(key)
            l_of_rack_cood.append(l[i])
            
    for i in range(len(l_of_rack_cood)):
        final_list = []
        box1 = l_of_rack_cood[i]
        n = 0.01
        for j in range(len(l_of_rack_cood)):
            if (i == j):
                continue
            box2 = l_of_rack_cood[j]
            area = calculate_intersection(box1, box2)
            if area != 0:
                j -= 1
                l_of_rack_cood[i] = set_cood(l_of_rack_cood[i], n)
                l_of_rack_cood[j] = set_cood(l_of_rack_cood[j], n)
                n += 0.01
                continue
            final_list.append(calculate_intersection(box1, box2))
            
        rack_list.append(final_list)
        
    
    for i in range(len(l_of_rack)):
        if l_of_rack[i] in final_dict.keys():
            list_change = final_dict[l_of_rack[i]]
            list_change.append(l_of_rack_cood[i])
        else:
            final_dict[l_of_rack[i]] = [l_of_rack_cood[i]]

    return final_dict




res_cood = check_overlap_rack(res_cood_1)

# Checking intersection area of price and rack
def check_overlap(text_cood_four, res_cood):
    dict_area = {}
    for rack_key in res_cood.keys():
        area_of_text = []
        l_rack = res_cood[rack_key]
        for i in range(len(l_rack)):
            l = []
            box_1 = l_rack[i]
            for text_key in text_cood_four.keys():
                l_text = text_cood_four[text_key]
                for i in range(len(l_text)):
                    box_2 = l_text[i]
                    area_overlap = calculate_intersection(box_1, box_2)
                    l.append(area_overlap)
            area_of_text.append(l)
        dict_area[rack_key] = area_of_text
    return dict_area


dict_res = check_overlap(text_cood, res_cood)


# Calculating area of a rectangle
def area_text(list_text_cood):
    poly_text = Polygon(list_text_cood)
    area = poly_text.area
    return area


# Getting Product Prices and storing it in a dictionary with their respective ratio of intersection
def price_matching(dict_res, text_cood):
    dict_price = {}
    l_of_text = []
    l_of_text_cood = []

    for key in text_cood.keys():
        l = text_cood[key]
        for i in range(len(l)):
            l_of_text.append(key)
            l_of_text_cood.append(l[i])
    
    for key in dict_res.keys():
        l_check = []
        l = dict_res[key]
        for i in range(len(l)):
            if (max(l[i]) == 0):
                l_check.append('Price is Missing')
                dict_price[key] = l_check
                continue
            else:
                for j in range(len(l[i])):
                    if l[i][j] == 0:
                        continue
                    else:
                        l_check.append([l_of_text[j], (l[i][j]/area_text(l_of_text_cood[j]))])
                dict_price[key] = l_check
    return dict_price



dict_price = price_matching(dict_res, text_cood)
    
    
dict_results = check_overlap(dict_all_text_cood, res_cood)


# Getting all the text in product rack coordinates
def final_price_matching(dict_res, text_cood):
    dict_price = {}
    l_of_text = []
    l_of_text_cood = []

    for key in text_cood.keys():
        l = text_cood[key]
        for i in range(len(l)):
            l_of_text.append(key)
            l_of_text_cood.append(l[i])
    
    for key in dict_res.keys():
        l_check = []
        l = dict_res[key]
        for i in range(len(l)):
            if (max(l[i]) == 0):
                l_check.append('No Text')
                dict_price[key] = l_check
                continue
            else:
                final_list = []
                for j in range(len(l[i])):
                    if l[i][j] == 0:
                        continue
                    else:
                        if l[i][j]/area_text(l_of_text_cood[j]) < 0.5:
                            continue
                        final_list.append(l_of_text[j])
                l_check.append(final_list)
                dict_price[key] = l_check
    return dict_price




final_dict = final_price_matching(dict_results, dict_all_text_cood)


# String Manpulation
for key in final_dict.keys():
    l = final_dict[key]
    for i in range(len(l)):
        if l[i] == 'No Text':
            continue
        elif l[i] == []:
            l[i] = 'No Text'
        else:
            for j in range(len(l[i])):
                if l[i][j][0] == '$':
                    l[i].pop(j)
                else:
                    l[i][j] = l[i][j].lower()
            l[i] = ["_".join(l[i])]
            

# String Matching Levenshtein Distance
def levenshtein(seq1, seq2):
    size_x = len(seq1) + 1
    size_y = len(seq2) + 1
    matrix = np.zeros ((size_x, size_y))
    for x in range(size_x):
        matrix [x, 0] = x
    for y in range(size_y):
        matrix [0, y] = y

    for x in range(1, size_x):
        for y in range(1, size_y):
            if seq1[x-1] == seq2[y-1]:
                matrix [x,y] = min(
                    matrix[x-1, y] + 1,
                    matrix[x-1, y-1],
                    matrix[x, y-1] + 1
                )
            else:
                matrix [x,y] = min(
                    matrix[x-1,y] + 1,
                    matrix[x-1,y-1] + 1,
                    matrix[x,y-1] + 1
                )
    return (matrix[size_x - 1, size_y - 1])


# Label Matching of the products
for key in final_dict.keys():
    l = final_dict[key]
    for i in range(len(final_dict[key])):
        if l[i] == 'No Text':
            continue
        else:
            if (levenshtein(key, l[i][0]) > 2):
                l[i].append('Mismatched Price Tag')
            else:
                l[i].append('Matched Price Tag')
                
                
                
                
# Storing the price and label name in a combined dictionary
def all_dict(final_dict, detected_obj, dict_price):
    con_dict = {}
    
    list_of_names = []
    list_of_coods = []
    list_of_price = []
    list_of_area = []
    list_of_label = []
    list_of_label_status = []
    
    for key in detected_obj.keys():
        l = detected_obj[key]
        for i in range(len(l)):
            list_of_names.append(key)
            list_of_coods.append(l[i])

            
    for key in final_dict.keys():
        l = final_dict[key]
        for i in range(len(l)):
            if l[i] == 'No Text':
                list_of_label.append(l[i])
                list_of_label_status.append(l[i])
                continue
            list_of_label.append(l[i][0])
            list_of_label_status.append(l[i][1])
            
    
    for key in dict_price.keys():
        l = dict_price[key]
        for i in range(len(l)):
            if l[i] == 'Price is Missing':
                list_of_price.append(l[i])
                list_of_area.append(l[i])
                continue
            list_of_price.append(l[i][0])
            list_of_area.append(l[i][1])
            
                        
    for i in range(len(list_of_coods)):
        temp_dict = {'Price' : '',
                 'Ratio of Area of Intersection' : 0,
                 'Actual Name' : '',
                 'Label Name' : '',
                 'Status of Label' : ''}
        
        temp_dict['Actual Name'] = list_of_names[i]
        temp_dict['Label Name'] = list_of_label[i]
        temp_dict['Status of Label'] = list_of_label_status[i]
        temp_dict['Price'] = list_of_price[i]
        temp_dict['Ratio of Area of Intersection'] = list_of_area[i]
        
        con_dict[str(list_of_coods[i])] = temp_dict
        
        
    return con_dict
        
        
        
final_price_matching = all_dict(final_dict, detected_obj, dict_price)
    