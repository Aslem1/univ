.data   0 
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
.alias n 	8 
.alias n2 	64 

.program 200 
	li R1, a  			--Inst1 
	li R2, b  			--Inst2 
	li R3, c  			--Inst3 
	li R4, n  			--Inst4 
	li R10, n  			--Inst5 
	li R11, n2  		--Inst6 
.boucle1 
	li R5, n  			--Inst7 
.boucle2 
	li R6, n  			--Inst8 
	li R7, 0  			--Inst9 
.boucle3 
	li R8, (R1)  		--Inst10  
	li R9, (R2)  		--Inst11  
	add R1, R1, 1   	--Inst14  
	mult R9, R9, R8 	--Inst12  
	add R2, R2, 1   	--Inst15  
	add R7, R7, R9  	--Inst13  
	sub R6, R6, 1   	--Inst16  
	brnz R6, boucle3 	--Inst17  
	si (R3), R7  		--Inst18  
	add R3, R3, 1   	--Inst19  
	sub R1, R1, R10 	--Inst20  
	sub R5, R5, 1   	--Inst21  
	brnz R5, boucle2 	--Inst22  
	add R1, R1, R10 	--Inst23  
	sub R2, R2, R11 	--Inst24  
	sub R4, R4, 1   	--Inst25  
	brnz R4, boucle1 	--Inst26  
	exit   				--Inst27  
.end 