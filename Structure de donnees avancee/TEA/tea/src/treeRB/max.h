#ifndef TREERB_MAX_H_
#define TREERB_MAX_H_

#ifndef MIN

#include <stdbool.h>
#include <stdlib.h>

#define MIN(x, y) ((x) > (y) ? (y) : (x))
#endif

#ifndef MAX
#define MAX(x, y) ((x) > (y) ? (x) : (y))
#endif

#endif  // TREERB_MAX_H_
