package logger;

import java.util.EnumSet;

public class ConsoleLogger extends LoggerBase {
    public ConsoleLogger(EnumSet<LogLevel> enumSet) {
        super(enumSet);
    }


    @Override
    void writeMessage(String msg) {
        System.out.println("[Console] " + msg);
    }
}
