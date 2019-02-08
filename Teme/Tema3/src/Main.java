import com.fasterxml.jackson.databind.ObjectMapper;
import utils.HospitalRunner;

import java.io.File;
import java.io.IOException;

public final class Main {
    private Main() { }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        HospitalRunner runner;

        // se citeste inputul
        try {
            runner = mapper.readValue(new File(args[0]), HospitalRunner.class);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // se ruleaza simularea efectiva
        for (int roundNumber = 0; roundNumber < runner.getSimulationLength(); ++roundNumber) {
            System.out.println("~~~~ Patients in round " + (roundNumber + 1) + " ~~~~");
            runner.triagePatients(roundNumber);
            runner.examinePatients();
            runner.investigatePatients();
            runner.printMessages();
            runner.applyTreatment();
            System.out.println();
        }
    }
}
