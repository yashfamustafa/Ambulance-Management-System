package daoimpl;

import dao.HistoryDAO;
import model.History;
import db.DBConnection;

import java.sql.*;
import java.util.*;

public class HistoryDAOImpl implements HistoryDAO {

    // ================= INSERT =================
    @Override
    public void insert(History h) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO history " +
                    "(Symptoms, Allergies, Patient_Medications, Stroke_FAST_Assessment, Medical_History) " +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, h.getSymptoms());
            ps.setString(2, h.getAllergies());
            ps.setString(3, h.getMedications());
            ps.setString(4, h.getStroke());
            ps.setString(5, h.getHistory());

            ps.executeUpdate();

            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                h.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Insert History Error: " + e);
        }
    }

    // ================= UPDATE =================
    @Override
    public void update(History h) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE history SET Symptoms=?, Allergies=?, Patient_Medications=?, Stroke_FAST_Assessment=?, Medical_History=? WHERE History_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, h.getSymptoms());
            ps.setString(2, h.getAllergies());
            ps.setString(3, h.getMedications());
            ps.setString(4, h.getStroke());
            ps.setString(5, h.getHistory());
            ps.setInt(6, h.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Update History Error: " + e);
        }
    }

    // ================= DELETE =================
    @Override
    public void delete(int id) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM history WHERE History_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Delete History Error: " + e);
        }
    }

    // ================= GET ALL =================
    @Override
    public List<History> getAll() {

        List<History> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM history";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {

                list.add(new History(
                        rs.getInt("History_ID"),
                        rs.getString("Symptoms"),
                        rs.getString("Allergies"),
                        rs.getString("Patient_Medications"),
                        rs.getString("Stroke_FAST_Assessment"),
                        rs.getString("Medical_History")
                ));
            }

        } catch (Exception e) {
            System.out.println("Fetch History Error: " + e);
        }

        return list;
    }


}