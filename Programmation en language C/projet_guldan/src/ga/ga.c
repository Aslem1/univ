#include <assert.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>


#include "./ga.h"
#include "./ga.inc"

void *(*ga_malloc)(size_t size) = malloc;
void *(*ga_realloc)(void *ptr, size_t size) = realloc;
void (*ga_free)(void *ptr) = free;

static int counter = 0;
/**
 * @brief
 *
 * @return true
 * @return false
 */
bool ga_init(void) {
  if (!counter++) {
    assert(printf("GA initialised\n"));
  }
  return true;
}

/**
 * @brief
 *
 * @return true
 * @return false
 */
bool ga_finish(void) {
  if (counter) {
    if (!--counter) {
      assert(printf("GA finished\n"));
    }
    return true;
  } else {
    return false;
  }
}
/**
 * @brief
 *
 * @param size
 * @return GeneticGenerator*
 */
GeneticGenerator *genetic_generator_create(const unsigned int size) {
  GeneticGenerator *generator = ga_malloc(sizeof *generator);
  if (generator) {
    generator->size = size;
    if (size) {
      generator->cardinalities = ga_malloc(sizeof(unsigned int) * size);
      if (!generator->cardinalities) {
        ga_free(generator);
        generator = NULL;
      } else {
        memset(generator->cardinalities, 0, sizeof(unsigned int) * size);
      }
    } else {
      generator->cardinalities = NULL;
    }
  }
  return generator;
}
/**
 * @brief
 *
 * @param generator
 */
void genetic_generator_destroy(GeneticGenerator *generator) {
  ga_free(generator->cardinalities);
  ga_free(generator);
}
/**
 * @brief
 *
 * @param generator
 * @param index
 * @param cardinality
 * @return GeneticGenerator*
 */
GeneticGenerator *genetic_generator_set_cardinality(GeneticGenerator *generator, const unsigned int index,const unsigned int cardinality) {
  assert(index < generator->size);
  generator->cardinalities[index] = cardinality;
  return generator;
}
/**
 * @brief
 *
 * @param generator
 * @param index
 * @return unsigned int
 */
unsigned int genetic_generator_get_cardinality(const GeneticGenerator *generator, const unsigned int index) {
  assert(index < generator->size);
  return generator->cardinalities[index];
}
/**
 * @brief
 *
 * @param generator
 * @return unsigned int
 */
unsigned int genetic_generator_get_size(const GeneticGenerator *generator) {
  return generator->size;
}
/**
 * @brief
 *
 * @param generator
 * @return GeneticGenerator*
 */
GeneticGenerator *genetic_generator_clone(const GeneticGenerator *generator) {
  GeneticGenerator *clone = genetic_generator_create(generator->size);
  if (clone) {
    memcpy(clone->cardinalities, generator->cardinalities, generator->size * sizeof(unsigned int));
    return clone;
  } else {
    return NULL;
  }
}
/**
 * @brief
 *
 * @param dest
 * @param src
 * @return GeneticGenerator*
 */
GeneticGenerator *genetic_generator_copy(GeneticGenerator *dest, const GeneticGenerator *src) {
  unsigned int *cardinalities = ga_realloc(dest->cardinalities, src->size * sizeof(unsigned int));
  if (cardinalities) {
    dest->size = src->size;
    dest->cardinalities = cardinalities;
    memcpy(dest->cardinalities, src->cardinalities, src->size * sizeof(unsigned int));
    return dest;
  } else {
    return NULL;
  }
}
/**
 * @brief
 *
 * @param generator
 * @param stream
 * @return GeneticGenerator*
 */
GeneticGenerator *genetic_generator_fwrite(const GeneticGenerator *generator, FILE *stream) {
  if (fwrite(&generator->size, sizeof(generator->size), 1, stream) == 1 &&
      fwrite(generator->cardinalities, sizeof(unsigned int), generator->size, stream) == generator->size) {
    return (GeneticGenerator *)generator;
  } else {
    return NULL;
  }
}
/**
 * @brief
 *
 * @param generator
 * @param stream
 * @return GeneticGenerator*
 */
GeneticGenerator *genetic_generator_fread(GeneticGenerator *generator, FILE *stream) {
  unsigned int size;
  unsigned int *cardinalities;
  if (fread(&size, sizeof(size), 1, stream) == 1) {
    cardinalities = ga_malloc(sizeof(unsigned int) * size);
    if (cardinalities) {
      if (fread(cardinalities, sizeof(unsigned int), size, stream) == size) {
        ga_free(generator->cardinalities);
        generator->size = size;
        generator->cardinalities = cardinalities;
        return generator;
      } else {
        ga_free(cardinalities);
        return NULL;
      }
    } else {
      return NULL;
    }
  } else {
    return NULL;
  }
}
/**
 * @brief
 *
 * @param pstring
 * @param plength
 * @param add
 * @return true
 * @return false
 */

static bool _add_string(char **pstring, unsigned int *plength, const char *add) {
  if (add) {
    unsigned int inc_length = strlen(add);
    char *string = ga_realloc(*pstring, *plength + inc_length + 1);
    if (string) {
      *pstring = string;
      strncpy(*pstring + *plength, add, inc_length + 1);
      *plength += inc_length;
      return true;
    } else {
      return false;
    }
  } else {
    return false;
  }
}

/**
 * @brief
 *
 * @param generator
 * @return const char*
 */
const char *genetic_generator_to_string(const GeneticGenerator *generator) {
  static char *string = NULL;
  unsigned int length;
  
  length = 0;

  if (!_add_string(&string, &length, "[")) {
    return NULL;
  }
  for (unsigned int index = 0; index < generator->size; index++) {
    if (index) {
      if (!_add_string(&string, &length, ",")) {
        return NULL;
      }
    }
    char element[100];
    snprintf(element, 100, "%u", generator->cardinalities[index]);
    if (!_add_string(&string, &length, element)) {
      return NULL;
    }
  }
  if (!_add_string(&string, &length, "]")) {
    return NULL;
  }
  return string;
}
/**
 * @brief generate random
 *
 * @param int a
 * @return int b
 */
static int rand_a_b(int a, int b){
	srand(time(NULL));
	return rand()%(b-a) +a;
}

/**
 * @brief Create an individual
 *
 * @param generator
 * @return unsigned* genetic_generator_individual
 */
unsigned int *genetic_generator_individual(const GeneticGenerator *generator) {
  // memory allocation
  unsigned int *individual = calloc(generator->size, sizeof(unsigned int));

  if (individual) {  // allocated
    // fill the tab
    for (unsigned int i = 0; i < generator->size; i++) {
      
      individual[i] = rand_a_b(1,(genetic_generator_get_cardinality(generator, i))+1);
       
    }

    return individual;
  } else {  // memory problem
    return NULL;
  }
}

unsigned int population_get_size(Population* population){
	return population->size;
}
GeneticGenerator * population_get_generator(Population* population){
	return population->generator;
}
unsigned int * population_get_individual(Population* population, unsigned int index){
	return population->individual[index];
}


Population* ga_population_create(const GeneticGenerator* generator,unsigned int size){
	Population*population=malloc(sizeof(Population));
	
	population->size=size+(size%2); //the size of the population must be even

	population->generator=genetic_generator_clone(generator);
	
	population->individual=malloc((population_get_size(population))*sizeof(unsigned int*));

	for (unsigned int i=0;i<population_get_size(population);i++){
		population->individual[i]=genetic_generator_individual(generator);
	}
	return population;
}

void ga_population_destroy(Population*population){
	
	for (unsigned int i=0;i<population_get_size(population);i++){
		free(population->individual[i]);
	}
	free(population->individual);
	genetic_generator_destroy(population->generator);
	free(population);
	
}





void setPop(Population *pop, unsigned int **individu) {
  memmove(pop->individual, individu, sizeof(pop->individual));
}

/**
 * @brief Mutate one gene
 * 
 * @param individual 
 * @param index 
 */
static void mutateF(unsigned int *individual, unsigned int index) {
  srand(time(NULL));
  unsigned int g = rand() % ((index) + 1);
  individual[index] = g;
}

/**
 * @brief Cross over one gen over 2 individu
 * 
 * @param Ia 
 * @param Ib 
 * @param index 
 */
static void cross_overF(unsigned int *Ia, unsigned int *Ib, unsigned int index) {
  unsigned int tmp = Ia[index];
  Ia[index] = Ib[index];
  Ib[index] = tmp;
}

Population *ga_population_next(Population *population, const float cross_over, const float mutation,
                               unsigned int (*evaluate)(unsigned int *, const void *), const void *problem) {

  // create the new pop we return
  Population *newpop = ga_population_create(genetic_generator_clone(population->generator), population->size);

  /**
   * @brief The two selected individu.
   *
   */
  
  unsigned int **selection = calloc(1, sizeof(unsigned int *) *2);
  for(unsigned int i=0;i<2;i++){
	selection[i]=malloc(population->generator->size*sizeof(unsigned int));
  }
  /**
   * @brief The tab with the value of evaluate.
   *
   */
  unsigned int *evalResult = calloc(population->size, sizeof(unsigned int));
  unsigned int sommeResult = 0;
  unsigned int countIndividus = 0;
  unsigned int counter=0;
  // fill evaResult
  
  for (unsigned int j = 0; j < population->size; j++) {
    evalResult[j] = evaluate(population->individual[j], problem);
    sommeResult += evalResult[j];
  }

  // + 1 because if the population is not pair
  // we need an new individus selected in the two generated
  // and at the end of the loop we add the correct number of individu
  // inserted one if need one or two
  while (counter < newpop->size) {
    // select the two individus
    for (unsigned int i = 0; i < 2; i++) {
      srand(time(NULL));
      unsigned int random = rand() % sommeResult;

      // index for the evaResult
      unsigned int index = 0;
      // the somme determinate if is choose
      unsigned int somme = evalResult[index];
      while (somme <= sommeResult) {
        index++;

        // add for the next loop
        somme += evalResult[index];
      }
	/*add individual in selection*/
	for(unsigned int k=0;k<population->generator->size;k++){
		selection[i][k]=population->individual[index][k];
	}
	
    }
	
    // cross over in the genome
    for (unsigned int i = 0; i < population->generator->size; i++) {
      srand(time(NULL));
      unsigned int random = rand() % 100;

      if (random < cross_over * 100) {
        cross_overF(selection[0], selection[1], i);
      }
    }
	
    // mutate the genome of the two individus
    for (unsigned int j = 0; j < 2; j++) {
      for (unsigned int i = 0; i < population->generator->size; i++) {
        srand(time(NULL));
        unsigned int random = rand() % 100;

        if (random < mutation * 100) {
          mutateF(selection[j], i);
        }
      }
    }

    
    // we insert individu in newpop
    for(unsigned int k=0;k<2;k++){
	for(unsigned int i=0;i<population->generator->size;i++){
		newpop->individual[counter][i]=selection[k][i];
	}
      counter++;
    }

 }
  free(selection);
  free(evalResult);
  //ga_population_destroy(population);
	
  return newpop;
}




