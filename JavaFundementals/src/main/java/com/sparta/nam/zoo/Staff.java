package com.sparta.nam.zoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class Staff implements Speakable {
    protected String name;
    protected LocalDate dateOfEmployment;
    protected LocalTime shiftStartTime;
    protected LocalTime shiftEndTime;

    public Staff(String name, LocalDate dateOfEmployment, LocalTime shiftStartTime, LocalTime shiftEndTime) {
        this.name = name;
        this.dateOfEmployment = dateOfEmployment;
        this.shiftStartTime = shiftStartTime;
        this.shiftEndTime = shiftEndTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public LocalTime getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(LocalTime shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public LocalTime getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(LocalTime shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }

    public int daysEmployed() {
        return (int) ChronoUnit.DAYS.between(dateOfEmployment, LocalDate.now());
    }

    @Override
    public abstract String talk();

    @Override
    public String toString() {
        return String.format("%s named %s, employed for %d days, shift: %s-%s, says: %s", 
                            getClass().getSimpleName(), name, daysEmployed(), 
                            shiftStartTime, shiftEndTime, talk());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Staff staff)) return false;
        return Objects.equals(name, staff.name) && 
               Objects.equals(dateOfEmployment, staff.dateOfEmployment) && 
               Objects.equals(shiftStartTime, staff.shiftStartTime) && 
               Objects.equals(shiftEndTime, staff.shiftEndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfEmployment, shiftStartTime, shiftEndTime);
    }
}