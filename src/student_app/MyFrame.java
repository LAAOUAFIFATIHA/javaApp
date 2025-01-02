package student_app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class MyFrame extends JFrame implements ActionListener {
	


	// Declare JTextField for input to remember
    private JLabel label1 , label2 , label3;  
    private JTextField textField1 , textField2 , textField3;
    private JButton button  , button_absence_chart, button1  , button_absence, button_charts , reset_button , button_change_filied ,button_student , button_teachers , button_fields , button_modules;
    JComboBox<String> comboBox ;
    public static volatile boolean flag = true;  

    
    String[] options = {"IDSD", "GI", "ER" , "GE" , "TM" , "MT"};
    
    private String lastSelectedField = options[0]; // Default to the first option


	// the default background
	public void getFrame1() {
		
		
		
		// the default screen 
		JLabel label = new JLabel(" ESTE MANAGE ");
		label.setBounds(280 , -20 , 200 , 30  );
		label.setSize(400 , 200);
		
				
		this.setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,600);
        
        
        //  the input 1
		JLabel label1 = new JLabel(" CNE  : ");
		label1.setBounds(50 , 100,  200 , 30  );
        textField1 = new JTextField();
        textField1.setBounds(200, 100, 200, 30); // size: (x, y, width, height)
        

        // the buttons 
        button1 = new JButton("search");
        button1.setBounds( 200 ,150 , 80, 20);
        button1.setFocusable(false);
        button1.addActionListener(this);
        
        
        // Check if TAB is not null 
        if (TAB != null) {
	            System.out.println("Yes, there is a student! Hahaha!");
	            
                //Thread.sleep(2000); // Simulate work
                flag = false ;
	            // Create a JPanel to group components
	            JPanel infoPanel = new JPanel();
	            infoPanel.setBounds(50, 50, 400, 200);
	            infoPanel.setLayout(null);
	            
	            
	            Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // Black border, 2px thick
	            
	
	            // Add the label to the frame
	            this.add(label);
	
	            JLabel nomETD = new JLabel("Nom:  "+TAB[1]);
	            nomETD.setBounds(40, 320, 200, 30); 
	            
	            
	            JLabel  prenom  = new   JLabel("Prenom :  "+TAB[2]);
	            prenom.setBounds(40, 340, 200, 30);
	            
	            
	            JLabel  CNE = new   JLabel(" CNE :   "+TAB[0]);
	            CNE.setBounds(40, 360, 200, 30);
	            
	            JLabel  EMAIL = new   JLabel("EMAIL :   "+TAB[3]);
	            EMAIL.setBounds(40, 380, 200, 30);
	            
	            
	            JLabel  FILIERE = new   JLabel(" FILIERE :   "+TAB[4]);
	            FILIERE.setBounds(40, 400, 200, 30);
	            
	            reset_button = new JButton("reset");
	            reset_button.setBounds(100 ,150 , 80, 20);
	            reset_button.setFocusable(false);
	            reset_button.addActionListener(this);
	            
	            
	            
	            // TO ADD A SINGLE BORDER 
	            // FILIERE.setBorder(border);
	            
	            /// ADD THE TITLE OF THE BORDER 
	            Border titledBorder = BorderFactory.createTitledBorder(
	                    BorderFactory.createLineBorder(Color.BLACK, 2), // Outer border
	                    "Student Information" // Title text
	                );
	            
	            infoPanel.setBorder(titledBorder);
	            // ADD BODER 
	            // Add components to the panel
	            infoPanel.add(nomETD);
	            infoPanel.add(prenom);
	            infoPanel.add(CNE);
	            infoPanel.add(EMAIL);
	            infoPanel.add(FILIERE);
	           
	            
	            infoPanel.setBounds(20, 300, 300, 200);
	            /// ADD THE INFORMATION TO THE  SCREEN 
	            this.add(nomETD);
	            this.add(prenom);
	            this.add(CNE);
	            this.add(EMAIL);
	            this.add(FILIERE);
	            this.add(reset_button);
	
	            // Refresh the frame to show the added component
	            this.revalidate();
	            this.repaint();
	            
	            // TO ADD THE BORDER 
	            this.add(infoPanel);
	            System.out.println("the state of the flag in the condition statement ..."+flag);

        }

        System.out.println("the state of the flag is  before "+flag);
        
        // the students screen 
 		button_student = new JButton("student");
 		button_student.setBounds( 600 ,100 , 200, 30);
 		button_student.setFocusable(false);
 		button_student.addActionListener(this);
         
         
 		// the teachers screen 
 		button_teachers = new JButton("teachers");
 		button_teachers.setBounds(600 , 150, 200, 30);
 		button_teachers.setFocusable(false);
 		button_teachers.addActionListener(this);
         
         
 		// the fields screen 
 		button_fields = new JButton("fields");
 		button_fields.setBounds( 600 ,200 , 200, 30);
 		button_fields.setFocusable(false);
 		button_fields.addActionListener(this);
         
         
 		// the modules screen 
 		button_modules = new JButton("modules");
 		button_modules.setBounds( 600 ,250 , 200, 30);
 		button_modules.setFocusable(false);
 		button_modules.addActionListener(this);
 		
 		// absente 
 		button_absence = new JButton("absence");
 		button_absence.setBounds( 600 ,300 , 200, 30);
 		button_absence.setFocusable(false);
 		button_absence.addActionListener(this);
 		
 		
 		
 		
 		
 		// add image 

        // Load an image
        //ImageIcon imageIcon = new ImageIcon("/docker_app/image/images.jpeg");
        //JLabel imageLabel = new JLabel(imageIcon);
  
        
           
        
        // add the inputs to the frame
        this.add(label);
        this.add(label1);
        this.add(textField1); 
        this.add(button1);
        

        
        if( flag) {
        
		        System.out.println("Flag changed to true. Updating UI...");
		        this.add(button_student);
		        this.add(button_teachers);
		        this.add(button_fields);
		        this.add(button_modules);
		        this.add(button_absence);
		        this.revalidate(); // Refresh the UI
		        this.repaint();
        }
        //this.add(imageLabel);
        
 
        // to make the layout visible 
        this.setVisible(true);
	}
	
	
	
	
	
	// the students frame
	public void getFrameStudents() {
		
		// the default screen 
		JLabel label = new JLabel(" ESTE students ");
		label.setBounds(380 , -30 , 200 , 30  );
		label.setSize(400 , 200);
		
		
		this.setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,600);
        


        String[] columns = {"CNE", "nom", "prenom" , "email" , "idF"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        
       // Adding rows dynamically
        for (int i = 0; i < students.length; i++) {
            if (students[i].length == columns.length) { // Check array size matches column count
                model.addRow(students[i]);
            } else {
                System.err.println("Row " + i + " has inconsistent data.");
            }
        }
        
        // Create the table and add it to a JScrollPane
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 800, 400);
        
        // button to retourn in the home page 
        button = new JButton("home");
        button.setBounds( 400 , 0 , 90 , 30 );
        button.setFocusable(false);
        button.addActionListener(this);
        
        
        

        
        
        
        
     // Create a JLabel
        JLabel label1 = new JLabel("Choose an option:");
        label1.setBounds(20, 20, 120, 30);
        this.add(label);

        // Create a JComboBox (Dropdown)
        comboBox = new JComboBox<>(options);
        comboBox.setBounds(100, 500, 120, 30);
        comboBox.setSelectedItem(lastSelectedField);
        

        // Create a JButton
        button_change_filied = new JButton("Submit");
        button_change_filied.setBounds(250, 500, 120, 30);
        button_change_filied.setFocusable(false);
        button_change_filied.addActionListener(this);
         
        
        
        this.add(label);
        this.add(scrollPane);
        this.add(button);
        this.add(button_change_filied);
        this.add(comboBox);
        
        // to make the layout visible 
        this.setVisible(true);
		
	}
	
	
	// the teachers frame 
	public void getFrameteachers() {
		
		// the default screen 
		JLabel label = new JLabel(" ESTE teachers ");
		label.setBounds(380 , -30 , 200 , 30  );
		label.setSize(400 , 200);
		
		
		
		this.setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,600);
        
        
        String[] columns = {"CNE", "nom", "prenom" , "email" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        
       // Adding rows dynamically
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].length == columns.length) { // Check array size matches column count
                model.addRow(teachers[i]);
            } else {
                System.err.println("Row " + i + " has inconsistent data.");
            }
        }
        
        // Create the table and add it to a JScrollPane
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 800, 400);
        
        button = new JButton("home");
        button.setBounds( 400 , 0 , 90 , 30 );
        button.setFocusable(false);
        button.addActionListener(this);
        
        
        
        this.add(label);
        this.add(scrollPane);
        this.add(button);
        
        // to make the layout visible 
        this.setVisible(true);
		
	}
	
	
	
	
	// the fields frame
	public void getFramefields() {
		
		// the default screen 
		JLabel label = new JLabel(" ESTE fields ");
		label.setBounds(380 , -30 , 200 , 30   );
		label.setSize(400 , 200);
		
		
		
		this.setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,600);
        
         
        String[] columns = {"idF", "nomF" , "nbrStudent"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        
       // Adding rows dynamically
        for (int i = 0; i < filieds.length; i++) {
            if (filieds[i].length == columns.length) { // Check array size matches column count
                model.addRow(filieds[i]);
            } else {
                System.err.println("Row " + i + " has inconsistent data.");
            }
        }
        
        // Create the table and add it to a JScrollPane
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 800, 400);
        
        button = new JButton("home");
        button.setBounds( 400 , 0 , 90 , 30 );
        button.setFocusable(false);
        button.addActionListener(this);
        
        
        button_charts = new JButton("charts");
        button_charts.setBounds( 100 , 	0 , 90 , 30 );
        button_charts.setFocusable(false);
        button_charts.addActionListener(this);
  
        this.add(label);
        this.add(scrollPane);
        this.add(button) ;
        this.add(button_charts);
         
        
        // to make the layout visible 
        this.setVisible(true);
		
	}
	
	
	
	
	// the modules 
	public void getFramemodules() {
		
		// the default screen 
		JLabel label = new JLabel(" ESTE modules  ");
		label.setBounds(380 , -30 , 200 , 30  );
		label.setSize(400 , 200);
		
		
		
		this.setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,600);
        
        String[] columns = {"idM", "nom" , "idE"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        
        
        
       // Adding rows dynamically
        for (int i = 0; i < modules.length; i++) {
            if (modules[i].length == columns.length) { // Check array size matches column count
                model.addRow(modules[i]);
            } else {
                System.err.println("Row " + i + " has inconsistent data.");
            }
        }
        
        // Create the table and add it to a JScrollPane
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 800, 400);
        
        
        
        button = new JButton("home");
        button.setBounds( 400 , 0 , 90 , 30 );
        button.setFocusable(false);
        button.addActionListener(this);
        
  
        this.add(label);
        this.add(scrollPane);
        this.add(button) ;
        
        
        
        
        
        
        // to make the layout visible 
        this.setVisible(true);
		
	}
	
	// THE ABSCENCE 
	public void FrameAbsence() {
		
		// the default screen 
		JLabel label = new JLabel(" Absence  ");
		label.setBounds(380 , -30 , 200 , 30  );
		label.setSize(400 , 200);
		
		
		
		this.setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,600);
        
        String[] columns = {"nomF", "nbr" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        
       // Adding rows dynamically
        for (int i = 0; i < absence.length; i++) {
            if (absence[i].length == columns.length) { // Check array size matches column count
                model.addRow(absence[i]);
            } else {
                System.err.println("Row " + i + " has inconsistent data.");
            }
        }
        
        
        
        // Create the table and add it to a JScrollPane
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 800, 400);
        
        button = new JButton("home");
        button.setBounds( 400 , 0 , 90 , 30 );
        button.setFocusable(false);
        button.addActionListener(this);
        
        button_absence_chart = new JButton("Chart");
        button_absence_chart.setBounds( 100 , 0 , 90 , 30 );
        button_absence_chart.setFocusable(false);
        button_absence_chart.addActionListener(this);
        
        
  
        this.add(label);
        this.add(scrollPane);
        this.add(button) ;
        this.add(button_absence_chart);
        
        
        
        
        // to make the layout visible 
        this.setVisible(true);
		
	}

	
	
	
	String[] TAB;
	String[][] students ;
	String[][] teachers ;
	String[][] filieds ;
	String[][] modules ;
	String[][] absence ;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// instance from 
		connectionToDatabase conn = new  connectionToDatabase();
		
		if(e.getSource() == button_absence_chart) {
			charts ch = new charts();
			ch.getAbsenceChart(absence);
			
		}
		
		if(e.getSource() == button_absence) {
		
			try {
				
				absence = conn.getAbsence();

				switchToFrame("absence");
				
			}catch(Exception e1) {
				System.out.println("ERROR IN THE SWITCH TO THE absence");
			}
			
		}
		
		if(e.getSource() == button_charts) {
			charts ch = new charts();
			ch.getChat(filieds);
		}
		
		
		
		if(e.getSource() == reset_button) {
			TAB =null ;
			flag = true;
			System.out.println("the reset button was clicked ");
			try {
				switchToFrame("home");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == button1) {
			
            // Print the entered text to the console
            //int cne = Integer.parseInt(textField1.getText());
			String cne = textField1.getText();
            
            
            try {
            	TAB = null;
            
            	
            
            	
				TAB = conn.searchForStudent(cne);
				System.out.println("hahahahha");
				switchToFrame("home");
				
				for (int i = 0; i < TAB.length; i++) {
					
				    System.out.println(TAB[i]); // Print each element
				}
			} catch (SQLException e1) {
				System.out.println("waaaaaaaaaaaaaaaaaa " +e1);
			} 
		}
		
		
		
		// about the select 
		
		// change the field 
		if(e.getSource() == button_change_filied) {
			String selectedOption = (String) comboBox.getSelectedItem();
		    lastSelectedField = selectedOption;

			try {
				
				System.out.println("the change is clicked ... ");
				students = conn.changeStudents(selectedOption);
				System.out.println("EVERY THING WORKS GOOD ... ");
			}catch(Exception e1) {
				System.out.println("error : in loading new students "+e1);
			}
			try {
				switchToFrame("students");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
}
		
		// if the filieds button is clicked 
		if(e.getSource() ==  button_fields ) {
			try {
				System.out.println("the filelds button is clicked .. ");
				filieds = conn.getfilieds(); 

				
			}catch(Exception e1) {
				System.out.println("the error : in filieds loading "+e1);
			}
			try {
				switchToFrame("fields");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
			
		// if the MODULES  button is clicked 
		if(e.getSource() ==  button_modules ) {
			try {
				System.out.println("the modules button is clicked .. ");
				modules = conn.getmodules();
				System.out.println("?????");
				if(modules.length == 0) {
				System.out.println(" the Lenght equal to 0 ");
				}

				
			}catch(Exception e1) {
				System.out.println("the error : in modules loading "+e1);
			}
			try {
				switchToFrame("modules");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		
		
		// if the teachers button it clicked 
		if (e.getSource() == button_teachers) {
			try {
				System.out.println("the teachers button is clicked .. ");
				teachers = conn.getteachers();
				
			    // If No students found, print an error and return null
			    if (teachers.length < 1) {
			        System.out.println("Error: No teachers found.");
			    }
				
			}catch(Exception e1 ) {
				System.out.println("an error : IN loading teachers data ... ");
			}	
			try {
				switchToFrame("teachers");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		// if the students button selected 
		if (e.getSource() == button_student) {
			System.out.println("button_student is clicked...HAHAHA");
			
			try {
				students =  conn.getStudents();
				System.out.println("WWWWAAAAAAAAAAAAAAAAAAAAAAAAAAA");
				
				for (int i = 0; i < students.length; i++) {
				    System.out.println(students[i][2]); // Print each element
				}
				
				
			} catch (SQLException e1) {
				
				System.out.println("error :  HHHHHH  getStudents "+e1);
			}
			
			try {
				switchToFrame("students");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
		
		// if the default button selected 
        if (e.getSource() == button ) {
        	try {
				switchToFrame("home");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	System.out.println(" SWICHING INTO HOME PAGE :::");

        } 	
	}
	
	
	// method to switch frames
	public void switchToFrame(String frameType) throws SQLException {
		
		connectionToDatabase conn = new  connectionToDatabase();

		
		System.out.println(" switchToFrame ");
	    // Clear the current content
	    getContentPane().removeAll();

	    // Add components for the selected frame
	    switch (frameType) {
	        case "students":
	        	getFrameStudents();
	            break;

	        case "teachers":
	        	getFrameteachers();
	            break;

	        case "fields":
	        	filieds = conn.getfilieds(); 
	        	getFramefields();
	            break;

	        case "modules":
	        	getFramemodules();
	            break;
	        case "home":
	        	getFrame1();
	        	break;
	        case "absence":
	        	FrameAbsence();
	        	System.out.println("the absence HAHAHHAHAAHAH ");
	        	break;

	        default:
	            getFrame1(); // Default to the main frame
	            break;
	    }

	    // Refresh the frame
	    revalidate();
	    repaint();
	}// fin switchToFrame
	
	
}
