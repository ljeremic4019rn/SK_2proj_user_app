package raf.hoteluseraplication.view.userViews;

import raf.hoteluseraplication.HotelUserApplication;
import raf.hoteluseraplication.restuser.NotificationServiceRESTClient;
import raf.hoteluseraplication.restuser.UserServiceRESTClient;
import raf.hoteluseraplication.restuser.dto.notificationDtos.UserPasswordDto;
import raf.hoteluseraplication.restuser.tableComponents.NotificationTable;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ManagerView extends JDialog {

    private UserServiceRESTClient userServiceRESTClient = new UserServiceRESTClient();
    private NotificationServiceRESTClient notificationServiceRESTClient = new NotificationServiceRESTClient();

    private NotificationTable notificationTable;
    private JTable jTable;

    private JButton updateManagerProfileButton = new JButton("Update profile");
    private JLabel updatePasswordLabel = new JLabel("New password:");
    private JPasswordField updatePasswordField = new JPasswordField(15);
    private JButton updatePasswordButton = new JButton("Save password");
//
//    private JLabel emailLabel = new JLabel("Enter your email:");
//    private JTextField emailInput = new JTextField(20);


    public ManagerView() throws IOException {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JPanel TopPanel = new JPanel();

        updateManagerProfileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0,30)));

        TopPanel.add(Box.createRigidArea(new Dimension(0,20)));
        TopPanel.add(updatePasswordLabel);
        TopPanel.add(updatePasswordField);
        TopPanel.add(Box.createRigidArea(new Dimension(0,10)));
        TopPanel.add(updatePasswordButton);
        TopPanel.add(updateManagerProfileButton);
        mainPanel.add(TopPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));

        updateManagerProfileButton.addActionListener(e -> {
            new ManagerUpdateView();


        });

        updatePasswordButton.addActionListener(e -> {
            String password = String.valueOf(updatePasswordField.getPassword());
            UserPasswordDto userPasswordDto = new UserPasswordDto();
            userPasswordDto.setId(HotelUserApplication.getInstance().getUserInfoHolder().getId());
            userPasswordDto.setEmail(HotelUserApplication.getInstance().getUserInfoHolder().getEmail());
            userPasswordDto.setPassword(password);
            userPasswordDto.setName(HotelUserApplication.getInstance().getUserInfoHolder().getFirstname());
            userPasswordDto.setLastname(HotelUserApplication.getInstance().getUserInfoHolder().getLastname());
            try {
                userServiceRESTClient.changePassword(userPasswordDto.getId(), userPasswordDto);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });



        notificationTable = new NotificationTable();
        jTable = new JTable(notificationTable);
//        NotificationListDto notificationListDto = notificationServiceRESTClient.getClientNotifications(HotelClientApplication.getInstance().getUser().getId());
//        notificationListDto.getContent().forEach(notificationDto -> {
//            notificationTableModel.addRow(new Object[]{notificationDto.getEmail(), notificationDto.getType(), notificationDto.getDateCreated(), notificationDto.getMessage()});
//        });
        JScrollPane notificationTablePane = new JScrollPane();
//        notificationTablePane.add(notificationTable);
        notificationTablePane.setViewportView(jTable);
        mainPanel.add(Box.createRigidArea(new Dimension(0,30)));
        mainPanel.add(notificationTablePane);
        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));


        mainPanel.setVisible(true);
        this.add(mainPanel);
        this.pack();
        this.setLocationByPlatform(true);
        this.setVisible(true);


    }
}
