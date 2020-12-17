

#include <stdlib.h>
#include <string.h>

#ifdef NDEBUG
#undef NDEBUG
#endif
#include <assert.h>

#include <ga/ga.h>

int main(void) {
  ga_init();
  {
    GeneticGenerator* generator = genetic_generator_create(10);
    genetic_generator_set_cardinality(generator, 0, 5);
    assert(strcmp(genetic_generator_to_string(generator), "[5,0,0,0,0,0,0,0,0,0]") == 0);
    genetic_generator_destroy(generator);
  }
  ga_finish();
  return EXIT_SUCCESS;
}
