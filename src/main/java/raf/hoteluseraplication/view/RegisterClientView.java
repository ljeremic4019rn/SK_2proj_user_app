package raf.hoteluseraplication.view;

import com.fasterxml.jackson.databind.ObjectMapper;
//import raf.hotelclientapplication.restclient.UserServiceRestClient;
//import raf.hotelclientapplication.restclient.dto.ClientCreateDto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisterClientView extends JDialog {


    private JLabel passportNumberLabel;
    private JLabel reservationNumLabel;
    private JLabel emailLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel phoneNumberLabel;
    private JLabel birthDateLabel;

    private JPasswordField passwordField;
    private JPasswordField reservationNumField;
    private JTextField emailField ;
    private JTextField firstNameField;
    private JTextField lastNameField ;
    private JTextField usernameField ;
    private JTextField passportField;
    private JTextField phoneNumberField ;
    private JTextField birthDateField;


    private JButton registerButton = new JButton("Register");

//    private UserServiceRestClient userServiceRestClient = new UserServiceRestClient();
    private ObjectMapper objectMapper = new ObjectMapper();


    public RegisterClientView() {
        this.setTitle("Client registration");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));


        passportNumberLabel = new JLabel("Passport number:");
        reservationNumLabel= new JLabel("Reservation number:");
        emailLabel = new JLabel("Email:");
        firstNameLabel = new JLabel("First name:");
        lastNameLabel = new JLabel("Last name:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        phoneNumberLabel = new JLabel("Phone number:");
        birthDateLabel = new JLabel("Birth date (dd-MM-yyyy):");

        passwordField = new JPasswordField(20);
        reservationNumField = new JPasswordField(20);
        emailField = new JTextField(20);
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        usernameField = new JTextField(20);
        passportField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        birthDateField = new JTextField(20);


        registerPanel.add(passportNumberLabel);
        registerPanel.add(passportField);
        registerPanel.add(reservationNumLabel);
        registerPanel.add(reservationNumField);
        registerPanel.add(firstNameLabel);
        registerPanel.add(firstNameField);
        registerPanel.add(lastNameLabel);
        registerPanel.add(lastNameField);
        registerPanel.add(emailLabel);
        registerPanel.add(emailField);
        registerPanel.add(usernameLabel);
        registerPanel.add(usernameField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(phoneNumberLabel);
        registerPanel.add(phoneNumberField);
        registerPanel.add(birthDateLabel);
        registerPanel.add(birthDateField);

        registerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        registerPanel.add(registerButton);
//
//        registerButton.addActionListener(e -> {
//            ClientCreateDto clientCreateDto = new ClientCreateDto();
//            clientCreateDto.setEmail(emailInput.getText());
//            clientCreateDto.setFirstName(firstNameInput.getText());
//            clientCreateDto.setLastName(lastNameInput.getText());
//            clientCreateDto.setPassportNumber(passportInput.getText());
//            clientCreateDto.setPhoneNumber(phoneNumberInput.getText());
//            clientCreateDto.setUsername(usernameInput.getText());
//            clientCreateDto.setPassword(String.valueOf(passwordInput.getPassword()));
//            clientCreateDto.setBirthday(LocalDate.of(Integer.parseInt(yearInput.getText()), Integer.parseInt(monthInput.getText()), Integer.parseInt(dayInput.getText())));
//            DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            try {
//                userServiceRestClient.registerClient(clientCreateDto);
//            } catch (IOException jsonProcessingException) {
//                jsonProcessingException.printStackTrace();
//            }
//            this.setVisible(false);
//        });

        this.add(registerPanel);
        this.pack();
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);





    }
}
