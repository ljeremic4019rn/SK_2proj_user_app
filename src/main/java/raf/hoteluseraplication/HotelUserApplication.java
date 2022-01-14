package raf.hoteluseraplication;

import raf.hoteluseraplication.view.HomeView;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.
 */
public class HotelUserApplication extends JFrame {

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
}
