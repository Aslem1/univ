#pragma once

#include <string.h>
#include <iostream>

#include "EmployeEncadre.h"

using namespace std;

class Livreur: public EmployeEncadre
{
public:
	Livreur(string, string, string, int, Employe*);
};

