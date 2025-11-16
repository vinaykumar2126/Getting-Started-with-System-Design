package Library;
import java.util.List;
import java.util.ArrayList;
public class Library {
    private List<Books> books;
    int numberOfBooks;
    public Library(int numberOfBooks){
        this.numberOfBooks = numberOfBooks;
        books = new ArrayList<>();
        System.out.println("Library "+this.numberOfBooks+" created");

        for(int i = 0;i<numberOfBooks;i++){
            books.add(new Books("Design Patterns","Erich Gamma"));
        }
        
    }
    public String getName(){
        return books.get(0).toString();
    }
}

