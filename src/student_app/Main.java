
package student_app;

import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, UnknownHostException {
	
		// connect to database of ESTE Oracl
		
		// instance from the connectionToDatabase class 
		connectionToDatabase con = new connectionToDatabase();
		
		// connect to oracl orclpdb 
		con.conectToOracl();
		System.out.println("successfully yeeeeeeeeeeeees");
		
		// the graphique app 
		
		//MyFrame frame = new MyFrame();
		//frame.getFrame1();
		var LG = new Login();
		LG.firstFrame();
		
		
		
	}

}
