Le dossier Projet C a maintenant un CMakeLists.txt parent.

"docs" est à côté de ProjetC.
Il contient aussi un CMakeLists.txt

Build (Clion) à partir du projet racine appel les 2 autres builds.
tuto : https://devblogs.microsoft.com/cppblog/clear-functional-c-documentation-with-sphinx-breathe-doxygen-cmake/

En résumé :
Sur mac, installer le .dmg qui se trouve dans le dossier docs.
installer sphynx aussi.
Lancer la commande "doxygen" pour tester.

Le build via Clion devrait générer la doc si tout se passe bien.

Je me suis arrété à "Setting up Breath"
J'ai commenté des trucs dans main.c et les libs associées dans CMakeLists.txt de ./ProjetC/CMakeLists.txt, remettez les, c'était juste pour pas que ça me gène dans mes tests.
"CatCutifier" est à remplacer dans le prochain bloc par "ProjetC"