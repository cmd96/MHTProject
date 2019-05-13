import java.awt.*;
import java.lang.*;
    public class User {
        int id=0;
        String first_name=null;
        String last_name=null;
        int password=0;

    public User() {
        int id=0;
        String first_name=null;
        String last_name=null;
        int password=0;
    }
    public  User(int id, String first_name, String last_name,int password){
        this.id= id;
        this.first_name= first_name;
        this.last_name=last_name;
        this.password=password;
        int is_rael=validId(id);
        if (is_rael==1)
            add_User_DATABASE(this);
        else
            System.out.println ("Error with user id ");
    }

    private void add_User_DATABASE(User user) {
    }
    private User get_User_DATABASE(int id)
    {
        User user=new User();//goto database search after the user id and return the details
        return user;
    }


    public int validId(int id){
        int id_len=Integer.toString(id).length();

        if (id_len!= 9)
            return 0;
        else
            return 1;
    }

    public int valid_user_exist(User user){
        //go to data base and search after the user the=n see if all  the detailse are correct
        //function that return the user detailes and his permission
       User u = null; //the user that return
        if ( u.first_name == user.first_name) {
            if (user.last_name == u.last_name) {
                if (user.password == u.password) {
                    System.out.println("exist");
                    return 1;
                }
                System.out.println("Password is nor true");
            }
            System.out.println("Last name not true");
        }
        System.out.println("First name is not valid");
    return 0;
    }
    public void set_id(int id){ this.id=id; }
    public void set_f_name(String fname){this.first_name=fname; }
    public void set_l_name(String lname){ last_name=lname; }
    public void set_pass(int pass){ password=pass; }

    public int get_user_id(){ return this.id; }
    public String get_user_f_name(){ return this.first_name; }
    public String get_user_l_name(){ return last_name; }
    public int get_user_password(){ return password; }

    public void print_user(){
        System.out.println(this.id +" "+ this.first_name +" "+this.last_name+" " +this.password);
}

//    public String append(User user, List list) {
//        while(true){
//            if (list[1].get_==user.id){
//                return "user is allready exist";
//            }
//            else
//            {
//                list.add(user);
//                return "user added";
//            }
//
//        }
//    }
}
