#À l’aide d’une boucle for, montrer que 97 est premier.
n = 97
N=1000
for i in range (2,n):
    if n % i == 0:
        print ("{} n'est pas premier : {}".format(n,i))
        break
else:
    print ("{} est premier".format(n))
    
    
#En réutilisant ce code dans le parcours des entiers entre 2 et 1000, construire la liste P des nombres premiers inférieurs à 1000.
"""
n=1000
tableau = [2,1000] + [i for i in range (2,n)]
for i in range (2,n):
    if tableau > i:
        print ("{} n'est pas premier : {}".format(n,i))
        break
else:
    print ("{} est premier".format(n))
"""

# Stratégie 1 
print ("Début P")
P = []
for i in range (2, N+1): #Nombres pour lesquels on va tester la primalité
    #print (f"(n): " end=""):
    for i in range (2, n):
         #print (f"(i): " end=","):
        if n % i ==0:
            #print ("--")
            break
    else:
        P.append(n)
print (f"Il y a {len(P)} nombres premiers entre 2 et {N}")
P = []


#Stratégie 2
print ("Début P")
P = []
for i in range (2, N+1): #Nombres pour lesquels on va tester la primalité
    #print (f"(n): " end=""):
    for i in P:
         #print (f"(i): " end=","):
        if n % i ==0:
            #print ("--")
            break
    else:
        P.append(n)
print (f"Il y a {len(P)} nombres premiers entre 2 et {N}")
P = []
