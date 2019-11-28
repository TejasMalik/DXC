import time

def log(*args, **kwargs):
    def logger(func):
        def the_wrapper(*lst):
            start = time.clock()
            print('*************************************************')
            if (len(args) == 0):
                print('$ python log.py')
            else:
                print('$ more', *args)
            print('*************************************************')
            type_of = str(func)
            type_of = (type_of.split())[1]
            print('Calling Function', type_of)
            if (len(lst) == 0):
                print('no arguments.')
            else:
                print('Arguments:')
                for e in lst:
                    type_of = str(type(e))
                    type_of = type_of.replace(' ','')
                    type_of = type_of.replace('class','')
                    type_of = type_of.replace('<', '')
                    type_of = type_of.replace('>','')
                    type_of = type_of.replace("'",'')
                    print('-', e,'of type',type_of)                
            print('Output:')
            result = func(*lst)
            time_of = time.clock()-start
            print('Execution Time:', time_of)
            if (type(result) != type(print(end=''))):
                type_of = str(type(result))
                type_of = type_of.replace(' ','')
                type_of = type_of.replace('class','')
                type_of = type_of.replace('<', '')
                type_of = type_of.replace('>','')
                type_of = type_of.replace("'",'')
                print('Return Value:',result,"of type",type_of)
            else:
                print('no return value')
        return the_wrapper
    return logger


@log()
def factorial(*num_list):
    results = []
    for number in num_list:
        res = number
        for i in range(number-1,0,-1):
            res = i*res
        results.append(res)
    return results


@log('logger.txt')
def waste_time(a, b, c):
    print("Wasting time.")
    time.sleep(5)
    return a, b, c


@log('logger.txt')
def gcd(a, b):
    print("The GCD of", a, "and", b, "is ", end="")
    while a!=b:
        if a > b:
            a -= b
        else:
            b -= a
    print(abs(a))
    return abs(a)


@log()
def print_hello():
    print("Hello!")
    
    
@log(10)
def print_goodbye():
    print("Goodbye!")

    
    
if __name__ == "__main__":
    factorial(4, 5)
    waste_time("one", 2, "3")
    gcd(15,9)
    print_hello()
    print_goodbye()


