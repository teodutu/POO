# Lab 4 - clase abstracte + interfete

- introducere in design pattern-uri: Command, Factory, Singleton;

- recapitulare concepte invatate pana acum: mostenire, agregare;

- lucrul cu pachete

## first - Command Pattern

- Task: interfata ce va fi folosita pentru *upcasting*;
	- contine metoda `execute()`;

- CounterOutTask:
	- numara cate obiecte de acest tip au fost create;
	- `execute()` afiseaza acest numar;

- OutTask:
	- inregistreaza un mesaj pentru fiecare obiect crea;
	- `execute()` afiseaza acest mesaj;

- RandomOutTask:
	- contine un generator de numere random;
	- `execute()` afiseaza un nou numar random.

## second - mostenire: stiva si coada implementate pe baza unui ArrayList

- Container: interfata ce stocheaza `Task`-uri si contine metodele specifice claselor `Stack` si `Queue`:
	- `pop()` - extrage si returneaza un `Task`;
	
	- `push()`;
	
	- `size()`;
	
	- `isEmpty()`;

	- `transferFrom()` - muta elementele dintr-un `Container` (pe care il goleste) in altul;
	
- AbstractContainer: clasa abstracta ce implementeaza Container, pentru a se evita duplicarea de cod in Queue si in Stack:

	- implementeaza toate metodele din Container, in afara de`pop()`;
	
        - contine un `ArrayList` ce sticheaza `Task`-urile;

- Queue: extinde AbstractContainet;

- Stack: extinde AbstractContainet.

## third - Factory Pattern + Singleton

- Strategy: une enum sec cu 2 campuri: `LIFO` si `FIFO`;

- IFactory: interfata ce contine o metoda ce se doreste a crea un `Container`:
	- `createContainer()`;

- ContainerFactory: **Singleton** ce implementeaza IFactory:
	- `createContainer()` creeaza o coada sau o stiva, in functie de `Strategy`-ul primit.

## fourth - extinderi ale unei clase abstracte

- AbstractTaskRunner: clasa abstracta de baza, ce contine un `Container`, asupra caruia poate efectua operatiile:
	- `addTask()` - adaugare (duh!);
	- `executeAll()` - se apeleaza `execute()` pentru toate `Task`-urile;
	- `afterExecution()` - metoda **abstracta** ce va fi implementata de urmatoarele clase;

- PrintTimeTaskRunner: contine un camp de tip `Calendar`;
	- `afterExecution()` afiseaza ora curenta pe baza acestuia;

- CounterTaskRunner: contine un camp `taskCount`;
	- campul se incrementeaza la fiecare `afterExecution()`;

- RedoBackTaskRunner: contine o stiva, implementata folosind clasa `Stack` de mai sus;
	- adauga fiecare `Task` in stiva, pentru a permite operatia `redo()`.

## Main

- implementeaza toate clasele de mai sus si le ilustreaza functionarea.
