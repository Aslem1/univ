from turtle import*
import math

"""
i = 0
while i < 4:
    forward (100)
    left (90)
    i = i + 1
    
print ("\n" *2 + "*" * 15 + "\n")

cote = 80
n = float (input (" à combien est égal n ?"))
i=0
while i <= n :
    forward (cote)
    left (360/n)
    i = i + 1

print ("\n" *2 + "*" * 15 + "\n")

"""
k = int (input("k ?"))

for m in range (179, 90, -1):
    if k * 360 % m == 0 :
        break 
else :
   print ("Je n'ai pas trouvé de multiple")
   

print ("\n" *2 + "*" * 15 + "\n")



#decroissant
for m in range (179,90,-1):
    if k * 360 % m == 0 :
        break
else:
    print ("Je n'ai pas trouvé de multiple")
    
#croissant
for m_ in range (91, 180, 1):
    if k*360 % m_ ==0:
        m = m_
else:
    print ("Je n'ai pas trouvé de multiple")

#print ("\n" *2 + "*" * 15 + "\n")



x_0 = xcor()
y_0 = ycor()
n = 0
while n < 1000 :
    forward (100)
    right (m)
    n = n + 1
    print("coords: {}, {} ". format(xcor(), ycor()))
    #if xcor() == x_0 and ycor() == y_0 :
    if math.isclose (xcor() and ycor()) == y_0 :
        break    
else:
    print ("Je ne suis pas revenu à l'origine")
print ("Je suis revenu à l'origine en {} itérations".format(n))