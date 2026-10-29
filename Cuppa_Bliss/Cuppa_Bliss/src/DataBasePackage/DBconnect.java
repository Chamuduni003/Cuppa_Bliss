
package DataBasePackage;

//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class DBconnect{
    
    public static Connection connect(){
        
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project01","root","");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

   
        
    return conn;
    }

   
    
    }

 




   
    
