package raf.hoteluseraplication.view.userViews;

import raf.hoteluseraplication.HotelUserApplication;
import raf.hoteluseraplication.restuser.UserServiceRESTClient;
import raf.hoteluseraplication.restuser.dto.ManagerUpdateDto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ManagerUpdateView extends JDialog {


    private UserServiceRESTClient userServiceRESTClient = new UserServiceRESTClient();

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

    private JButton updateBtn = new JButton("Update");

    public ManagerUpdateView() {

        this.setTitle("Manager update ");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.Y_AXIS));
        updatePanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

//        emailLabel = new JLabel("Email:");
        firstNameLabel = new JLabel("First name:");
        lastNameLabel = new JLabel("Last name:");
        usernameLabel = new JLabel("Username:");
//        passwordLabel = new JLabel("Password:");
        phoneNumberLabel = new JLabel("Phone number:");
        birthDateLabel = new JLabel("Birth date (dd-MM-yyyy):");
        hotelLabel = new JLabel("Hotel:");
//        hireDateLabel = new JLabel("Employment Day:");

//        passwordField = new JPasswordField(20);
//        emailField = new JTextField(20);
        firstNameField = new JTextField(HotelUserApplication.getInstance().getUserInfoHolder().getFirstname(),20);
        lastNameField = new JTextField(HotelUserApplication.getInstance().getUserInfoHolder().getLastname(), 20);
        usernameField = new JTextField(HotelUserApplication.getInstance().getUserInfoHolder().getUsername(),20);
        phoneNumberField = new JTextField(20);
        birthDateField = new JTextField(20);
        hotelField = new JTextField(20);
//        hireDateField = new JTextField(20);

        updatePanel.add(hotelLabel);
        updatePanel.add(hotelField);
//        updatePanel.add(hireDateLabel);
//        updatePanel.add(hireDateField);
//        updatePanel.add(emailLabel);
//        updatePanel.add(emailField);
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

        updateBtn.addActionListener(e -> {
            ManagerUpdateDto managerUpdateDto = new ManagerUpdateDto();
            managerUpdateDto.setFirstName(firstNameField.getText());
            managerUpdateDto.setLastName(lastNameField.getText());
            managerUpdateDto.setHotel(hotelField.getText());
            managerUpdateDto.setBirthDate(birthDateField.getText());
            managerUpdateDto.setPhoneNumber(Long.valueOf(phoneNumberField.getText()));
            managerUpdateDto.setUsername(usernameField.getText());
            try {
                userServiceRESTClient.updateManagerProfile(HotelUserApplication.getInstance().getUserInfoHolder().getId(),managerUpdateDto);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        this.add(updatePanel);
        this.pack();
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
