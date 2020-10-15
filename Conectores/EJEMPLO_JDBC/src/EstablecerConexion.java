import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Utils.SingletonProperties;

public class EstablecerConexion {
    public static Connection getConnection() throws SQLException {
        SingletonProperties sp = SingletonProperties.getInstancia();
        String driverinfo = sp.getPropiedad("jdbc.driverinfo");
        String serverinfo = sp.getPropiedad("jdbc.serverinfo");
        String portInfo = sp.getPropiedad("jdbc.portinfo");
        String dbName = sp.getPropiedad("jdbc.dbname");
        String user = sp.getPropiedad("jdbc.user");
        String password = sp.getPropiedad("jdbc.password");

        String connectionString = "jdbc:" + driverinfo + ":" + serverinfo;
        if (portInfo != null) {
            connectionString += (":" + portInfo + "/");
        }
        if (dbName != null) {
            connectionString += dbName;
        }
        return DriverManager.getConnection(connectionString, user, password);
    }
}
