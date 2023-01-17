# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

A meglévő exams repóba dolgozz! Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek). Projekt, könyvtár,
repository neve legyen: `sv3-2022-jvjbf-zarovizsga-potvizsga`. GroupId: `training360`, artifactId: `sv3-2022-jvjbf-zarovizsga-potvizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: "init".

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes
feladathoz tartoznak előre elkészített tesztosztályok. Ezekkel a megoldásod helyességét ellenőrizheted.

A feladatra 3 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

Csak olyan kódot commitolj, ami le is fordul! Ha nem fordul, arra a részfeladatra nem jár pont.

## Algoritmizálás (15 pont)

Készíts az `Algorithms` nevű osztályban egy metódust, ami paraméterül kapja egész számok listáját és visszaadja,
hogy hány darab van a legnagyobb számból!

## Komplex OOP feladat (50 pont)

Ebben a feladatban hotelszoba bérlést fogunk szimulálni.
Készítsd el az `Apartment` nevű osztályt! Adattagjai a szobaszám, az, hogy éppen szabad-e, egy `FoodServiceType` enum, 
ami az ellátást jelzi és az, hogy hány ember fér be. A `FoodServiceType` három értéket vehet fel: `BREAKFAST`, `BREAKFAST_DINNER`
és `ALL_INCLUSIVE`. Ezen felül legyen benne egy paraméter, ami azt jelzi, hogy az ellátás mennyi extraköltséggel jár. 
Ez rendre: 0, 10000 és 20000. Az `Apartment` osztály konstruktorban csak a szobaszámot és
azt kapja meg, hogy hány ember fér be. Alapértelmezetten szabad és csak reggeli jár hozzá.  
Legyenek benne még a további metódusok:
- Egy `rent()` metódus, ami a szabad attribútumot hamisra állítja amennyiben szabad a szoba. Ha nem szabad, akkor kivételt dob!
- Egy `upgradeService()`, ami paraméterül kap egy szolgáltatást és átállítja a szoba szolgáltatását,
  de csak akkor, ha magasabb szintre váltott. (Ezt az árából tudjuk kideríteni.) 
- Egy `getPrice()`, ami visszaadja az alapértelmezett árat, ami jelen esetben 40000 plusz a kaja
  költség.    

Készítsd el a `HotelRoom` nevű osztályt, ami az `Apartment` osztályból származik! Konstruktorban
ugyanazokat az adatokat kapja meg mint a szülő, de ha a beférő emberek száma nagyobb mint 3, akkor kivételt dob. 
A hotelszoba alapértelmezett ára 20000 forint. Ennek megfelelően definiáld felül az árkalkuláló metódust!   

Készítsd el a `Hotel` nevű osztályt, ami egy halmazban tárolja a bérelhető szobákat! Módosítsd úgy
az osztályokat hogy két azonos szobaszámú szobát ne lehessen belerakni a halmazba! A halmazt egyébként konstruktorban kapja meg.  

Adottak az `input_.txt` állományok, amiben foglalások találhatók, egy sorban egy szám ami az érkező emberek számát jelzi.
Olvasd be a fájlt és nézd meg, hogy teljesíthetők-e a foglalások! Olvass be egy sort, 
majd keresd meg a szabad szobák között azt, ahova beférnek! Figyelj arra, hogy ha van 6 fős szoba, de csak ketten
jönnek, akkor csak abban az esetben add ki nekik, ha nincs más opció! A kiadáshoz hívd meg a szoba `rent()` metódusát!  
Ha valamelyik sorban az embereket már nem tudod berakni, akkor dobj kivételt!   

Készíts még egy metódust, ami listában visszaadja a szabad szobák szobaszámát!

## Adatbáziskezelés (35 pont)

Ebben a feladatban rendeléseket fogunk tárolni adatbázisban.

Készítsd el az `Order`, `OrderService` és `OrderRepository` osztályokat!
A megfelelő migrációs állományt neked kell létrehoznod! Ebben a feladatban az adatbázis elérésre 
vonatkozó részt a tesztekben átírhatod. 

Az `Order` osztály az adatbázis egy sorát fogja reprezentálni. Minden rendelésnél van egy azonosító, egy termék, 
az, hogy hány darabot rendeltek belőle és a darabonkénti ár.
Rendelést lehessen létrehozni azonosítóval vagy anélkül is. 

Az `OrderRepository` osztályban legyen egy `saveOrder(Order order)` nevű metódus, ami lementi a rendelést az 
adatbázisba, és visszaadja az adatbázis által generált egyedi azonosítót!
Szintén itt legyen egy `getOrder()` nevű metódus, ami visszaadja az összes rendelést id-val együtt abc sorrendben!
Legyen egy `getMostExpensiveOrderPrice()` nevű metódus, ami vsszaadja a legdrágább rendelés árát! Ez a darabszám 
és a darabár szorzata. Csak az árat kell visszadnod. 

Az `OrderService` adattagja egy `OrderRepository`. Legyen lehetőség innen delegálni a kéréseket a repository felé! 
Továbbá legyen egy metódus, ami lekéri az összes terméket és egy `Map` adatszerkezetben összeszedi, hogy melyik 
termékből összesen hány rendelést kell teljesíteni!










