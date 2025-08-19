package Withjavastrategy.Strategy;
import java.io.IOException;
import java.nio.file.*;


public interface FileMatchStrategy {
    public boolean matches(Path path) throws IOException;

}
