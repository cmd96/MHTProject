import java.awt.*;

public class Main {

    public static void main(String[] args) {
        List list=new List();
        System.out.println("Hello, World!");
        User use=new User();
        User use2=new User(2,"zvia","Edrey",9);
        User use3=new User();
        use.set_id(11);
        use.set_f_name("Shira");
        use.set_l_name("David");
        use.set_pass(00);
//        list.add(String.valueOf(use));
//        list.add(String.valueOf(use2));
        use.print_user();
        use2.print_user();
        use3.print_user();

        Project p=new Project();
        p.print_pro();
        p.set_pro_id(1);
        p.set_pro_name("Shira");
        //Date date=new Date("1/1/2001");
        //p.set_pro_create_date(date);
        p.set_pro_manag_id(11);
        p.get_project_DATABASE(p.id);
//        p.print();

    }


}
