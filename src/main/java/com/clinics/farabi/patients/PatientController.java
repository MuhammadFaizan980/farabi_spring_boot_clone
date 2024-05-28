package com.clinics.farabi.patients;

import com.clinics.farabi.globals.GlobalResponseModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    public PatientMapper patientMapper;
    @Autowired
    public IPatientRepository iPatientRepository;

    @PostMapping("/patients")
    public ResponseEntity<Object> create(@Valid @RequestBody PatientRequest request) {
        PatientEntity patientEntity = iPatientRepository.save(patientMapper.toPatientEntity(request));
        GlobalResponseModel globalResponseModel = patientMapper.toGlobalResponseModel(patientEntity);
        return ResponseEntity.ok(globalResponseModel);
    }

    @GetMapping("/patients")
    public ResponseEntity<GlobalResponseModel> getAll(@RequestParam Integer page) { // client must sent page starting from 1, not 0
        List<PatientEntity> patients = iPatientRepository.findAll(PageRequest.of(page - 1, 20)).getContent();
        return ResponseEntity.ok(patientMapper.toGlobalResponseModel(patients));
    }

    @GetMapping("/patients/filter")
    public ResponseEntity<Object> filterUsers(@RequestParam Optional<String> email, @RequestParam(name = "first_name") Optional<String> firstName, @RequestParam(name = "last_name") Optional<String> lastName, @RequestParam Optional<String> phone, @RequestParam Integer page) {
        try {
            Pageable pageable = PageRequest.of(page - 1, 20);

            if (email.isPresent()) {
                return ResponseEntity.ok(patientMapper.toGlobalResponseModel(iPatientRepository.findAllByEmailContaining(email.get(), pageable).getContent()));
            } else if (firstName.isPresent()) {
                return ResponseEntity.ok(patientMapper.toGlobalResponseModel(iPatientRepository.findAllByFirstNameContaining(firstName.get(), pageable).getContent()));
            } else if (lastName.isPresent()) {
                return ResponseEntity.ok(patientMapper.toGlobalResponseModel(iPatientRepository.findAllByLastNameContaining(lastName.get(), pageable).getContent()));
            } else if (phone.isPresent()) {
                return ResponseEntity.ok(patientMapper.toGlobalResponseModel(iPatientRepository.findAllByPhoneNumberContaining(phone.get(), pageable).getContent()));
            } else {
                return ResponseEntity.ofNullable(new GlobalResponseModel(false, List.of("invalid filter params"), null));
            }
        } catch (Exception e) {
            return ResponseEntity.ofNullable(new GlobalResponseModel(false, List.of(e.getMessage()), null));
        }
    }
}