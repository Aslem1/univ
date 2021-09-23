#include <stdio.h>
#include <stdlib.h>

int main()
{
    int X = 1;
    int Y = 0;
    int Z = 0;
    int A = 1;
    int B = 1;

    //D = (X and Y and Z) or (((X and Y) or (Y and Z) or (X and Z)) and (A and B))
    int D = (X && Y && Z) || (((X && Y) || (Y && Z) || (X && Z)) && (A && B));
    if(D) {
        printf("diplome obtenu");
    }
    else {
        printf("diplome non obtenu");
    }
}
