package BookStore;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Client implements SocketConnection, ActionListener, ItemListener {


    protected Socket socket;

    protected ObjectInputStream inputStream;

    protected ObjectOutputStream outputStream;

    protected String CurrentToWho = "Everyone";

    protected static ArrayList<String> users_lists;
    private JComboBox<String> display_users;

    private JPanel switchPanels; // a panel that uses CardLayout

    ///Swing UI
    private JFrame window;

    private JPanel cover;
    private JPanel main;
    private JTextField host;
    private JTextField port;
    private JTextField clientName;
    private JButton run;
    private Color clientColour;
    private JLabel labels_cover[];


    private JTextArea server;
    private JTextField input;
    private JScrollPane scrollBar;


    public void runPanel() {

        window = new JFrame("Client");
        labels_cover = new JLabel[6];
        switchPanels = new JPanel(new CardLayout());

        cover = new JPanel();
        cover.setLayout(null); // Setting to layout to null, so it becomes absolute position
        cover.setSize(300, 400);

        clientName = new JTextField();
        clientName.setBounds(60, 60, 400, 40);
        clientName.addActionListener(this);
        labels_cover[0] = new JLabel("Please enter your name?");
        labels_cover[0].setBounds(60, 30, 300, 40);
        cover.add(clientName);
        cover.add(labels_cover[0]);


        host = new JTextField();
        host.setBounds(60, 120, 400, 40);
        host.setText("localhost");
        host.addActionListener(this);
        labels_cover[1] = new JLabel("Please enter your host?");
        labels_cover[1].setBounds(60, 90, 300, 40);
        cover.add(labels_cover[1]);
        cover.add(host);


        port = new JTextField();
        port.setBounds(60, 180, 400, 40);
        port.addActionListener(this);
        port.setText("5000");
        labels_cover[2] = new JLabel("Please enter your port number?");
        labels_cover[2].setBounds(60, 150, 300, 40);
        cover.add(labels_cover[2]);
        cover.add(port);

        // Button for the user to leave the chat system
        run = new JButton("Run Client");
        run.setBounds(200, 250, 100, 50);
        run.addActionListener(this);
        cover.add(run);

        switchPanels.add(cover, "cover");

        main = new JPanel();
        main.setLayout(null); // Setting to layout to null, so it becomes absolute position
        main.setSize(300, 400);

        mainInterface();
        window.setSize(500, 350);

        switchPanels.add(main, "main");
        window.add(switchPanels);

        window.setResizable(false); // size remain the same, not changeable
        window.setSize(500, 350); // size for the client
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true); // display frame

    }

    public void mainInterface() {

        window.setTitle(this.clientName.getText());
        main.setBackground(clientColour);

        labels_cover[3] = new JLabel("Display Messages:");
        labels_cover[3].setForeground(Color.white);
        labels_cover[3].setBounds(30, -5, 300, 40);
        main.add(labels_cover[3]);

        Border thinBorder = LineBorder.createBlackLineBorder();
        server = new JTextArea();
        server.setEditable(false);
        server.setBorder(thinBorder);
        scrollBar = new JScrollPane(server);
        scrollBar.setBounds(20, 30, 450, 150);

        main.add(scrollBar);

        users_lists = new ArrayList<>();
        users_lists.add("Everyone");

        display_users = new JComboBox(users_lists.toArray());
        display_users.setBounds(20, 200, 200, 50);

        display_users.addItemListener(this);

        labels_cover[4] = new JLabel("Direct message to");
        labels_cover[4].setForeground(Color.white);
        labels_cover[4].setBounds(30, 180, 300, 40);
        main.add(labels_cover[4]);
        main.add(display_users);


        labels_cover[5] = new JLabel("Enter message here");
        labels_cover[5].setForeground(Color.white);
        labels_cover[5].setBounds(30, 250, 300, 40);
        main.add(labels_cover[5]);

        input = new JTextField();
        input.setBounds(20, 280, 450, 30);
        input.addActionListener(this);
        main.add(input);


    }


    class serverReader extends Thread {

        public void run() {
            try {
                Message p;
                String message = "";
                while ((p = (Message) inputStream.readObject()) != null) {

                    if(p.getToWho().equals("Everyone")) {

                        message = message + p.toString() + "\n";
                        server.setText(message);

                    }
                    if(p.getToWho().equals("Update")) {

                        updateOnlineUsers(p.getOnlineUsers());
                        message = message + p.toString() + "\n";
                        server.setText(message);

                    }

                    if(p.getToWho().toLowerCase().equals(clientName.getText().toLowerCase())) {
                        message = message + p.toString() + "\n";
                        server.setText(message);
                    }



                }

            } catch (Exception e) {
            }

        }
    }

    public Client() {


        try {

            clientColour = randomColors();
            runPanel();

            int port_number = Integer.parseInt(port.getText());

            socket = new Socket(host.getText(), port_number);

            // sends output to the socket
            outputStream = new ObjectOutputStream(socket.getOutputStream());

            // takes input from the sockets
            inputStream = new ObjectInputStream(socket.getInputStream());


            new serverReader().start();

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }
    }


    public void communicate() {

        try {
            String message = input.getText();
            outputStream.writeObject(new Message(this.clientName.getText(), message, CurrentToWho));
            outputStream.flush();

        } catch (IOException i) {
            System.out.println("Error " + i);
        }

        input.setText("");
    }

    public void joinUser() {

        try {
            outputStream.writeObject(new Message("@join", clientName.getText(), "Update"));
            outputStream.flush();

        } catch (IOException i) {
            System.out.println("Error " + i);
        }

        input.setText("");
    }

    public void updateOnlineUsers(ArrayList<String> updated_users){

        //remove duplicates
        Set<String> set = new HashSet<>(updated_users);
        users_lists.clear();
        users_lists.addAll(set);

        System.out.print(users_lists);
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(users_lists.toArray());
        display_users.setModel(defaultComboBoxModel);
    }


    public void closeConnections() {
        try {
            inputStream.close();
            outputStream.close();
            this.socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public Color randomColors() {
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);

        return new Color(red, green, blue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        CardLayout changePages = (CardLayout) (switchPanels.getLayout());

        if (e.getSource() == run && port.getText().length() < 1 && clientName.getText().length() < 1) {

            JOptionPane.showMessageDialog(null, "All forms must be filled!");

        }
        if (e.getSource() == run && port.getText().length() > 0 && clientName.getText().length() > 0) {

            changePages.show(switchPanels, "main");
            window.setSize(500, 350);
            joinUser();

        }

        if (!input.getText().equals("")) {
            // user message input
            communicate();

        }

    }

    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {

            CurrentToWho = (String) e.getItem();
        }

    }

    public static void main(String[] args) {

        new Client();
    }

  
}