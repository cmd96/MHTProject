package exception;

import java.sql.SQLException;

public class ProjectExeption extends Throwable {
    public ProjectExeption(String s, SQLException e) {
    }

    public ProjectExeption(String s) {
    }
}
