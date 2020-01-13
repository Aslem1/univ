import matplotlib.pyplot as plt # a installer

#Générer un tableau de taille n d’entiers.
l=10*[0]
for i in range(len(l)):
    l[i]=10*[0]
l[0][0]=1
print(l)

#Définissez et vérifiez une fonction de dissimilarité diss entre deux nombres :diss(a, b)=|a-b|
#Testez l’algorithme vu en TD pour la recherche du plus proche élément. On commencera par n petit pour tester votre fonction.
def plus_proche (T,ref,diss):
    imin, dmin = 0, diss (T[0],ref)
    for i,x in enumerate (T[1]):
        if diss (x,ref)<dmin:
            imin,dmin=1, diss (x,ref)
    return imin

'''A l’aide du module time (vu en cours), mesurez le temps mis par l’algorithme pour n petit, moyen, grand.
Conjecturez sur le temps mis en fonction de n.'''
from time import time, sleep

debut = time()
sleep(2)
fin = time()
duree = fin - debut
plt.plot(l)
plt.show()
print("Duree: ", duree)

#Mettez en place un expérimentation dans laquelle n varie, et dans laquelle vous stockez le temps mis parl’algorithme dans une liste tps.
tps = [duree]
plt.plot(tps)
plt.show()
#Affichez la liste tps grâce au module matplotlib.