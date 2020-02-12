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

boucleA:
MOV AL,[DL]
OUT 02
INC DL
MOV CL,B0

JNZ boucleA

boucleB:
MOV AL,[CL]
OUT 02
ADD CL,1
MOV CL,FB

JNZ boucleB

END


