#pragma once

#include <string.h>
#include <iostream>

#include "Employe.h"

using namespace std;

class Directeur: public Employe
{
public:
	Directeur(string, string, string, int, int);
	virtual int donneRevenu();
	virtual Employe* donneEncadrant();
private:
	int m_prime;
};

