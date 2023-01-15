## Intoduction

Ceci est un programme dédié pour les pilotes afin de limiter la désorientation spaciale, Cela est fait en présentant au pilote à la fois le cadran soviétique et européen, ce qui lui donne une vue plus précise sur l'orentation de l'avion dans l'air.

Présentation des classes du programme:

cadran: la classe qui représente toutes les caractiristiques des cadran présentés dans l'écran, changer les paramètres de celle-ci changera la figure des cadrans automatiquement( la taille, l'arrière-plan...)

EuropeanDial - SovieticDial: des classes filles de la classe cadran, elles implémentent les méthodes d'affichage des deux cadrans

Cadran_Interface: l'interface qui nous permet d'automatiser et faciliter la gestion des cadrans, une connaissance des méthodes de celle-ci nous dispose d'avoir une connaissance détaillée sut les classes cadran,EuropeanDial et SovieticDial

Graphics: classe qui gère le graphisme du logiciel

App: la 'main' classe qui fait appel à la classe Graphics 

