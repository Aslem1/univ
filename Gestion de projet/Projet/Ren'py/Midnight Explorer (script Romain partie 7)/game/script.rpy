# The script of the game goes in this file.

# Declare characters used by this game. The color argument colorizes the
# name of the character.

define l = Character("Léna")
define a = Character("Alexis")
define c = Character("Claire")
define i = Character("Isaac")

# The game starts here.

label start:

    scene choix_tous
    show claire at left

    c "On va où maintenant?"

    show lena at left
    hide claire

    menu:
        l "On va..."
        "A gauche!":
            jump gauche
        "Tout droit!":
            jump milieu
        "A droite!":
            jump droite

    hide lena

label gauche:
    scene salle_soins
    show isaac at left
    i "Wow c'est le bordel ici"
    show claire at right
    c "Beurk des gens se faisaient dissecter ici"
    hide claire
    hide isaac
    show lena at left
    l "C'est un hopital Claire, pas un cours de biologie, les gens se faisaient opérer, pas dissecter"
    show alex at right
    a "Oh regardez ce que j'ai trouvé! C'est le dossier de ..."
    hide lena
    hide alex
    show dossier_patient:
        xalign 0.5
        yalign 0.5
    show claire at left
    c "Le pauvre! Regardez tous les traitement qu'ils lui ont fait subir"
    hide claire
    show isaac at left
    i "Tu m'étonnes qu'il ne se rappelle de rien ..."
    hide isaac
    hide dossier_patient
    show lena at left
    l "Bon allez on avance?"
    # jump [suite]
    return

label droite:
    scene chambre_patient
    show lena at left
    l "Je pense que cette salle servait de chambre de patient avant"
    show alex at right
    a "Y a pleins de papiers par terre"
    a "Oh regardez ces vieilles lettres que j'ai trouvées"
    # afficher image de lettres
    l " 'Et j'entendais les patients hurlés dans le couloir ...' ça ne donne pas envie de venir se faire opérer ici"
    hide lena
    hide alex
    # hide lettres
    show claire at left
    c "C'est sur, allons autre part du coup!!"
    # jump [suite]
    return

label milieu:
    scene piece_vide
    show claire at left
    c "Cette salle ne m'inspire pas du tout confiance"
    show isaac at right
    i "Booouh!" with vpunch
    hide isaac
    c "Aaaaah!" with vpunch
    c "C'est pas drôle Isaac!"
    show isaac at right
    i "Moi je trouve ça très marrant ahah!"
    hide isaac
    hide claire
    show lena at left
    l "Bon on avance les enfants?"
    # jump [suite]
    return


return
