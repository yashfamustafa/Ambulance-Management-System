package daoimpl;

import dao.AssessmentDAO;
import model.Assessment;
import db.DBConnection;

import java.sql.*;
import java.util.*;

public class AssessmentDAOImpl implements AssessmentDAO {

    // ================= INSERT =================
    @Override
    public void insert(Assessment a) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO assessment (Vitals, Eyes, Breath_Sounds, Skin, Pain) VALUES (?,?,?,?,?)";

            // ⭐ IMPORTANT: enable auto ID fetching
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, a.getVitals());
            ps.setString(2, a.getEyes());
            ps.setString(3, a.getBreath());
            ps.setString(4, a.getSkin());
            ps.setString(5, a.getPain());

            ps.executeUpdate();

            //  GET AUTO GENERATED ID
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                a.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Insert Assessment Error: " + e);
        }
    }

    // ================= UPDATE =================
    @Override
    public void update(Assessment a) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE assessment SET Vitals=?, Eyes=?, Breath_Sounds=?, Skin=?, Pain=? WHERE Assessment_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, a.getVitals());
            ps.setString(2, a.getEyes());
            ps.setString(3, a.getBreath());
            ps.setString(4, a.getSkin());
            ps.setString(5, a.getPain());
            ps.setInt(6, a.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Update Assessment Error: " + e);
        }
    }

    // ================= DELETE =================
    @Override
    public void delete(int id) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM assessment WHERE Assessment_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Delete Assessment Error: " + e);
        }
    }

    // ================= GET ALL =================
    @Override
    public List<Assessment> getAll() {

        List<Assessment> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM assessment";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {

                Assessment a = new Assessment(
                        rs.getInt("Assessment_ID"),
                        rs.getString("Vitals"),
                        rs.getString("Eyes"),
                        rs.getString("Breath_Sounds"),
                        rs.getString("Skin"),
                        rs.getString("Pain")
                );

                list.add(a);
            }

        } catch (Exception e) {
            System.out.println("Fetch Assessment Error: " + e);
        }

        return list;
    }

   
}