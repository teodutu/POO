package logger;

import java.util.EnumSet;

enum LogLevel {
    None, Info, Debug, Warning, Error, FunctionalMessage, FunctionalError;

    static EnumSet<LogLevel> All() {
        return EnumSet.allOf(LogLevel.class);
    }
}
