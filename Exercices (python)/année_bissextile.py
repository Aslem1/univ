#Mon code
année = int (input ("Entrez une année: "))

if not (année % 4 ==0):
    print ("Cette année n'est pas bissextile.")
else: 
    if année %100 ==0 :
        if année % 400 ==0:
            print ("Cette année est bissextile.")
        else:
            print ("Cette année n'est pas bissextile.")
    else:
        print ("Cette année est bissextile.")

print ("-----------------------------------------------------------------------------------------")

#Correction 

# Programme testant si une année, saisie par l'utilisateur,
# est bissextile ou non

annee = input("Saisissez une année : ") # On attend que l'utilisateur saisisse l'année qu'il désire tester
annee = int(annee) # Risque d'erreur si l'utilisateur n'a pas saisi un nombre
bissextile = False # On crée un booléen qui vaut vrai ou faux
                   # selon que l'année est bissextile ou non

if annee % 400 == 0:
    bissextile = True
elif annee % 100 == 0:
    bissextile = False
elif annee % 4 == 0:
    bissextile = True
else:
    bissextile = False

if bissextile: # Si l'année est bissextile
    print("L'année saisie est bissextile.")
else:
    print("L'année saisie n'est pas bissextile.")


print ("-----------------------------------------------------------------------------------------")


#Autre correction possible
annee = input("Saisissez une année : ") # On attend que l'utilisateur saisisse l'année qu'il désire tester
annee = int(annee) # Risque d'erreur si l'utilisateur n'a pas saisi un nombre

if annee % 400 == 0 or (annee % 4 == 0 and annee % 100 != 0):
    print("L'année saisie est bissextile.")
else:
    print("L'année saisie n'est pas bissextile.")
