algo genetique
==============

### change the copyrigth user creator in the conf.py

Why
---
The c year project 2019-2020 by C.DEMKO

Usage
-----

### Installation

~~~bash
$ cd path of your project
$ pip3 install -r /docs/requirements.txt
~~~

### Compilation

~~~bash
$ mkdir build
$ cd build
$ cmake ../srcDirectory -DBUILD_COVERAGE=1 -DBUILD_HTML_COVERAGE=1 -DUSE_VALGRIND=1 -DRUN_CPPCHECK=1
$ cmake ../projet -DCMAKE_INSTALL_PREFIX=~/.local
$ make
~~~

### Run test and code coverage

~~~bash
$ make test
$ make coverage
$ make html-coverage
~~~

### Check style

~~~bash
$ make cclint
~~~

### Run flaw finder

~~~bash
$ make flawfinder
~~~

### Build the docs

~~~bash
$ make docs
~~~

### Create archives

~~~bash
$ make package
$ make package_source
~~~

### Install package

~~~bash
$ make install
~~~
### Run sudoku.c
~~~bash
$ cd build/src/sudoku
$ make
$ ./sudoku "area where the yaml file is located" cross_over mutation numberInPopulation numberOfGeneration


Université de la Rochelle
-------------------------
