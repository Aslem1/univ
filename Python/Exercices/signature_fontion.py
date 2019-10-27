def exemple():
    print ("Un exemple d'une fonction sans paramètre")

exemple()

def exemple(): #On redéfinit la fonction exemple
    #La précédente à été écrasée
    print ("Un autre exemple de fonction sans paramètre")

exemple()

#L'instruction return
def carre(valeur):
    return valeur * valeur