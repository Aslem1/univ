def tri_bulle(tabl):
    n = len(tabl)
    for i in range(n - 1):
        for j in range(i-1):
            if tabl[j+1] > tabl[j] :
                tabl[j], tabl[j+1] = tabl[j+1], tabl[j]
tabl = [1,5,12,54,26,89]
 
tri_bulle(tabl)
 
print ("Le tableau trié est:")
for i in range(len(tabl)):
    print ("%d" %tabl[i])
    


           