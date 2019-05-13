package Project.db.managers;

import java.sql.Connection;
import  Project.exception.ProjectExeption;
import Project.MileSton.MileSton;

public interface MileStonManager {

    void insert (Connection con, MileSton mileston) throws ProjectExeption;
    void Update_MileSton (Connection con, MileSton mileston) throws ProjectExeption;
    void Copy_MileSton (Connection con, int mileston_num) throws ProjectExeption;
    void delete (Connection con, int mile_num) throws ProjectExeption;
//    Client query (Connection con, long id) throws ProjectExeption;
//    Client[] queryAllClients(Connection con);

}
