package Design_LinkedList;

public class MyInt implements ComparableValue<MyInt> {
    int value;
    
    public MyInt(int value) { 
        this.value = value; 
    }
    @Override
    public boolean isLessThan(MyInt other) {
        return this.value < other.value;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof MyInt) {
            return this.value == ((MyInt)o).value;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}