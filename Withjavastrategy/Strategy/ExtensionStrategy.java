package Withjavastrategy.Strategy;

import java.nio.file.Files;
import java.nio.file.Path;

public class ExtensionStrategy implements FileMatchStrategy {
    private final String extLower;

    public ExtensionStrategy(String ext) {        // <-- public
        this.extLower = ext.toLowerCase();        // normalize once
    }

    @Override
    public boolean matches(Path path) {
        if (!Files.isRegularFile(path)) return false;
        String name = path.getFileName().toString().toLowerCase();
        int dot = name.lastIndexOf('.');
        if (dot < 0) return false;
        return name.substring(dot + 1).equals(extLower);
    }
}
