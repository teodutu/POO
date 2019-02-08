# Lab11 - design patterns

- se implementeaza patternurile urmatoare pentru a realiza un joc de tip RPG in lina de comanda:

	- command;

	- factory;

	- observer;

	- strategy;

	- singleton;

## commands

- contine interfata *Command*, invokerul *CommandManager* ce retine comenzile in stive si este responsabil de operatii de *undo* si *redo* si comanda *MoveCommand* care implementeaza *Command*.

## entitites

- contine elementele de pe harta: eroi, monstri, obstacole, obiecte.

## factories

- *factoryuri* care creeaza eroi, monstri sau obiecte de pe harta.

## game

- contine clasa *Main* a carei metoda `main()` proceseaza comenzile scrise in linia de comanda si modifica in mod corespunzator *GameState*;

- clasa *GameState* retine toate informatiile despre joc: harta, obiecte, eroi, monstri, obstacole;

- ca parte a patternului *Observer* este observabilul, observatorii fiind definit mai jos.

## observers

- contine observatorii care afiseaza informatii despre *GameState* la stdout;

- la fiecare modificare a hartii (miscarea unui erou) sunt afisate harta, impreuna cu toate evenimentele aparute in urma acestei miscari, prin clasele *MapPrinter*, *MonsterDiscoverer*, *ObstacleDiscoverer*, *TreasureDiscoverer*.

## strategies

- implementeaza patternul *strategy*:

	- interfata *Strategy* contine doar metoda `attack()`;

	- startegiile *AttackStrategy* si *DefenseStrategy* implementeaza 2 moduri de a actiona ca jucator: agresiv, respectiv pasiv.
