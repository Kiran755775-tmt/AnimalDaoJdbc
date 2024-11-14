import java.util.List;

public class Main {
    public static void main(String[] args) {

        //INSERTING ANIMAL OBJECTS HERE
        /*Animal animal = new Animal("Snake","Reptile",3);
        Animal animal1 = new Animal("Hen","Bird",2);
        Animal animal2= new Animal("Whale","Mammal",10);*/
        AnimalDAO animalDAO= new AnimalDAOImpl();
        //System.out.println(animalDAO.insertAnimal(animal2));

        //RETRIEVING ALL THE DATA IN THE TABLE
        /*List<Animal> animalList= animalDAO.getAllAnimals();
        for(Animal animal:animalList){
            System.out.println(animal);
        }*/

        //RETRIEVING THE DATA BY USING ID
        //System.out.println(animalDAO.getAnimalById(2));

        //UPDATING THE DATA BY USING ID
        //System.out.println(animalDAO.updateAnimalById(2,"Eagle"));


        //DELETING DATA BY USING ID
        //animalDAO.deleteAnimalById(3);
    }
}