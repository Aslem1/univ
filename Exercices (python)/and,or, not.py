#On fait un test pour savoir si a est compris dans l'intervalle [2,8]

a=5
if a >=2:
    if a <=8:
        print ("a est dans l'intervalle.")
    else:
        print ("a n'est pas dans l'intervalle.")
else:
        print ("a n'est pas dans l'intervalle.")
#Programme fonctionnel mais assez lourd


print ("----------------------------------------------------------------------------------------------")
 
 
if a>=2 and a <=8:
    print ("a est bien dans l'intervalle.")
else:
    print ("a n'est pas dans l'intervalle.")
#Simple et bien plus compréhensible


print ("----------------------------------------------------------------------------------------------")


if a <2 or a >8:
    print ("a n'est pas dans l'intervalle.")
else :
    print ("a est dans l'intervalle.") 


print ("----------------------------------------------------------------------------------------------")


if not a >=2 or not a <=8:
    print ("a n'est pas dans l'intervalle.")
else:
    print ("Yep")


print ("----------------------------------------------------------------------------------------------")


