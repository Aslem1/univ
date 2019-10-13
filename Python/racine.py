import math
# print(math.sqrt(x))

x = input ("Entrez un nombre : ")
x = float(x)
if   x >= 0  :
    print ("La racine carrée de" , x , "est" , math.sqrt(x))
else :
    print ("Erreur")