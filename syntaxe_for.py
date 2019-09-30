for x in range (1,6):
    print (x, end = ' ')
    
print ("\n" *2 + "*" * 15 + "\n")

a= int (input ("a ? "))
b = int (input ("b ?"))

produit_ab = 0

if b < a: 
    for n in range (0 , b):
        produit_ab = produit_ab + a
else:
    for n in range (0 , a):
        produit_ab = produit_ab + a

assert (produit_ab == a*b)
print ("{} * {} = {}".format (a, b, produit_ab)) 