#Chiffrage T9
mot = input()
## Exo n°1
conversion = {
    "a": 2,
    "b": 2,
    "c": 2,
    "d": 3,
    "e": 3,
    "f": 3,
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
    "z": 9
    }

def chiffrage(mot):
    reponse = ""
    for letter in mot:
        reponse += str (conversion[letter])
        
    return reponse
## Fin Exo n°1
print (chiffrage(mot))


#Déchiffrage T9
chiffres = input()
## Exo n°2
conversionV2 = {
    2: ["a","b","c"],
    3: ["d","e","f"],
    4: ["g","h","i"],
    5: ["j","k","l"],
    6: ["m","n","o"],
    7: ["p","q","r","s"],
    8: ["t","u","v"],
    9: ["w","x","y","z"]
    }

def dechiffrage(chiffres):
    with open("Dico.txt", "r") as f :  # ouvre le fichier -> cibler le bon fichier
        lines = f.read().split('\n')
    
    # enlever de la liste tout ce qui n'a pas la bonne taille
    new_lines = []
    for line in lines:
        if len(line) == len(chiffres):
            new_lines.append(line)
    
    # pour chaque chiffre
    for i in range(len(chiffres)):
        # vérifier si les mots ont la bonne lettre à la bonne place
        new_new_lines = [] # créer nouvelle nouvelle liste
        for line in new_lines: # pour chaque mot de la nouvelle liste
            if line[i] in conversionV2[int (chiffres[i])]: # vérifier que la lettre d'index n est dans la liste de lettres du chiffre
                new_new_lines.append(line) # ajouter à la nouvelle nouvelle liste
        new_lines = new_new_lines # mettre nouvelle nouvelle liste dans la nouvelle liste
    if len(new_lines) == 0:
        new_lines = "Aucun mot ne correspond à la recherche, désolé."
    return new_lines
## Fin Exo n°2
print (dechiffrage(chiffres))



#Déchiffrage T9
chiffres = input()
## Exo n°3
conversionV2 = {
    2: ["a","b","c"],
    3: ["d","e","f"],
    4: ["g","h","i"],
    5: ["j","k","l"],
    6: ["m","n","o"],
    7: ["p","q","r","s"],
    8: ["t","u","v"],
    9: ["w","x","y","z"]
    }

def dechiffrage2(chiffres):
    with open("Dico.txt", "r") as f :  # ouvre le fichier -> cibler le bon fichier
        lines = f.read().split('\n')
    
    # pour chaque chiffre
    for i in range(len(chiffres)):
        # vérifier si les mots ont la bonne lettre à la bonne place
        new_lines = [] # créer nouvelle liste
        for line in lines: # pour chaque mot de la liste de mots
            if i < len(line) and line[i] in conversionV2[int (chiffres[i])]: # vérifier que le mot en cours fait bien la bonne taille et vérifier que la lettre d'index n est dans la liste de lettres du chiffre
                new_lines.append(line) # ajouter à la nouvelle liste
        if len(new_lines) <= 5: # Si il reste 5 mots ou moins, renvoyer le nombre de chiffres parcourus et la liste associée.
            return (i+1, new_lines)
        else:
            lines = new_lines # sinon, mettre nouvelle liste dans la liste de mots pour recommencer le traitement sur le chiffre suivant.
    if len(lines) > 5: # Si il reste plus de 5 mots, renvoyer le tuple (None, None).
        return (None, None)
## Fin Exo n°3
print (dechiffrage2(chiffres))