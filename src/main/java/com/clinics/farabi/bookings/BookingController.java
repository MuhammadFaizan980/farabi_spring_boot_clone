package com.clinics.farabi.bookings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    public IBookingRepository iBookingRepository;

    @PostMapping("/bookings")
    public BookingEntity create(@RequestBody BookingEntity bookingEntity) {
        return iBookingRepository.save(bookingEntity);
    }

    @GetMapping("/bookings/{patient-id}")
    public List<BookingEntity> getAll(@PathVariable("patient-id") int patientId) {
        return iBookingRepository.findAllByPatientIdEquals(patientId);
    }
}
