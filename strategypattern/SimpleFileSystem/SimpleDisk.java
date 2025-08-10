package strategypattern.SimpleFileSystem;

public class SimpleDisk implements DiskDrive {
    private byte[][] blocks = new byte[100][1024]; // 100 blocks, 1024 bytes each
    
    @Override
    public void writeBlock(int blockNumber, byte[] data) {
        System.out.println("Disk: Writing to block " + blockNumber);
        blocks[blockNumber] = data;
    }
    
    @Override
    public byte[] readBlock(int blockNumber) {
        System.out.println("Disk: Reading from block " + blockNumber);
        return blocks[blockNumber];
    }
    
    @Override
    public int getBlockSize() {
        return 1024;
    }
}