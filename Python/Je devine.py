import random
alea=random.randint(1,20)

print("Devine !")


while True :
    nombrePropose = int(input("Quel est le nombre ?"))
    if nombrePropose > alea:
        print ("Plus petit")
    elif nombrePropose < alea:
        print ("Plus grand")
    else:  #forcément nombrePropose == alea
        print ("Gagné, c'était {} !".format(alea))
        break
