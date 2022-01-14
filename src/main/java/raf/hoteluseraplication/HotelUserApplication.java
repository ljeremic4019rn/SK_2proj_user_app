package raf.hoteluseraplication;

import raf.hoteluseraplication.restuser.tableComponents.UserInfoHolder;
import raf.hoteluseraplication.view.HomeView;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.
 */
public class HotelUserApplication extends JFrame {

    private String token;
    private Long currentUserId;
    private String currentUserEmaiil;

    private UserInfoHolder userInfoHolder;

    private static HotelUserApplication instance = new HotelUserApplication();

    private HotelUserApplication() {
        this.setTitle("Application");
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        HomeView homeView = new HomeView();
        this.add(homeView, BorderLayout.CENTER);
        this.pack();

        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static HotelUserApplication getInstance() {
        return instance;
    }


    public Long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Long currentUserId) {
        this.currentUserId = currentUserId;
    }

    public String getCurrentUserEmaiil() {
        return currentUserEmaiil;
    }

    public void setCurrentUserEmaiil(String currentUserEmaiil) {
        this.currentUserEmaiil = currentUserEmaiil;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfoHolder getUserInfoHolder() {
        return userInfoHolder;
    }

    public void setUserInfoHolder(UserInfoHolder userInfoHolder) {
        this.userInfoHolder = userInfoHolder;
    }
}
