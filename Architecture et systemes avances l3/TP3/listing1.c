#include <stdio.h>
#define N 8
main() {
	int i;
	int j;
	int k;
	for (i=0 ; i< N ; i++) {
	for (j=0 ; j<N ; j++) { tmp = 0;
	for (k=0; k< N ; k++) {
	tmp = tmp + A[i][k] * B[k][j];
	} C[i][j] = tmp;
	}
	}
}