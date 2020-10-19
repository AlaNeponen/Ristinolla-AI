## Projektin rakenne

Ohjelman sovelluslogiikan toteuttavat luokat löytyvät pakkauksesta ristinolla.domain. Luokka `AI` on projektin keskeisin luokka. Se sisältää projektin minimax-toteutuksen, sekä metodit sen hyödyntämiseen. Toinen keskeinen luokka on `Pelilauta`, jossa säilytetään pelilaudan tilannetta, ja joka tarjoaa metodit sen tarkasteluun.

## Aika- ja tilavaatimus

Minimax-algoritmi käy läpi mahdolliset siirrot aina samassa järjestykessä (sen sijaan että esim. aloittaisi todennäköisesti parhaista) joten on täysin mahdollista että jossain suorituksessa karsintaa ei tapahdu. Tällöin aikavaatimus on sama kuin raa'alla minimaxilla: O(b^d), jossa b on mahdollisten siirtojen määrä (esim. 3x3 laudalla keskimääräinen b = 4) ja d on siirtojen muodostaman pelipuun syvyys.

Tilavaatimus on vastaavasti O(b*d).

## Parannusehdotukset

Algoritmin toimintaa voisi nopeuttaa suurempien lautakokojen mahdollistamiseksi. Vaihtoehtoja olisivat esim. siirtojen järjestäminen siten että tapahtuisi mahdollisimman paljon karsintaa, keskeneräisten pelitilanteiden tarkasteleminen jollain arviointi-algoritmilla joka mahdollistaisi hakusyvyyden rajoittamisen, tai karsinnan parantaminen tappaja heuristiikan avulla. 

Itse ohjelmasta saisi mielenkiintoisemman esimerkiksi lisäämällä vaihtoehdon säätää voittavan rivin pituutta, tai vaikka antaa käyttäjän päättää kumpi aloittaa.

#### Lähteet

[Minimax ja karsinta yleisesti](http://www.cs.umd.edu/~hajiagha/474GT15/Lecture12122013.pdf)

[Minimax](https://en.wikipedia.org/wiki/Minimax)

[Alfa-beta-karsinta](https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning)

*Aiheeseen liittyvää:* [Branching factor](https://en.wikipedia.org/wiki/Branching_factor), [Game complexity](https://en.wikipedia.org/wiki/Game_complexity) sekä [Ristinolla-takut](https://en.wikipedia.org/wiki/Tic-tac-toe#Strategy) 

