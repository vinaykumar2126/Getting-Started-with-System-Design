package Withjavastrategy;

import Withjavastrategy.Strategy.FileMatchStrategy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Finder {
    public static List<Path> find(Path root, FileMatchStrategy strategy, int maxDepth) {
        List<Path> result = new ArrayList<>();
        try (Stream<Path> stream = Files.walk(root, maxDepth)) {
            // simple for-each over the stream
            for (Path p : (Iterable<Path>) stream::iterator) {
                if (strategy.matches(p)) {
                    result.add(p);
                }
            }
        } catch (Exception e) {
            // optional: log e
        }
        return result;
    }
}

