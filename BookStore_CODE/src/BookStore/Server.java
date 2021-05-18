package BookStore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public  class Server implements ActionListener {

    private ServerSocket serverSocket;
    private Transaction transactions;
    private SynchList outputs;
    private int port_number = 0;
    private static ArrayList<String> online_users;

    ///Swing UI
    private JFrame window;
    private JPanel cover;
    private JLabel labels_port;
    private JTextField port;
    private JButton run;

    public Server() {

        runPanel();

    }

    public void runPanel() {

        window = new JFrame("Server Config");

        cover = new JPanel();
        cover.setLayout(null); // Setting to layout to null, so it becomes absolute position

        port = new JTextField();
        port.setBounds(60, 60, 400, 40);
        port.addActionListener(this);
        port.setText("5000");
        labels_port = new JLabel("Please enter your port number?");
        labels_port.setBounds(60, 30, 400, 40);

        // Button for the user to leave the chat system
        run = new JButton("Run Server");
        run.setBounds(200, 100, 100, 50);
        run.addActionListener(this);

        cover.add(run);
        cover.add(port);
        cover.add(labels_port);

        window.add(cover);

        window.setResizable(false); // size remain the same, not changeable
        window.setSize(500, 250); // size for the server
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true); // display frame

    }


    public void runServer() {



        try {
            System.out.println("It works "+port_number);

            if (port_number > 0) {
                serverSocket = new ServerSocket(port_number);
                outputs = new SynchList();
                online_users = new ArrayList<String>();
                online_users.add("Everyone");
            }

            while (true) {
                transactions = new Transaction(outputs.size(), outputs,online_users ,serverSocket.accept());
                System.out.println("Server is now listening on port "+port_number +".....");
                transactions.start();
                System.out.println("Client has joined...");
            }
        } catch (Exception i) {
            System.out.println("Transaction failed: " + i);
        }


    }


    public static void main(String[] args) 
    {

        new Server();

    }
    
   
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == run && port.getText().length() < 1) {

            JOptionPane.showMessageDialog(null, "A port number must be entered!");

        }

        if (e.getSource() == run && port.getText().length() > 0) {

            port_number = Integer.parseInt(port.getText());
            JOptionPane.showMessageDialog(null,
                    "Server is now listening in the background on port " + port_number);
            runServer();

            window.setState(Frame.ICONIFIED);

        }


    }
}


