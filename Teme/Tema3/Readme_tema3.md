# Tema 3: EMERGENCY ROOM

- se simuleaza camera de garda a unui spital

## Implementare:

- fiecare coada (*TriageQueue*, *ExaminationQueue*, *InvestigationsQueue*) contine o coada cu prioritati care contine pacientii din respectiva etapa sortati conform criteriului etapei respective;

- design patternul *Observer* se implementeaza intre pacienti si spital, prin intermediul doctorului curant al fiecarui pacient care inca nu a fost externat;

- clasele sunt organizate in pachete in functie de functionalitatea respectivelor clase:

    - pachetul `enums` contine enumurile date in schelet;

    - pachetul factories contine clase care creeaza campuri specifice ale
doctorilor sau pacientilor, pornind de la stringurile din input;

    - pachetul `personnel` contine clasele pentru doctori, respectiv pacienti;

    - pachetul `queues` contine cele 3 cozi in care pot ajunge pacientii;

    - pachetul `utils` contine campurile aditionale ale pacientilor si doctorilor, estimatorul oferit in schelet si clasa ce implementeaza spitalul in sine;


## Functionare:

- in clasa *HospitalRunner* se vor citi toate campurile din fisierul *JSON*;

- in fiecare runda, se executa, pe rand, etapele descrise in enunt, dupa care se afiseaza mesajele corespunzatoare starii fiecarui pacient si actiunilor asistentelor si doctorilor;

- *HospitalRunner* contine:

    - cele 3 cozi in care vor intra pacientii in vederea tratarii;

    - o lista in care sunt tinuti doctorii, folosita pentru a se selecta medicul curant al fiecarui pacient;

    - 2 *TreeSeturi* ce contin pacientii internati, respectiv ajunsi la un anumit moment de timp sortati crescator dupa nume;

- pentru simplitate, comparatorii folositi atat in *PriorityQueueuri*, cat si in *TreeSeturi* folosesc interfata *Comparator* si functii lambda;


## Observer Pattern:

- se realizeaza intre spital si doctori astfel: doctorii sunt observatorii, iar subiectul este *HospitalRunner*;

- obiectul updateurilor il reprezinta afisarile mesajelor provenite de la doctori;

- asadar, la update, fiecare doctor isi va parcurge lista de pacienti si va va afisa mesajele corespunzatoare, in functie de starea fiecarui pacient;

- daca unul dintre acesti pacienti si-a terminat tratamentul, este scos din lista mentionata mai sus.
