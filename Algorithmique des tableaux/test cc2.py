#Ex1
#vérifie que la première parenthèse est ouvrante (i.e. est "(" ). Vrai pour expr1.
def premiere(expr):
    for char in expr:
        if char == '(':
             return False
        if char == ')':
            return expr.index(char)
    return 0

#Ex2
#retourne le niveau d'imbrication des parenthèses. 2 pour expr1 car "(5 / (2 + 1))".
def niveau(expr):
    compteur = 0
    max = 0
    for char in expr:
        if char == '(':
            compteur += 1
            if compteur > max:
                max = compteur
        if char == ')':
            compteur -= 1
    return max

#Ex3
# retourne position etlongueur de l'expression parenthésée la plus longue (parenthèses comprises). (18, 13) pour expr1
def max_expr(expr):
    longueur = 0
    longueur_max = 0
    taille = 0
    taille_max = 0
    compteur = 0
    max = 0
    for char in expr:
        if char == '(':
            compteur += 1
            if compteur > max:
                max = compteur
        if char == ')':
            taille_max += 1
            #taille = 0
        if compteur >= 1:
            taille += 1
            if taille > taille_max:
                taille_max = taille
    return max
expr1 = "3 * (4 + 1) - 5 * (5 / (2 + 1))"
print (premiere(expr1))

print (niveau(expr1))

print (max_expr(expr1))