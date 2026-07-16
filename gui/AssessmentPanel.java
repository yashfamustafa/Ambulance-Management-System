package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dao.*;
import model.*;
import java.util.List;

public class AssessmentPanel extends JPanel {

    AssessmentDAO dao = DAOFactory.getAssessmentDAO();

    JTextField vitals = new JTextField();
    JTextField eyes = new JTextField();

    JComboBox<String> breath = new JComboBox<>(new String[]{"Normal", "Difficult"});
    JComboBox<String> skin = new JComboBox<>(new String[]{"Normal", "Pale", "Sweaty"});

    JSlider pain = new JSlider(1, 10, 5);

    JTable table;
    DefaultTableModel model;

    public AssessmentPanel() {

        setLayout(null);

        // ================= LABELS =================
        JLabel lblVitals = new JLabel("Vitals");
        JLabel lblEyes = new JLabel("Eyes");
        JLabel lblBreath = new JLabel("Breath");
        JLabel lblSkin = new JLabel("Skin");
        JLabel lblPain = new JLabel("Pain");

        lblVitals.setBounds(20, 20, 100, 25);
        lblEyes.setBounds(20, 60, 100, 25);
        lblBreath.setBounds(20, 100, 100, 25);
        lblSkin.setBounds(20, 140, 100, 25);
        lblPain.setBounds(20, 180, 100, 25);

        vitals.setBounds(120, 20, 150, 25);
        eyes.setBounds(120, 60, 150, 25);
        breath.setBounds(120, 100, 150, 25);
        skin.setBounds(120, 140, 150, 25);
        pain.setBounds(120, 175, 150, 50);

        pain.setMajorTickSpacing(1);
        pain.setPaintTicks(true);
        pain.setPaintLabels(true);

        // ================= BUTTONS =================
        JButton insert = new JButton("Insert");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton view = new JButton("View");

        insert.setBounds(20, 250, 100, 30);
        update.setBounds(140, 250, 100, 30);
        delete.setBounds(20, 290, 100, 30);
        view.setBounds(140, 290, 100, 30);

        // ================= TABLE =================
        table = new JTable();
        model = new DefaultTableModel();

        model.setColumnIdentifiers(new String[]{
                "ID", "Vitals", "Eyes", "Breath", "Skin", "Pain"
        });

        table.setModel(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(300, 20, 500, 320);

        // ================= ADD =================
        add(lblVitals); add(vitals);
        add(lblEyes); add(eyes);
        add(lblBreath); add(breath);
        add(lblSkin); add(skin);
        add(lblPain); add(pain);

        add(insert); add(update); add(delete); add(view);
        add(sp);

        loadTable();

        // ================= TABLE CLICK =================
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {

                int row = table.getSelectedRow();

                vitals.setText(model.getValueAt(row, 1).toString());
                eyes.setText(model.getValueAt(row, 2).toString());

                breath.setSelectedItem(model.getValueAt(row, 3).toString());
                skin.setSelectedItem(model.getValueAt(row, 4).toString());

                pain.setValue(Integer.parseInt(model.getValueAt(row, 5).toString()));
            }
        });

        // ================= INSERT =================
        insert.addActionListener(e -> {

            Assessment a = new Assessment(
                    vitals.getText(),
                    eyes.getText(),
                    breath.getSelectedItem().toString(),
                    skin.getSelectedItem().toString(),
                    String.valueOf(pain.getValue())
            );

            dao.insert(a);

            JOptionPane.showMessageDialog(this, "Inserted! ID = " + a.getId());

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

            Assessment a = new Assessment(
                    vitals.getText(),
                    eyes.getText(),
                    breath.getSelectedItem().toString(),
                    skin.getSelectedItem().toString(),
                    String.valueOf(pain.getValue())
            );

            a.setId(id);

            dao.update(a);

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

        List<Assessment> list = dao.getAll();

        for (Assessment a : list) {

            model.addRow(new Object[]{
                    a.getId(),
                    a.getVitals(),
                    a.getEyes(),
                    a.getBreath(),
                    a.getSkin(),
                    a.getPain()
            });
        }
    }

    // ================= CLEAR =================
    private void clearFields() {

        vitals.setText("");
        eyes.setText("");
        breath.setSelectedIndex(0);
        skin.setSelectedIndex(0);
        pain.setValue(5);
    }
}