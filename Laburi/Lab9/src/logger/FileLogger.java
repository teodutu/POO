package logger;

import java.util.EnumSet;

public class FileLogger extends LoggerBase {
    public FileLogger(EnumSet<LogLevel> enumSet) {
        super(enumSet);
    }

    @Override
    void writeMessage(String msg) {
        System.out.println("[File] " + msg);
    }
}
