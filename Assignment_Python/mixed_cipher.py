keyword = input('Please enter a keyword for the mixed cipher: ')
keyword = keyword.lower()
lst_keyword = list(map(lambda e:e, keyword))

lst_keyword = list(dict.fromkeys(lst_keyword))

plain_text = 'abcdefghijklmnopqrstuvwxyz'
print("Plaintext:", plain_text)

lst_plain_text = list(map(lambda e:e, plain_text))
lst_check = list(map(lambda e:e, plain_text))

for i in range(len(lst_keyword)):
    lst_plain_text.remove(lst_keyword[i])
    
plain_text = ""
keyword = ""

for e in lst_plain_text:
    plain_text += e
    
for e in lst_keyword:
    keyword += e
    
ciphered_text = keyword + plain_text
print("Ciphertext:", ciphered_text)
lst_ciphered = list(map(lambda e:e, ciphered_text))


file = open('mixed_text.txt', 'r')
file_words = file.read()

lst_file_words = list(map(lambda e:e, file_words))
ciphered_text = ""

i = 0

for element in lst_file_words:
    if ((ord(element) <= 65 or ord(element) >= 90) and (ord(element) <= 95 or ord(element) >= 122)):
        ciphered_text += element
        continue
    elif (element.isupper()):
        element = element.lower()
        i = lst_check.index(element)
        element = lst_ciphered[i]
        ciphered_text += element.upper()
        continue
    else:
        i = lst_check.index(element)
        element = lst_ciphered[i]
        ciphered_text += element
        
print(ciphered_text)


