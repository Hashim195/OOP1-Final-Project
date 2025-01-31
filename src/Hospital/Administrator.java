package Hospital;

import java.util.ArrayList;
import java.util.List;

import static Hospital.Main.findPatientById;
import static Hospital.Main.input;

public class Administrator extends Person {

    private List<Doctor> doctorList;
    private static List <Patient> patientList;
    private int officeNumber;
    private String email;

    public Administrator(int officeNumber, String email, int id, String name, String address, String gender, int age, int phoneNumber) {
        super(id, name, address, gender, age, phoneNumber);
        this.officeNumber = officeNumber;
        this.email = email;
        this.doctorList = new ArrayList<>();
        this.patientList = new ArrayList<>();
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void displayPatientInfo(Patient patient) {
        System.out.println("All Information for Patient " + patient.getName() + ":");
        System.out.println("Age: " + patient.getAge());
        System.out.println("Gender: " + patient.getGender());
        System.out.println("Weight: " + patient.getWeight());
        System.out.println("Height: " + patient.getHeight());
        System.out.println("Chronic Illness: " + patient.getChronicIllness());
        System.out.println("Allergies: " + patient.getAllergies());
        System.out.println("Blood Type: " + patient.getBloodType());
    }

    public void displayDoctorInfo(Doctor doctor) {
        System.out.println("Information for Doctor " + doctor.getName() + ":");
        System.out.println("Age: " + doctor.getAge());
        System.out.println("Gender: " + doctor.getGender());
        System.out.println("Medical Field: " + doctor.getMedicalField());
        System.out.println("Years of Experience: " + doctor.getYearsOfExperience());
        System.out.println("Address: " + doctor.getAddress());
        System.out.println("Phone Number: " + doctor.getPhoneNumber());
    }

    public String removeDoctor(Doctor doctor) {
        if (doctorList.contains(doctor)) {
            doctorList.remove(doctor);
            return "Doctor " + doctor.getName() + " has been removed.";
        } else {
            return "Doctor not found.";
        }
    }

    static void removePatient() {
        System.out.println("Enter patient ID to remove:");
        int patientId = input.nextInt();
        Patient patient = findPatientById(patientId);
        if (patient != null) {
            patientList.remove(patient);
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    public void registerPatient(int id, String name, String address, String gender, int age, int phoneNumber,
                                int height, int weight, String chronicIllness, String allergies, String bloodType,
                                String emergencyContactName, int emergencyContactPhoneNumber) {
        Patient patient = new Patient(id, name, address, gender, age, phoneNumber, height, weight,
                chronicIllness, allergies, bloodType, emergencyContactName, emergencyContactPhoneNumber);
        patientList.add(patient);
        System.out.println("Patient " + name + " has been registered.");
    }

    public void registerDoctor(int id, String name, String address, String gender, int age, int phoneNumber,
                               String medicalField, int yearsOfExperience, String email) {
        Doctor doctor = new Doctor(id, name, address, gender, age, phoneNumber, medicalField, yearsOfExperience, email);
        doctorList.add(doctor);
        System.out.println("Doctor " + name + " has been registered.");
    }

}