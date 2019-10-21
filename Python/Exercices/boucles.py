#La boucle while

nb = int(input("Entrez un nombre:")) # On garde la variable contenant le nombre dont on veut la table de multiplication
i = 0 # C'est notre variable compteur que nous allons incrémenter dans la boucle

while i < 10: # Tant que i est strictement inférieure à 10
    print(i + 1, "*", nb, "=", (i + 1) * nb)
    i += 1 # On incrémente i de 1 à chaque tour de boucle


print ("-----------------------------------------------------------------------------------------")


#La boucle for
chaine = "Bonjouuuuuur"
for lettre in chaine:
    print (lettre)


print ("-----------------------------------------------------------------------------------------")


#break et continue
while True: #Toujours vrai -> boucle infinie
    lettre=input("Tapez 'Q' pour quitter: ")
    if lettre == "Q":
        print ("Fin de la boucle")
        break 

i = 1
while i < 20: #tant que i est inférieur à 20
    if i % 3 ==0:
        i += 4 #on ajoute 4 à i
        print("On incrémente i de 4. i est maintenant égal à", i)
        continue #On retourne au while sans éxecuter les autres lignes
    print ("La variable i =", i)
    i+= 1 #On ajoute 1 à i

