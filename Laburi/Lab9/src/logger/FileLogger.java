package logger;

import java.util.EnumSet;

class FileLogger extends LoggerBase {
    FileLogger(EnumSet<LogLevel> enumSet) {
        super(enumSet);
    }

    @Override
    void writeMessage(String msg) {
        System.out.println("[File] " + msg);
    }
}
