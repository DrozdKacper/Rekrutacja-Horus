import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FileCabinet implements Cabinet {
    private List<Folder> folders;

    //Nadpisanie klasy findFolderByName z interfejsu
    @Override
    public Optional<Folder> findFolderByName(String name){
     return collectAllFolders().stream().filter(folder -> folder.getName().equals(name)).findFirst();
    }

    //Nadpisanie klasy findFoldersBySize z interfejsu
    @Override
    public List<Folder> findFoldersBySize(String size){
        return collectAllFolders().stream().filter(folder -> folder.getSize().equals(size)).toList();
    }

    //Napidpisanie klasy count z interfejsu
    @Override
    public int count(){
        long count =  collectAllFolders().stream().count();

        return (int) count;
    }

    // metoda pomocnicza wykorzystująca algorytm DFS służąca do przeszukania wszystkich podfolderów
    private void dfsSearch(Folder folder, List<Folder> result) {
        // Dodajemy folder

        result.add(folder);

        // Jeśli folder ma podfoldery, to przechodzimy do nich
        if (folder instanceof MultiFolder) {
            for (Folder child : ((MultiFolder) folder).getFolders()) {
                dfsSearch(child, result);
            }
        }


    }
    // metoda pomocnicza wykorzystująca poprzednią metodę dla każdego folderu z katalogu głownego
    private List<Folder> collectAllFolders() {
        List<Folder> all = new ArrayList<>();
        for (Folder f : folders) {
            dfsSearch(f, all);
        }
        return all;
    }


}

