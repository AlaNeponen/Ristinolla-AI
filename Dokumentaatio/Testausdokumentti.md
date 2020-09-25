## Yksikkötestaus

Tavoitteena oli kattaa kaikki sovelluslogiikan kannalta olennaiset luokat ja metodit yksikkötestauksella. Tässä dokumentissa on mainittu vain toteutuksen kannalta tärkeimmät testit.

(Tänne tulee kuva/kuvia joista tulee ilmi projektin testikattavuus)


### Pelilauta

Testeissä tarkastetaan että pelilauta tunnistaa, mikäli viimeisimällä siirolla jompikumpi pelaaja on päässyt voittavaan tilaan (sekä sen milloin lauta on täynnä).


### AI

Testeissä tarkastetaan että tekoäly osaa tehdä oikean siirron yksinkertaisissa perustilanteissa (estää vastustajan voittavan siirron yms.)


## Ohjelman suorituskyvyn testaus

Perusversiolla (minimax-algoritmi alpha-beta-karsinnalla) ohjelmalla kestää ~1m 30s laskea tekoälyn ensimmäinen siirto 4x4 pelilaudalla.
