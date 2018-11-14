# Lab7 - colectii

- se pune accentul pe *HashSet*, *TreeMap*, *Comparator* si *Comparable*;

## clasa Student

- se suprascrie metoda `hashCode` pentru a se putea introduce studenti in *HashSet*;

- se suprascrie metoda `compareTo` pentru a se putea sorta o colectie dupa numele studentilor;

## clasa GradeBook

- extinde un `TreeMap<Integer, List<Student>>`

- cheile reprezinta rotunjirea la unitate a notelor studentilor;

- lista de valori corespunzatoare unei chei este lista de studenti a caror nota rotunjita este egala cu cheia;

- metoda `sortStudents` sorteaza fiecare lista de studenti conform metodei `compareTo` din clasa *Student*;

## clasele CustomHashSet si CustomLinkedList

- ilustreaza diferentele de functionalitate dintre un *HashSet* si un *LinkedList* vis-a-vis de numarul de elemente stocate.
