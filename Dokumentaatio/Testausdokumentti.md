## Yksikkötestaus

Tavoitteena oli kattaa kaikki sovelluslogiikan kannalta olennaiset luokat ja metodit yksikkötestauksella. Tässä dokumentissa on mainittu vain toteutuksen kannalta tärkeimmät testit.

(Tänne tulee kuva/kuvia joista tulee ilmi projektin testikattavuus)


### Pelilauta

Testeissä tarkastetaan että pelilauta tunnistaa, mikäli viimeisimällä siirolla jompikumpi pelaaja on päässyt voittavaan tilaan (sekä sen milloin lauta on täynnä).


### AI

Testeissä tarkastetaan että tekoäly osaa tehdä oikean siirron yksinkertaisissa perustilanteissa (estää vastustajan voittavan siirron yms.)


## Ohjelman suorituskyvyn testaus

Perusversiolla (minimax-algoritmi alpha-beta-karsinnalla) ohjelmasta kesti ~1m 30s laskea tekoälyn ensimmäinen siirto 4x4 pelilaudalla. 

Ohjelman toimintaa testattiin nopeuttaa rajaamalla hakusyvyyttä ja käyttämällä erilaisia arviointi-algoritmeja jotka käsittelivät keskeneräisiä pelitilanteita (perusidea kaikissa lyhyesti: jos rivillä oma merkki ja tyhjää, rivin arvo +x. Jos taas vastustajan merkki ja tyhjää, rivin arvo -x. Jos molempia, rivin arvo = 0. Mitä useampi sama merkki putkeen + tyhjää, niin sitä suurempi/pienempi rivin arvo. Laudan arvo = rivien arvot yhteenlaskettuna). 

Saatu hyöty oli kuitenkin aika vähäinen, pahimmillaan arvioinilla kesti kauemmin kuin puhtaalla minimaxilla ja parhaimmillaan aikaa säästyi ~10-15s. Näissä tapauksissa hakusyvyyttä oli jouduttu kuitenkin rajoittamaan hyvin rajusti, ja tekoälyn toiminta ei ollut enää optimaallista. 

Uskon että tämä johtui lähinnä siitä, että kaksiulotteisten taulukoiden läpikäynti on liian hidasta sellaisenaan, etenkin jos sama taulukko joudutaan käymään useita kertoja läpi saman kutsun aikana (pysty- vaaka- ja vinorivit erikseen).