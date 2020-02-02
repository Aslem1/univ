#Chiffrage T9
conversion = {
    "a" : 2,
    "b":  2,
    "c": 2,
    "d": 3,
    "e" : 3,
    "f":  3,
    "g": 4,
    "h": 4,
    "i": 4,
    "j": 5,
    "k": 5,
    "l": 5,
    "m": 6,
    "n": 6,
    "o": 6,
    "p": 7,
    "q": 7,
    "r": 7,
    "s": 7,
    "t": 8,
    "u": 8,
    "v": 8,
    "w": 9,
    "x": 9,
    "y": 9,
    "z": 9,
    }

mot = "mon"


def chiffrage(mot):
    reponse = ""
    for letter in mot:
        reponse += str (conversion[letter])
        
    return reponse

print (chiffrage(mot))


#Déchiffrage T9
conversionV2 = {
    2: {"a","b","c"},
    3: {"d","e","f"},
    4: {"g","h","i"},
    5: {"j","k","l"},
    6: {"m","n","o"},
    7: {"p","q","r","s"},
    8: {"t","u","v"},
    9: {"w","x","y","z"}
    }

def dechiffrage (chiffres):
    #charger dico dans variable
    #compter nb de lettres dans var chiffre
    #trouver mot possibles (de même taille)
    for ch in chiffres:
        
    #trouver les mots dont la première lettre correspond au premier chiffre 
    #recommencer pour chaque lettre
    #elimination au fur et à mesure
    #renvoyer tableau résultat
print (dechiffrage ("666"))  #Doit renvoyer {"mon", "nom", "non"}