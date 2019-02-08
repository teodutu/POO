package logger;

import java.util.EnumSet;

class ConsoleLogger extends LoggerBase {
    ConsoleLogger(EnumSet<LogLevel> enumSet) {
        super(enumSet);
    }


    @Override
    void writeMessage(String msg) {
        System.out.println("[Console] " + msg);
    }
}
