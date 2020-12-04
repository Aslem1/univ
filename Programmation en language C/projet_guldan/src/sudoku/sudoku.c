#include <assert.h>
#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <math.h>

#include <yaml.h>

#include "../ga/ga.h"


#ifndef SUDOKU_
#define SUDOKU_
struct _Sudoku{
	unsigned int size;
	unsigned int*sudoku_init;
};
#endif
typedef struct _Sudoku Sudoku;

unsigned int evaluate(unsigned int *individual, const void*problem){
	
	unsigned int evaluate;
	
	unsigned int pbline=0,pbcolumn=0;
	Sudoku*sudoku=(Sudoku*)problem;
	unsigned int size=sudoku->size;
	
	unsigned int root=sqrt(size);
	
	unsigned int *newIndividual=malloc(size*sizeof(unsigned int));
	unsigned int count=0;
	
	for(unsigned int i=0;i<size;i++){
		if(sudoku->sudoku_init[i]==0){
			
			//printf("individual[count]:%u\n",individual[3]);
			
			newIndividual[i]=individual[count];//PROBLEM!
			count++;
			
			
		}else{
			newIndividual[i]=sudoku->sudoku_init[i];
			
		}
	}
	
	for (unsigned int i=0;i<root;i++){
		for(unsigned int current=0;current<root;current++){
			for(unsigned int j=0;j<root;j++){
				if((newIndividual[i*root+current]==newIndividual[i*root+j])&&((i*root+current)!=(i*root+j))){//testline:
					pbline++;
				}if((newIndividual[i*root+current]==newIndividual[j*root+current])&&((i*root+current)!=(j*root+current))){//testcolumn:
					pbcolumn++;
				}
			}
		}
	}
	
	evaluate=(unsigned int)(100*(size-((pbline+pbcolumn)/root))/size);
	free(newIndividual);

	//printf("evaluate: %u\n",evaluate);
	return evaluate;
}

void Error(int i);

unsigned int convert(const char *st);


int main(int argc, char const *argv[]) {
	
  // check the number of arguments
  if (argc <= 5) {
    Error(5);
    return 5;
  }

  // get the path to the sudoku
  const char *path = argv[1];

  // get the cross_over mutation value
  float cross_over = atof(argv[2]);
  float mutation = atof(argv[3]);

  // get the size and the number of generation
  int sizePopulation = convert(argv[4]);
  int numberOfGeneration = convert(argv[5]);

  // check if an error as ocure
  if (sizePopulation == -1 || numberOfGeneration == -1) {
    Error(-1);
    return 1;
  }

  // make the args signed unsigned
  if (cross_over < 0) {
    cross_over = (-cross_over);
  }
  if (mutation < 0) {
    mutation = (-mutation);
  }
  // endmake

  // because mutation and cross_over > 1 is useless
  while (mutation > 1 || cross_over > 1) {
    if (mutation > 1) {
      mutation--;
    }
    if (cross_over > 1) {
      cross_over--;
    }
  }

  
  unsigned int cpt=0;
  

  FILE *fh = fopen(path, "r");
  yaml_parser_t parser;
  yaml_token_t  token;   

  /* Initialize parser */
  if(!yaml_parser_initialize(&parser))
    fputs("Failed to initialize parser!\n", stderr);
  if(fh == NULL)
    fputs("Failed to open file!\n", stderr);

  /* Set input file */
  yaml_parser_set_input_file(&parser, fh);
	/*to find sudoku size:*/
 do {
    yaml_parser_scan(&parser, &token);
 	
    if(token.type== YAML_SCALAR_TOKEN){ cpt++; }
   
    
    if(token.type != YAML_STREAM_END_TOKEN)
      yaml_token_delete(&token);
  } while(token.type != YAML_STREAM_END_TOKEN);
  yaml_token_delete(&token);

yaml_parser_delete(&parser);
fclose(fh);


Sudoku * f_sudoku=malloc(sizeof(Sudoku));
	f_sudoku->size=cpt;
	f_sudoku->sudoku_init=malloc(cpt*sizeof(unsigned int));
unsigned int i=0;
const char*null="null"; 


FILE *fh1 = fopen(path, "r");
yaml_parser_t parser1;
  yaml_token_t  token1;
  /* Initialize parser */
  if(!yaml_parser_initialize(&parser1))
    fputs("Failed to initialize parser!\n", stderr);
  if(fh == NULL)
    fputs("Failed to open file!\n", stderr);

  /* add nb in sudoku */
  yaml_parser_set_input_file(&parser1, fh1);
do {
    yaml_parser_scan(&parser1, &token1);
 	
    if(token1.type== YAML_SCALAR_TOKEN){ 
	
	if(strcmp(token1.data.scalar.value,null) ==0){
		f_sudoku->sudoku_init[i]=0;
		i++;
		
	}else{
		f_sudoku->sudoku_init[i]=(unsigned int)(token1.data.scalar.value[0]-48);//i don't know why -48
		i++;
		
	}
    }
   
    
    if(token1.type != YAML_STREAM_END_TOKEN)
      yaml_token_delete(&token);
  } while(token1.type != YAML_STREAM_END_TOKEN);
  yaml_token_delete(&token1);
  /* Cleanup */
  yaml_parser_delete(&parser1);
  fclose(fh1);

 


	unsigned int nbNull=0;
	for(unsigned int i=0; i<f_sudoku->size;i++){
		if(f_sudoku->sudoku_init[i]==0){	
			nbNull++;	
		}
	}
	GeneticGenerator *generator=genetic_generator_create(nbNull);
	for(unsigned int i=0;i<nbNull;i++){
		genetic_generator_set_cardinality(generator, i,(int)sqrt(f_sudoku->size));
	}
	

	Population* population=ga_population_create(generator,sizePopulation);
	unsigned int GenerationCurrent=0;
	bool solution=false;
	unsigned int IndividualCurrent=0;

	/*while((GenerationCurrent<numberOfGeneration)&&(solution==false)){
		
		population=ga_population_next(population,cross_over,mutation,&evaluate,f_sudoku);
		
		for(unsigned int pop=0;pop<population->size;pop++){
			for(unsigned int individualInPop=0;individualInPop<genetic_generator_get_size(population_get_generator(population));individualInPop++){
				//population->individual[pop][individualInPop]=newpop->individual[pop][individualInPop];
				if(evaluate(population->individual[pop],f_sudoku)==100){
					solution=true;
					IndividualCurrent=pop;
				}
			}
		}//ga_population_destroy(newpop);
		printf("current Population: %u\n",GenerationCurrent);
		GenerationCurrent++;
	}*/
	//end test ga_population_next
	


/*write in tmpfile.yaml*/
unsigned int current=0;
for(unsigned int i=0;i<f_sudoku->size;i++){
	if(f_sudoku->sudoku_init[i]==0){
    	 	f_sudoku->sudoku_init[i]=population_get_individual(population,IndividualCurrent)[current];
		current++;
	}	
}
unsigned int k=0;
FILE *fh2 = fopen(path, "r");
yaml_parser_t parser2;
  yaml_token_t  token2;
  /* Initialize parser */
  if(!yaml_parser_initialize(&parser2))
    fputs("Failed to initialize parser!\n", stderr);
  if(fh == NULL)
    fputs("Failed to open file!\n", stderr);

  
  yaml_parser_set_input_file(&parser2, fh2);
do {
    yaml_parser_scan(&parser2, &token2);
 	
    switch(token2.type)
    {
    
    case YAML_STREAM_START_TOKEN:  break;
    case YAML_STREAM_END_TOKEN:   break;
   
    case YAML_KEY_TOKEN:   printf("(Key token)   "); break;
    case YAML_VALUE_TOKEN: printf("(Value token) "); break;
    
    case YAML_BLOCK_SEQUENCE_START_TOKEN:  break;
    case YAML_BLOCK_ENTRY_TOKEN:          puts("\n[");    break;
    case YAML_BLOCK_END_TOKEN:      puts("]\n");                    break;
 
    case YAML_BLOCK_MAPPING_START_TOKEN:              break;
    case YAML_SCALAR_TOKEN:  printf(" %u, ",f_sudoku->sudoku_init[k]);k++; break;
   
   
   
    
    }if(token2.type != YAML_STREAM_END_TOKEN)
      yaml_token_delete(&token);
  } while(token2.type != YAML_STREAM_END_TOKEN);
  yaml_token_delete(&token2);
  /* Cleanup */
  yaml_parser_delete(&parser2);
  fclose(fh2);


	free(f_sudoku);
	genetic_generator_destroy(generator);
    	ga_population_destroy(population);
}






unsigned int convert(const char *st) {
  const char *x;
  for (x = st; *x; x++) {
    if (!isdigit(*x))
      return -1;
  }
  return (strtoul(st, 0L, 10));
}
// endfrom

/**
 * @brief Print the error.
 *
 * @param i
 */
void Error(int i) {
  switch (i) {
    case 5:
      printf("Please give the correct argument\n");
      break;

    case -1:
      printf("Please give the correct type argument\n");
      break;

    case 0:
    printf("Files not found\n");
      break;

    default:
      printf("Unknow error\n");
      break;
  }
  printf(
      "./Sudoku path_to_the_file cross_over_possibility:float mutation_possibility:float size_of_population:integer "
      "number_of_generation:integer\n");
}

