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



# Ecrivez une fonction python permettant de calculer le nombre de survivants.
# Combien sont-ils ?

def nb_survivants ():
    return sum([bool(row[1] == '1') for row in csv.reader(open('titanic.csv'))])



print ("PROUT Nombre de survivants: ", nb_survivants())

def question3():
    with open("titanic.csv") as f:
        reader = csv.reader(f)
        cpt = 0
        next(reader)
        for ligne in reader:
            if ligne[1] == "1":
                cpt += 1  # Equivaut à cpt = cpt + 1 
        return cpt
    
print("Nombre de survivants: {}".format(question3()))


#Quel était le pourcentage de femmes à bord du Titanic ?
def question4():
    with open("titanic.csv") as f:
        reader = csv.reader(f)
        next(reader)
        for ligne in reader:
            women, nb = 0, 0
            if ligne[3] == "female":
                women = women +1
                nb = nb +1
                return women*100/nb

    