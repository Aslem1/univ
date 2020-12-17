


#ifdef NDEBUG
#undef NDEBUG
#endif
#include <assert.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

#include <ga/ga.h>






int main(void) {
 
  

  {
	
	
    
    GeneticGenerator* generator = genetic_generator_create(81);
    for(unsigned int i=0;i<genetic_generator_get_size(generator);i++){
	genetic_generator_set_cardinality(generator,i,9); 
    }
    Population* population=ga_population_create(generator,100);
    
    
    
    
    
    genetic_generator_destroy(generator);
    ga_population_destroy(population);
    
  }
  
  return EXIT_SUCCESS;
}
