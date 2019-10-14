print("Choisis un nombre compris entre 0 et 20")
borne = [0, 20]
 
while borne[1] - borne[0] >1 :
     
    milieu = int((borne[0] + borne[1]) / 2)
    reponse = input ("Est-ce que ton nombre est supérieur à " + str(milieu) + " ?" + " Oui/Non ")
    if reponse == "Oui":
        borne = [milieu, borne [1]] 
    elif reponse == "Non":
        borne = [borne [0], milieu] 
    else:
        print ("Tu n'as pas respecté la consigne") 
     
reponse == input("Est-ce que ton nombre est " + str(borne[0]) + " Oui/Non")
if reponse == "Oui":
    print("Ton nombre est " +str(borne[0]) + " ! ") 
else :print("Ton nombre est %a ! " % (str(borne[1])))
