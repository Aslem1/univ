


#ifdef NDEBUG
#undef NDEBUG
#endif
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>

#include <ga/ga.h>

int main(void) {
  ga_init();
  {
	GeneticGenerator* generator = genetic_generator_create(10);
	genetic_generator_set_cardinality(generator, 0,9);
	genetic_generator_set_cardinality(generator, 1,9);
	genetic_generator_set_cardinality(generator, 2,9);
	genetic_generator_set_cardinality(generator, 3,9);
	genetic_generator_set_cardinality(generator, 4,9);
	genetic_generator_set_cardinality(generator, 5,9);
	genetic_generator_set_cardinality(generator, 6,9);
	genetic_generator_set_cardinality(generator, 7,9);
	genetic_generator_set_cardinality(generator, 8,9);
	genetic_generator_set_cardinality(generator, 9,9);

	unsigned int *individual=genetic_generator_individual(generator);
	
	for(unsigned int i=0;i<sizeof(individual);i++){
		printf("%u\n",individual[i]);
	}
	free(individual);
    	genetic_generator_destroy(generator);
  }
  ga_finish();
  return EXIT_SUCCESS;
}
