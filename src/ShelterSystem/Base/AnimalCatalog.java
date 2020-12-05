package ShelterSystem.Base;

import java.util.ArrayList;
import java.util.Iterator;

public class AnimalCatalog implements Iterable<Animal> {
    private final ArrayList<Animal> animals = new ArrayList<Animal>();

    /**
     * Add a animal in this animalCatalog.
     *
     * @param animal Animal arguments. The animal you want to add in this animalCatalog.
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * Remove a animal in this animalCatalog.
     *
     * @param animal Animal arguments. The animal you want to Remove in this animalCatalog.
     */
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    /**
     * get the animal you want in this animalCatalog.
     *
     * @param index int arguments. The index of the animal you want to get in this animalCatalog.
     * @return the animal find by the index.
     */
    public Animal getAnimal(int index) {
        return animals.get(index);
    }

    /**
     * get the animal you want in this animalCatalog.
     *
     * @param code String arguments. The id of the animal you want to get in this animalCatalog.
     * @return the animal find by the id.
     */
    public Animal getAnimal(String code) {
        for (Animal animal : animals) {
            if (animal.getCode().equals(code))
                return animal;
        }
        return null;
    }

    /**
     * get the number of the animals you want in this animalCatalog.
     *
     * @return the number of animals.
     */
    public int getNumberOfAnimals() {
        return animals.size();
    }

    @Override
    public Iterator<Animal> iterator() {
        return animals.iterator();
    }
}
