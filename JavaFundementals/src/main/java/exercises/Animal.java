package exercises;

import java.time.LocalDate;

public class Animal {
    private String name;
    private LocalDate birthDate;

    public Animal(String name, int year, int month, int day) {
        this.name = name;
        this.birthDate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        LocalDate period = LocalDate.now().minusYears(birthDate.getYear());
        return period.getYear();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Returns a string representation of the animal.
     * Could also use birthDate.toString() instead of String.valueOf(getAge())
     * @return a string representation of the animal
     */
    @Override
    public String toString() {
        String age = String.valueOf(getAge());
        return "The name of the animal is: " + getName() + "The age of the animal is: " + age + " years old.";
    }
}
