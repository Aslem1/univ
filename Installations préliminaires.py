'''Créez une liste L de taille 10.
Utilisez les codes du cours pour parcourir L avec tqdmet afficher L avec matplotlib.'''

L=[0,1,2,3,4,5,6,7,8,9]
#print (L)

from tqdm import tqdm, tqdm_gui  # a installer
from time import sleep
from random import randint
import matplotlib.pyplot as plt # a installer

for i in tqdm(range(3)):
    for j in tqdm(range(4)):
        duree_sommeil = randint(1, 4)
        sleep(duree_sommeil)
        plt.plot(L)
        plt.show()
