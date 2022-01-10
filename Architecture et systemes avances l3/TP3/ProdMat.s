.data 	0
.global a 
	1 1 1 1 1 1 1 1 
	2 2 2 2 2 2 2 2 
	3 3 3 3 3 3 3 3
	4 4 4 4 4 4 4 4 
	5 5 5 5 5 5 5 5    
	6 6 6 6 6 6 6 6
	7 7 7 7 7 7 7 7  
	8 8 8 8 8 8 8 8
.global b
	1 1 1 1 1 1 1 1 
	2 2 2 2 2 2 2 2  
	3 3 3 3 3 3 3 3
	4 4 4 4 4 4 4 4  
	5 5 5 5 5 5 5 5 


	6 6 6 6 6 6 6 6
	7 7 7 7 7 7 7 7 
	8 8 8 8 8 8 8 8  
.global c
	0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0
	0 0 0 0 0 0 0 0
.alias n 8
.alias n2 64
.program 200
	li R1, a


	li R2, b

	li R3, c




	li R4, n
	li R10, n
	li R11, n2
.boucle1
	li R5, n
.boucle2
	li R6, n
	li R7, 0
.boucle3
	li R8, (R1)
	li R9, (R2)
	mult R9, R9, R8
	add R7, R7, R9
	add R1, R1, 1
	add R2, R2, 1
	sub R6, R6, 1
	brnz R6, boucle3
	si (R3), R7
	add R3, R3, 1
	sub R1, R1, R10
	sub R5, R5, 1
	brnz R5, boucle2
	add R1, R1, R10
	sub R2, R2, R11
	sub R4, R4, 1
	brnz R4, boucle1
	exit
.end