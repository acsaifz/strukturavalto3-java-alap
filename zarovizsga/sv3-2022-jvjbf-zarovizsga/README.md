# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

A szokásos `exams` repository-ba dolgozz! Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek). Projekt, könyvtár,
repository neve legyen: `sv3-2022-jvjbf-zarovizsga`. GroupId: `training360`, artifactId: `sv3-2022-jvjbf-zarovizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: "init".

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes
feladathoz tartoznak előre elkészített tesztosztályok. Ezekkel a megoldásod helyességét ellenőrizheted.

A feladatra 3 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

Csak olyan kódot commitolj, ami le is fordul! Ha nem fordul, arra a részfeladatra nem jár pont.

## Algoritmizálás (10 pont)

Készíts az `Algorithms` nevű osztályban egy metódust, ami paraméterül vár egy String listát és eldönti,
hogy szóláncot kapott-e! Szóláncról akkor beszélünk, ha minden szó az azt megelőző szó utolsó karakterével 
kezdődik. A kis és nagybetűket az algoritmus hagyja figyelmen kívül!

## Komplex OOP feladat (50 pont)

Az alábbi feladatban egy jegyiroda működését fogjuk szimulálni. 
Készíts egy `BasicTicket` nevű osztályt, melynek attrtibútumai az esemény (`String`), a
dátum (`LocalDateTime`) és az ár (`int`). Konstruktorban minden adattagot állíts be és készíts gettereket!  

Készíts egy `Ticket` nevű interface-t melynek publikus absztrakt metódusai a `BasicTicket getBasicTicket()` és a `double getPrice()`!   

Az eseményekre kétféle jegyet lehet venni: álló- vagy ülőjegyet.  

Készítsd el a `StandingTicket` osztályt, mely implementálja a `Ticket` interface-t!
Attribútumai egy `BasicTicket basicTicket` és egy `StandingTicketType ticketType` ami egy enum. 
A `StandingTicketType` lehet `FRONT_OF_STAGE` és `NORMAL` továbbá van egy százalék attribútuma, ami azt
jelöli, hogy az alapárhoz képest hány százalékkal drágább. Az első esetben ez 20 a másodikban 0.
Az állójegyben a következőképpen definiáld felül az interface metódusokat:
- A `getBasicTicket()` egyszerűen adja vissza az attribútum értékét!
- A `getPrice()` adja vissza az alapár megfelelő százalékkal megnövelt értékét! (Lehet tizedes tört is!)    

Készítsd el a `SeatedTicket` osztályt mely implementálja a `Ticket` interface-t!  
Attribútumai egy `BasicTicket basicTicket` egy `int row` és egy `int seat`. A metódusokat így definiáld felül:
- A `getBasicTicket()` egyszerűen adja vissza az attribútum értékét!
- A `getPrice()` értéke attól függ, hogy mennyire ül messze, azaz hányadik sorban ül. A jegyár 10 soronként
csökken 10%-ot. Azaz az első 9 sor alapáron kapja, a 10-19. sor 10% kedvezménnyel, a 20-29. sor 20% kedvezménnyel
és így tovább, viszont a jegy ára sosem megy 2000 alá!  

Készítsd el a `TicketOffice` nevű osztályt, melyben a jegyeket egy halmazban tárolod!
Legyen benne egy `addTicket()` nevű metódus, amivel a jegyiroda jegyeket tud hozzáadni a halmazhoz!
Bővítsd úgy a megfelelő osztályokat, hogy ugyanarra az eseményre ugyanarra az ülésre ne lehessen két jegyet 
belerakni a halmazba! Kerüld az `instanceof` használatát! 

Ugyanebben az osztályban készíts egy `sellTicket(String event, int maxPrice)` metódust, ami a jegyeladást szimulálja. 
Keressük meg azokat a jegyeket, amik a megfelelő eseményre szólnak, és ezek közül add vissza a legdrágábbat, ami legfeljebb
a `maxPrice` értéket veszi fel! Figyelj arra, hogy ha megvan a jegy, akkor távolítsd el a halmazból! Ha nincs 
a kívánt feltételeknek megfelelő jegy, dobj kivételt!  

Bővítsd még az osztályt egy metódussal, ami megmondja, hogy melyik eseményre hány darab jegy van!
A visszatérési érték egy `Map` legyen, melynek kulcsa `BasicTicket`, értéke `Integer`!

Legyen még egy metódus ami egy dátum alapján visszaadja az aznapi eseményeket egy `String` halmazban, elkerülve,
hogy egy esemény kétszer szerepeljen.

## Fájl és Adatbáziskezelés (40 pont)

Ebben a feladatban állatok megfigyelését fogjuk nyilvántartani egy adatbázisban.  
Készítsd el az `Animal`, `AnimalService` és `AnimalRepository` osztályokat!
A megfelelő migrációs állományt neked kell létrehoznod! Ebben a feladatban az adatbázis elérésre vonatkozó részt a tesztekben átírhatod. 

Adott az `input.csv` állomány, melynek egy sorában egy állat megfigyelésének adatai találhatók. Először
az állat fajtája, darabszám, majd végül a dátum. A fájl tartalmaz fejlécet. Készítsd el ennek megfelelően az 
`Animal` osztályt, de figyelj, hogy legyen benne egy `id` adattag is a későbbi lekérdezések miatt! 

Az `AnimalRepository` osztályban legyen egy metódus ami lement egy állatot az adatbázisba! 
Legyen emellett egy metódus, ami az összes állatot lekéri az adatbázisból már id-val együtt és visszaadja egy listában! 
Legyen továbbá egy metódus, ami paraméterül vár egy állattípust, és visszaadja, hogy összesen hány állatot figyeltek meg
ebből a típusból. 

Az `AnimalService` osztályban legyen egy metódus, ami paraméterül kap egy fájlt és
a fájl egy-egy sorát lementi az adatbázisba!
Legyen benne további két metódus, ami az `AnimalRepository` osztály másik két metódusának delegálja a kérést! 

