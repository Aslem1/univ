from turtle import*

while 1 : 
    direction = input ( "Que voulez vous faire ? ( A= avancer, R: reculer, G: Tourner à gauche, D: tourner à droite, Q : quitter) ").upper()
    if direction == "A" :
        print ("Le robot avance de 100 pixels")
        forward (100) 
    elif direction == "R" :
        print ("Le robot recule de 100 pixels")
        backward (100)
    elif direction == "G" :
        print ("Le robot tourne à gauche de 90 degrés")
        left (90)
    elif direction == "D" :
        print ("Le robot tourne à droite de 90 degrés")
        right (90)
    elif direction == "Q":
        print ("Quitter")
        bye ()
        break 
    else :
        print ("Le robot ne comprend pas" + direction )
