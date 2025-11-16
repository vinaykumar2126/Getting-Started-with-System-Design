package Library;

public class Books implements BookInterface {
    String bookname;
    String author;
    public Books(String bookname,String author){
        this.bookname = bookname;
        this.author = author;

    }
    @Override
    public String getName(){
        return this.bookname;
    }
    @Override
    public String getAuthor(){
        return this.author;
    }
    @Override
    public String toString() {
        return this.bookname + " by " + this.author;
    }
}
