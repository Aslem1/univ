#Définir la listeRcontenant 10 entiers choisis aléatoirement entre 1 et 20 (append).
#import random
#R = random.randint (1,20)

#for R in range [1,20]:
    #if R >= 1 and R <=20:
#print (R)

#Correction
import random

n = 10

R = []
for _ in range (n): # _ car variable non utilisée (convention)
    alea = random.randint(1, 20)
    R.append(alea)
    
#Définir la variablelongcomme la longueur de R. (correction)
long = len(R)

#Afficher les éléments deRen les séparant par les " :" en la parcourant :(correction)
#par les indices entiers positifs (for,range).
for i in range(long) :
    print (R[i], end =":")
print ()
#directement par une boucle for.
for Ri in R:
    print (Ri, end=":")
print ()


#Calculer la somme des éléments de R.
sum=0
for i in range (1, n+1):
    sum = sum + i
#ou
sum=0
for Ri in R:
    print (Ri, end =":")
print ()

#ou
somme=0
for Ri in R:
    somme = somme + Ri
print (f"Somme : {somme}")

#Donnez la position de la valeur maximale de R. En cas d’occurrences multiples du maximum, donnez la position de la première occurrence.


#Compter le nombre d’éléments deRsupérieur ou égal à 10.


#Créer la listeR2de même taille de R qui contient :R2[i]=⇢R[i]siR[i]10


#Créer la listeR3résultante de la concaténation deRetR2.



