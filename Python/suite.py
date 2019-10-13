print ("Nous allons écrire les n premiers termes de la suite arithmétique u(n+1) = u(n) + r.")
u = float (input("u0 ?"))
r = float (input("r ?"))
n = int (input("n ?"))

if n <= 0 :
    print ("Valeur de n incorrecte, il doit être supérieur à 0.")
else :
    for i in range (n):
        print (u+i*r)
    