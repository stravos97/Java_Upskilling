package exercises;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Animal2 {

    protected String name; //wrong
    protected LocalDate birthDate;
    static ArrayList<Animal2> animals = new ArrayList<Animal2>();

    public Animal2(String name, int year, int month, int day) {
        this.name = name;
        this.birthDate = LocalDate.of(year, month, day);
        animals.add(this); // Add the newly created animal object to the list

    }


    /**
     * Returns a string representation of the animal.
     * Could also use birthDate.toString() instead of String.valueOf(getAge())
     * THIS IS WRONG, fix it
     * @return a string representation of the animal
     */
    @Override
    public String toString() {
        String age = String.valueOf(getAge());
        return "The name of the animal is: " + getName() + "\nThe age of the animal is: " + age + " years old.\n" + ", and it can speak! : " + speak();
    }

    /**
     * We don't make these methods abstract because they are not required for all animals.
     * We also get them and set them in one specific way and don't need to modify them in differrent ways for different animals
     * @return
     */
    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        LocalDate period = LocalDate.now().minusYears(birthDate.getYear());
        return period.getYear();
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setBirthDate(LocalDate newBirthDate)
    {
        this.birthDate = newBirthDate;
    }

    public abstract String speak();

    /**
     * Add an indivdual animal object to the list. not really needed as animals are automatically added to the list anyway.
     * @param newAnimal
     */
    public static void setAnimals(Animal2 newAnimal)
    {
        animals.add(newAnimal);
    }

    /**
     * Get a specific animal from the list.
     * @param index
     * @return
     */
    public static Animal2 getSpecificAnimal(int index)
    {
        return animals.get(index);
    }

    /**
     * Get all animals in the list.
     * @return
     */
    public static ArrayList<Animal2> getAllAnimals()
    {
        return animals;
    }

    /**
     * Remove a specific animal from the list.
     * @param index
     */
    public static void removeAnimal(int index)
    {
        animals.remove(index);
    }

    /**
     * Remove all animals from the list.
     */
    public static void removeAllAnimals()
    {
        animals.clear();
    }

}
