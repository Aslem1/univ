.data 	0
.program 100
	li R0, 0
	si (R0), R0
	add R0, R0, 1
	si (R0), R0
	add R0, R0, 1
	li R1, 1
	li R2, 0
	li R3, 1022
.boucle
	li R4, (R1)
	li R5, (R2)
	add R6, R4, R5
	si (R0), R6
	add R0, R0, 1
	add R1, R1, 1
	add R2, R2, 1
	sub R3, R3, 1
	brnz R3, boucle
	nop 
	nop
	nop
	nop 
	nop
	nop
	exit
.end