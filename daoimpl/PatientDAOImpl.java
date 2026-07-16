package daoimpl;

import dao.PatientDAO;
import model.Patient;
import db.DBConnection;

import java.sql.*;
import java.util.*;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public void insert(Patient p) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO patient_id (Patient_Name, Mailing_Address, Phone, Age, Weight) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setString(2, p.getAddress());
            ps.setString(3, p.getPhone());
            ps.setInt(4, p.getAge());
            ps.setInt(5, p.getWeight());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Insert Error: " + e);
        }
    }

    @Override
    public void update(Patient p) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE patient_id SET Patient_Name=?, Mailing_Address=?, Phone=?, Age=?, Weight=? WHERE Patient_ID=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setString(2, p.getAddress());
            ps.setString(3, p.getPhone());
            ps.setInt(4, p.getAge());
            ps.setInt(5, p.getWeight());
            ps.setInt(6, p.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Update Error: " + e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM patient_id WHERE Patient_ID=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Delete Error: " + e);
        }
    }

    @Override
    public List<Patient> getAll() {

        List<Patient> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT * FROM patient_id");

            while (rs.next()) {
                list.add(new Patient(
                        rs.getInt("Patient_ID"),
                        rs.getString("Patient_Name"),
                        rs.getString("Phone"),
                        rs.getString("Mailing_Address"),
                        rs.getInt("Age"),
                        rs.getInt("Weight")
                ));
            }

        } catch (Exception e) {
            System.out.println("Fetch Error: " + e);
        }

        return list;
    }


}