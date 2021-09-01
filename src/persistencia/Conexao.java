package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gustavo dos santos machado
 */
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost/locadora";
    private static final String USER = "root";
    private static final String PASS = "abc123";
    public static Connection getConexao() {
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            return c;
        } catch (Exception e) {
            return null;
        }
    }
}
