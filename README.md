Wykonał: Kacper Drozd drozdkacper2000@gmail.com

Do wykonania zadania wykorzystałem algorytm DFS. Umieściłem go w osobnej metodzie "dfsSearch" aby znaleźć wszystkie podfoldery dla danego folderu. Aby uzyskać kompletną listę wszystkich folderów w szafce, stworzyłem metodę pomocniczą "collectAllFolders", która stosuje "dfsSearch" dla każdego folderu z katalogu głównego. 
Następnie zadeklarowałem metody z interfejsu "Cabinet". W każdej z nich wykorzystałem metode "collectAllFolders", aby nie powielać kodu. w każdej z nich przy pomocy stream zrobiłem odpowiednie operacje,, takie jak wyszukiwanie folderów po nazwie, filtrowanie po rozmiarze czy zliczanie wszystkich folderów.
