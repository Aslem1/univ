import csv

with open ('titanic.csv', newline= '') as f:
    lecteur = csv.reader(f, delimiter=',', quotechar='"')
    next(lecteur)
    for ligne in lecteur:
        print (ligne)

#Quel était le pourcentage de femmes à bord du Titanic ?
def question4():
    with open('titanic.csv', newline ='') as f:
        lecteur = csv.reader(f, delimiter=',', quotechar='"')
        next(lecteur)
        women, nb = 0, 0
        for ligne in lecteur:
            if ligne[3] == "female":
                women = women + 1
            nb = nb +1
    return round (women*100/nb/nb,2)
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
                age = float(age.replace(','',''.'))
                somme_age = somme_age + age
    return round(somme_age / nb, 2)
print (f"Age moyen des personnes à bord : {question5()}")



'''Quel est le nom du premier homme de 42 ans ayant survécu ?
def question6():
     with open('titanic.csv', newline ='') as f:
        lecteur = csv.reader(f, delimiter=',', quotechar='"')
        next(lecteur)
        age=
        if age == "42"
        '''


#Combien de personnes ont payé le tarif maximum ?

'''Nous souhaitons vérifier si la règle "les femmes et les enfants d'abord" a été respéctée, en partie, en vérifiant le pourcentage de survivant chez les hommes et chez les femmes.
Créez une fonction en python qui prend en paramètre un sexe et calcule le pourcentage de survivant au sein de ce sexe. 
Testez votre fonction pour chacun des sexes, et comparez les résultats.
Indiquer le pourcentage de survivant chez les hommes, puis chez les femmes en séparant les résultats par une virgule. Les pourcentages sont à arrondir à l'entier le plus proche.
Exemple :
65, 70'''
