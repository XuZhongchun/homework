package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
*
* @author ASUS
*/
public class DBConnection {
   
   
      public boolean flag = true;
   
       private static final String DBdriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=BookDB"; 
	private static String DBUSER = "sa";
	private static String DBPASS = "123456";
	private Connection con=null; 
       
       public void setDBUSER(String DBUSER){
           this.DBUSER = DBUSER;
       }
       public void setDBPASS(String DBPASS){
           this.DBPASS = DBPASS;
       }
       
	public DBConnection(String a, String b){
              DBUSER = a;
              DBPASS = b;
           
		try {
			Class.forName(DBdriver);
			this.con=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		} catch (ClassNotFoundException e) {
	
			
		} catch (SQLException e) {

			this.flag = false;
	
			
                       //
                       //
                       //�˴������������ʧ��ʱ�ķ��� ������ʾ��¼ʧ��
                       //
                       //
		}
	}

/*
       public DBConnection(){
             
           
		try {
			Class.forName(DBdriver);
			this.con=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (Exception ex){
                   loginFalse.main3(args1);
               }
	}
*/
//���������εĹ��췽��
       
       
	public Connection getCon(){
		return this.con;
	}
	public void closeCon(){
		if(this.con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

       
}

