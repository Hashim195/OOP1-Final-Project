package Hospital;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

    private int height;
    private int weight;
    private String chronicIllness;
    private String allergies;
    private String bloodType;
    private String emergencyContactName;
    private int emergencyContactPhoneNumber;
    private List<String> medicalHistory;
    private List<String> appointments;

    public Patient(int id, String name, String address, String gender, int age, int phoneNumber,
                   int height, int weight, String chronicIllness, String allergies,
                   String bloodType, String emergencyContactName, int emergencyContactPhoneNumber) {
        super(id, name, address, gender, age, phoneNumber);
        this.height = height;
        this.weight = weight;
        this.chronicIllness = chronicIllness;
        this.allergies = allergies;
        this.bloodType = bloodType;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
        this.medicalHistory = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getChronicIllness() {
        return chronicIllness;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public int getEmergencyContactPhoneNumber() {
        return emergencyContactPhoneNumber;
    }

    public void addMedicalRecord(String record) {
        medicalHistory.add(record);
    }

    public String displayMedicalHistory() {
        if (medicalHistory.isEmpty()) {
            return "No medical history available.";
        }
        StringBuilder history = new StringBuilder("Medical History:\n");
        for (Object record : medicalHistory) {
            history.append("- ").append(record).append("\n");
        }
        return history.toString();
    }

    public String displayEmergencyContact() {
        return "Emergency Contact Name: " + emergencyContactName + "\n" +
                "Emergency Contact Phone Number: " + emergencyContactPhoneNumber;
    }

    public void addAppointment(String date, String time, String doctorName, String purpose) {
        String appointment = "Appointment with Dr. " + doctorName + "\n" +
                "Date: " + date + "\n" +
                "Time: " + time + "\n" +
                "Purpose: " + purpose;
        appointments.add(appointment);
    }

    public String displayAppointments() {
        if (appointments.isEmpty()) {
            return "No appointments scheduled.";
        }
        StringBuilder appointmentDetails = new StringBuilder("Appointments:\n");
        for (String appointment : appointments) {
            appointmentDetails.append(appointment).append("\n");
        }
        return appointmentDetails.toString();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Height: " + height + " cm\n" +
                "Weight: " + weight + " kg\n" +
                "Chronic Illness: " + chronicIllness + "\n" +
                "Allergies: " + allergies + "\n" +
                "Blood Type: " + bloodType + "\n" +
                displayEmergencyContact() + "\n" +
                displayMedicalHistory() + "\n" +
                displayAppointments();
    }
}