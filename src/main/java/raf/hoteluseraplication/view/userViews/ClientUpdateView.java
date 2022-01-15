package raf.hoteluseraplication.view.userViews;

import raf.hoteluseraplication.restuser.UserServiceRESTClient;
import raf.hoteluseraplication.restuser.dto.ClientUpdateDto;
import raf.hoteluseraplication.restuser.dto.ManagerUpdateDto;

import javax.swing.*;
import java.awt.*;

public class ClientUpdateView extends JDialog{

    private UserServiceRESTClient userServiceRESTClient = new UserServiceRESTClient();

    private JLabel passportNumberLabel;
    private JLabel reservationNumLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel phoneNumberLabel;
    private JLabel birthDateLabel;

    private JPasswordField passwordField;
    private JTextField reservationNumField;
    private JTextField firstNameField;
    private JTextField lastNameField ;
    private JTextField usernameField ;
    private JTextField passportField;
    private JTextField phoneNumberField ;
    private JTextField birthDateField;

    private JButton updateBtn = new JButton("Update");


    public ClientUpdateView() {
        this.setTitle("Client update");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.Y_AXIS));
        updatePanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));


        passportNumberLabel = new JLabel("Passport number:");
        reservationNumLabel= new JLabel("Reservation number:");
        firstNameLabel = new JLabel("First name:");
        lastNameLabel = new JLabel("Last name:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        phoneNumberLabel = new JLabel("Phone number:");
        birthDateLabel = new JLabel("Birth date (dd-MM-yyyy):");

        passwordField = new JPasswordField(20);
        reservationNumField = new JPasswordField(20);
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        usernameField = new JTextField(20);
        passportField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        birthDateField = new JTextField(20);


        updatePanel.add(passportNumberLabel);
        updatePanel.add(passportField);
        updatePanel.add(reservationNumLabel);
        updatePanel.add(reservationNumField);
        updatePanel.add(firstNameLabel);
        updatePanel.add(firstNameField);
        updatePanel.add(lastNameLabel);
        updatePanel.add(lastNameField);
        updatePanel.add(usernameLabel);
        updatePanel.add(usernameField);
//        updatePanel.add(passwordLabel);
//        updatePanel.add(passwordField);
        updatePanel.add(phoneNumberLabel);
        updatePanel.add(phoneNumberField);
        updatePanel.add(birthDateLabel);
        updatePanel.add(birthDateField);

        updatePanel.add(Box.createRigidArea(new Dimension(0, 30)));
        updatePanel.add(updateBtn);

        updateBtn.addActionListener(e ->{
            ClientUpdateDto clientUpdateDto = new ClientUpdateDto();
            clientUpdateDto.setFirstName(firstNameField.getText());
            clientUpdateDto.setLastName(lastNameField.getText());
            clientUpdateDto.setBirthDate(birthDateField.getText());
            clientUpdateDto.setPhoneNumber(Long.valueOf(phoneNumberField.getText()));
            clientUpdateDto.setUsername(usernameField.getText());
            clientUpdateDto.setPassportNumber(passportField.getText());
        });


        this.add(updatePanel);
        this.pack();
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
