package com.clinics.farabi.patients;

import com.clinics.farabi.globals.GlobalResponseModel;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {
    GlobalResponseModel toGlobalResponseModel(Object data) {
        return new GlobalResponseModel(true, null, data);
    }

    PatientEntity toPatientEntity(PatientRequest request) {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName(request.firstName());
        patient.setLastName(request.lastName());
        patient.setEmail(request.email());
        patient.setPhoneNumber(request.phone());
        patient.setPassword(request.password());
        patient.setAge(request.age());

        return patient;
    }
}
