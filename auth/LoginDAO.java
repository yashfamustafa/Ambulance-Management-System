package auth;

import db.DBConnection;
import java.sql.*;

public class LoginDAO {

    public boolean validate(String username, String password) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next(); 

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}