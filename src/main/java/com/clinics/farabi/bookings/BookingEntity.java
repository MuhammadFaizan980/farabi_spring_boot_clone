package com.clinics.farabi.bookings;

import com.clinics.farabi.patients.PatientEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class BookingEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "booking_date")
    @JsonProperty("booking_date")
    private String bookingDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;


    public BookingEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }
}
