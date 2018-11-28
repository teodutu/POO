package logger;

import java.util.EnumSet;

abstract class LoggerBase {
    private EnumSet<LogLevel> logLevels;
    private LoggerBase next;

    LoggerBase() {}

    LoggerBase(EnumSet<LogLevel> enumSet) {
        logLevels = enumSet;
    }

    LoggerBase setNext(LoggerBase nextLogger) {
        next = nextLogger;
        return next;
    }

    abstract void writeMessage(String msg);

    void message(String msg, LogLevel severity) {
        if (logLevels.contains(severity)) {
            writeMessage(msg);
        }

        if (next != null) {
            next.message(msg, severity);
        }
    }
}
