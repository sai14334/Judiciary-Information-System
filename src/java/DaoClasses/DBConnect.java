/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author rguktrkvalley
 */
public class DBConnect 
{
    String url="jdbc:mysql://localhost:3306/Judiciary";
    String username="GowriSankar";
    String password="Bablu@2005";
    public Connection checkConnection()
    {   
        Connection conn =null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
