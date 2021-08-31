# Clinical Center Information System

<!--Project description.-->
Clinical Center Information System je informacioni sistem
kliničkog centra preko kojeg će pacijenti moći da zakazuju preglede. Pristup
sistemu imaju i medicinske sestre i lekari koji mogu da unose izveštaje o
izvršenim pregledima i operacijama, kao i da zakazuju iste za pacijente. Klinički
centar se sastoji iz više usko specijalizovanih klinika koje su registrovane u
okviru informacionog sistema. Osnovna namena aplikacije je vođenje evidencije
o zaposlenima, registrovanim klinikama, salama za preglede i operacije,
pacijentima i njihovim zdravstvenim kartonima, kao i zakazivanje pregleda.

## Članovi tima

> Ivana Marošević

> Veljko Plećaš

> ~~Filip Vasić~~ (*odustao od projekta*)

## Korišćene tehnologije

* [Spring Boot](https://spring.io/) - The web framework 
* [Maven](https://maven.apache.org/) - Dependency Management
* [Angular](https://angular.io/) - The web framework

## Trello board
[Link](https://trello.com/b/nJnKKQdS/mrsisa2020t8) do Trello table.

## Pokretanje projekta

### Pokretanje Spring Boot projekta

Potrebno je importovati CCSystem folder u okruženje koje se koristi i podesiti application.properties fajl kako je opisano ispod.
Zatim instalirati sve dependency-je iz pom.xml fajla, i onda
desni klik na projekat -> Run as -> Java Application



#### Podešavanje application.properties fajla
Potrebno je podesiti application.properties fajl tako što se na 9. liniji navede URL do baze koja je pokrenuta u lokalu - u ovom slučaju na podrazumevanom portu 5432 i na serveru je kreirana šema baze pod nazivom "isa"
```
spring.datasource.url=jdbc:postgresql://localhost:5432/isa
```
Na linijama 12 i 13 je potrebno upisati svoje kredencijale za konekciju na server baze
```
spring.datasource.username=postgres
spring.datasource.password=ivanasql
```
Na linijama 38 i 39 je potrebno upisati kredencijale mejla koji se koristi. Ostala podešavanja vezana za mejl su vezana za gmail server.
```
spring.mail.username=given_username
spring.mail.password=given_password
```

### Pokretanje Angular projekta

Da bi se pokrenuo Angular projekat prvo je potrebno importovati frontend folder u okruženje koje se koristi.
Nakon toga pokreće se komanda 
```
npm install
```
koja instalira sve potrebne dependency-je i kreira node_modules folder.
Nakon što se završi instalacija angular projekat se može pokrenuti komandom 
```
ng serve
```
Nakon toga u pretraživaču možemo kucati http://localhost:4200 što će nas odvesti na početnu stranicu.

## Dodatne napomene

* Šifra svakog korisnika iz baze je 123
* Tamo gde se koristi slanje mejla je nekad podrebno sačekati određeni period da bi se dobio odgovor od sistema.
