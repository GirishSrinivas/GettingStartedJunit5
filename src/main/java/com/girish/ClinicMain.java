package com.girish;

import com.girish.patientintake.ClinicCalendar;
import com.girish.patientintake.PatientAppointment;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicMain {

    private static ClinicCalendar calendar;

    public static void main(String[] args) throws Throwable {
        calendar = new ClinicCalendar();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Patient Intake Computer System!\n\n");
        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("x")) {
            lastOption = displayMenu(scanner);
        }
        System.out.println("\nExiting System...\n");
    }

    private static String displayMenu(Scanner scanner) throws Throwable {
        System.out.println("Please select an option:");
        System.out.println("1. Enter a Patient Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("X.  Exit System.");
        System.out.print("Option: ");
        String option = scanner.next();
        return switch (option) {
            case "1" -> {
                performPatientEntry(scanner);
                yield option;
            }
            case "2" -> {
                performAllAppointments();
                yield option;
            }
            default -> {
                System.out.println("Invalid option, please re-enter.");
                yield option;
            }
        };
    }

    private static void performPatientEntry(Scanner scanner) {
        scanner.nextLine();
        System.out.println("\n\nPlease Enter Appointment Info:");
        System.out.print("  Patient Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("  Patient First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("  Appointment Date (M/d/yyyy h:m a): ");
        String when = scanner.nextLine();
        System.out.print("  Doctor Last Name: ");
        String doc = scanner.nextLine();
        try {
            calendar.addAppointment(firstName, lastName, doc, when);
        } catch (Throwable t) {
            System.out.println("Error!  " + t.getMessage());
            return;
        }
        System.out.println("Patient entered successfully.\n\n");
    }

    private static void performAllAppointments() throws Throwable {
        System.out.println("\n\nAll Appointments in System:");
        for (PatientAppointment appointment : calendar.getAppointments()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a");
            String apptTime = formatter.format(appointment.appointmentDateTime());
            System.out.printf("%s:  %s, %s\t\tDoctor: %s%n", apptTime, appointment.patientLastName(),
                    appointment.patientFirstName(), appointment.doctor().getName());
        }
        System.out.println("\nPress any key to continue...");
        System.in.read();
        System.out.println("\n\n");
    }

}