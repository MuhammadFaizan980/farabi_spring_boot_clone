package com.clinics.farabi.bookings;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookingRepository extends JpaRepository<BookingEntity, Integer> {
    List<BookingEntity> findAllByPatientIdEquals(int patientId);
}