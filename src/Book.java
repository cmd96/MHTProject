import java.util.List;

public class Book {
    int id=0;
    String book_Link=null;
    String status=null;
    List<Integer> book_list;
    int draf_num=0;
    public  Book(int id, String book_Link, String status,int draf_num){
        this.id= id;
        this.book_Link= book_Link;
        this.status=status;
        this.draf_num=draf_num;
        add_Book_to_DATABASE(this);
    }
    public void Add_project_to_book(int id_project){
        this.book_list.add(id_project);
    }
    public void add_Book_to_DATABASE(Book book){
        //goto database and add the book
    }
}
