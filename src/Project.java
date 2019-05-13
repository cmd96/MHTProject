import java.util.Date;
import java.util.List;

public class Project {
    public int id_project=0;
        int id=0;
        String pro_name=null;
        Date create_pro=null;
        int id_managment=0;
    //  Book book=null;
        List<Book> book=null;
        public Project (){
            int id=0;
            String pro_name=null;
            Date create_pro=null;
            int id_managment=0;
        }
//    public Project(Project p){
//        Project(p.id,p.pro_name,p.c_d,p.id_managm,p.book);
//    }

    public Project(String p_name, Date c_p, int id_managm,Book book){
        this.id=get_new_id();
        this.pro_name=p_name;
        this.create_pro=c_p;
        this.id=id_managm;
        this.book.add(book);
        add_proj_DATABASE(this);
    }

    private void add_proj_DATABASE(Project project) {
        //go to dattabase and add the project
    }
   public void Found_project_from_DATABASE(int id){
       //goto database and search afer this project
       print_pro();
//        return project;
   }
    private int get_new_id(){
        id_project++;
        return id_project;
    }
    public void get_project_DATABASE(int id){
        Found_project_from_DATABASE(id);
    }

    //get
    public int get_proj_id(){return this.id;}
    public String get_proj_name(){return this.pro_name;}
    public Date get_proj_create(){return this.create_pro;}
    public int get_proj_managment_id(){return this.id_managment;}


    //set
    public void set_pro_id(int id){this.id=id;}
    public void set_pro_name(String p_n){this.pro_name=p_n;}
    public void set_pro_create_date(Date date){this.create_pro=date;}
    public void set_pro_manag_id(int id){this.id_managment=id;}

    //print all project
    public void print_pro()
    {
        System.out.println(this.id+" "+ this.pro_name+" "+ this.create_pro+" " +this.id_managment);
    }
    //print varieble
    public void print_pro_id()
    {
        System.out.println(this.id);
    }
    public void print_pro_name()
    {
        System.out.println(this.pro_name);
    }
    public void print_pro_create()
    {
        System.out.println(this.create_pro);
    }
    public void print_pro_id_managment()
    {
        System.out.println(this.id_managment);
    }
}

