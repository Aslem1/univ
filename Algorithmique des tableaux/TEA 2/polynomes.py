#Question 1
'''
def rndi_poly(n,min=-5,max=5):
    import random
    for n in random.randit (min,max):
        tab = [] #creation tableau
        for n in tab: #boucler n fois
            tab.append(n) #ajouter valeur aleatoire tableau
            print ("test"+ n) #afficher tableau
'''

#Question 1 - Autre solution (qui fonctionne)
'''
def rndi_poly(n,min=-5,max=5):
    import random
    tab = []
    for i in range (0, n+1):
        a = random.randint(min,max)
        while a == 0 and i == n:
           a = random.randint(min,max)
        tab.append(a)
    return tab
'''

#Question 2
def eval_poly(P,x):
    somme = 0
    for i in range (len(P)):
        somme = somme + P[i]*x**i
    return somme

#Question 3
def eval_rec(P,x):
    somme = 0
    for i in range (a,len(P)):
        somme = somme + P[-i]*x**i
    return somme