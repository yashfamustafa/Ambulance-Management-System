package gui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    public Dashboard() {

        setTitle("Ambulance Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // ================= SIDE MENU =================
        JPanel menu = new JPanel();
        menu.setLayout(null);
        menu.setBounds(0, 0, 200, 600);

        JButton patientBtn = new JButton("Patient");
        JButton historyBtn = new JButton("History");
        JButton assessmentBtn = new JButton("Assessment");
        JButton responseBtn = new JButton("Response");

        patientBtn.setBounds(20, 50, 150, 40);
        historyBtn.setBounds(20, 110, 150, 40);
        assessmentBtn.setBounds(20, 170, 150, 40);
        responseBtn.setBounds(20, 230, 150, 40);

        menu.add(patientBtn);
        menu.add(historyBtn);
        menu.add(assessmentBtn);
        menu.add(responseBtn);

        // ================= MAIN AREA =================
        mainPanel.setBounds(200, 0, 800, 600);

        // ADD YOUR EXISTING PANELS HERE
        mainPanel.add(new PatientPanel(), "patient");
        mainPanel.add(new HistoryPanel(), "history");
        mainPanel.add(new AssessmentPanel(), "assessment");
        mainPanel.add(new ResponsePanel(), "response");

        // ================= BUTTON ACTIONS =================
        patientBtn.addActionListener(e -> cardLayout.show(mainPanel, "patient"));
        historyBtn.addActionListener(e -> cardLayout.show(mainPanel, "history"));
        assessmentBtn.addActionListener(e -> cardLayout.show(mainPanel, "assessment"));
        responseBtn.addActionListener(e -> cardLayout.show(mainPanel, "response"));

        // ================= ADD TO FRAME =================
        add(menu);
        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}