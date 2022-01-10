/**
 * @file treeBicolor.h
 * @author NIVET Marie, NTSAMA Estelle, PERRIN Agathe, PEARSON Nicole
 * @brief Bicolore lib header.
 * @version 0.1
 * @date 2022-01-10
 */
#include <stdbool.h>
#include <stdlib.h>

#include "./max.h"

#ifndef TREERB_TREEBICOLOR_H_
#define TREERB_TREEBICOLOR_H_

/**
 * @brief Définition de la structure _Node en tant que type Tree.
 *
 */
typedef struct _Node Tree;

/**
 * @brief Enum for color.
 *
 */
typedef enum { RED, BLACK } Color;

/**
 * @brief Permet d'instancier un nouvel arbre dans la mémoire.
 *
 * @param data
 * @return Tree*
 */
extern Tree* tree_new(void* data, size_t size);

/**
 * @brief Désallocation complète de t.
 *
 * @param tree
 * @param delete function de destruction de data
 */
extern void tree_destroy(Tree* tree, void (*delete)(void*));

/**
 * @brief Getter pour data.
 *
 * @param tree
 * @return void*
 */
extern void* get_data(Tree* tree);

/**
 * @brief Setter pour data.
 *
 * @param tree
 * @param data
 * @return true
 * @return false
 */
extern bool set_data(Tree* tree, void* data);

/**
 * @brief Getter pour la racine de l'arbre.
 *
 * @param tree
 * @return Tree*
 */
extern Tree* get_root(Tree* tree);

/**
 * @brief Getter pour le pere de l'arbre.
 *
 * @param tree
 * @return Tree*
 */
extern Tree* get_father(Tree* tree);

/**
 * @brief Setter pour la racine de l'arbre
 *
 * @param tree
 * @param root
 * @return true
 * @return false
 */
extern bool set_root(Tree* tree, Tree* root, int (*compare)(void*, void*));

/**
 * @brief Setter pour le pere de l'arbre
 *
 * @param tree
 * @param root
 * @return true
 * @return false
 */
extern bool set_father(Tree* tree, Tree* root);

/**
 * @brief Getter pour l'arbre gauche.
 *
 * @param tree
 * @return Tree*
 */
extern Tree* get_left(Tree* tree);

/**
 * @brief Setter pour l'arbre gauche.
 *
 * @param tree
 * @param left
 * @return true
 * @return false
 */
extern bool set_left(Tree* tree, Tree* left);

/**
 * @brief Getter pour l'arbre droit.
 *
 * @param tree
 * @return Tree*
 */
extern Tree* get_right(Tree* tree);

/**
 * @brief Setter pour l'arbre droit.
 *
 * @param tree
 * @param right
 * @return true
 * @return false
 */
extern bool set_right(Tree* tree, Tree* right);

/**
 * @brief Getter pour la hauteur.
 *
 * @param tree
 * @return int
 */
extern int get_height(Tree* tree);

/**
 * @brief Setter pour la hauteur.
 *
 * @param tree
 * @param height
 * @return true
 * @return false
 */
extern bool set_height(Tree* tree, int height);

/**
 * @brief Getter pour la couleur.
 *
 * @param tree
 * @return int
 */
extern int get_color(Tree* tree);

/**
 * @brief Setter pour la couleur.
 *
 * @param tree
 * @param c
 * @return true
 * @return false
 */
extern bool set_color(Tree* tree, Color c);

/**
 * @brief Equilibre l'arbre.
 *
 * @param tree
 * @return int
 */
extern int get_balance(Tree* tree);

/**
 * @brief Retourne si c'est un noeud vide (sentinelle).
 *
 * @param tree
 * @return true
 * @return false
 */
extern bool is_empty(Tree* tree);

/**
 * @brief Affiche l'arbre en pre.
 *
 * @param tree
 */
extern void tree_show_pre(Tree* tree, void (*print)(void*));

/**
 * @brief Affiche l'arbre en in.
 *
 * @param tree
 */
extern void tree_show_in(Tree* tree, void (*print)(void*));

/**
 * @brief Affiche l'arbre en post.
 *
 * @param tree
 */
extern void tree_show_post(Tree* tree, void (*print)(void*));

/**
 * @brief Insère une nouvelle node à l'arbre.
 *
 * @param tree
 * @param data
 * @param compare Compare 2 data renvoie 0 égal 1 supérieur -1 inférieur
 * @return Tree*
 */
extern Tree* tree_insert(Tree* tree, void* data, int (*compare)(void*, void*),
                         size_t size);

/**
 * @brief Fonction d'équilibrage et de coloration post insertion.
 *
 * @param tree
 * @return Tree*
 */
extern void tree_correction_after_insertion(Tree* tree, Tree* z,
                                            int (*compare)(void*, void*));

/**
 * @brief Supprimme la node contenant data.
 *
 * @param tree
 * @param data
 * @param compare Compare 2 data renvoie 0 égal 1 supérieur -1 inférieur
 * @return Tree*
 */
extern Tree* tree_delete(Tree* tree, void* data, int (*compare)(void*, void*));

/**
 * @brief Fonction d'équilibrage et de coloration post supression.
 *
 * @param tree
 */
extern void tree_correction_after_delete(Tree* tree, Tree* x,
                                         int (*compare)(void*, void*));

/**
 * @brief Donne le sucesseur.
 *
 * @param x
 * @return Tree*
 */
extern Tree* tree_sucessor(Tree* x);

/**
 * @brief Permet de récupérer le minimum de l'arbre.
 *
 * @param tree
 * @return Tree*
 */
extern Tree* min_tree(Tree* tree);

/**
 * @brief Permet de récupérer le maximum de l'arbre.
 *
 * @param tree
 * @return Tree*
 */
extern Tree* max_tree(Tree* tree);

/**
 * @brief Fonction de rotation de noeud gauche.
 *
 * @param T
 * @param x
 * @return Tree*
 */
extern Tree* left_rotate(Tree* T, Tree* x, int (*compare)(void*, void*));

/**
 * @brief Fonction de rotation de noeud droite.
 *
 * @param T
 * @param x
 * @return Tree*
 */
extern Tree* right_rotate(Tree* T, Tree* x, int (*compare)(void*, void*));

/**
 * @brief Recherche si data est présente dans l'arbre.
 *
 * @param tree
 * @param data
 * @param compare Compare 2 data renvoie 0 égal 1 supérieur -1 inférieur
 * @return Tree*
 */
extern Tree* search(Tree* tree, void* data, int (*compare)(void*, void*));

#endif  // TREERB_TREEBICOLOR_H_
