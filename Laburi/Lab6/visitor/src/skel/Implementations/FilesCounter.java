package skel.Implementations;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Retine caile tuturor fisierelor Java din directorul dat.
 */
public class FilesCounter extends SimpleFileVisitor<Path> {

    private ArrayList<Path> javaFiles;

    public final ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    //TODO - suprascrieti metodele visit
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        if (attr.isRegularFile() && file.toString().endsWith(".class")) {
            System.out.format(file.toString());
        }

        return CONTINUE;
    }

    public static void Main(String[] args) {
        FilesCounter fc = new FilesCounter();

        fc.visitFile(Paths.get("."), );
    }
}
