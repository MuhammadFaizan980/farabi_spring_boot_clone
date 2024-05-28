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
        patient.firstName = request.firstName();
        patient.lastName = request.lastName();
        patient.email = request.email();
        patient.phoneNumber = request.phone();
        patient.password = request.password();
        patient.age = request.age();

        return patient;
    }
}
