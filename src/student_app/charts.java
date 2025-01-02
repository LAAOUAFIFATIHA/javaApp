package student_app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login extends JFrame implements ActionListener {

    JButton buttonAdministrateur;
    JButton buttonStudent;

    // Constructor
    public Login() {
        System.out.println("Initializing the Login window...");
    }

    // Authentication method
    public int authentication() {
        try {
            // Collect all networking interfaces
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
                        if (inetAddress.getHostAddress().equals("192.168.8.1")) {
                            System.out.println("Found the target IP address: 192.168.8.1");
                            return 1;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }

    // Initialize the first frame
    public void firstFrame() {
        JLabel labelHello = new JLabel("HELLO Friends *-* ");
        labelHello.setBounds(400, 20, 200, 50);

        buttonAdministrateur = new JButton("Administrateur");
        buttonAdministrateur.setBounds(380, 200, 200, 50);
        buttonAdministrateur.setFocusable(false);
        buttonAdministrateur.addActionListener(this);

        buttonStudent = new JButton("Student");
        buttonStudent.setBounds(380, 300, 200, 50);
        buttonStudent.setFocusable(false);
        buttonStudent.addActionListener(this);

        // Frame setup
        this.setForeground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900, 600);

        // Add components
        this.add(labelHello);
        this.add(buttonAdministrateur);
        this.add(buttonStudent);

        // Make the layout visible
        this.setVisible(true);
    }

    // Error frame setup
    public void getErrorFrame() {
        getContentPane().removeAll(); // Clear previous content
        JLabel labelError = new JLabel("ERROR: Invalid Authentication!");
        labelError.setBounds(400, 20, 300, 50);
        this.add(labelError);
        this.revalidate(); // Refresh the frame
        this.repaint();    // Ensure visual update
    }

    // MyFrame class definition
    MyFrame mf = new MyFrame();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAdministrateur) {
            System.out.println("Navigating to the administration page...");
            try {
                if (authentication() == 1) {
                    switchToFrame("home");
                    System.out.println("Authentication successful!");
                } else {
                    switchToFrame("error");
                }
            } catch (Exception ex) {
                System.out.println("Error: Unable to navigate to the home page.");
            }
        } else if (e.getSource() == buttonStudent) {
            System.out.println("Navigating to the student page...");
        }
    }

    // Method to switch frames
    private void switchToFrame(String frameType) {
        System.out.println("Switching frame to: " + frameType);
        getContentPane().removeAll();

        switch (frameType) {
            case "error":
                getErrorFrame();
                break;

            case "home":
                mf.getFrame1();
                break;

            default:
                mf.getFrame1(); // Default to the main frame
                break;
        }

        // Refresh the frame
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        Login loginApp = new Login();
        loginApp.firstFrame();
    }
}

// Placeholder for MyFrame class
class MyFrame {
    public void getFrame1() {
        System.out.println("Navigating to the main frame...");
        // Placeholder implementation
        JFrame frame = new JFrame("Home Frame");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Welcome to the Home Page!");
        label.setBounds(350, 250, 300, 50);
        frame.setLayout(null);
        frame.add(label);
        frame.setVisible(true);
    }
}
