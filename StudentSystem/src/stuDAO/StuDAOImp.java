package stuDAO;

import connection.DBConnection;
import studentDemo.Student;
import java.sql.*;

public class StuDAOImp implements StuDAO{

    public Connection con = null;
    public PreparedStatement ps = null;
    public StuDAOImp(Connection con){
        this.con = con;
    }

    public void deleteStu()throws SQLException{
        String sql = "delete from student";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        if(this.ps!=null) ps.close();
    }

    public void saveStu(Student student) throws SQLException{
        String sql = "insert into student values(?,?,?,?,?)";
        PreparedStatement ps = this.con.prepareStatement(sql);
        ps.setString(1,student.getsNo());
        ps.setString(2,student.getsName());
        ps.setString(3,student.getclas());
        ps.setString(4,student.getcNo());
        ps.setString(5,student.getcName());
        ps.executeUpdate();
        if(this.ps!=null) ps.close();
    }

    @Override
    public ResultSet findStu(Student student) throws SQLException {
        String sql = "select * from student where ?";
        StringBuffer buf = new StringBuffer();
        PreparedStatement ps = this.con.prepareStatement(sql);
        if(student.getsNo().isEmpty());
        else buf.append(" sNo = "+ student.getsNo());
        if(student.getsName().isEmpty());
        else buf.append(" and sName = "+ student.getsName());
        if(student.getclas().isEmpty());
        else buf.append(" and clas = "+ student.getclas());
        if(student.getcNo().isEmpty());
        else buf.append(" and cNo = "+student.getcNo());
        if(student.getcName().isEmpty());
        else buf.append(" and cName = "+ student.getcName());
        ps.setString(1,buf.toString());
        ResultSet rs = ps.executeQuery();
        return rs;


    }
}
