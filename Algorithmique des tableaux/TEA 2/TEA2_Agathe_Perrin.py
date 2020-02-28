#Question 1
def rndi_poly(n, min=-5, max=5):
    import random
    tab = []
    for i in range (0, n+1):
        a = random.randint(min, max)
        while a == 0 and i == n:
           a = random.randint(min, max)
        tab.append(a)
    return tab
print (rndi_poly(5))

#Question 2
def eval_poly(P, x):
    somme = 0
    for i in range (len(P)):
        somme = somme + P[i]*x**i
    return somme

#Question 3
def eval_rec(P, x):
    if len(P) == 1:
        return P[0]
    return P[0] + x * eval_rec(P[1:], x)
print(eval_rec([1, 2, 5, 6], 1))

#Question 4
def eval_iter(P, x):
    somme = 0
    while len(P) != 0:
        somme += P[0]
        P = [n*x for n in P[1:]]
    return somme
l = [1, 2, 5, 6]
print(eval_iter(l, 3))

#Question 5
def add_poly(P, Q):
    if len(P) >= len(Q):
        max_tab = P
        min_tab = Q
    else:
        max_tab = Q
        min_tab = P
        
    for i in range (len(min_tab)):
        max_tab[i] = max_tab[i] + min_tab [i]
    while max_tab[-1] == 0:
        del (max_tab[-1])
    return max_tab
P = [1, 3 ]
Q = [2, 1, -3]
print (Q[-1])
print( add_poly(P, Q))


#Question 6
def mult_poly(P, Q):
    R=[0]*(len(Q)+len(P)-1)
    for i in range(len(P)):
        for j in range(len(Q)):
            R[i+j]=R[i+j]+(P[i]*Q[j])
    while R[-1] == 0:
        del (R[-1])
    return R

print(mult_poly([0, 1], [0, 0, 1]))
#[0, 0, 0, 1]
print(mult_poly([4, -3, 12], [2, 0, 5, 0, 3]))
#[8, -6, 44, -15, 72, -9, 36]