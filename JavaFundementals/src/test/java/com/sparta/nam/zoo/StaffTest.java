package com.sparta.nam.zoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class StaffTest {

    private static class TestStaff extends Staff {
        public TestStaff(String name, LocalDate dateOfEmployment, LocalTime shiftStartTime, LocalTime shiftEndTime) {
            super(name, dateOfEmployment, shiftStartTime, shiftEndTime);
        }

        @Override
        public String talk() {
            return "Test staff member speaking!";
        }
    }

    @Test
    @DisplayName("Staff creation with basic properties")
    public void staffCreationTest() {
        LocalDate employmentDate = LocalDate.of(2020, 5, 15);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        
        TestStaff staff = new TestStaff("John", employmentDate, startTime, endTime);
        
        Assertions.assertEquals("John", staff.getName());
        Assertions.assertEquals(employmentDate, staff.getDateOfEmployment());
        Assertions.assertEquals(startTime, staff.getShiftStartTime());
        Assertions.assertEquals(endTime, staff.getShiftEndTime());
    }

    @Test
    @DisplayName("Staff setters work correctly")
    public void staffSettersTest() {
        LocalDate employmentDate = LocalDate.of(2020, 5, 15);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        
        TestStaff staff = new TestStaff("John", employmentDate, startTime, endTime);
        
        LocalDate newEmploymentDate = LocalDate.of(2019, 3, 10);
        LocalTime newStartTime = LocalTime.of(8, 0);
        LocalTime newEndTime = LocalTime.of(16, 0);
        
        staff.setName("Jane");
        staff.setDateOfEmployment(newEmploymentDate);
        staff.setShiftStartTime(newStartTime);
        staff.setShiftEndTime(newEndTime);
        
        Assertions.assertEquals("Jane", staff.getName());
        Assertions.assertEquals(newEmploymentDate, staff.getDateOfEmployment());
        Assertions.assertEquals(newStartTime, staff.getShiftStartTime());
        Assertions.assertEquals(newEndTime, staff.getShiftEndTime());
    }

    @Test
    @DisplayName("daysEmployed calculates correctly")
    public void daysEmployedTest() {
        LocalDate employmentDate = LocalDate.now().minusDays(100);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        
        TestStaff staff = new TestStaff("John", employmentDate, startTime, endTime);
        
        int expectedDays = (int) ChronoUnit.DAYS.between(employmentDate, LocalDate.now());
        Assertions.assertEquals(expectedDays, staff.daysEmployed());
    }

    @Test
    @DisplayName("daysEmployed returns 0 for employment date today")
    public void daysEmployedTodayTest() {
        LocalDate employmentDate = LocalDate.now();
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        
        TestStaff staff = new TestStaff("John", employmentDate, startTime, endTime);
        
        Assertions.assertEquals(0, staff.daysEmployed());
    }

    @Test
    @DisplayName("Staff implements Speakable interface")
    public void speakableInterfaceTest() {
        LocalDate employmentDate = LocalDate.of(2020, 5, 15);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        
        TestStaff staff = new TestStaff("John", employmentDate, startTime, endTime);
        
        Assertions.assertTrue(staff instanceof Speakable);
        Assertions.assertEquals("Test staff member speaking!", staff.talk());
    }

    @Test
    @DisplayName("Staff toString returns correct format")
    public void staffToStringTest() {
        LocalDate employmentDate = LocalDate.now().minusDays(50);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        
        TestStaff staff = new TestStaff("John", employmentDate, startTime, endTime);
        
        String expectedString = String.format("TestStaff named John, employed for 50 days, shift: 09:00-17:00, says: Test staff member speaking!");
        Assertions.assertEquals(expectedString, staff.toString());
    }

    @Test
    @DisplayName("Staff equals method works correctly")
    public void staffEqualsTest() {
        LocalDate employmentDate = LocalDate.of(2020, 5, 15);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        
        TestStaff staff1 = new TestStaff("John", employmentDate, startTime, endTime);
        TestStaff staff2 = new TestStaff("John", employmentDate, startTime, endTime);
        TestStaff staff3 = new TestStaff("Jane", employmentDate, startTime, endTime);
        
        Assertions.assertEquals(staff1, staff2);
        Assertions.assertNotEquals(staff1, staff3);
    }

    @Test
    @DisplayName("Staff hashCode method works correctly")
    public void staffHashCodeTest() {
        LocalDate employmentDate = LocalDate.of(2020, 5, 15);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);
        
        TestStaff staff1 = new TestStaff("John", employmentDate, startTime, endTime);
        TestStaff staff2 = new TestStaff("John", employmentDate, startTime, endTime);
        
        Assertions.assertEquals(staff1.hashCode(), staff2.hashCode());
    }
}