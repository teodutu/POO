package utils;

/**
 * Contine boala unui pacient sub forma de string si severitatea acesteia.
 */
public class PatientState {
    private String illnessName;
    private int severity;

    public final String getIllnessName() {
        return illnessName;
    }

    public final void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public final int getSeverity() {
        return severity;
    }

    public final void setSeverity(int severity) {
        this.severity = severity;
    }
}
