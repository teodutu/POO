package factories;

public class DoctorNameFactory {
    private static DoctorNameFactory doctorNameFactory;

    /**
     * Returneaza string-ul dat ca input intr-o forma ce respecta tiparul cerut la afisare.
     *
     * @param type string citit din fisierul JSON
     * @return     string de mai sus, rescris
     */
    public String makeName(String type) {
        switch (type) {
            case "CARDIOLOGIST":
                return "Cardiologist";
            case "ER_PHYSICIAN":
                return "ERPhysician";
            case "GASTROENTEROLOGIST":
                return "Gastroenterologist";
            case "GENERAL_SURGEON":
                return "General Surgeon";
            case "INTERNIST":
                return "Internist";
            case "NEUROLOGIST":
                return "Neurologist";
            default:
                return "";
        }
    }

    public static DoctorNameFactory getInstance() {
        if (doctorNameFactory == null) {
            doctorNameFactory = new DoctorNameFactory();
        }

        return doctorNameFactory;
    }
}
