package strategypattern.SimpleFileSystem;

public class Main {
    public static void main(String[] args) {
        // Dependency injection (Strategy Pattern)
        DiskDrive disk = new SimpleDisk();
        SimpleFileSystem fs = new SimpleFileSystem(disk);
        
        // Test basic operations
        fs.writeFile("hello.txt", "Hello World!");
        String content = fs.readFile("hello.txt");
        System.out.println("Content: " + content);
    }
}