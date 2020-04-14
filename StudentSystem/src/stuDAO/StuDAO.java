package stuDAO;

import java.sql.*;
import studentDemo.Student;

public interface StuDAO {

    public void deleteStu() throws SQLException;

    public void saveStu(Student student) throws SQLException;

    public ResultSet findStu(Student student) throws SQLException;
}
