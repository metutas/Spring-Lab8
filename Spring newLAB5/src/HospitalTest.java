public class HospitalTest {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("Medipol Hastanesi", 5, 10);
        System.out.println("Hastane oluşturuldu: " + hospital);


        Doctor d1 = new Doctor("Dr. Ali", "D001", "Kardiyoloji");
        hospital.addDoctor(d1);
        System.out.println("Doktor eklendi: " + hospital);


        Patient p1 = new Patient("Ahmet Yılmaz", "P001", "2025-04-20", null);
        hospital.addPatient(p1);
        System.out.println("Hasta eklendi: " + hospital);


        hospital.assignDoctorToPatient("P001", "D001");
        System.out.println("Doktor hastaya atandı: " + hospital);


        Patient foundPatient = hospital.findPatient("P001");
        System.out.println("Bulunan hasta: " + foundPatient);


        Doctor foundDoctor = hospital.findDoctor("D001");
        System.out.println("Bulunan doktor: " + foundDoctor);


        hospital.removePatient("P001");
        System.out.println("Hasta silindi: " + hospital);
    }
}
