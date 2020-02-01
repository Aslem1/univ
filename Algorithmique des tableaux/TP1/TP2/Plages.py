#1er exercice
def longss1(T, x):
    longueur_courante = 0
    position_max, longueur_max = None, 0
    
    for i in range (len(T)):
        if T[i] == x:
            longueur_courante += 1
            if longueur_courante > longueur_max:
                longueur_max = longueur_courante
                position_max = i - longueur_courante + 1
        else:
            longueur_courante = 0
    if longueur_max > 0:
        return position_max, longueur_max
    return None, 0
    

#2e exercice
def longss2(chaine):
    caractere_courant, longueur_courante = chaine[0], 0
    caractere_max, position_max, longueur_max = chaine [0], 0, 0
    
    for i in range(len(chaine)):
        if chaine[i] == caractere_courant:
            longueur_courante += 1
            if longueur_courante > longueur_max:
                longueur_max = longueur_courante
                position_max = i - longueur_courante + 1
                caractere_max = caractere_courant
        else:
            caractere_courant = chaine[i]
            longueur_courante = 1
    return caractere_max, position_max, longueur_max
        
