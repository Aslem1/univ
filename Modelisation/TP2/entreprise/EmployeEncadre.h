#pragma once

#include <string.h>
#include <iostream>

#include "Employe.h"

using namespace std;

class EmployeEncadre: public Employe
{
public:
	EmployeEncadre(string, string, string, int, Employe*);
	virtual Employe* donneEncadrant();
protected:
	Employe* m_encadrant;
};

