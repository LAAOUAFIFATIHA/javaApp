package student_app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class Login  extends JFrame implements ActionListener  {

	
	
	JButton button_administrateur ;
	JButton button_student;
	
	// the constructeur
	 Login(){
		 System.out.println("the contruceur of login ...");
	 }
	
	 public int authentication(  ) throws UnknownHostException {
		 
	 
		 try {
			    // COLLECTE ALL THE NETWORKING INTERFACES
			    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			    
			    // Loop through all network interfaces
			    while (networkInterfaces.hasMoreElements()) {
			        NetworkInterface networkInterface = networkInterfaces.nextElement();
			        
			        // Get the list of IP addresses for the interface
			        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
			        while (inetAddresses.hasMoreElements()) {
			            InetAddress inetAddress = inetAddresses.nextElement();
			            
			            // Check if the address is an IPv4 address
			            if (inetAddress instanceof Inet4Address) {
			                System.out.println("IP Address: " + inetAddress.getHostAddress());
			                
			                // Compare the IP address with "192.168.8.1"
			                if (inetAddress.getHostAddress().equals("192.168.8")) {
			                    System.out.println("Found the target IP address: 192.168.8.1");
			                    return 1;
			                }
			            }
			        }
			    }
			} catch (SocketException e) {
				System.out.println(".()"+e);
			}
		 return 0;
	 }
	
	 
	 
	 
	 
	public void firstFrame() {
		
		JLabel button_hello = new JLabel(" HELLO Friends *-* ");
		button_hello.setBounds( 400  ,  20  ,  200, 50);
		
		// IDMISTRATEUR
		button_administrateur = new JButton("administrateur");
		button_administrateur.setBounds(380 , 200 , 200, 50);
		button_administrateur.setFocusable(false);
		button_administrateur.addActionListener(this);
		
		button_student = new JButton("student");
		button_student.setBounds(380 , 300 , 200, 50);
		button_student.setFocusable(false);
		button_student.addActionListener(this);
		
		
		// the frame 
		this.setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,600);
		
		
		// add the component to the screen 
        this.add(button_hello);
        this.add(button_administrateur);
        this.add(button_student);
        
        
        
        // to make the layout visible 
        this.setVisible(true);
		
		
	}
	
	
	// the error function 
	public void getErrorFrame() {
		
		JLabel button_hello = new JLabel(" HELLO Friends *-* ");
		button_hello.setBounds( 400  ,  20  ,  200, 50);
		
		this.setForeground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,600);
        
        this.add(button_hello);
		
     // to make the layout visible 
        this.setVisible(true);
	}
	
	

	MyFrame mf = new  MyFrame();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// declaration 
		
		
		if ( e.getSource()  == button_administrateur) {
				System.out.println("go to teh page of administation ... ");
				try {
					if ( authentication() == 1) {
					switchToFrame("home");
					System.out.println("evrery things works good ... ");
					}else {
						switchToFrame("error");
					}
				}catch(UnknownHostException e1 ) {
					System.out.println(" error : the administation to the home page is not normal");
				}
			}
			else if ( e.getSource()  == button_student) {
				System.out.println("go to teh page of Student ... ");
			}}
			
			
			// method to switch frames
			private void switchToFrame(String frameType) {
				
				System.out.println(" switchToFrame ");
			    // Clear the current content
			    getContentPane().removeAll();

			    // Add components for the selected frame
			    switch (frameType) {
			    case "error":
			    	getErrorFrame();
			    
			        case "home":
			        	mf.getFrame1();
			        	break;

			        default:
			        	mf.getFrame1(); // Default to the main frame
			            break;
			    }

			
	}

}
