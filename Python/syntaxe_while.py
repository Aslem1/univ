x = 1
while x <= 5: 
    print (x)
    x = x + 1

print ("\n" *2 + "*" * 15 + "\n")

a = 2
while a <= 12:
    if a %2 ==0:
        print (a, end=", ")
    a = a + 1

print ("\n" *2 + "*" * 15 + "\n")

b= 4
while b<=21:
    if b%2==0:
        print(b, end= ", ")
    b = b + 1
    
print ("\n" *2 + "*" * 15 + "\n")

c = 130
cpt_5 = 0
while cpt_5 < 10:
    if c % 5 == 0:
        print (c, end=", ")
        cpt_5 = cpt_5 +1
    c = c - 1