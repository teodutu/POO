# TEMA 1 POO - Sheriff of Nottingham

## Implementare:

- exista clase pentru fiecare carte si pentru fiecare jucator;

- pachetul de carti este stocat in clasa Deck, ce contine o coada de carti;

- tot jocul este rulat de metodele playGame si getResults ale clasei GameEngine;


## Schema de design:

- "a -> b" inseamna "b implementeaza / extinde a";

- "a: b" inseamna "b face parte din pachetul a";

- "(abs)C" inseamna "C este abstracta";

- "(i)C" inseamna "I este o interfata";

    - players: 
    
        - (abs)Player -> Basic
        - Basic -> Bribed
        - Basic -> Greedy
        - Basic -> Wizard

        - (i)ILeaderBoardUpdater -> LeaderBoardUpdater
    
    - assets: 
        - (abs)Card -> Apple    |
                    -> Barrel   |
                        -> Bread    |
                        -> Cheese   |  (generate de CardFactory)
                        -> Chicken  |
                        -> Pepper   |
                        -> Silk     |


## Design:

- din moment ce nu este nevoie ca fiecare carte sa existe ca un obiect separat,
dar si din motive de eficienta a memoriei consumate, toate cartile vor fi
singleton-uri ce mostenesc clasa abstracta Card, ce stocheaza datele acestora,
iar cartile din pachet, din mainile jucatorilor, de pe tarabe si din saci
vor fi referinte la aceste instante unice;

- CardFactory nu creeaza cartile in sine, ci returneaza prin metoda getCard
referinte la acestea;

- toate metodele necesare jucatorilor sunt implementate in clasa abstracta
Player, care contine si 3 metode abstracte: playMerchant, playSheriff si
updateLeaderboard, ce vor fi implementate de toti jucatorii;

- s-a implementat clasa Basic, ce extinde Player si care, la randul sau este
extinsa de toate celelalte (inclusiv de Wizard, ce va fi detaliata mai jos) din
moment ce toti jucatorii folosesc in anumite situatii strategia de baza;

- obtinerea rezultatelor finale se face print interfata ILeaderBoardUpdater,
implementata de clasa LeaderBoardUpdater, care impreuna cu Player, realizeaza un
design pattern de tip Visitor pentru a genera clasamentul;

- se foloseste o clasa abstracta, Player in loc de o interfata pentru metoda de
tip "accept" (updateLeaderBoard), deoarece toti jucatorii deja extind clasa
Player, deci pot fi instantiati prin aceasta pentru vizitare;

- Factory-ul PlayerFactory foloseste metoda getPlayer pentru a crea si returna
jucatori in functie de string-ul primit ca parametru;


## Bonus:

- cel mai eficient jucator este Basic deoarece, alegand cele mai frecvente
carti, el obtine multe bonusuri si deoarece el nu plateste penalizari pentru
sacii sai;

- totusi, el are o slabiciune principala: plateste mereu penalizari pentru sacii
jucatorilor onesti;

- Basic este mereu onest, iar atunci cand Greedy minte, el nu ia decat maximum
o carte ilegala, deci nu obtine un beneficiu prea mare, motiv pentru care poate
fi ignorat;

- cel ce obtine cel mai mult jucand ilegal este Bribed, care, pe deasupra,
adauga si mita, care este in cantitati destul de mici incat aceasta sa merite
in majoritatea rundelor (profitul total castigat de pe urma cartilor ilegale
este mai mare decat mita);

- Wizard va profita de aceste aspecte si va cauta sa-l imite pe Basic atunci
cand este comerciant si sa-i elimine slabiciunea in rolul de serif;

- in concluzie, Wizard va fi un comerciant identic cu Basic, dar va verifica
doar sacii ce contin mita, caci acestia provin de la Greedy;

- if it's stupid but it works, it ain't stupid.

