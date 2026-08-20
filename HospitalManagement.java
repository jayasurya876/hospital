import java.util.*;

public class HospitalManagement {

    static class Patient {
        String name;
        int age;
        String doctor;
        String department;
        String appointmentType;
        int duration;
        double labCharges;
        double medicineCharges;
        boolean insured;
        double insuranceCoverage;
        boolean followUp;

        Patient(String name, int age, String doctor, String department,
                String appointmentType, int duration,
                double labCharges, double medicineCharges,
                boolean insured, double insuranceCoverage,
                boolean followUp) {

            this.name = name;
            this.age = age;
            this.doctor = doctor;
            this.department = department;
            this.appointmentType = appointmentType;
            this.duration = duration;
            this.labCharges = labCharges;
            this.medicineCharges = medicineCharges;
            this.insured = insured;
            this.insuranceCoverage = insuranceCoverage;
            this.followUp = followUp;
        }
    }

    public static double consultationFee(Patient p) {

        double fee = 500;

        // Duration charge
        if (p.duration > 30)
            fee += (p.duration - 30) * 10;

        // Emergency charge
        if (p.appointmentType.equalsIgnoreCase("Emergency"))
            fee += 500;

        // Senior citizen discount
        if (p.age >= 60)
            fee *= 0.80;

        // Follow-up discount
        if (p.followUp)
            fee *= 0.50;

        return fee;
    }

    public static double totalBill(Patient p) {

        double consultation = consultationFee(p);

        return consultation
                + p.labCharges
                + p.medicineCharges;
    }

    public static double insuranceAmount(Patient p) {

        if (!p.insured)
            return 0;

        double bill = totalBill(p);

        double coverage = bill * p.insuranceCoverage / 100;

        return Math.min(coverage, bill);
    }

    public static double patientPayable(Patient p) {

        return totalBill(p) - insuranceAmount(p);
    }

    public static void printBill(Patient p) {

        double consultation = consultationFee(p);
        double total = totalBill(p);
        double insurance = insuranceAmount(p);
        double payable = patientPayable(p);

        System.out.println("\n===== HOSPITAL BILL =====");
        System.out.println("Patient: " + p.name);
        System.out.println("Age: " + p.age);
        System.out.println("Doctor: " + p.doctor);
        System.out.println("Department: " + p.department);
        System.out.println("Appointment: " + p.appointmentType);

        System.out.printf("Consultation Fee: %.2f%n", consultation);
        System.out.printf("Lab Charges: %.2f%n", p.labCharges);
        System.out.printf("Medicine Charges: %.2f%n", p.medicineCharges);
        System.out.printf("Total Bill: %.2f%n", total);
        System.out.printf("Insurance Coverage: %.2f%n", insurance);
        System.out.printf("Patient Payable: %.2f%n", payable);
    }

    public static void main(String[] args) {

        Patient p1 = new Patient(
                "Jayasurya",
                65,
                "Dr. Kumar",
                "Cardiology",
                "Emergency",
                45,
                1500,
                2000,
                true,
                50,
                false
        );

        printBill(p1);

        Patient p2 = new Patient(
                "Rahul",
                35,
                "Dr. Ravi",
                "General",
                "Regular",
                30,
                500,
                1000,
                false,
                0,
                true
        );

        printBill(p2);
    }
}
