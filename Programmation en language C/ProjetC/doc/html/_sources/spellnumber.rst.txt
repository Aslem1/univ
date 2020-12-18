
SpellNumber C
===============

Statement
---------------

+-----------------------------------------------------------------------------------------------------+
| Programm allowing to represent a whole number in full letters.                                      |
+-----------------------------------------------------------------------------------------------------+
| And a programm capable of displaying the representation of a number in a given dialect.             |
+-----------------------------------------------------------------------------------------------------+


Realisation
---------------
:Authors: - Alexandre Bouloizeau
          - Lucas Dumon
          - Martin Ehlinger
          - Tangui Georgeon
          - Agathe Perrin
:Version: 1.0.0
:Date: November, December 2020
:Main File: main.c

When the programme begins, it asks which dialect we want to use.
We have to choose between :
 
+------------+------------------+
| fr-fr      | French           |
+------------+------------------+
| fr-be      | French belgian   |
+------------+------------------+
| fr-african | French African   |
+------------+------------------+
| fr-date    | French Date      |
+------------+------------------+
| fr-roman   | Roman Numeration |
+------------+------------------+

After that, you will have to enter the value to be converted.

Development
---------------

Configurations
~~~~~~~~~~~~~~

+-------------+------------------+
| C Version   | 11               |
+-------------+------------------+
| IDE         | CLion            |
+-------------+------------------+
| Compilation | CMake            |
+-------------+------------------+

Patterns
~~~~~~~~~~~~~~

The main program converts the entered text into int and calls the appropriate library.
Each library is designed and called in the same way, the entry point is named `conv_letter_number` and takes an int as parameter.