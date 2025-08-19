package Withjavastrategy.Strategy;
import java.io.IOException;
import java.nio.file.*;

public class SizeGreaterStrategy implements FileMatchStrategy {
    private final long minBytes;
    public SizeGreaterStrategy(long minBytes){
        this.minBytes = minBytes;
    }
    @Override
    public boolean matches(Path path) throws IOException{
        return Files.isRegularFile(path) && Files.size(path)>minBytes;

    }
    
}
