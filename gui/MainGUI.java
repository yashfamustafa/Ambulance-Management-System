package gui;

import javax.swing.*;

public class MainGUI extends JFrame {

    public MainGUI() {

        setTitle("🚑 Ambulance System");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tab = new JTabbedPane();

        tab.add("Patient", new PatientPanel());
        tab.add("Response", new ResponsePanel());
        tab.add("History", new HistoryPanel());
        tab.add("Assessment", new AssessmentPanel());

        add(tab);

        setVisible(true);
    }
}