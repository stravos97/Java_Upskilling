package exercises;

import java.time.LocalDate;

public abstract class Animal2 {

    protected String name;
    protected LocalDate birthDate;

    public Animal2(String name, int year, int month, int day) {
        this.name = name;
        this.birthDate = LocalDate.of(year, month, day);
    }


    /**
     * Returns a string representation of the animal.
     * Could also use birthDate.toString() instead of String.valueOf(getAge())
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

}
