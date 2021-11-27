/*Exercice 2 - Ecrivez les requêtes SQL  permettant  de  transférer  les  éléments  de  n’importe  quel 
ensemble de tables vers n’importe quel autre ensemble de tables (1FN -> 2FN, 1FN->3FN, 2FN->1FN, 
2FN->3FN, 3FN->1FN, 3FN->2FN)*/
-- 1FN -> 2FN --
INSERT INTO location2
SELECT NoDVD