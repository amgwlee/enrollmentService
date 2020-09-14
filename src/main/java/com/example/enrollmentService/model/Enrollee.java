package com.example.enrollmentService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;

@Document
public class Enrollee {

    //requiredFields
    @Id
    @NotBlank
    private String id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    //doesn't need annotation by defaulting to false
    private boolean active;
    @NotBlank
    private Date birthDate;

    //optionalFields
    private String phoneNumber;
    private ArrayList<Dependent> dependents; //zero or more


    public Enrollee(String id, String firstName, String lastName, boolean active, Date birthDate, String phoneNumber, ArrayList<Dependent> dependents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.dependents = dependents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(ArrayList<Dependent> dependents) {
        this.dependents = dependents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enrollee enrollee = (Enrollee) o;

        if (active != enrollee.active) return false;
        if (!id.equals(enrollee.id)) return false;
        if (!firstName.equals(enrollee.firstName)) return false;
        if (!lastName.equals(enrollee.lastName)) return false;
        if (!birthDate.equals(enrollee.birthDate)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(enrollee.phoneNumber) : enrollee.phoneNumber != null)
            return false;
        return dependents != null ? dependents.equals(enrollee.dependents) : enrollee.dependents == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (dependents != null ? dependents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Enrollee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dependents=" + dependents +
                '}';
    }
}
