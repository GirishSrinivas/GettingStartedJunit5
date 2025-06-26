package com.girish.patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

    @Test
    void allowEntryOfAnAppointment() {
        ClinicCalendar calendar = new ClinicCalendar();
        String firstName = "John";
        String lastName = "Doe";
        String doctorKey = "Avery";
        String dateTime = "10/15/2023 2:30 PM";

        assertDoesNotThrow(() -> calendar.addAppointment(firstName, lastName, doctorKey, dateTime));
        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1, appointments.size());
        assertEquals(firstName, appointments.get(0).patientFirstName());
        assertEquals(lastName, appointments.get(0).patientLastName());
        assertEquals(Doctor.AVERY, appointments.get(0).doctor());
        assertEquals("10/15/2023 2:30 PM", appointments.get(0).appointmentDateTime().format(
                DateTimeFormatter.ofPattern("M/d/yyyy h:mm a", Locale.US)));
    }
}