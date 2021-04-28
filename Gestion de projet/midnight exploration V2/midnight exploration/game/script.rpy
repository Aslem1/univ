# Vous pouvez placer le script de votre jeu dans ce fichier.

# Déclarez sous cette ligne les images, avec l'instruction 'image'
# ex: image eileen heureuse = "eileen_heureuse.png"

image eileen heureuse = "eileen_heureuse.png"


#image de fond :
image appartement = "images/background/apartment.png"
#images Lena
image lena = "images/characters/Lena/lena.png"
image lena_reversed = im.Flip("images/characters/Lena/lena.png", horizontal="True")
image lena_thinking_reversed = im.Flip("images/characters/Lena/lena_thinking.png", horizontal="True")
image lena_awkward_reversed = im.Flip("images/characters/Lena/lena_awkward.png", horizontal="True")
image lena_asking_camera = "images/characters/Lena/lena_asking.png"
#images Isaac
image isaac = "images/characters/Isaac/isaac.png"
image isaac_reversed = im.Flip("images/characters/Isaac/isaac.png", horizontal="True")
image isaac_baille_reversed = im.Flip("images/characters/Isaac/isaac_baille.png", horizontal="True")
image isaac_thinking_reversed = im.Flip("images/characters/Isaac/isaac_thinking.png", horizontal="True")
image isaac_tousse_reversed = im.Flip("images/characters/Isaac/isaac_tousse.png", horizontal="True")
image isaac_flirting_reversed = im.Flip("images/characters/Isaac/isaac_flirting.png", horizontal="True")
image isaac_listening_reversed = im.Flip("images/characters/Isaac/isaac_listening.png", horizontal="True")
#images Claire
image claire = "images/characters/Claire/claire.png"
image claire_reversed = im.Flip("images/characters/Claire/claire.png", horizontal="True")
image claire_embarrased = "images/characters/Claire/claire_embarrassed.png"
image claire_awkward_reversed = im.Flip("images/characters/Claire/claire_awkward.png", horizontal="True")
#images Alexis
image alexis = "images/characters/Alexis/alexis.png"
image alexis_whisky_reversed = im.Flip("images/characters/Alexis/alexis_with_whisky.png", horizontal="True")
image alexis_reversed = im.Flip("images/characters/Alexis/alexis.png", horizontal="True")
image alexis_thinking_reversed = im.Flip("images/characters/Alexis/alexis_thinking.png", horizontal="True")
#images Personnages secondaires
image hote = "images/characters/Secondaires/hotesoiree.png"
image hote_enjouee = "images/characters/Secondaires/hote_enjouee.png"
image hote_decue = "images/characters/Secondaires/hote_decue.png"
image hote_shook = "images/characters/Secondaires/hote_shook.png"
image hote_disappointed = "images/characters/Secondaires/hote_disappointed.png"
image hote_blush = "images/characters/Secondaires/hote_in_love.png"

# Déclarez les personnages utilisés dans le jeu.
define i = Character('Isaac', color="#7B3FFB", who_font="Rubik.ttf")
define a = Character('Alexis', color="#18394F", who_font="Rubik.ttf")
define l = Character('Lena', color="#B02406", who_font="Rubik.ttf")
define c = Character('Claire', color="#E77EEC", who_font="Rubik.ttf")
define Rchara =  Character('???', color="#E78EEC", who_font="Rubik.ttf")


# Le jeu commence ici
label start:
    play music "Audio/soiree.mp3" volume 0.5 fadeout 1.0 fadein 1.0
    play sound "Audio/Party_Crowd.mp3" volume 1 fadeout 1.0 fadein 1.0
    scene appartement
    show lena at Position(xpos = 0.2, xanchor=1, ypos=0.1, yanchor=2)
    with dissolve


    ' \[22h05]\ : Soirée étudiante en appartement '
    l "Hey Isaac, tu me ressers un autre verre ?"
    show isaac_reversed at Position(xpos = 0.5, xanchor=1, ypos=0.1, yanchor=2)
    hide lena
    i " Demande à Claire c'est elle qui est la plus proche d'la bouteille de Whisky"
    hide isaac_reversed
    show lena at Position(xpos = 0.2, xanchor=1, ypos=0.1, yanchor=2)
    show claire_embarrassed at Position(xpos = 0.6, xanchor=1, ypos=0.1, yanchor=2)
    c " Euh j'ose pas trop me servir vu que c'est pas chez moi... "
    show alexis_whisky_reversed at Position(xpos = 0.45, xanchor=1, ypos=0.05, yanchor=2)
    a " T'inquiètes, j'm'en occupe "

    l " Merci Alex "
    hide alexis_whisky_reversed with dissolve
    show isaac_baille_reversed at Position(xpos = 0.5, xanchor=1, ypos=0.1, yanchor=2)
    i " J'sais pas pour vous mais j'arrive pas trop à m'amuser ici on a vraiment pas les mêmes délires que les gens ici "

    l " J'allais le dire.. en vrai  je comptais aller fumer une clope dehors parce qu'il fait chaud ici, j'ai besoin de sortir "
    hide isaac_baille_reversed with dissolve
    hide claire_embarrassed
    show alexis_reversed at Position(xpos = 0.5, xanchor=1, ypos=0.05, yanchor=2)
    a " Je te rejoins "


    show claire_reversed at Position(xpos = 0.8, xanchor=1, ypos=0.1, yanchor=2)
    c " Moi aussi ! "
    hide alexis_reversed
    hide claire_reversed
    hide lena
    show hote at Position(xpos = 0, xanchor=1, ypos=0.05, yanchor=2)
    Rchara " Oh vous partez déjà ?? vous êtes sûres de partir aussi tôt. La soirée vient juste de commencer. "
    show lena_thinking_reversed at Position(xpos = 0.5, xanchor=1, ypos=0.1, yanchor=2)
menu :

    l "{i}Il faut qu'on trouve une excuse pour partir...{/i}"
    "a. T'inquiète je vais juste sortir fumer parce que j'ai envie de prendre l'air mais on revient vite":
        jump choixConfiant


    "b. Euh.. on va prendre l'air on revient plus tard ":
        jump choixHesitant

    "c. On sort un coup on revient juste après ":
        jump choixIndifferent



label choixConfiant:
    hide hote
    show hote_enjouee at Position(xpos = 0, xanchor=1, ypos=0.05, yanchor=2)
    Rchara "Ça marche ! En vrai j'hésite à vous rejoindre "
    hide lena_thinking_reversed
    show isaac_thinking_reversed at Position(xpos = 0.4, xanchor=2, ypos=0.05, yanchor=2)

    i "Bah c'est ta soirée, il vaut mieux que tu restes surveiller les autres"
    show alexis_reversed at Position(xpos = 0.6, xanchor=2, ypos=0.05, yanchor=2)
    a "Oui j'ai vu un gars qui avait pas l'air d'aller bien"
    play sound "Audio/breakingglass.mp3" volume 2
    Rchara "Ah bon ?! J'avais pas fait gaffe mais bon ça devrait aller j'ai l'habitude de partir quelques minutes et de revenir sans que mon appart soit en bordel"
    hide alexis_reversed
    show alexis_thinking_reversed at Position(xpos = 0.6, xanchor=2, ypos=0.05, yanchor=2)
    hide hote_enjouee
    show hote_shook at Position(xpos = 0, xanchor=1, ypos=0.05, yanchor=2)

    a "Oulah.. vous avez entendu ? J'pense que tu devrais aller voir ce qu'il se passe à ta place je laisserais pas mon appart pendant une soirée sans surveillance."
    hide hote_shook
    show hote_decue at Position(xpos = 0, xanchor=1, ypos=0.05, yanchor=2)
    Rchara "Ouais t'as pas tort.. Bon bah à tout à l'heure les gars"
    hide hote_decue
    hide alexis_thinking_reversed
    hide isaac_thinking_reversed
    jump suite


label choixHesitant:
    hide hote
    hide lena_thinking_reversed
    show hote_disappointed at Position(xpos = 0, xanchor=1, ypos=0.05, yanchor=2)
    Rchara "Ah ok, j'espère que vous ennuyez pas trop.."
    show claire_awkward_reversed at Position(xpos = 0.6, xanchor=1, ypos=0.1, yanchor=2)
    c "En vrai on allait par.."
    show isaac_tousse_reversed at Position(xpos = 0.4, xanchor=2, ypos=0.05, yanchor=2)
    play sound "Audio/tousser.mp3" volume 3
    i "t'inquiète on revient dans la soirée"
    hide isaac_tousse_reversed
    show isaac_flirting_reversed at Position(xpos = 0.4, xanchor=2, ypos=0.05, yanchor=2)

    hide hote_disappointed
    show hote_blush at Position(xpos = 0, xanchor=1, ypos=0.05, yanchor=2)
    Rchara "Oh j'espère que tu euh.. vous allez revenir vite. La soirée ne sera pas pareil sans vous"
    Rchara "Je vous laisse tranquille du coup à toute à l'heure"
    hide isaac_flirting_reversed
    hide claire_awkward_reversed
    hide hote_blush
    jump suite

label choixIndifferent:
    hide lena_thinking_reversed
    show hote at Position(xpos = 0, xanchor=1, ypos=0.05, yanchor=2)

    Rchara "Ok n'oubliez bah n'oublier pas vos téléphones avant de partir comme ça vous m'envoyez un message quand vous revenez"
    show lena_awkward_reversed at Position(xpos = 0.5, xanchor=2, ypos=0.05, yanchor=2)
    l "Oui pas de soucis, on revient plus tard "
    show isaac_listening_reversed at Position(xpos = 0.3, xanchor=2, ypos=0.05, yanchor=2)
    i " on va vérifier ça "
    hide hote
    hide lena_awkward_reversed
    hide isaac_listening_reversed
    jump suite


label suite:
    show lena_asking at Position(xpos = 0.2, xanchor=2, ypos=0.05, yanchor=2)
    l " On est tous bon du coup ? Vous avez rien oublié avant de partir de cette soirée ? "
    hide lena_asking
    menu:
        " {b}Vous allez bientôt partir de la soirée, êtes-vous sûr de sortir tout de suite ?{/b}"

        " Non, il y'a peut-être des objets intéressants à prendre ":
            jump attendre
        " Oui, on est prêt ":
            jump partir

return
