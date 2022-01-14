package raf.hoteluseraplication.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.view.
 */
public class HomeView extends JPanel {


    //todo Jpanel register client
    //todo JPanel register manager

    //loging fields
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton loginButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    //register buttons
    private JButton clientRegister;
    private JButton managerRegister;
    //client, manager, admin for login
    private JComboBox<String> userTypeCb;

    //panels
    private JPanel registerPanel;
    private JPanel intputFieldsPanel;
    private JPanel loginButtonPanel;



    public HomeView() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10, 25, 20, 25));

        //login
        emailLabel = new JLabel("Email: ");
        passwordLabel = new JLabel("Password: ");
        usernameInput = new JTextField(20);
        passwordInput = new JPasswordField(20);
        loginButton = new JButton("Login");


        clientRegister = new JButton("Register client");
        managerRegister = new JButton("Register manager");

        String []types = {"Client", "Manager", "Admin"};
        userTypeCb = new JComboBox<>(types);
        userTypeCb.setSelectedIndex(0);

        //samo za login dugme, da bi bilo odvojeno malo
        this.loginButtonPanel = new JPanel();
        loginButtonPanel.add(loginButton);
       // loginButton.setAlignmentX(LEFT_ALIGNMENT); //todo ovo ne ce da se pomeri levo idk zasto

        //input fields / top panel
        intputFieldsPanel = new JPanel();
        intputFieldsPanel.setBorder(BorderFactory.createEmptyBorder(25, 50, 20, 50));
        intputFieldsPanel.setLayout(new BoxLayout(intputFieldsPanel, BoxLayout.PAGE_AXIS));
        intputFieldsPanel.add(userTypeCb);
        intputFieldsPanel.add(emailLabel);
        intputFieldsPanel.add(usernameInput);
        intputFieldsPanel.add(passwordLabel);
        intputFieldsPanel.add(passwordInput);
        intputFieldsPanel.add(loginButtonPanel);

        loginButton.addActionListener(e ->{
            //todo get token
        });

        this.add(intputFieldsPanel);


        //register buttons / bottom panel
        registerPanel = new JPanel();
        registerPanel.add(managerRegister);
        registerPanel.add(clientRegister);

        clientRegister.addActionListener(e -> {
           new RegisterClientView();
        });

        managerRegister.addActionListener( e -> {
           new RegisterManagerView();
        });

        this.add(registerPanel);



    }

}
