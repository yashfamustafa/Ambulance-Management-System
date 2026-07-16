package daoimpl;

import dao.ResponseDAO;
import model.Response;
import db.DBConnection;

import java.sql.*;
import java.util.*;

public class ResponseDAOImpl implements ResponseDAO {

    // ================= INSERT =================
    @Override
    public void insert(Response r) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO response " +
                    "(EC_No, Station_Name, Ambulance_No, Incident_Address, Destination_Address, Mileage_km, Ambulance_Staff_Name) " +
                    "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, r.getEcNo());
            ps.setString(2, r.getStation());
            ps.setInt(3, r.getAmbulanceNo());
            ps.setString(4, r.getIncident());
            ps.setString(5, r.getDestination());
            ps.setInt(6, r.getMileage());
            ps.setString(7, r.getStaff());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Insert Response Error: " + e);
        }
    }

    // ================= UPDATE =================
    @Override
    public void update(Response r) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE response SET " +
                    "EC_No=?, Station_Name=?, Ambulance_No=?, Incident_Address=?, Destination_Address=?, Mileage_km=?, Ambulance_Staff_Name=? " +
                    "WHERE Response_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, r.getEcNo());
            ps.setString(2, r.getStation());
            ps.setInt(3, r.getAmbulanceNo());
            ps.setString(4, r.getIncident());
            ps.setString(5, r.getDestination());
            ps.setInt(6, r.getMileage());
            ps.setString(7, r.getStaff());
            ps.setInt(8, r.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Update Response Error: " + e);
        }
    }

    // ================= DELETE =================
    @Override
    public void delete(int id) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM response WHERE Response_ID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Delete Response Error: " + e);
        }
    }

    // ================= GET ALL =================
    @Override
    public List<Response> getAll() {

        List<Response> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM response";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {

                Response r = new Response(
                        rs.getInt("Response_ID"),
                        rs.getInt("EC_No"),
                        rs.getString("Station_Name"),
                        rs.getInt("Ambulance_No"),
                        rs.getString("Incident_Address"),
                        rs.getString("Destination_Address"),
                        rs.getInt("Mileage_km"),
                        rs.getString("Ambulance_Staff_Name")
                );

                list.add(r);
            }

        } catch (Exception e) {
            System.out.println("Fetch Response Error: " + e);
        }

        return list;
    }

    
}