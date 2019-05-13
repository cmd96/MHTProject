package db.handling;

import java.sql.SQLException;

public class MBankException extends Exception {
    public MBankException(String s, SQLException e) {
    }
}
