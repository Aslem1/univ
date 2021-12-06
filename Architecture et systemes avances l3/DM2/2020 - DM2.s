.data   0

.program 100
			br pgm		-- inst1 : Ligne program
			nop		
			nop
			nop
			nop
.sspgm		        
                        sub R12,R12,1  	-- inst2 : Ligne sspgm
			sub R13,R13,1	-- inst3 
			br boucle2	-- inst4 

			nop		
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop
			nop

.pgm
			li R3, 400		--  inst5 :Ligne pgm
			li R12,0		--  inst6
			li R13,0		--  inst7
			li R14,0		--  inst8
			li R15,0		--  inst9
					
				
.boucle			
			add R12,R12,1		-- inst10 : Ligne boucle
			add R13,R13,1		-- inst11 
			br sspgm		-- inst12 
.boucle2
			add R14,R14,1		-- inst13		 
			sub R3, R3, 1		-- inst14 : Ligne boucle2
    			brnz R3, boucle		-- inst15 : Ligne fin de boucle
            
.end          		exit			-- inst16 : Ligne exit
		
			

