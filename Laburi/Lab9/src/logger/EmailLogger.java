package logger;

import java.util.EnumSet;

public class EmailLogger extends LoggerBase{
    public EmailLogger(EnumSet<LogLevel> enumSet) {
        super(enumSet);
    }

    @Override
    void writeMessage(String msg) {
        System.out.println("[Email] " + msg);
    }
}
