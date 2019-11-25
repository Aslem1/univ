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

Combien sont-ils ?'''
def nb_survivants (titanic,survived):
    with open(titanic.csv) as f:
             reader = csv.reader(f)
             return sum([bool(row[survived]) for row in reader])

