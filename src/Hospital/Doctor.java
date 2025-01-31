package Hospital;

public class Doctor extends Person {
    private String medicalField;
    private int yearsOfExperience;
    private String email;

    public Doctor(int id, String name, String address, String gender, int age, int phoneNumber,
                  String medicalField, int yearsOfExperience, String email) {
        super(id, name, address, gender, age, phoneNumber);
        this.medicalField = medicalField;
        this.yearsOfExperience = yearsOfExperience;
        this.email = email;
    }

    public String getMedicalField() {
        return medicalField;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getEmail() {
        return email;
    }

    public void displayVitalPatientInfo(Patient patient) {
        System.out.println("Vital Information for Patient " + patient.getName() + ":");
        System.out.println("Age: " + patient.getAge());
        System.out.println("Gender: " + patient.getGender());
    }

    public boolean rescheduleAppointment(Patient patient) {
        System.out.println("Rescheduling appointment for " + patient.getName());
        return true;
    }

    @Override
    public String toString() {
        return "Doctor Details:\n" +
                super.toString() + "\n" +
                "Medical Field: " + medicalField + "\n" +
                "Years of Experience: " + yearsOfExperience + "\n" +
                "Email: " + email;
    }
}