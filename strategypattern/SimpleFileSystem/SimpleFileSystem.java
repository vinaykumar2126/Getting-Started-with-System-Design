package SimpleFileSystem;
import java.util.*;
public class SimpleFileSystem {
    private DiskDrive disk;  // disk variable can access DiskDrive methods
    private Map<String,Integer>fileToBlock;
    private int nextAvailableBlock;

     // THIS IS THE CONSTRUCTOR ↓
    public SimpleFileSystem(DiskDrive disk) {  
        this.disk = disk;
        this.fileToBlock = new HashMap<>();
        this.nextAvailableBlock = 0; // Start with the first block
    }
    
    public void writeFile(String fileName, String content) {
        byte[] data = content.getBytes();
        System.out.println("FileSystem: Writing file " + fileName);
        fileToBlock.put(fileName,nextAvailableBlock); // Map file name to block number
        disk.writeBlock(nextAvailableBlock, data); // Write to disk
        nextAvailableBlock++; // Move to the next block for future writes
    }
    
    public String readFile(String fileName) {
        System.out.println("FileSystem: Reading file " + fileName);
        Integer blockNumber = fileToBlock.get(fileName);
        if(blockNumber == null){
            return "File not found!";
        }
        byte[] data = disk.readBlock(blockNumber);
        return new String(data);
    }

    public void listFiles(){
        System.out.println("\nFiles in the system:");
        if(fileToBlock.isEmpty()){
            System.out.println("No files found.");
            return;
        }
        for(String fileName : fileToBlock.keySet()){
            System.out.println("- " + fileName + " (Block: " + fileToBlock.get(fileName) + ")");
        }
    }
}