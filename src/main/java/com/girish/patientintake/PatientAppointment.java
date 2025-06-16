package com.girish.patientintake;

import java.time.LocalDateTime;

public record PatientAppointment(String patientFirstName, String patientLastName, LocalDateTime appointmentDateTime,
                                 Doctor doctor) {

}