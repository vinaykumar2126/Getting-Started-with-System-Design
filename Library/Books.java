package Library;

public class Books {
    String bookname;
    String author;
    public Books(String bookname,String author){
        this.bookname = bookname;
        this.author = author;

    }
    @Override
    public String toString() {
        return this.bookname + " by " + this.author;
    }
}
