package Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Hospital.Administrator.removePatient;

public class Main {
    public static String mainMenu = "\n*** Welcome to the hospital management system ! *** .\n" +
            "\nPlease choose authorization level.\n" +
            "1- Administrator\n" +
            "2- Doctor\n" +
            "3- Patient\n" +
            "4- Exit\n";

    public static String adminMenu = "\n*** Welcome Administrator ***\n" +
            "1- Display Patient Info\n" +
            "2- Display Doctor Info\n" +
            "3- Remove Doctor\n" +
            "4- Remove Patient\n" +
            "5- Register Patient\n" +
            "6- Register Doctor\n" +
            "7- Exit\n" +
            "Your choice: ";

    public static String doctorMenu = "\n*** Welcome Doctor ***\n" +
            "1- View Vital Information of a Patient\n" +
            "2- Reschedule Appointment\n" +
            "3- Exit\n" +
            "Your choice: ";

    public static String patientMenu = "\n*** Welcome Patient ***\n" +
            "1- Pick an appointment\n" +
            "2- View appointments\n" +
            "3- View history\n" +
            "4- Exit\n" +
            "Your choice: ";

    static Scanner input = new Scanner(System.in);
    static List<Administrator> adminList = new ArrayList<>();
    static List<Doctor> doctorList = new ArrayList<>();
    static List<Patient> patientList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println(mainMenu);
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    patientMenu();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Wrong entry. Please try again.");
            }
        } while (choice != 4);
    }

    // Admin Menu
    private static void adminMenu() {
        int choice;
        do {
            System.out.println(adminMenu);
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    displayPatientInfo();
                    break;
                case 2:
                    displayDoctorInfo();
                    break;
                case 3:
                    removeDoctor();
                    break;
                case 4:
                    removePatient();
                    break;
                case 5:
                    registerPatient();
                    break;
                case 6:
                    registerDoctor();
                    break;
                case 7:
                    System.out.println("Returning to main menu.");
                    return;
                default:
                    System.out.println("Wrong entry. Please try again.");
            }
        } while (choice != 7);
    }

    private static void displayPatientInfo() {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        System.out.println("Enter patient ID to display information:");
        int patientId = input.nextInt();
        Patient patient = findPatientById(patientId);
        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void displayDoctorInfo() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        System.out.println("Enter doctor ID to display information:");
        int doctorId = input.nextInt();
        Doctor doctor = findDoctorById(doctorId);
        if (doctor != null) {
            System.out.println(doctor);
        } else {
            System.out.println("Doctor not found.");
        }
    }

    private static void removeDoctor() {
        System.out.println("Enter doctor ID to remove:");
        int doctorId = input.nextInt();
        Doctor doctor = findDoctorById(doctorId);
        if (doctor != null) {
            doctorList.remove(doctor);
            System.out.println("Doctor removed successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }



    private static void registerPatient() {
        System.out.println("Register a new patient:");
        System.out.println("Enter patient ID:");
        int id = input.nextInt();
        input.nextLine(); // Consume newline
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter address:");
        String address = input.nextLine();
        System.out.println("Enter gender:");
        String gender = input.nextLine();
        System.out.println("Enter age:");
        int age = input.nextInt();
        System.out.println("Enter phone number:");
        int phoneNumber = input.nextInt();
        System.out.println("Enter height (cm):");
        int height = input.nextInt();
        System.out.println("Enter weight (kg):");
        int weight = input.nextInt();
        input.nextLine(); // Consume newline
        System.out.println("Enter chronic illness (if any):");
        String chronicIllness = input.nextLine();
        System.out.println("Enter allergies (if any):");
        String allergies = input.nextLine();
        System.out.println("Enter blood type:");
        String bloodType = input.nextLine();
        System.out.println("Enter emergency contact name:");
        String emergencyContactName = input.nextLine();
        System.out.println("Enter emergency contact phone number:");
        int emergencyContactPhoneNumber = input.nextInt();

        Patient newPatient = new Patient(id, name, address, gender, age, phoneNumber, height, weight, chronicIllness, allergies, bloodType, emergencyContactName, emergencyContactPhoneNumber);
        patientList.add(newPatient);
        System.out.println("Patient " + name + " has been registered.");
    }

    private static void registerDoctor() {
        System.out.println("Register a new doctor:");
        System.out.println("Enter doctor ID:");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter address:");
        String address = input.nextLine();
        System.out.println("Enter gender:");
        String gender = input.nextLine();
        System.out.println("Enter age:");
        int age = input.nextInt();
        System.out.println("Enter phone number:");
        int phoneNumber = input.nextInt();
        input.nextLine();
        System.out.println("Enter medical field:");
        String medicalField = input.nextLine();
        System.out.println("Enter years of experience:");
        int yearsOfExperience = input.nextInt();
        input.nextLine();
        System.out.println("Enter email:");
        String email = input.nextLine();

        Doctor newDoctor = new Doctor(id, name, address, gender, age, phoneNumber, medicalField, yearsOfExperience, email);
        doctorList.add(newDoctor);
        System.out.println("Doctor " + name + " has been registered.");
    }

    static Patient findPatientById(int id) {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    // Doctor Menu
    private static void doctorMenu() {
        int choice;
        System.out.println("Enter your doctor ID:");
        int doctorId = input.nextInt();
        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        do {
            System.out.println(doctorMenu);
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    viewVitalPatientInfo(doctor);
                    break;
                case 2:
                    rescheduleAppointment();
                    break;
                case 3:
                    System.out.println("Returning to main menu.");
                    return;
                default:
                    System.out.println("Wrong entry. Please try again.");
            }
        } while (choice != 3);
    }

    private static void viewVitalPatientInfo(Doctor doctor) {
        System.out.println("Enter patient ID to view vital information:");
        int patientId = input.nextInt();
        Patient patient = findPatientById(patientId);
        if (patient != null) {
            doctor.displayVitalPatientInfo(patient);
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void rescheduleAppointment() {
        System.out.println("Rescheduling appointment...");

    }


    private static void patientMenu() {
        int choice;
        System.out.println("Enter your patient ID:");
        int patientId = input.nextInt();
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        do {
            System.out.println(patientMenu);
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    pickAppointment(patient);
                    break;
                case 2:
                    viewAppointments(patient);
                    break;
                case 3:
                    viewMedicalHistory(patient);
                    break;
                case 4:
                    System.out.println("Returning to main menu.");
                    return;
                default:
                    System.out.println("Wrong entry. Please try again.");
            }
        } while (choice != 4);
    }

    private static void pickAppointment(Patient patient) {
        input.nextLine();
        System.out.println("Enter appointment details: ");
        System.out.println("Enter date (YYYY-MM-DD):");
        String date = input.nextLine();
        System.out.println("Enter time (HH:MM):");
        String time = input.nextLine();
        System.out.println("Enter doctor's name:");
        String doctorName = input.nextLine();
        System.out.println("Enter purpose of visit:");
        String purpose = input.nextLine();

        patient.addAppointment(date, time, doctorName, purpose);
        System.out.println("Appointment scheduled successfully.");
    }

    private static void viewAppointments(Patient patient) {
        System.out.println(patient.displayAppointments());
    }

    private static void viewMedicalHistory(Patient patient) {
        System.out.println(patient.displayMedicalHistory());
    }
}

