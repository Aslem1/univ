CLO

ORG A0
dB CF
dB FF
dB 8B
dB FD
dB DD
dB 4F
dB 9F
dB B7
dB 0B
dB FB


ORG 1
MOV DL,A0
MOV AL,00
OUT 02
boucle:
MOV AL,[DL]
OUT 02
ADD DL,1
CMP AL,FB

JNZ boucle

CLO

MOV AL,CE
OUT 02

ORG 2
MOV DL,A0
MOV AL,00
OUT 02
boucle:
MOV AL,[DL]
OUT 02
ADD DL,1
CMP AL,FB

END


