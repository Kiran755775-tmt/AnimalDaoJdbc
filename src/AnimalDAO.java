import java.util.List;

public interface AnimalDAO {
    int insertAnimal(Animal animal);
    List<Animal> getAllAnimals();
    Animal getAnimalById(int id);
    int updateAnimalById(int id,String name);
    void deleteAnimalById(int id);
}
