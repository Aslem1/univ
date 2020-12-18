Libraries
===============

Technical details
------------------------------------------

All librairies except fr-roman includes :

+------------+---------------------------------------------------------+
| <stdio.h>  | dedicated to entry/exit operations                      |
+------------+---------------------------------------------------------+
| <stdlib.h> | dedicated to commons operations                         |
+------------+---------------------------------------------------------+
| <string.h> | dedicated to string manipulation                        |
+------------+---------------------------------------------------------+
| <ctype.h>  | dedicated to commons operations and string manipulation |
+------------+---------------------------------------------------------+

And have the following 3 arrays :

+------+--------------------------+--------------------------------------------------------------------------------------------+
| unit | static char unit[10][16] | Contains the units of the target language                                                  |
+------+--------------------------+--------------------------------------------------------------------------------------------+
| ten  | static char unit[10][16] | Contains the specific values for the ten values between 10 and 19 of the target language   |
+------+--------------------------+--------------------------------------------------------------------------------------------+
| tens | static char unit[10][16] | Contains tens of the target language                                                       |
+------+--------------------------+--------------------------------------------------------------------------------------------+

fr-roman : Roman Numeration specificities
------------------------------------------

This library is different from the previous ones.

The Includes are :

+------------+---------------------------------------------------------+
| <stdio.h>  | dedicated to entry/exit operations                      |
+------------+---------------------------------------------------------+
| <stdlib.h> | dedicated to commons operations                         |
+------------+---------------------------------------------------------+
| <string.h> | dedicated to string manipulation                        |
+------------+---------------------------------------------------------+

And have the following 1 arrays :

+---------------+------------------------------------------+
| roman_table[] | Contains all letters of numeric language |
+---------------+------------------------------------------+

Examples
----------

fr-fr : French
~~~~~~~~~~~~~~~~

+-------+-------------------------+
| value | Full letters traduction |
+=======+=========================+
| 1700  | Mille sept cents        |
+-------+-------------------------+
| -1700 | Moins mille sept cents  |
+-------+-------------------------+
| 637   | Six cent trente-sept    |
+-------+-------------------------+
 

fr-be : French belgian
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

+-------+-------------------------+
| value | Full letters traduction |
+=======+=========================+
| 1700  | Mille sept cents        |
+-------+-------------------------+
| -1700 | Moins mille sept cents  |
+-------+-------------------------+
| 83    | Octante trois           |
+-------+-------------------------+

fr-african : French African
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

+-------+-------------------------+
| value | Full letters traduction |
+=======+=========================+
| 1700  | mille sept cents        |
+-------+-------------------------+
| -1700 | Moins mille sept cents  |
+-------+-------------------------+
| 83    | quatre-vingt-et-trois   |
+-------+-------------------------+

fr-date : French Date
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

+-------+---------------------------+
| value | Full letters traduction   |
+=======+===========================+
| 1700  | Dix-sept sept cents       |
+-------+---------------------------+
| -1700 | Dix-sept cents avant JC   |
+-------+---------------------------+
| 637   | Six cent trente-sept      |
+-------+---------------------------+

fr-roman : Roman Numeration
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

+-------+---------------------------+
| value | Full letters traduction   |
+=======+===========================+
| 1700  | MDCC                      |
+-------+---------------------------+
| 437   | IDXXXVII                  |
+-------+---------------------------+