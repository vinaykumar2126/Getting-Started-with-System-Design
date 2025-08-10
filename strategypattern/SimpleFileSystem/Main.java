package strategypattern.SimpleFileSystem;

public class Main {
    public static void main(String[] args) {
        // Dependency injection (Strategy Pattern)
        DiskDrive disk = new SimpleDisk();   // Use SimpleDisk Strategy,  Polymorphism: Same interface, different behaviors
        //DiskDrive disk = new SSDDisk(); // Could also use SSDDisk or NetworkDisk if they were implemented
        SimpleFileSystem fs = new SimpleFileSystem(disk);//Disk is passed to SimpleFileSystem constructor
        //                        ↑                   ↑
//                   Constructor call     Parameter passed
        
        // Write multiple files
        fs.writeFile("hello.txt", "Hello World!");
        fs.writeFile("hi.txt","hi");
        fs.writeFile("bye.txt","bye");

        // Read a file
        System.out.println("\nReading files:");
        System.out.println("hello.txt: " + fs.readFile("hello.txt"));
        System.out.println("hi.txt: " + fs.readFile("hi.txt"));
        System.out.println("bye.txt: " + fs.readFile("bye.txt"));


        System.out.println("missing.txt: "+ fs.readFile("missing.txt"));
        // fs.listFiles()
    }
}