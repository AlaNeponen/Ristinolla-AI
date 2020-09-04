# Ristinolla-AI

Tietojenkäsittelytieteen kandidaatti, Suomi

### Algoritmit ja tietorakenteet

Toteutan työssä minimax-algoritmin jonka toimintaa tehostetaan alpha-beta karsinnalla.
Tietorakenteina yksinkertainen matriisi (taulukoita taulukossa) jolla pidetään kirjaa pelilaudasta. *Mahdollisesti joku lista mahdollisten siirtojen säilyttämiseen*

### Syötteet

Ohjelma saa pelaajalta syötteenä pelaajan siirrot (tekstinä tai graafisen käyttöliittymän kautta painikkeita painamalla).

### Aika- ja tilavaativuudet

Aikavaatimus (tilanteessa jossa ei tapahdu yhtään karsintaa): O(b^h), ja
tilavaatimus O(bh) (jossa b = mahdollisten siirtojen määrä, ja h = siirtojen muodostaman puun syvyys)

#### Lähteet

[Minimax ja karsinta](http://www.cs.umd.edu/~hajiagha/474GT15/Lecture12122013.pdf)