CC       = gcc
CFLAGS   = 
LDLIBS =  -pthread -lrt

SRC      = $(wildcard *.c)
OBJ      = $(SRC:.c=.o)

EXEC     = $(basename $(SRC))

all: $(EXEC)

%.o: %.c
	$(CC) -o $@ -c $< $(CFLAGS)

.PHONY: clean mrproper

clean:
	@rm -rf *.o

mrproper: clean
	@rm -rf $(EXEC)

echo:
	echo $(EXEC)
