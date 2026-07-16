package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dao.*;
import model.*;
import java.util.List;

public class PatientPanel extends JPanel {

    PatientDAO dao = DAOFactory.getPatientDAO();

    JTextField name = new JTextField();
    JTextField phone = new JTextField();
    JTextField address = new JTextField();
    JTextField age = new JTextField();
    JTextField weight = new JTextField();

    JTable table;
    DefaultTableModel model;

    public PatientPanel() {

        setLayout(null);

        // ================= LABELS =================
        JLabel lblName = new JLabel("Name");
        JLabel lblPhone = new JLabel("Phone");
        JLabel lblAddress = new JLabel("Address");
        JLabel lblAge = new JLabel("Age");
        JLabel lblWeight = new JLabel("Weight");

        lblName.setBounds(20,20,100,25);
        lblPhone.setBounds(20,60,100,25);
        lblAddress.setBounds(20,100,100,25);
        lblAge.setBounds(20,140,100,25);
        lblWeight.setBounds(20,180,100,25);

        name.setBounds(120,20,150,25);
        phone.setBounds(120,60,150,25);
        address.setBounds(120,100,150,25);
        age.setBounds(120,140,150,25);
        weight.setBounds(120,180,150,25);

        // ================= BUTTONS =================
        JButton insert = new JButton("Insert");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton view = new JButton("View");

        insert.setBounds(20,230,100,30);
        update.setBounds(140,230,100,30);
        delete.setBounds(20,270,100,30);
        view.setBounds(140,270,100,30);

        // ================= TABLE =================
        table = new JTable();
        model = new DefaultTableModel();

        model.setColumnIdentifiers(new String[]{
                "ID","Name","Phone","Address","Age","Weight"
        });

        table.setModel(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(320,20,500,300);

        // ================= ADD =================
        add(lblName); add(name);
        add(lblPhone); add(phone);
        add(lblAddress); add(address);
        add(lblAge); add(age);
        add(lblWeight); add(weight);

        add(insert); add(update); add(delete); add(view);
        add(sp);

        loadTable();

        // ================= TABLE CLICK =================
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {

                int row = table.getSelectedRow();

                name.setText(model.getValueAt(row, 1).toString());
                phone.setText(model.getValueAt(row, 2).toString());
                address.setText(model.getValueAt(row, 3).toString());
                age.setText(model.getValueAt(row, 4).toString());
                weight.setText(model.getValueAt(row, 5).toString());
            }
        });

        // ================= INSERT =================
        insert.addActionListener(e -> {

            Patient p = new Patient(
                    name.getText(),
                    phone.getText(),
                    address.getText(),
                    Integer.parseInt(age.getText()),
                    Integer.parseInt(weight.getText())
            );

            dao.insert(p);

            JOptionPane.showMessageDialog(this, "Inserted Successfully!");

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

            Patient p = new Patient(
                    id,
                    name.getText(),
                    phone.getText(),
                    address.getText(),
                    Integer.parseInt(age.getText()),
                    Integer.parseInt(weight.getText())
            );

            dao.update(p);

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

        List<Patient> list = dao.getAll();

        for (Patient p : list) {

            model.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getPhone(),
                    p.getAddress(),
                    p.getAge(),
                    p.getWeight()
            });
        }
    }

    // ================= CLEAR =================
    private void clearFields() {

        name.setText("");
        phone.setText("");
        address.setText("");
        age.setText("");
        weight.setText("");
    }
}