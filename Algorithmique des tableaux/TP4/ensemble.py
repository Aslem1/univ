from bisect import *

E = [1,3,5,6,7]

#Taille --- Ma version
def set_len(E): #Nombre d'élements
    R = [0,1,4,5,7,8]
    
    for r in R:
        print(f"{r} : {bisect_right(E,r)} {set_in(E,r)}")

        print ("-------------------------------------------------")

#Appartient --- Ma version
def set_in(E,x): #Vrai si x appartient à E
    for x in E:
            return True

#Appartient --- Correction
def set_in2(E,x):
    i = bisect_right(E,x)
    if i == 0 or E[i-1] != x:
        return False
    else:
        return True

print ("-------------------------------------------------")

#N'appartient pas --- Ma version
def set_not_in(E,x): #Vrai si x n'appartient pas à E
    for x in E:
        while x != E:
            return True
        
print ("-------------------------------------------------")

#Ajout --- Ma version
def set_add(E,x): #Ajoute un élément, ne rien faire si il est déja présent
    i = bisect_right(E,x)
    if i <= x:
        E.insert(i,x)
    else:
        return None

#Ajout --- Correction
def set_add2(E,x):
    i = bisect_right(E,x)
    if i == 0 or E[i-1] != x:
        E.insert(i,x)
            
print ("-------------------------------------------------")

#Supression --- V1
def set_rm(E, x):
    try:
        E.remove(x)
    except ValueError:
        pass
    
#Supression --- V2
def set_rm2(E, x):
    i = bisect_right(E,x)
    if i > 0 and E[i-1] == x:
        del E[i-1]
        
#Création
def set_create(L): #Tri avec supression des doublons
    R = sorted(L)
    E = R[:1] #E = R[0]
    for r in R[1:]:
        if E[-1] != r:
            E.append(r)
    return E