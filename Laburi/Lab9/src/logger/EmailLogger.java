package logger;

import java.util.EnumSet;

class EmailLogger extends LoggerBase{
    EmailLogger(EnumSet<LogLevel> enumSet) {
        super(enumSet);
    }

    @Override
    void writeMessage(String msg) {
        System.out.println("[Email] " + msg);
    }
}
