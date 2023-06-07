package sport.diary.api.signup.repository;

import sport.diary.api.common.repository.AbstractRepository;
import sport.diary.api.signup.model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupRepositoryImpl extends AbstractRepository implements SignupRepository {
    @Override
    public void create(Customer customer) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("insert into customers (login,pass,email) values (?, ?, ?)");
            ps.setString(1, customer.getLogin());
            ps.setString(2, customer.getPass());
            ps.setString(3, customer.getEmail());
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
