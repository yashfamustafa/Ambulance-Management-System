package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dao.*;
import model.*;
import java.util.List;

public class HistoryPanel extends JPanel {

    HistoryDAO dao = DAOFactory.getHistoryDAO();

    JTextField symptoms = new JTextField();
    JTextField allergies = new JTextField();
    JTextField medications = new JTextField();
    JTextField stroke = new JTextField();
    JTextField history = new JTextField();

    JTable table;
    DefaultTableModel model;

    public HistoryPanel() {

        setLayout(null);

        // ================= LABELS =================
        JLabel lblSymptoms = new JLabel("Symptoms");
        JLabel lblAllergies = new JLabel("Allergies");
        JLabel lblMedications = new JLabel("Medications");
        JLabel lblStroke = new JLabel("Stroke FAST");
        JLabel lblHistory = new JLabel("Medical History");

        lblSymptoms.setBounds(20, 20, 120, 25);
        lblAllergies.setBounds(20, 60, 120, 25);
        lblMedications.setBounds(20, 100, 120, 25);
        lblStroke.setBounds(20, 140, 120, 25);
        lblHistory.setBounds(20, 180, 120, 25);

        symptoms.setBounds(150, 20, 150, 25);
        allergies.setBounds(150, 60, 150, 25);
        medications.setBounds(150, 100, 150, 25);
        stroke.setBounds(150, 140, 150, 25);
        history.setBounds(150, 180, 150, 25);

        // ================= BUTTONS =================
        JButton insert = new JButton("Insert");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton view = new JButton("View");

        insert.setBounds(20, 230, 100, 30);
        update.setBounds(140, 230, 100, 30);
        delete.setBounds(20, 270, 100, 30);
        view.setBounds(140, 270, 100, 30);

        // ================= TABLE =================
        table = new JTable();
        model = new DefaultTableModel();

        model.setColumnIdentifiers(new String[]{
                "ID", "Symptoms", "Allergies", "Medications", "Stroke", "History"
        });

        table.setModel(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(320, 20, 500, 300);

        // ================= ADD =================
        add(lblSymptoms); add(symptoms);
        add(lblAllergies); add(allergies);
        add(lblMedications); add(medications);
        add(lblStroke); add(stroke);
        add(lblHistory); add(history);

        add(insert); add(update); add(delete); add(view);
        add(sp);

        // ================= LOAD TABLE =================
        loadTable();

        // ================= TABLE CLICK (AUTO FILL) =================
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {

                int row = table.getSelectedRow();

                symptoms.setText(model.getValueAt(row, 1).toString());
                allergies.setText(model.getValueAt(row, 2).toString());
                medications.setText(model.getValueAt(row, 3).toString());
                stroke.setText(model.getValueAt(row, 4).toString());
                history.setText(model.getValueAt(row, 5).toString());
            }
        });

        // ================= INSERT =================
        insert.addActionListener(e -> {

            History h = new History(
                    symptoms.getText(),
                    allergies.getText(),
                    medications.getText(),
                    stroke.getText(),
                    history.getText()
            );

            dao.insert(h);

            JOptionPane.showMessageDialog(this, "Inserted! ID = " + h.getId());

            loadTable();
            clearFields();
        });

        // ================= UPDATE =================
        update.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a record first!");
                return;
            }

            int id = Integer.parseInt(model.getValueAt(row, 0).toString());

            History h = new History(
                    symptoms.getText(),
                    allergies.getText(),
                    medications.getText(),
                    stroke.getText(),
                    history.getText()
            );

            h.setId(id);

            dao.update(h);

            JOptionPane.showMessageDialog(this, "Updated Successfully!");

            loadTable();
        });

        // ================= DELETE =================
        delete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a record first!");
                return;
            }

            int id = Integer.parseInt(model.getValueAt(row, 0).toString());

            dao.delete(id);

            JOptionPane.showMessageDialog(this, "Deleted Successfully!");

            loadTable();
            clearFields();
        });

        // ================= VIEW =================
        view.addActionListener(e -> loadTable());
    }

    // ================= LOAD TABLE =================
    private void loadTable() {

        model.setRowCount(0);

        List<History> list = dao.getAll();

        for (History h : list) {

            model.addRow(new Object[]{
                    h.getId(),
                    h.getSymptoms(),
                    h.getAllergies(),
                    h.getMedications(),
                    h.getStroke(),
                    h.getHistory()
            });
        }
    }

    // ================= CLEAR =================
    private void clearFields() {

        symptoms.setText("");
        allergies.setText("");
        medications.setText("");
        stroke.setText("");
        history.setText("");
    }
}