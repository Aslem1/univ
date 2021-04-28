# Vous pouvez placer le script de votre jeu dans ce fichier.

# Déclarez sous cette ligne les images, avec l'instruction 'image'
# ex: image eileen heureuse = "eileen_heureuse.png"

# Déclarez les personnages utilisés dans le jeu.
define i = Character('Isaac', color="#7B3FFB")
define a = Character('Alexis', color="#18394F")
define l = Character('Lena', color="#B02406")
define c = Character('Claire', color="#E77EEC")


# Le jeu commence ici
label start:

    ' \[22h05]\ : Appartement de Isaac '
    a "Hey Isaac, tu me resers un autre verre ?"

    a "Après avoir ajouté une histoire, des images et de la musique, vous pourrez le présenter au monde entier !"

    return
