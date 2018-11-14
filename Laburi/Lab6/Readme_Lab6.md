# Lab6 - Visitor patern

- se implementeaza un design pattern de tip **Visitor**;

## Clasele vizitablile:

- Manager;

- Employee;

- Intern;

## Vizitatorii:

- RevenueVisitor: afiseaza venitul fiecarui angajat;

- TreeVisitor: constructorul primeste un `Visitor`, pe care il apeleaza pentru fiecare angajat, cu mentiunea ca pentru *Manager*, il va apela recursiv pentru toti subalternii;

- MostHardworkingEmployeeFinder: vizitator gandit spre a fi folosi impreuna cu *TreeVisitor* (la fiecare apelare a metodei `visit`, se va incrementa numarul de ore lucrate de respectivul tip de angajat, pentru ca la final sa se apeleze metoda `isManagerHardWorking`);

## FilesCounter

- un exemplu diferit de *Visitor*, care afiseaza fisierele `.class` dintr-o ierarhie este *FilesCounter*, ce extinde clasa *SimpleFileVisitor<Path>* si suprascrie metoda *visitFile*.
