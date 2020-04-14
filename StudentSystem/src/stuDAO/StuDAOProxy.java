package stuDAO;

import connection.DBConnection;
import studentDemo.Student;
import java.sql.*;

public class StuDAOProxy implements StuDAO{
    private DBConnection dbc = null;
    private StuDAO dao = null;
    public StuDAOProxy(String args[]){
        try{
            this.dbc = new DBConnection(args[0],args[1]);
        }catch(Exception e){
            System.out.println("DAOPROxy层出错");
        }
        this.dao = new StuDAOImp(dbc.getCon());
        //采用args[]数组传递账密 args[0]为帐号 args[1]为密码
    }

    public void deleteStu() throws SQLException{
        dao.deleteStu();;
        dbc.closeCon();
    }

    public void saveStu(Student student) throws SQLException{
        dao.saveStu(student);
        dbc.closeCon();
    }

    public  ResultSet findStu(Student student) throws SQLException{
        ResultSet rs = null;
        rs = dao.findStu(student);
        return rs;
    }
}
