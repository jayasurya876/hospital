public class HospitalManagementQA {

    static void check(String test, double actual, double expected) {
        if (Math.abs(actual - expected) < 0.01)
            System.out.println("PASS: " + test);
        else
            System.out.println("FAIL: " + test +
                    " | Expected: " + expected +
                    " | Actual: " + actual);
    }

    public static void main(String[] args) {

        // 1. Normal patient
        HospitalManagement.Patient p1 =
                new HospitalManagement.Patient(
                        "John", 30, "Dr. Kumar", "General",
                        "Regular", 30, 500, 1000,
                        false, 0, false);

        check("Normal Patient",
                HospitalManagement.totalBill(p1),
                2000);


        // 2. Senior citizen
        HospitalManagement.Patient p2 =
                new HospitalManagement.Patient(
                        "Ravi", 65, "Dr. Kumar", "General",
                        "Regular", 30, 500, 1000,
                        false, 0, false);

        check("Senior Citizen",
                HospitalManagement.consultationFee(p2),
                400);


        // 3. Emergency patient
        HospitalManagement.Patient p3 =
                new HospitalManagement.Patient(
                        "Arun", 30, "Dr. Kumar", "Emergency",
                        "Emergency", 30, 500, 1000,
                        false, 0, false);

        check("Emergency Patient",
                HospitalManagement.consultationFee(p3),
                1000);


        // 4. Follow-up consultation
        HospitalManagement.Patient p4 =
                new HospitalManagement.Patient(
                        "Kumar", 30, "Dr. Kumar", "General",
                        "Regular", 30, 500, 1000,
                        false, 0, true);

        check("Follow-up Patient",
                HospitalManagement.consultationFee(p4),
                250);


        // 5. Long consultation
        HospitalManagement.Patient p5 =
                new HospitalManagement.Patient(
                        "Raj", 30, "Dr. Kumar", "General",
                        "Regular", 40, 500, 1000,
                        false, 0, false);

        check("Long Consultation",
                HospitalManagement.consultationFee(p5),
                600);


        // 6. Insurance patient
        HospitalManagement.Patient p6 =
                new HospitalManagement.Patient(
                        "Siva", 30, "Dr. Kumar", "General",
                        "Regular", 30, 500, 1000,
                        true, 50, false);

        check("Insurance Amount",
                HospitalManagement.insuranceAmount(p6),
                1000);


        // 7. Patient payable after insurance
        check("Patient Payable",
                HospitalManagement.patientPayable(p6),
                1000);


        // 8. Full insurance
        HospitalManagement.Patient p7 =
                new HospitalManagement.Patient(
                        "Anil", 30, "Dr. Kumar", "General",
                        "Regular", 30, 500, 1000,
                        true, 100, false);

        check("100% Insurance",
                HospitalManagement.patientPayable(p7),
                0);


        // 9. Emergency + Senior Citizen
        HospitalManagement.Patient p8 =
                new HospitalManagement.Patient(
                        "Ramesh", 65, "Dr. Kumar", "Emergency",
                        "Emergency", 30, 0, 0,
                        false, 0, false);

        check("Emergency Senior",
                HospitalManagement.consultationFee(p8),
                800);


        // 10. Complete bill
        HospitalManagement.Patient p9 =
                new HospitalManagement.Patient(
                        "Jayasurya", 65, "Dr. Kumar", "Cardiology",
                        "Emergency", 45, 1500, 2000,
                        true, 50, false);

        check("Complete Bill",
                HospitalManagement.totalBill(p9),
                4900);

        check("Complete Insurance",
                HospitalManagement.insuranceAmount(p9),
                2450);

        check("Complete Patient Payable",
                HospitalManagement.patientPayable(p9),
                2450);

        System.out.println("\nQA Testing Completed.");
    }
}
