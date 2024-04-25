package dev.lpa;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        // Depth first

        Path startingPath = Path.of(".");
        FileVisitor<Path> statsVisitor = new StatsVisitor();

        try{
            Files.walkFileTree(startingPath, statsVisitor);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

    }

    private static class StatsVisitor extends SimpleFileVisitor<Path>{

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);
            System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }


    }
}