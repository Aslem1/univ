#ifndef GENETIC_GENERATOR_STRUCT_ // Not TODO (only for moodle coderunner)
#define GENETIC_GENERATOR_STRUCT_

struct _GeneticGenerator {
  unsigned int size;
  unsigned int *cardinalities;
};
struct _Population{
	unsigned int size;
	GeneticGenerator* generator;
	unsigned int**individual;
};
#endif // GENETIC_GENERATOR_STRUCT_


