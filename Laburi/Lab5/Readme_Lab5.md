# Lab5 - clase interne + Publish-Subscribe pattern

- se implementeaza un `bash` minimalist, urmand pattern-ul [Publisher-Subscriber](https://en.wikipedia.org/wiki/Publish%E2%80%93subscribe_pattern);

- comenzile se trimit in paralel tuturor "executabilelor" (clasele interne ale lui BashUtils);

## Bash

- contine clasele necesare pattern-ului mentionat;

- Bash reprezinta o anumita sesiune de bash, care prin clasa interna BashCmdPublisher va transmite fiecare comanda catre toti subscriberii, retinuti prin upcasting ca fiind de tipul `CommandSubscriber`;

- BashUtils contine cate o clasa interna reprezentativa pentru fiecare comanda:
	- Echo
	- Cd
	- Ls
	- History

## Linux

- clasa simuleaza un sistem de operare de tip `linux`, creind un nou terminal de tip Bash
