package strategypattern.SimpleFileSystem;

public interface DiskDrive {
    void writeBlock(int blockNumber, byte[] data);
    byte[] readBlock(int blockNumber);
    int getBlockSize();
}