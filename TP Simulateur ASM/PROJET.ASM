CLO
ORG A0 ;ecriture a partir de RAM[A0]
DB FB ;stock 0 dans RAM[A0] a droite
DB 0B ;stock 1 dans RAM[A1] a droite 
DB B7 ;2
DB 9F ;3
DB 4F ;4
DB DD ;5
DB 7D ;6
DB 8B ;7
DB FF ;8
DB CF ;9
DB FA ;stock 0 dans RAM[AA] a gauche
DB 0A ;stock 1 dans RAM[AB] a gauche
DB B6 ;2
DB 9E ;3
DB 4E ;4
DB DC ;5


ORG 01 ;ecriture a partir de RAM[01]
reinitDiz: ;reinitialisation dizaines
	MOV DL,00 ;ecrit la valeur 00 dans registre DL
BoucleDiz:
	JMP AfficheDizaine ;se teleporte vers AfficheDizaine
BoucleUnite:
	JMP AfficheUnite ;se teleporte vers AfficheUnite
SuiteDiz:
	INC DL ;Incrementation DL
	CMP DL,07 ;compare 06 à DL -> si DL = 06, alors z = 1 (etat zero)
	MOV CL,00 ;remettre a 0 les unites
	JZ end ;Jump if Zero
	JMP BoucleUnite ;se tp vers BoucleUnite

SuiteUnite:
	INC CL ;Incrementation CL
	CMP CL,0A ;compare 0A (10 en decimal) a CL
	JZ BoucleDiz;Jump if Zero
	JMP BoucleUnite ;se tp vers BoucleUnite

AfficheUnite:
	MOV BL,A0 ;ecrit la valeur A0 (10 en decimal) dans le registre BL
	;INC BL ;Incrementation de BL
	ADD BL,CL ;Ajouter CL dans BL
	MOV AL,[BL] ;Transfert du code extrait de la table des unites dans le registre AL
	OUT 02 ;Affichage sur les 7 segments
	JMP SuiteUnite ;se tp vers SuiteUnite

AfficheDizaine:
	MOV BL,AA ;ecrit la valeur AA dans le registre BL
	ADD BL,DL ;Ajouter CL dans BL
	MOV AL,[BL] ;Transfert du code extrait de la table des unites dans le registre AL
	OUT 02 ;Affichage sur les 7 segments
	JMP SuiteDiz ;se tp vers SuiteDiz


end:
	END