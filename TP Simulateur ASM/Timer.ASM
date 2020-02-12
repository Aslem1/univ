boucle:
	CLO
	MOV AL,C3
	OUT 02
	MOV AL,01
	OUT 02
	MOV AL,FF
	OUT 02
	MOV AL,0
	OUT 02
	JMP boucle
	END