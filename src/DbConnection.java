
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sai Swapna
 */
public class DbConnection {
    
    Connection conn;
    Statement st;
    ResultSet rs;
    public DbConnection() throws SQLException, ClassNotFoundException  {
        // TODO code application logic here
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:sqlserver://SAISWAPNA-PC\\SQLEXPRESS;databaseName=Test;integratedSecurity=true;","","");
            //Connection con = DriverManager.getConnection("jdbc:odbc:Test_DSN");
            //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Connection conn=DriverManager.getConnection("jdbc:ucanaccess:SAISWAPNA-PC\\\\SQLEXPRESS//");
            //Connection conn = DriverManager.getConnection("jdbc:sqlserver://;SAISWAPNA-PC\\\\SQLEXPRESS;integratedSecurity=true;authenticationScheme=JavaKerberos");
            //Registering the Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //Establishing the connection
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=POAdb;integratedSecurity=true;");
            
            st = conn.createStatement();
            //JOptionPane.showMessageDialog(null,"Connected");
//            ResultSet rs = st.executeQuery("select * from tbl_Users");
//            String i1="",i2="",i3="";
//           while(rs.next()){
//                i1=rs.getString(1);
//                i2=rs.getString(2);
//                i3=rs.getString(3);
//                System.out.println("ID: "+i1+" User Name: "+i2+" Password: "+i3);
            
        }
    }