package Score.pkg;
import java.sql.*;

import javax.swing.JOptionPane;

public class SQLSignUp {

	public static void main(String[] args) {
		
		Statement stmt = null;
	    ResultSet rs = null;
	    
	}
	    
		   private static Connection cin =null;
		   
		  
		    
		    public static Connection COnnecrDB(){
		        
		        if (cin != null) return cin;
		        
		        try{
		   
		          cin = DriverManager.getConnection( "jdbc:sqlite:/Users/naran128386/Desktop/Info.sqlite" );      
		          									
		          return cin;
		          
		        }
		    catch(Exception e){
		        JOptionPane.showMessageDialog(null, e);
		        return null;
		    }
		  
		    
	

	}

}





	

    



