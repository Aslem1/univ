.data   0 
.program    100 
 
	 li R0, 0  			-- Inst1 
	 si (R0), R0  		-- Inst2 
	 add R0, R0, 1   	-- Inst3 
	 si (R0), R0  		-- Inst4 
	 add R0, R0, 1   	-- Inst5 
	 li R1, 1  			-- Inst6 
	 li R2, 0  			-- Inst7 
	 li R3, 1022		-- Inst8 
.boucle 
	 li R4, (R1)  		-- Inst9 
	 li R5, (R2)  		-- Inst10 
	 add R6, R4, R5  	-- Inst11 
	 si (R0), R6  		-- Inst12 
	 add R0, R0, 1   	-- Inst13 
	 add R1, R1, 1   	-- Inst14 
	 add R2, R2, 1   	-- Inst15 
	 sub R3, R3, 1   	-- Inst16 
	 brnz R3, boucle 	-- Inst17 
	 exit   			-- Inst18 
.end