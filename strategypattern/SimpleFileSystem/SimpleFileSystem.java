package strategypattern.SimpleFileSystem;

public class SimpleFileSystem {
    private DiskDrive disk;
    
    public SimpleFileSystem(DiskDrive disk) {
        this.disk = disk;
    }
    
    public void writeFile(String fileName, String content) {
        byte[] data = content.getBytes();
        System.out.println("FileSystem: Writing file " + fileName);
        disk.writeBlock(1, data); // Simple: use block 0
    }
    
    public String readFile(String fileName) {
        System.out.println("FileSystem: Reading file " + fileName);
        byte[] data = disk.readBlock(0);
        return new String(data);
    }
}