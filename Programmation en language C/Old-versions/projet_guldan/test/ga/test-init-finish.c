

#include <stdlib.h>

#ifdef NDEBUG
#undef NDEBUG
#endif
#include <assert.h>

#include <ga/ga.h>

int main(void) {
  assert(ga_init());
  assert(ga_init());
  assert(ga_init());
  { /* some code */
  }
  assert(ga_finish());
  assert(ga_finish());
  assert(ga_finish());
  assert(!ga_finish());
  return EXIT_SUCCESS;
}
