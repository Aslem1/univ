import csv

with open ('titanic.csv', newline= '') as f:
    lecteur = csv.reader(f, delimiter=',', quotechar='"')
    next(lecteur)
    for ligne in lecteur:
        print (ligne)

'''Ecrivez une fonction python permettant de parcourir le fichier csv.
Combien personnes sont dans le fichier ? (nombre de lignes)'''
f = open ('titanic.csv', 'r')
NumberOfLine = 0
for line in f:
    NumberOfLine += 1

print ("Nombre de lignes: ",NumberOfLine)



'''Ecrivez une fonction python permettant de calculer le nombre de survivants.

Combien sont-ils ?
def nb_survivants (titanic,survived):
    with open(titanic.csv) as f:
             reader = csv.reader(f)
             next(lecteur)
             sum = 0
             for row in reader:
                 if row [1] == "1":
                     sum = sum+1 
             return sum([bool(row[1]) for row in reader])
print ("Nombre de survivants: ",nb_survivants)
'''
with open(titanic.csv) as f:
             reader = csv.reader(f)
             next(lecteur)
             cpt = 0
             for ligne in lecteur:
                 if ligne[1] == "1"
                     cpt = cpt + 1
        return cpt


#Quel était le pourcentage de femmes à bord du Titanic ?
def question4():
    with open(titanic.csv) as f:
                 reader = csv.reader(f)
                 next(lecteur)
                 women, nb = 0, 0
                 for ligne in lecteur:
                     if ligne[3] == "female":
                     women = women +1
                 nb = nb +1
            return women*100/nb

    