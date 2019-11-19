#Définir la fonction aire_carre qui donne l’aire d’un carré dont le coté est passé en paramètre.
def aire1_carre (longueur,largeur):
    aire = 4*4
    return aire
print ("L'aire du carré est {1}".format("aire"))
    
#Correction
def aire_carre(cote):
    if cote >= 0:
        aire = cote * cote
    else:
        aire = None
    return aire

x = float(input("Cote du carré"))
aire = aire_carre(x)
print(f"L'aire d'un carré de côté {x} est {aire}")


#Définir la fonction aire_rectangle qui donne l’aire d’un rectangle.
def aire1_rectangle (longueur,largeur):
    aire = 5*3
    return aire
print("L'aire d'un rectangle de longueur {1} et de largeur {2} est {3}".format(1,2,3))
#Correction
def aire_rectangle(long,larg):
    if long >= 0 and larg >=0:
        return long*larg
    return None


#Définir la fonction aire_carre2 qui utilise aire_rectangle.
def aire1_carre2 (aire_rectangle):
    aire=aire_rectangle
    return aire
#Correction
def aire_carre2 (cote):
    return aire_rectangle(cote,cote)

cote = float (input("Côté du carré ?"))
aire = aire_carre(cote)
aire2 = aire_carre2(cote)
print (f"L'aire d'un carré de côté {cote} est {aire} (ou")

longueur = float(input("Longueur ?"))
largeur = float(input("Largeur ?"))
aire = aire_rectangle (longueur, largeur)

       

#Définir la fonction aire_rectangle2 qui utilise aire_carre lorsque celle est nécessaire : Soit les valeurs des deux cotés sont égales. Soit une seule valeur est donnée (l’autre contient None comme valeur par défaut).
def aire1_rectangle2 (aire_carre):
    if aire_rectangle2 == aire_carre:
       print ("Les deux aires sont égales")
    elif aire_rectangle:

#Correction
def aire_rectangle2(long, larg=None):
    if larg == None or long == larg:
        return aire_carre(long)
    return long * larg
    

#Définir la fonction coords_carre qui retourne la liste des coordonnées (un tuple) des coins d’un carré3; il est de coté c, son coin inférieur gauche est en (x0,y0).
def coords1_carre
#Correction