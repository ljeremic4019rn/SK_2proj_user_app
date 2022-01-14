package raf.hoteluseraplication.view;

import com.fasterxml.jackson.databind.ObjectMapper;
//import raf.hotelclientapplication.restclient.UserServiceRestClient;
//import raf.hotelclientapplication.restclient.dto.ManagerCreateDto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisterManagerView extends JDialog {

    private JLabel emailLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel phoneNumberLabel;
    private JLabel birthDateLabel;
    private JLabel hotelLabel;
    private JLabel hireDateLabel;

    private JPasswordField passwordField;
    private JTextField emailField ;
    private JTextField firstNameField;
    private JTextField lastNameField ;
    private JTextField usernameField ;
    private JTextField phoneNumberField ;
    private JTextField birthDateField;
    private JTextField hotelField;
    private JTextField hireDateField;

    private JButton registerButton = new JButton("Register");
//    private UserServiceRestClient userServiceRestClient = new UserServiceRestClient();
    private ObjectMapper objectMapper = new ObjectMapper();


    public RegisterManagerView() {
        this.setTitle("Client Application");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        emailLabel = new JLabel("Email:");
        firstNameLabel = new JLabel("First name:");
        lastNameLabel = new JLabel("Last name:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        phoneNumberLabel = new JLabel("Phone number:");
        birthDateLabel = new JLabel("Birth date (dd-MM-yyyy):");
        hotelLabel = new JLabel("Hotel:");
        hireDateLabel = new JLabel("Employment Day:");

        passwordField = new JPasswordField(20);
        emailField = new JTextField(20);
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        usernameField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        birthDateField = new JTextField(20);
        hotelField = new JTextField(20);
        hireDateField = new JTextField(20);

        registerPanel.add(hotelLabel);
        registerPanel.add(hotelField);
        registerPanel.add(hireDateLabel);
        registerPanel.add(hireDateField);
        registerPanel.add(emailLabel);
        registerPanel.add(emailField);
        registerPanel.add(firstNameLabel);
        registerPanel.add(firstNameField);
        registerPanel.add(lastNameLabel);
        registerPanel.add(lastNameField);
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
//            ManagerCreateDto managerCreateDto = new ManagerCreateDto();
//            managerCreateDto.setEmail(emailInput.getText());
//            managerCreateDto.setFirstName(firstNameInput.getText());
//            managerCreateDto.setLastName(lastNameInput.getText());
//            managerCreateDto.setUsername(usernameInput.getText());
//            managerCreateDto.setPassword(String.valueOf(passwordInput.getPassword()));
//            managerCreateDto.setPhoneNumber(phoneNumberInput.getText());
//            managerCreateDto.setBirthday(LocalDate.of(Integer.parseInt(yearInput.getText()), Integer.parseInt(monthInput.getText()), Integer.parseInt(dayInput.getText())));
//            DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            managerCreateDto.setEmploymentDate(LocalDate.of(Integer.parseInt(employmentYearInput.getText()), Integer.parseInt(employmentMonthInput.getText()), Integer.parseInt(employmentDayInput.getText())));
//            DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            managerCreateDto.setHotel(hotelInput.getText());
//            try {
//                userServiceRestClient.registerManager(managerCreateDto);
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
