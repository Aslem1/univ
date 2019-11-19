#Créer une listeLde 5 entiers de votre choix
L=[4,-3,2,6,8]

#Afficher le premier élément et le dernier élément deux façons différentes.
print (L[0])
print (L[4], L[-1])

#RemplacerL[1] = 0etL[3]par la somme deL[2]etL[4].
L[1] = 0
L[3] = L[2] + L[4]

#Afficher la liste L par un print.
print (L)

#Échanger les valeurs de L[0] et L[1]en utilisant une variable auxilaire aux.
aux = L[0]
L[0] = L[1]
L[1] = aux

#Afficher la liste L par un print.
print (L)

#Échanger à nouveau les valeurs de L[0] et L[1]en utilisant un tuple.
(L[0], L[1]) = (L[1], L[0])

#Vérifier le résultat en affichant la liste.
L [:2] = L[:2][::-1]
print (L)

#Supprimer la première occurrence de 0.
L.remove (0)
print (L)