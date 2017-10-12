import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;


public class Database {

    private BasicDataSource dataSource;

    private static final String USER_TABLE = "vartotoju_sarasas";

    public Database() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/kcs");
        dataSource.setMaxIdle(1);
        dataSource.setInitialSize(1);
        dataSource.setValidationQuery("SELECT 1");

    }

    public void crateTable(String tableName) {
        String sql = "CREATE TABLE " + tableName + " (id INTEGER NOT NULL AUTO_INCREMENT, "
                + "Vardas TEXT, Pavarde TEXT, Adresas TEXT, El_pastas TEXT, PRIMARY KEY(id))";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Ivyko klaida: " + e.getLocalizedMessage());
        }

    }


    public void insert(String vardas, String pavarde, String adresas, String el_pastas) {
        String sql = "INSERT INTO " + USER_TABLE + " (Vardas, Pavarde, Adresas, El_pastas) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, vardas);
            statement.setString(2, pavarde);
            statement.setString(3, adresas);
            statement.setString(4, el_pastas);
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Ivyko klaida: " + e.getLocalizedMessage());
        }
    }


    public void selectVardas(String vardas) {
        String sql = "SELECT * FROM " + USER_TABLE + " WHERE Vardas='" + vardas + "'";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (!resultSet.next()) {
                System.out.println("Vartotojas nerastas.");
                return;
            } else {
                do {
                    String var = resultSet.getString("Vardas");
                    String pav = resultSet.getString("Pavarde");
                    String adr = resultSet.getString("Adresas");
                    String el_pas = resultSet.getString("El_pastas");
                    System.out.println("Vardas=" + var + ", Pavarde=" + pav + ", Adresas=" + adr
                            + ", El_pastas=" + el_pas);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            System.out.println("Ivyko klaida: " + e.getLocalizedMessage());
        }
    }

    public void selectPavarde(String pavarde) {
        String sql = "SELECT * FROM " + USER_TABLE + " WHERE Pavarde='" + pavarde + "'";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (!resultSet.next()) {
                System.out.println("Vartotojas nerastas.");
                return;
            } else {
                do {
                    String var = resultSet.getString("Vardas");
                    String pav = resultSet.getString("Pavarde");
                    String adr = resultSet.getString("Adresas");
                    String el_pas = resultSet.getString("El_pastas");
                    System.out.println("Vardas=" + var + ", Pavarde=" + pav + ", Adresas=" + adr
                            + ", El_pastas=" + el_pas);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            System.out.println("Ivyko klaida: " + e.getLocalizedMessage());
        }
    }

    public void selectElPastas(String el_pastas) {
        String sql = "SELECT * FROM " + USER_TABLE + " WHERE El_pastas='" + el_pastas + "'";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (!resultSet.next()) {
                System.out.println("Vartotojas nerastas.");
                return;
            } else {
                do {
                    String var = resultSet.getString("Vardas");
                    String pav = resultSet.getString("Pavarde");
                    String adr = resultSet.getString("Adresas");
                    String el_pas = resultSet.getString("El_pastas");
                    System.out.println("Vardas=" + var + ", Pavarde=" + pav + ", Adresas=" + adr
                            + ", El_pastas=" + el_pas);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            System.out.println("Ivyko klaida: " + e.getLocalizedMessage());
        }
    }
}
