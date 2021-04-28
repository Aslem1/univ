
#include <stdlib.h>

#ifdef NDEBUG
#undef NDEBUG
#endif
#include <assert.h>
#include <stdio.h>
#include <string.h>
#include "ga/ga.h"
#include "ga/ga.inc"
int main(void) {
  ga_init();
  {
    GeneticGenerator* generator = genetic_generator_create(10);
    assert(genetic_generator_get_size(generator) == 10);
    for (unsigned int index = 0; index < genetic_generator_get_size(generator); index++) {
      assert(genetic_generator_get_cardinality(generator, index) == 0);
    }
    /*Population* population=ga_population_create(generator,99);
	printf("jhghj");
    assert(population_get_size(population)== 100);
	for(unsigned int j=0;j<population_get_size(population);j++){
    		for (unsigned int index = 0; index < genetic_generator_get_size(generator); index++) {
			assert(population->individual[j][index]==0);
		}
	}
    
    ga_population_destroy(population);*/
   genetic_generator_destroy(generator);
  }
  ga_finish();
  return EXIT_SUCCESS;
}
