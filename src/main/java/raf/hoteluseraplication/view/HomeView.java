package raf.hoteluseraplication.view;

import raf.hoteluseraplication.HotelUserApplication;
import raf.hoteluseraplication.restuser.UserServiceRESTClient;
import raf.hoteluseraplication.view.registerViews.RegisterClientView;
import raf.hoteluseraplication.view.registerViews.RegisterManagerView;
import raf.hoteluseraplication.view.userViews.AdminView;
import raf.hoteluseraplication.view.userViews.ClientView;
import raf.hoteluseraplication.view.userViews.ManagerUpdateView;
import raf.hoteluseraplication.view.userViews.ManagerView;

import javax.swing.*;
import java.io.IOException;
import java.util.Base64;

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
                String token = userservice.login(email,password);
                System.out.println(token);

                String[] chunks = token.split("\\.");
                Base64.Decoder decoder = Base64.getUrlDecoder();
                String header = new String(decoder.decode(chunks[0]));
                String payload = new String(decoder.decode(chunks[1]));
                System.out.println(payload);

                String []payloadSplit = payload.split(",");
                String []id = payloadSplit[0].split(":");
                HotelUserApplication.getInstance().setCurrentUserId(Long.parseLong(id[1]));
                HotelUserApplication.getInstance().setCurrentUserEmaiil(emailInput.getText());
                HotelUserApplication.getInstance().setToken(token);

                if(payload.contains("ROLE_ADMIN")){
                    new AdminView();
                } else if(payload.contains("ROLE_CLIENT")){
                    new ClientView();
                } else if(payload.contains("ROLE_MANAGER")){
                    new ManagerView();
                    new ManagerUpdateView();
                }


            } catch (RuntimeException ex) {
                System.out.println("Netacan email i sifra");
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
