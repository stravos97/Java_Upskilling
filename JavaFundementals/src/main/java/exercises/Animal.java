package exercises;

import java.time.LocalDate;

//abstract class Pig extends Animal{
//
//    public Pig(String name, int year, int month, int day) {
//        super(name, year, month, day);
//    }
//
//    public void speak()
//    {
//        System.out.println("The pig says: wee wee");
//    }
//}

public class Animal {
    private String name;
    private LocalDate birthDate;

    public Animal(String name, int year, int month, int day) {
        this.name = name;
        this.birthDate = LocalDate.of(year, month, day);
    }

//    public abstract void speak();

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

    @Override
    public String toString() {
        return "Person{name='" + name + "', age= " + birthDate.toString() + "}";
    }
}
