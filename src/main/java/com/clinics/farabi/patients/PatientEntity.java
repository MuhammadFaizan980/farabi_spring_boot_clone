package com.clinics.farabi.patients;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue
    public int id;
    @Column(name = "first_name")
    @JsonProperty("first_name")
    public String firstName;
    @Column(name = "last_name")
    @JsonProperty("last_name")
    public String lastName;
    @Column(unique = true)
    public String email;
    public String password;
    @Column(unique = true, name = "phone")
    @JsonProperty("phone")
    public String phoneNumber;
    public Integer age;

    public PatientEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
