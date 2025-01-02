package student_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class connectionToDatabase {
	
	// TODO Auto-generated method stub
    String jdbcURL = "jdbc:oracle:thin:@localhost:1521/orclpdb"; // Replace with your database URL
    String username = "miniProjet"; 
    String password = "2005";

    
 // define the connection 
    Connection connection = null;
    PreparedStatement statement = null;
	
	// to connect with orclpdb database
	public  void conectToOracl() throws ClassNotFoundException {
		
        
       
        
     // SQL Query
        String query = "SELECT idF, nomF FROM filieres";
        
        try {
        	// to load the JDBC 
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	System.out.println("the connection success...");
        	
        	// the connection to the database 
        	connection = DriverManager.getConnection(jdbcURL, username, password);
        	
        	System.out.println("the connection has establiched successfully ...");
        	
        	
        	// prepare  the query
        	PreparedStatement statement = connection.prepareStatement(query);
        	
        	// Execute Query
            ResultSet resultSet = statement.executeQuery();
            
            System.out.println("the data loaded successfully");
            
            
            // print the result
            while (resultSet.next()) {
                int id = resultSet.getInt("idF"); // Fetch 'id' column
                String name = resultSet.getString("nomf"); // Fetch 'name' column

                // Print or use the data
                System.out.println("ID: " + id + ", Name: " + name );
            }    
        }catch(ClassNotFoundException | SQLException e) {
        	System.out.println("error  not connceted   : "+e);
        }        
}

	

	// get the nbr of students that were  absence in such field
	
	
	// get teachers of a student spesific  not conpleted 
 	public String[][] getAbsence() throws SQLException {
 		ResultSet res2;
		// Establish the connection
        connection = DriverManager.getConnection(jdbcURL, username, password);
		
        // Query to get the teachers
        String query = "SELECT    nomF , count(E.idf) as nbr from absence a join etudiant e on a.cne = e.cne join filieres f on e.idf = f.idf group by  nomF ";
        
        statement = connection.prepareStatement(query);
        
        res2 = statement.executeQuery();
        
	    // Create a list to hold the student data 
	    List<String[]> studentsList = new ArrayList<>();

	    // select each row and and it to the studentsList 
	    while (res2.next()) {
	        studentsList.add(new String[] {
	            res2.getString("nomF"),
	            res2.getString("nbr")
	        });
	    }
        
	    // If No students found, print an error and return null
	    if (studentsList.isEmpty()) {
	        System.out.println("Error: No students found.");
	        return null;
	    }
	    // System.out.println("waaaaaaa errrrrroooooooooooooor");
	    // Convert the list of students to a 2D array and return it
	    return studentsList.toArray(new String[0][0]);
	}
	
	
    
    // function for search
	public String[] searchForStudent(String cne) throws SQLException {
	

	    ResultSet res = null;
	    System.out.println("the begin from the  searchForStudent ");
	    try {
	        // Establish the connection
	        connection = DriverManager.getConnection(jdbcURL, username, password);

	        // Query to search for the student using CNE
	        String query = "SELECT E.CNE, E.nom , E.prenom ,E.email ,F.NOMF FROM etudiant E JOIN filieres F ON E.IDF = F.IDF WHERE cne ='"+cne+"'";
	        
	        statement = connection.prepareStatement(query);
	       
	        // Execute the query
	        res = statement.executeQuery();
	        
	        System.out.println("after executing ...");

	        // Check if a record is found
	        if (res.next()) {
	            // Return the student details as a String array
	            return new String[] {
	                res.getString("CNE"),
	                res.getString("nom"),
	                res.getString("prenom"),
	                res.getString("email"),
	                res.getString("NOMF"),
	            };
	        } else {
	            // If no student is found, return null
	            System.out.println("No student found with CNE: " + cne);
	            return null;
	        }
	    } catch (SQLException e) {
	        throw e; // Rethrow exception to handle it further up if needed
	    } 
	}
		
	
	// get the students 
	public String[][] getStudents() throws SQLException {
	    ResultSet res1 = null;
	    // Establish the connection
	    connection = DriverManager.getConnection(jdbcURL, username, password);

	    // Query to retrieve all student records
	    String query = "SELECT * FROM etudiant join filieres on filieres.idF = etudiant.idF";
	    statement = connection.prepareStatement(query);

	    // Execute the query
	    res1 = statement.executeQuery();

	    // Create a list to hold the student data 
	    List<String[]> studentsList = new ArrayList<>();

	    // select each row and and it to the studentsList 
	    while (res1.next()) {
	        studentsList.add(new String[] {
	            res1.getString("CNE"),
	            res1.getString("nom"),
	            res1.getString("prenom"),
	            res1.getString("email"),
	            res1.getString("nomF")
	        });
	    }
	    // If No students found, print an error and return null
	    if (studentsList.isEmpty()) {
	        System.out.println("Error: No students found.");
	        return null;
	    }

	    // Convert the list of students to a 2D array and return it
	    return studentsList.toArray(new String[0][0]);
	}
	
	
	// get the teachers 
	public String[][] getteachers() throws SQLException {
	    ResultSet res1 = null;
	    // Establish the connection
	    connection = DriverManager.getConnection(jdbcURL, username, password);

	    // Query to retrieve all student records
	    String query = "SELECT * FROM enseignant";
	    statement = connection.prepareStatement(query);

	    // Execute the query
	    res1 = statement.executeQuery();

	    // Create a list to hold the student data 
	    List<String[]> teachersList = new ArrayList<String[]>();
	    

	    // select each row and and it to the studentsList 
	    while (res1.next()) {
	        teachersList.add(new String[] {
	            res1.getString("idE"),
	            res1.getString("nomE"),
	            res1.getString("prenomE"),
	            res1.getString("email")
	        });
	    }
	    if (teachersList == null) {
	    	System.out.println("the table of students is null HHAHAHAHHAHAHAH");
	    }
	    
	    System.out.println("in the function of loading data ... ");

	    // Convert the list of students to a 2D array and return it
	    return teachersList.toArray(new String[0][0]);
	}


	// get the filieds 
	public String[][] getfilieds() throws SQLException {
	    ResultSet res1 = null;
	    // Establish the connection
	    connection = DriverManager.getConnection(jdbcURL, username, password);

	    // Query to retrieve all student records
	    String query = "SELECT F.IDF , F.NOMF , COUNT(F.IDF) as nbrStudent  FROM FILIERES F JOIN ETUDIANT E ON F.IDF = E.IDF GROUP BY F.IDF , F.NOMF "
	    		+ "";
	    statement = connection.prepareStatement(query);

	    // Execute the query
	    res1 = statement.executeQuery();

	    // Create a list to hold the student data 
	    List<String[]> filiedsList = new ArrayList<String[]>();
	    

	    // select each row and and it to the studentsList 
	    while (res1.next()) {
	        filiedsList.add(new String[] {
	            res1.getString("idF"),
	            res1.getString("nomF"),
	            res1.getString("nbrStudent")
	        });
	    }
	    
	    if (filiedsList == null) {
	    	System.out.println("the table of filieds  is null HHAHAHAHHAHAHAH");
	    }
	    
	    System.out.println("in the function of loading data ... ");

	    // Convert the list of students to a 2D array and return it
	    return filiedsList.toArray(new String[0][0]);
	}
	
	
	// get the modules 
	public String[][] getmodules() throws SQLException {
	    ResultSet res1 = null;
	    // Establish the connection
	    connection = DriverManager.getConnection(jdbcURL, username, password);

	    // Query to retrieve all student records
	    String query = "SELECT * FROM MODULES";
	    statement = connection.prepareStatement(query);

	    // Execute the query
	    res1 = statement.executeQuery();

	    // Create a list to hold the student data 
	    List<String[]> modulesList = new ArrayList<String[]>();
	    

	    // select each row and and it to the studentsList 
	    while (res1.next()) {
	        modulesList.add(new String[] {
	            res1.getString("idM"),
	            res1.getString("nom"),
	            res1.getString("idE")
	        });
	    }
	    
	    if (modulesList == null) {
	    	System.out.println("the table of filieds is null HHAHA   HAHHA HAHAH");
	    }
	    
	    System.out.println("in the function of loading data...");

	    // Convert the list of students to a 2D array and return it
	    return modulesList.toArray(new String[0][0]);
	}
	

	// change the students depend to the field 
	public String[][] changeStudents(String filied) throws SQLException {
		
		
	    ResultSet res1 = null;
	    // Establish the connection
	    connection = DriverManager.getConnection(jdbcURL, username, password);
	    

	    // Query to retrieve all student records
	    String query = "SELECT CNE , NOM , PRENOM , EMAIL , NOMF  FROM etudiant e join filieres f on e.idF = f.idF where nomF = '"+filied+"'";
	    
	    statement = connection.prepareStatement(query);
	    

	    // Execute the query
	    res1 = statement.executeQuery();
	    System.out.println("when changing the xsstudents ");

	    // Create a list to hold the student data 
	    List<String[]> NewStudentList = new ArrayList<String[]>();
	    
	    
	    // select each row and and it to the studentsList 
	    while (res1.next()) {
	    	NewStudentList.add(new String[] {
		            res1.getString("CNE"),
		            res1.getString("nom"),
		            res1.getString("prenom"),
		            res1.getString("email"),
		            res1.getString("NOMF")
	        });
	    }
	    
	    if (NewStudentList == null) {
	    	System.out.println("the table of filieds is null HHAHA   HAHHA HAHAH");
	    }
	    
	    System.out.println("in the function of loading data...");

	    // Convert the list of students to a 2D array and return it
	    return NewStudentList.toArray(new String[0][0]);
		
	}
	
}
