import csv

with open ('titanic.csv', newline= '') as f:
    lecteur = csv.reader(f, delimiter=',', quotechar='"')
    next(lecteur)
    for ligne in lecteur:
        print (ligne)

#Quel était le pourcentage de femmes à bord du Titanic ?
def question4():
    with open('titanic.csv', newline ='') as f:
        reader = csv.reader(f, delimiter=',', quotechar='"')
        next(reader)
        women, nb = 0, 0
        for ligne in reader:
            if ligne[3] == "female":
                women = women + 1
            nb = nb +1
    return round (women*100/nb,2)
print (f"Pourcentage de femmes : {question4()}")




'''Quel est l'âge moyen des personnes à bord ?
Le résultat sera à arrondir à deux chiffres après la virgule.
Indication: chaine.replace(",", ".")  
permet de remplacer les virgules par des points dans la chaine.'''

def question5():
    with open('titanic.csv', newline ='') as f:
        lecteur = csv.reader(f, delimiter=',', quotechar='"')
        next(lecteur)
        somme_age, nb = 0, 0
        for ligne in lecteur:
            age = ligne[4]
            if age != '':
                nb = nb + 1
                age = float(age.replace(',','.'))
                somme_age = somme_age + age
    return round(somme_age / nb, 2)
print ("Age moyen des personnes à bord : {}".format (question5()))



#Quel est le nom du premier homme de 42 ans ayant survécu ?
def medium_first_survived_man():
    with open('titanic.csv') as csv_file:
        data = csv.reader(csv_file, delimiter=',')
        next(data)
        while True:
            current = next(data)
            if current[1] == "1" and current[3] == "male" and current[4] == "42":
                break
    return current[2]
print ("Le nom du premier homme de 42 ans ayant survécu est : {}".format (medium_first_survived_man()))


#Combien de personnes ont payé le tarif maximum ?
def nb_riches(): ##
    with open('titanic.csv') as csv_file:
        data = csv.reader(csv_file, delimiter=',')
        next(data)
        somme_max = 0
        maxi = 0.0
        for ligne in data:
            p = ligne[8]
            if p != '':
                prix = float (p.replace(',','.'))
                if prix == maxi:
                    somme_max +=1
                elif prix > maxi:
                    maxi  = prix
                    somme_max =1
        return somme_max
print ("Le nombre de personnes ayant payé le tarif maximum est : {}".format (nb_riches()))
                


'''Nous souhaitons vérifier si la règle "les femmes et les enfants d'abord" a été respéctée, en partie, en vérifiant le pourcentage de survivant chez les hommes et chez les femmes.
Créez une fonction en python qui prend en paramètre un sexe et calcule le pourcentage de survivant au sein de ce sexe. 
Testez votre fonction pour chacun des sexes, et comparez les résultats.
Indiquer le pourcentage de survivant chez les hommes, puis chez les femmes en séparant les résultats par une virgule. Les pourcentages sont à arrondir à l'entier le plus proche.
Exemple :
65, 70'''

def question8(sex):
    with open('titanic.csv') as csv_file:
        reader = csv.reader(csv_file, delimiter=',')
        next(reader)
        nb_sex, nb = 0, 0
        for ligne in reader:
            if ligne[3] == sex:
                nb = nb +1
                if ligne [1] == "1":
                    nb_sex = nb_sex + 1
    return round (nb_sex*100/nb,0)
print ("Pourcentage de survivants chez les hommes et chez les femmes : {}, {}".format(question8("male"), question8("female")))