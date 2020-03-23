# I20L1GR2
 
DOKUMENTACJA PROJEKTOWA
Aplikacja webowa do zarządzania restauracją
 
 
1.	Opis projektu 

Nasz projekt zawiera aplikację webową, składającą się z programu oraz dokumentacji, służącą do obsługi i zarządzania restauracją.
Program opiera się głównie na obsłudze magazynu produktów oraz obsłudze zamówień na relacji przyjmij-zrealizuj-wydaj.
Za pomocą programu można w każdej chwili pobrać dane zawierające informacje o stanie magazynowym, 
na podstawie którego pracownik jednym kliknięciem układa zamówienie gotowe do realizacji, na towary deficytowe. 
Dzięki usłudze wprowadzania przez obsługę kuchni na bieżąco danych o pobraniu konkretnej ilości produktów, 
lista dostępnych produktów jest aktualna w każdym momencie. Usprawnia to też współpracę kuchni z obsługą sali pod względem dostępności potraw.
Każdego dnia na zakończenie zmiany, użytkownik ma możliwość wygenerowania raportu podsumowującego cały dzień pracy 
zawierającego zarówno ilość sprzedanych produktów jak i dzienny przychód. 
Całe oprogramowanie wspierało możliwość pracy na terminalach komputerowych typu POS.
Co więcej aplikacja daje administratorowi możliwość tworzenia raportów miesięcznych i podsumowań przedstawiających najczęściej sprzedawane
produkty. Dzięki nim administrator może ukierunkować sprzedaż na rzeczy sprzedawane systematycznie i generujące największy przychód.
Dostęp do wydatków ułatwia prowadzenie rozliczeń finansowych oraz kontrolę pieniędzy wydawanych przez pracowników. 


1.1	Technologie wykorzystane w aplikacji:

	Java spring

	MySQL

	CSS

	HTML

	Hibernate

1.2	Architektura

Trzy warstwy składowe aplikacji:

	Warstwa prezentacji – jest ona odpowiedzialna za interakcje z użytkownikiem.
Za te rolę będzie odpowiedzialna aplikacja webowa. Każda interakcja aplikacja-użytkownik będzie miała miejsce w tej warstwie. 

	Warstwa biznesowa – odpowiedzialna jest za przetwarzanie danych.
To ona generuje raporty, samoistnie je tworząc na każdy dzień. 

	Warstwa danych – jest ona odpowiedzialna za przechowywanie danych. 
W tej warstwie zawiera się baza danych oraz serwer. Raporty są zapisywane na serwerze na dysku lub w bazie danych.
 

2.	Diagram przypadków użycia

![alt text](https://github.com/JakubKozimorStudy/I20L1GR2/blob/master/Diagram_przypadkow_uzycia.jfif)

Powyżej przedstawiony jest diagram przypadków użycia, wyróżniamy w nim cztery rodzaje użytkowników: Administrator, Manager Restauracji, Kelner oraz Kucharz. 	
Administrator odpowiada za tworzenie kont każdej z obu podkategorii tj. konto kelner oraz konto manager. 
Ma on także możliwość logowania do systemu jako administrator. 
Manager restauracji ma największe uprawnienia ze wszystkich użytkowników. Korzysta on z funkcji generowania raportów, 
która została poszerzona o raporty generowane automatycznie i umożliwione mu zostało pobieranie ich z systemu. Do jego użytku przekazana 
została też funkcja wprowadzania produktów, poszerzona o funkcje aktualizowania stanów magazynowych. Dodatkowo może on tworzyć konta typu kelner oraz zamykać otwarte rachunki klientów. 	
Kelner loguje się do systemu i odpowiada za przyjmowanie zamówień od klientów i wprowadzanie ich do systemu, 
poza tym kontroluje on rachunek klienta i zamyka go gdy klient decyduje się zapłacić za usługę.  
Kucharz loguje się do systemu i odpowiada za wprowadzanie na bieżąco do systemu ilości wykorzystanych produktów do przygotowania 
każdego dania. Dostaje on także informacje o potrawach które ma przygotować i je akceptuje.
 
3.	Diagram klas dla domeny głównej

![alt text](https://github.com/JakubKozimorStudy/I20L1GR2/blob/master/diagram%20klas.png)
 
4.	Diagram aktywności 

![alt text](https://github.com/JakubKozimorStudy/I20L1GR2/blob/master/diagakt.jpg)
 
5.	Diagram stanów

![alt text](https://github.com/JakubKozimorStudy/I20L1GR2/blob/master/state2.JPG)
 
6.	Diagram sekwencji

![alt text](https://github.com/JakubKozimorStudy/I20L1GR2/blob/master/sekw.JPG)
 
