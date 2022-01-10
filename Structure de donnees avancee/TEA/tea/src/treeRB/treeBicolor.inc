#include "./treeBicolor.h"
struct _Node {
    char data[1];
    int height;
    struct _Node *left;
    struct _Node *right;
    struct _Node *root;
    Color color;
};

