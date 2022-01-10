/**
 * @file treeBicolor.c
 * @author NIVET Marie, NTSAMA Estelle, PERRIN Agathe, PEARSON Nicole
 * @brief Bicolore lib.
 * @version 0.1
 * @date 2022-01-10
 */
#include "treeBicolor.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "treeBicolor.inc"

static Tree* create_sentinelle() {
    Tree* tree = calloc(1, sizeof(Tree));

    if (tree) {
        tree->root = NULL;
        tree->left = NULL;
        tree->right = NULL;
        tree->height = 1;
        tree->color = BLACK;

        return tree;
    }
    return NULL;
}

/*
 * Permet d'instancier un nouvel arbre dans la mémoire
 */
Tree* tree_new(void* data, size_t size) {
    Tree* tree = calloc(1, sizeof(Tree) + size);

    if (tree) {
        memcpy(tree->data, data, size);
        tree->root = create_sentinelle();
        tree->left = create_sentinelle();
        set_father(tree->left, tree);
        tree->right = create_sentinelle();
        set_father(tree->right, tree);
        tree->height = 1;
        tree->color = BLACK;

        return tree;
    }
    return NULL;
}

/*
 * Libére la mémoire alloué par l'arbre
 */
void tree_destroy(Tree* tree, void (*delete)(void*)) {
    if (tree != NULL && !is_empty(tree)) {
        tree_destroy(tree->left, delete);
        tree_destroy(tree->right, delete);
        delete (tree->data);
        free(tree);
    } else if (is_empty(tree)) {
        free(tree);
    }
}

/*
 * Permet de récuperer la valeur de l'arbre
 */
void* get_data(Tree* tree) {
    if (tree) {
        return tree->data;
    }

    return NULL;
}

/*
 * Permet de changer la valeur de l'arbre
 */
bool set_data(Tree* tree, void* data) {
    if (tree && !is_empty(tree)) {
        memcpy(tree->data, data, sizeof(char));
        return true;
    }
    return false;
}

/*
 * Permet de récuperer la racine de l'arbre
 */
Tree* get_root(Tree* tree) {
    if (!is_empty(tree)) {
        if (!is_empty(get_father(tree))) {
            return get_root(get_father(tree));
        }
        return tree;
    }
    return NULL;
}

/*
 * Permet de récuperer le père de l'arbre
 */
Tree* get_father(Tree* tree) {
    if (tree && !is_empty(tree)) {
        return tree->root;
    }
    return NULL;
}

/*
 * Permet de changer la racine de l'arbre
 */
bool set_root(Tree* tree, Tree* root, int (*compare)(void*, void*)) {
    assert(!is_empty(root) && !is_empty(tree));

    Tree* root_of_tree = get_root(tree);
    if (tree && !is_empty(tree)) {
        if (compare(tree, root) == 1) {
            set_right(root, tree);
            root_of_tree->root = root->root;
            return true;
        } else if (compare(tree, root) == -1) {
            set_left(root, tree);
            root_of_tree->root = root->root;
            return true;
        } else {
            assert(compare(tree, root) != 0);
        }
    }
    return false;
}

/*
 * Permet de changer le père de l'arbre
 */
bool set_father(Tree* tree, Tree* root) {
    if (tree && !is_empty(tree)) {
        tree->root = root;
        return true;
    }

    return false;
}

/*
 * Permet de récuperer le fils gauche de l'arbre
 */
Tree* get_left(Tree* tree) {
    if (tree) {
        return tree->left;
    }

    return NULL;
}

/*
 * Permet de changer le fils gauche de l'arbre
 */
bool set_left(Tree* tree, Tree* left) {
    if (tree && !is_empty(tree)) {
        tree->left = left;
        return true;
    }

    return false;
}

/*
 * Permet de récuperer le fils droit de l'arbre
 */
Tree* get_right(Tree* tree) {
    if (tree) {
        return tree->right;
    }

    return NULL;
}

/*
 * Permet de changer le fils droit de l'arbre
 */
bool set_right(Tree* tree, Tree* right) {
    if (tree && !is_empty(tree)) {
        tree->right = right;
        return true;
    }

    return false;
}

/*
 * Permet de récuperer la hauteur de l'arbre
 */
int get_height(Tree* tree) {
    if (tree) {
        // return MAX(get_height(tree->left), get_height(tree->right)) + 1;
        return tree->height;
    }

    return 0;
}

/*
 * Permet de changer la hauteur de l'arbre
 */
bool set_height(Tree* tree, int height) {
    if (tree && is_empty(tree)) {
        tree->height = height;
        return true;
    }

    return false;
}

/*
 * Permet de récuperer la hauteur de l'arbre
 */
int get_color(Tree* tree) {
    if (tree) {
        return tree->color;
    }

    return 0;
}

/*
 * Permet de changer la hauteur de l'arbre
 */
bool set_color(Tree* tree, Color c) {
    if (tree && !is_empty(tree)) {
        tree->color = c;
        return true;
    }

    return false;
}

/*
 * Permet de récuperer l'équilibre de l'arbre
 */
int get_balance(Tree* tree) {
    if (tree && !is_empty(tree)) {
        Tree* l = get_left(tree);
        Tree* r = get_right(tree);

        if (is_empty(l)) l = 0;
        if (is_empty(r)) r = 0;

        return get_height(l) - get_height(r);
    }

    return 0;
}

/*
 * Retourne si c'est un noeud vide (sentinelle).
 */
bool is_empty(Tree* tree) {
    if (tree && get_left(tree) == NULL && get_right(tree) == NULL) {
        return true;
    }
    return false;
}

/*
 * Permet d'afficher l'arbre
 */
void tree_show_pre(Tree* tree, void (*print)(void*)) {
    if (tree) {
        printf("Node : ");
        print(get_data(tree));
        printf(" height %d balance %d root %p left %p right %p\n", get_height(tree),
               get_balance(tree), get_data(tree->root), get_data(tree->left),
               get_data(tree->right));
        tree_show_pre(get_left(tree), print);
        tree_show_pre(get_right(tree), print);
    }
}

/*
 * Permet d'afficher l'arbre
 */
void tree_show_in(Tree* tree, void (*print)(void*)) {
    if (tree && !is_empty(tree)) {
        tree_show_in(get_left(tree), print);

        printf("Node %p : ", tree);
        print(get_data(tree));
        printf(" height %d balance %d root %d left %p right %p color %s\n",
               get_height(tree), get_balance(tree), *(int*)get_data(tree->root),
               get_data(tree->left), get_data(tree->right),
               get_color(tree) == RED ? "ROUGE" : "NOIR");

        tree_show_in(get_right(tree), print);
    }
}

/*
 * Permet d'afficher l'arbre
 */
void tree_show_post(Tree* tree, void (*print)(void*)) {
    if (tree) {
        tree_show_post(get_left(tree), print);
        tree_show_post(get_right(tree), print);
        printf("Node : ");
        print(get_data(tree));
        printf(" height %d balance %d root %p left %p right %p\n", get_height(tree),
               get_balance(tree), get_data(tree->root), get_data(tree->left),
               get_data(tree->right));
    }
}

/*
 * Permet d'inserer un noeud dans l'arbre
 */
Tree* tree_insert(Tree* tree, void* data, int (*compare)(void*, void*), size_t size) {
    if (tree && search(tree, data, compare) == NULL) {
        Tree* y = create_sentinelle();
        Tree* x = get_root(tree);

        while (!is_empty(x)) {
            y = x;
            // assert(x->data != NULL && data != NULL);

            if (compare(data, get_data(x)) == -1) {
                x = get_left(x);
            } else {
                x = get_right(x);
            }
        }

        Tree* z = tree_new(data, size);
        set_father(z, y);

        assert(y != NULL);

        if (is_empty(y)) {  // cas vide
            tree = z;
        } else if (compare(data, get_data(y)) == -1) {  // cas insertion gauche
            set_left(y, z);
        } else {  // cas insertion droite
            set_right(y, z);
        }

        set_left(z, create_sentinelle());
        set_right(z, create_sentinelle());

        z->color = RED;
        tree_correction_after_insertion(tree, z, compare);
    }
    return get_root(tree);
}

/*
 * Permet d'équilibrer un arbre après l'insertion d'un noeud
 */
void tree_correction_after_insertion(Tree* tree, Tree* z, int (*compare)(void*, void*)) {
    while (get_father(z)->color == RED && !is_empty(get_father(get_father(z)))) {
        if (get_father(z) == get_left(get_father(get_father(z)))) {
            Tree* y = get_right(get_father(get_father(z)));
            if (y->color == RED) {
                y->color = BLACK;
                get_father(get_father(z))->color = RED;
                z = get_father(get_father(z));
            } else if (z == get_right(get_father(z))) {
                z = get_father(z);
                left_rotate(tree, z, compare);
            } else {
                set_color(get_father(z), BLACK);
                set_color(get_father(get_father(z)), RED);
                right_rotate(tree, get_father(get_father(z)), compare);
            }
        } else if (get_father(z) == get_right(get_father(get_father(z)))) {
            Tree* y = get_left(get_father(get_father(z)));
            if (y->color == RED) {
                y->color = BLACK;
                get_father(get_father(z))->color = RED;
                z = get_father(get_father(z));
            } else if (z == get_left(get_father(z))) {
                z = get_father(z);
                right_rotate(tree, z, compare);
            } else {
                set_color(get_father(z), BLACK);
                set_color(get_father(get_father(z)), RED);
                left_rotate(tree, get_father(get_father(z)), compare);
            }
        }
    }
}

/*
 * Permet de supprimer un noeud dans l'arbre
 */
Tree* tree_delete(Tree* tree, void* data, int (*compare)(void*, void*)) {
    Tree* z = search(tree, data, compare);
    Tree *x, *y = NULL;

    if (is_empty(get_left(z)) || is_empty(get_right(z))) {
        y = z;
    } else {
        y = tree_sucessor(z);
    }

    if (!is_empty(get_left(y))) {
        x = get_left(y);
    } else {
        x = get_right(y);
    }

    set_father(x, get_father(y));

    if (is_empty(get_father(y))) {
        set_root(tree, x, compare);
    } else if (y == get_left(get_father(y))) {
        set_left(get_father(y), x);
    } else {
        set_right(get_father(y), x);
    }

    if (y != z) {
        set_data(z, y);
    }

    if (y->color == BLACK) {
        tree_correction_after_delete(tree, x, compare);
    }

    return get_root(y);
}

/*
 * Permet d'équilibrer un arbre après la suppression d'un noeud
 */
void tree_correction_after_delete(Tree* tree, Tree* x, int (*compare)(void*, void*)) {
    Tree* w = NULL;

    while (x != get_root(tree) && x->color == BLACK) {
        if (x == get_left(get_father(x))) {
            w = get_right(x);

            if (w->color == RED) {
                w->color = BLACK;
                get_father(x)->color = RED;

                left_rotate(tree, get_father(x), compare);
                w = get_right(get_father(x));
            }

            if (get_color(get_left(w)) == BLACK && get_color(get_right(w)) == BLACK) {
                set_color(w, RED);
                x = get_father(x);
            } else if (get_color(get_right(w)) == BLACK) {
                set_color(get_left(w), BLACK);
                set_color(w, RED);

                right_rotate(tree, w, compare);
                w = get_right(get_father(x));
            } else {
                set_color(w, get_color(get_father(x)));
                set_color(get_father(x), BLACK);
                set_color(get_right(w), BLACK);

                left_rotate(tree, get_father(x), compare);
                x = get_root(tree);
            }
        } else if (x == get_right(get_father(x))) {
            w = get_left(x);

            if (w->color == RED) {
                w->color = BLACK;
                get_father(x)->color = RED;

                left_rotate(tree, get_father(x), compare);
                w = get_left(get_father(x));
            }

            if (get_color(get_right(w)) == BLACK && get_color(get_left(w)) == BLACK) {
                set_color(w, RED);
                x = get_father(x);
            } else if (get_color(get_left(w)) == BLACK) {
                set_color(get_right(w), BLACK);
                set_color(w, RED);

                left_rotate(tree, w, compare);
                w = get_left(get_father(x));
            } else {
                set_color(w, get_color(get_father(x)));
                set_color(get_father(x), BLACK);
                set_color(get_left(w), BLACK);

                right_rotate(tree, get_father(x), compare);
                x = get_root(tree);
            }
        }
    }

    set_color(x, BLACK);
}

/*
 * Permet de récupérer le noeud minimal de l'arbre
 */
Tree* min_tree(Tree* tree) {
    if (tree->left) {
        return min_tree(tree->left);
    }

    return tree;
}

/*
 * Permet de récupérer le noeud maximal de l'arbre
 */
Tree* max_tree(Tree* tree) {
    if (tree->right) {
        return max_tree(tree->right);
    }

    return tree;
}

/**
 * Donne le sucesseur.
 */
Tree* tree_sucessor(Tree* x) {
    Tree* y = NULL;

    if (!get_right(x)) {
        return min_tree(get_right(x));
    }

    y = get_father(x);
    while (y && get_right(y) == x) {
        x = y;
        y = get_father(y);
    }

    return y;
}

/*
 * Permet d'effectuer une rotation à gauche de l'arbre
 */
Tree* left_rotate(Tree* T, Tree* x, int (*compare)(void*, void*)) {
    // met la droite de y dans x
    Tree* y = get_right(x);
    set_right(x, get_left(y));
    set_father(get_left(y), x);

    set_left(y, x);

    Tree* f = get_father(x);
    set_father(x, y);

    if (!is_empty(f)) {
        switch (compare(y->data, f->data)) {
            case 1:
                set_right(f, y);
                break;
            case -1:
                set_left(f, y);
                break;
            default:
                printf("errror\n");
                assert(false);
        }
    }

    set_father(y, f);

    return T;
}

Tree* right_rotate(Tree* T, Tree* x, int (*compare)(void*, void*)) {
    // met la droite de y dans x
    Tree* y = get_left(x);
    set_left(x, get_right(y));
    set_father(get_right(y), x);

    set_right(y, x);

    Tree* f = get_father(x);
    set_father(x, y);

    if (!is_empty(f)) {
        switch (compare(y->data, f->data)) {
            case 1:
                set_right(f, y);
                break;
            case -1:
                set_left(f, y);
                break;
            default:
                printf("errror\n");
                assert(false);
        }
    }

    set_father(y, f);

    return T;
}

/*
 * Permet de rechercher une valeur dans l'arbre
 */
Tree* search(Tree* tree, void* data, int (*compare)(void*, void*)) {
    if (tree !=NULL && !is_empty(tree)) {
        switch (compare(data, tree->data)) {
            case 1:
                return search(tree->right, data, compare);
            case 0:
                return tree;
            case -1:
                return search(tree->left, data, compare);
        }
    }

    return NULL;
}
