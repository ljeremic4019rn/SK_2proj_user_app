package raf.hoteluseraplication.view;

import raf.hoteluseraplication.restuser.UserServiceRESTClient;

import javax.swing.*;
import java.io.IOException;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.view.
 */
public class HomeView extends JPanel {


    //todo Jpanel register client
    //todo JPanel register manager

    //loging fields
    private JTextField emailInput;
    private JPasswordField passwordInput;
    private JButton loginButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    //register buttons
    private JButton clientRegister;
    private JButton managerRegister;
    //client, manager, admin for login

    //panels
    private JPanel registerPanel;
    private JPanel intputFieldsPanel;
    private JPanel loginButtonPanel;

    UserServiceRESTClient userservice = new UserServiceRESTClient();

    public HomeView() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10, 25, 20, 25));

        //login
        emailLabel = new JLabel("Email: ");
        passwordLabel = new JLabel("Password: ");
        emailInput = new JTextField(20);
        passwordInput = new JPasswordField(20);
        loginButton = new JButton("Login");


        clientRegister = new JButton("Register client");
        managerRegister = new JButton("Register manager");


        //samo za login dugme, da bi bilo odvojeno malo
        this.loginButtonPanel = new JPanel();
        loginButtonPanel.add(loginButton);
       // loginButton.setAlignmentX(LEFT_ALIGNMENT); //todo ovo ne ce da se pomeri levo idk zasto

        //input fields / top panel
        intputFieldsPanel = new JPanel();
        intputFieldsPanel.setBorder(BorderFactory.createEmptyBorder(25, 50, 20, 50));
        intputFieldsPanel.setLayout(new BoxLayout(intputFieldsPanel, BoxLayout.PAGE_AXIS));
        intputFieldsPanel.add(emailLabel);
        intputFieldsPanel.add(emailInput);
        intputFieldsPanel.add(passwordLabel);
        intputFieldsPanel.add(passwordInput);
        intputFieldsPanel.add(loginButtonPanel);

        loginButton.addActionListener(e ->{
            String email = emailInput.getText();
            String password = String.valueOf(passwordInput.getPassword());

            try {
//                System.out.println(email+" " + password);
                String token = userservice.login(email,password);
                System.out.println(token);
            } catch (RuntimeException ex) {
                System.out.println("Netacan email i sifra");
                //todo moglo bi izadje obavestenje da nije tacna sifra i mail
            }catch (IOException ex) {
                ex.printStackTrace();
            }

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
