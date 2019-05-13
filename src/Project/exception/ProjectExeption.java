package Project.exception;

import java.sql.SQLException;

public class ProjectExeption extends Exception {

//    don't knkow what is this line!!
    private static final long	serialVersionUID	= 5240204752227005837L;

    public ProjectExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectExeption(SQLException e) {
        super(e);

    }
    public ProjectExeption(String string){
        // TODO Auto-generated constructor stub
    }
}
