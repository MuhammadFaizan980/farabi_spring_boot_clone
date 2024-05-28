package com.clinics.farabi.patients;

import com.clinics.farabi.globals.GlobalResponseModel;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@RestControllerAdvice
public class PatientsConstraintErrorHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<GlobalResponseModel> handleSqlExceptions(SQLException ex) {
        List<String> errors = new LinkedList<>();
        String emailErrKey = "patients_email_key";
        String phoneErrKey = "patients_phone_key";

        String error = NestedExceptionUtils.getMostSpecificCause(ex).getMessage();


        if (error.contains(emailErrKey)) {
            errors.add("Email already exists");
        }
        if (error.contains(phoneErrKey)) {
            errors.add("Phone number already exists");
        }
        return ResponseEntity.ofNullable(new GlobalResponseModel(false, errors,
                null));
    }
}
