#Définir une fonction rect qui trace un rectangle de largeur l et de hauteur h depuis la position (x,y). Par défaut,cette position sera (0,0). Tester votre fonction.
from turtle import *

def rect (x, y, h, l=30):
    penup()
    setposition(x,y)
    pendown()
    forward (l)
    left (90)
    forward (h)
    left (90)
    forward (l)
    left (90)
    forward (h)
    left (90)
    
setup (1000, 1000)
rect(0, 0, 100, 30)
rect(30, 0, 180, 30)
rect(60, 0, 50, 30)

def histo(Liste, largeur, x0=0, y0=0):
    for l in enumerate (Liste):
        rect (x0 + i*largeur, y0, x, l=largeur)

clear()
histo([100,50,-20,200,10,30])

#Utiliser votre fonction pour tracer 3 rectangles accolés de même largeur mais de hauteur différente.

#Écrire la fonctionhistoqui prend comme entrées une liste et l’affiche une succession de rectangles de mêmelargeurlet dont la hauteur dépend des valeurs dans la liste.

#(Bonus) Personnalisez votre affichage (axes, couleur, remplissage, hauteur maximale,...)