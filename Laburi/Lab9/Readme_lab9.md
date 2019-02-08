# Lab9 - exceptii + chain-of-responsibility

- pachetul `exceptions` ilustreaza functionarea exceptiilor in *Java*

- pachetul `logger` implementeaza un logger pe baza patternului *chain-of-responsibility*, pe modelul de pe [wikipedia](https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern#C#_example)

## exceptions

- in *MainErrors* sunt implementate `outOfMemory()` si `stackOverflow()`, care ilustreaza exceptiile respective;

- de asemenea, tot in *MainErrors* se ilustreaza si erori de calcul, implementate in clasele *Calculator*, *OverflowException* si *UnderflowException*;

## logger

- in *Test* se ilustreaza functionarea loggerului si a patternului *chain-of-responsibility*;

- toti loggerii extind clasa abstracta LoggerBase;

- in momentul in care trebuie scris un mesaj, acesta este transmis unui logger, iar daca acesta nu este loggerul corect, mesajul se transmite in cascada loggerilor urmatori, pana se ajunge la cel corect, care afiseaza acest mesaj.
