package skel.Implementations;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Retine caile tuturor fisierelor Java din directorul dat.
 */
public class FilesCounter extends SimpleFileVisitor<Path> {
    private ArrayList<Path> javaFiles;

    FilesCounter() {
        javaFiles = new ArrayList<>();
    }

    final ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        if (attr.isRegularFile() && file.toString().endsWith(".class")) {
            javaFiles.add(file);
        }

        return CONTINUE;
    }
}
