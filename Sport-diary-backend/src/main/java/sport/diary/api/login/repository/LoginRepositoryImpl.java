package sport.diary.api.login.repository;

import java.sql.*;

public class LoginRepositoryImpl implements LoginRepository {
    @Override
    public boolean isPresent(String login, String password) {

        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT count(*) FROM customers where login = ? and pass = ?");
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count==1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sport-diary", "root", "11111111");
    }
}
