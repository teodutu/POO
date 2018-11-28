package logger;

import java.util.EnumSet;

public class Test {
    public static void main(final String[] args) {
        // Construiți lanțul de responsabilitate
        LoggerBase logger, logger1;
        // TODO Instanțiați obiectele și setați lanțul de responsabilitate folosind metoda setNext()
        logger = new ConsoleLogger(LogLevel.All());
        logger1 = logger.setNext(new EmailLogger(EnumSet.of(LogLevel.FunctionalMessage,
                                                            LogLevel.FunctionalError)));
        logger1.setNext(new FileLogger(EnumSet.of(LogLevel.Warning, LogLevel.Error)));

        // Manipulat de ConsoleLogger pentru că ConsoleLogger are LogLevel.All()
        logger.message("Se execută metoda ProcessOrder()", LogLevel.Debug);
        logger.message("Comanda a fost procesată cu succes", LogLevel.Info);

        // Manipulat de ConsoleLogger și FileLogger pentru că FileLogger extinde Warning & Error
        logger.message("Datele despre adresa clientului lipsesc din baza de date a filialei", LogLevel.Warning);
        logger.message("Detele despre adresa clientului lipsesc din baza de date a organizație", LogLevel.Error);

        // Manipulat de ConsoleLogger și EmailLogger pentru că EmailLogger extinde FunctionalMessage & FunctionalError
        logger.message("Nu se poate procesa comanda #Comanda1 datată pe 25.11.2018 pentru clientul #Clientul1",
                LogLevel.FunctionalError);

        // Manipulat de ConsoleLogger și EmailLogger
        logger.message("Comandă procesată", LogLevel.FunctionalMessage);

        /*
         * Ce se va afișa:
         *
         *
         * [Console] Se execută metoda ProcessOrder()
         * [Console] Comanda a fost procesată cu succes
         * [Console] Datele despre adresa clientului lipsesc din baza de date a filialei
         * [File] Datele despre adresa clientului lipsesc din baza de date a filialei
         * [Console] Detele despre adresa clientului lipsesc din baza de date a organizație
         * [File] Detele despre adresa clientului lipsesc din baza de date a organizație
         * [Console] Nu se poate procesa comanda #Comanda1 datată pe 25.11.2018 pentru clientul #Clientul1
         * [Email] Nu se poate procesa comanda #Comanda1 datată pe 25.11.2018 pentru clientul #Clientul1
         * [Console] Comandă procesată
         * [Email] Comandă procesată
         *
         */
    }
}
