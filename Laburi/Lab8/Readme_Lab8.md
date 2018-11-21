# Lab 8

- genericitatea se va obtine in diverse moduri:
	- iteratori;
	- wildcard-uri;
    - "template-uri";

## hashmap

- implementeaza un *HashMap* facut "de mana", ce trateaza coliziunile prin bucket-uri si care primeste chei si valori de tipuri generice, cu precizarea ca trebuie sa se puna **doar** chei comparabile (care implementeaza *Comparable*);

- hashMapul este iterabil, acesta implementand interfata *Iterable<MyMapEntry<K, V>>*, iar pentru usurinta crearii iteratorului, bucket-urile sunt retinute intr-un *ArrayList*;

- pentru a face clasa *MyHashMap* iterabila, se definesc 2 iteratori aditionali, unul pentru bucket-uri si celalalt pentru perechile cheie-valoare;

- se testeaza cu o perechi (*MyEntry*) formate dintr-o clasa cu obiecte comparabile (*MyString*), ce retine un `String`, si un `Integer`.

## summable

- contine clasele *MyMatrix* si *MyVect3*, "legate" prin interfata *Summable* pe care ambele o implementeaza;

- metodele `addValue` ale acestor clase, implementate din *Summable*, aduna element cu element campurile claselor;

- in *MainSummable*, metoda `addAll` ilustreaza functionarea unui iterator pe o colectie generica, ale carei elemente extind *Summable*.
