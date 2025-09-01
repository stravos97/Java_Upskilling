package oop;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Member implements Printable, Movable {

    private final String firstName;
    protected String lastName;
    private LocalDate joinDate;

    public Member(String firstName, String lastName, int year, int month, int day) {
        this(firstName, lastName);
        this.joinDate = LocalDate.of(year, month, day);
    }

    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinDate = LocalDate.now();
    }

    public static LocalDate getDate(){
        return LocalDate.now();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public final String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public long getMemberDays(){
        return joinDate.until(LocalDate.now(), ChronoUnit.DAYS);
    }

    @Override
    public String toString() {
        return getFullName() + " has been member for " + getMemberDays() + " days.";
    }

    @Override
    public void print() {
        System.out.println("I am a member");
    }

    @Override
    public String move() {
        return "I am moving";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Member member)) return false; // check to see if obj is a member. If it is a member it will be referred to as "member"
        // checking whether the firstname of the this object, is the same as the firstname of the the obejct we're comparing it to, same with lastname and joindate
        return Objects.equals(firstName, member.firstName) && Objects.equals(lastName, member.lastName) && Objects.equals(joinDate, member.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName, this.joinDate);
    }
}


