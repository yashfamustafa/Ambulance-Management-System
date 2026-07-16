package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dao.*;
import model.*;
import java.util.List;

public class ResponsePanel extends JPanel {

    ResponseDAO dao = DAOFactory.getResponseDAO();

    JTextField ecNo = new JTextField();
    JTextField station = new JTextField();
    JTextField ambulance = new JTextField();
    JTextField incident = new JTextField();
    JTextField destination = new JTextField();
    JTextField mileage = new JTextField();
    JTextField staff = new JTextField();

    JTable table;
    DefaultTableModel model;

    public ResponsePanel() {

        setLayout(null);

        // ================= LABELS =================
        JLabel lblEc = new JLabel("EC No");
        JLabel lblStation = new JLabel("Station");
        JLabel lblAmbulance = new JLabel("Ambulance");
        JLabel lblIncident = new JLabel("Incident");
        JLabel lblDestination = new JLabel("Destination");
        JLabel lblMileage = new JLabel("Mileage");
        JLabel lblStaff = new JLabel("Staff");

        lblEc.setBounds(20, 20, 100, 25);
        lblStation.setBounds(20, 60, 100, 25);
        lblAmbulance.setBounds(20, 100, 100, 25);
        lblIncident.setBounds(20, 140, 100, 25);
        lblDestination.setBounds(20, 180, 100, 25);
        lblMileage.setBounds(20, 220, 100, 25);
        lblStaff.setBounds(20, 260, 100, 25);

        ecNo.setBounds(120, 20, 150, 25);
        station.setBounds(120, 60, 150, 25);
        ambulance.setBounds(120, 100, 150, 25);
        incident.setBounds(120, 140, 150, 25);
        destination.setBounds(120, 180, 150, 25);
        mileage.setBounds(120, 220, 150, 25);
        staff.setBounds(120, 260, 150, 25);

        // ================= BUTTONS =================
        JButton insert = new JButton("Insert");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton view = new JButton("View");

        insert.setBounds(20, 310, 100, 30);
        update.setBounds(140, 310, 100, 30);
        delete.setBounds(20, 350, 100, 30);
        view.setBounds(140, 350, 100, 30);

        // ================= TABLE =================
        table = new JTable();
        model = new DefaultTableModel();

        model.setColumnIdentifiers(new String[]{
                "ID", "EC No", "Station", "Ambulance", "Incident", "Destination", "Mileage", "Staff"
        });

        table.setModel(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(300, 20, 520, 360);

        // ================= ADD =================
        add(lblEc); add(ecNo);
        add(lblStation); add(station);
        add(lblAmbulance); add(ambulance);
        add(lblIncident); add(incident);
        add(lblDestination); add(destination);
        add(lblMileage); add(mileage);
        add(lblStaff); add(staff);

        add(insert); add(update); add(delete); add(view);
        add(sp);

        loadTable();

        // ================= TABLE CLICK =================
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {

                int row = table.getSelectedRow();

                ecNo.setText(model.getValueAt(row, 1).toString());
                station.setText(model.getValueAt(row, 2).toString());
                ambulance.setText(model.getValueAt(row, 3).toString());
                incident.setText(model.getValueAt(row, 4).toString());
                destination.setText(model.getValueAt(row, 5).toString());
                mileage.setText(model.getValueAt(row, 6).toString());
                staff.setText(model.getValueAt(row, 7).toString());
            }
        });

        // ================= INSERT =================
        insert.addActionListener(e -> {

            Response r = new Response(
                    Integer.parseInt(ecNo.getText()),
                    station.getText(),
                    Integer.parseInt(ambulance.getText()),
                    incident.getText(),
                    destination.getText(),
                    Integer.parseInt(mileage.getText()),
                    staff.getText()
            );

            dao.insert(r);

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

            Response r = new Response(
                    Integer.parseInt(ecNo.getText()),
                    station.getText(),
                    Integer.parseInt(ambulance.getText()),
                    incident.getText(),
                    destination.getText(),
                    Integer.parseInt(mileage.getText()),
                    staff.getText()
            );

            r.setId(id);

            dao.update(r);

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

        List<Response> list = dao.getAll();

        for (Response r : list) {

            model.addRow(new Object[]{
                    r.getId(),
                    r.getEcNo(),
                    r.getStation(),
                    r.getAmbulanceNo(),
                    r.getIncident(),
                    r.getDestination(),
                    r.getMileage(),
                    r.getStaff()
            });
        }
    }

    // ================= CLEAR =================
    private void clearFields() {

        ecNo.setText("");
        station.setText("");
        ambulance.setText("");
        incident.setText("");
        destination.setText("");
        mileage.setText("");
        staff.setText("");
    }
}