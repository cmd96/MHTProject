package Project.db.managers;

import db.handling.MBankException;

import java.sql.Connection;

public interface MileStonManager {
    void update(Connection con, Project.MileSton.MileSton mileston) throws Project.exception.ProjectExeption;

    void delete(Connection con, long clientId) throws MBankException;
}
