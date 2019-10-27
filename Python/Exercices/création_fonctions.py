def table(nb):
    i=0 #Le compteur
    while i < 10:
        print (i+1, "*", nb, "=", (i+1) * nb)
        i += 1 #On incrémente i de 1 à chaque tour de boucle
        


#On peut également paramétrer le nombre de valeurs à afficher
def table (nb, max):
    i=0
    while i < max:
        print (i+1, "*", nb, "=", (i+1)*nb)
        i +=1 

#Autre solution possible
def table (nb, max=10):
    """Fonction affichant la table de multiplication par nb de 1*nb à max*nb   
    (max >= 0)""" #Doc string, si on tape help(table) ce message apparaitera 
    
    i = 0
    while i < max:
        print (i + 1, "*", nb, "=", (i + 1) * nb)
        i += 1

#Exemple définition de fonction
def fonc(a=1, b=2, c=3, d=4, e=5):
    print("a=", a, "b=", b, "c=", c, "d=", d, "e=", e)
    