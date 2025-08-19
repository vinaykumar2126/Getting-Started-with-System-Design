package Withjavastrategy;

import Withjavastrategy.Strategy.ExtensionStrategy;
import Withjavastrategy.Strategy.SizeGreaterStrategy;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path root = Paths.get("."); // current directory
        // Finder finder = new Finder();

        long FIVE_MB = 5 * 1024 * 1024;

        // Use case 1: files > 5MB
        List<Path> bigFiles = Finder.find(root, new SizeGreaterStrategy(FIVE_MB), Integer.MAX_VALUE);
        System.out.println("Files > 5MB:");
        for (Path p : bigFiles) {
            System.out.println(p);
        }

        // Use case 2: XML files (use lowercase "xml" since strategy normalizes)
        List<Path> xmlFiles = Finder.find(root, new ExtensionStrategy("xml"), Integer.MAX_VALUE);
        System.out.println("\nXML files:");
        for (Path p : xmlFiles) {
            System.out.println(p);
        }
    }
}
