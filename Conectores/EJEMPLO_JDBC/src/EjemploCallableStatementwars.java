import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class EjemploCallableStatementwars {
    public static void main(String[] args) throws SQLException {
        Connection conexion = null;
        try {
            conexion = EstablecerConexion.getConnection();
            String sql = "{? = call numCharacters()}";
            CallableStatement stm = conexion.prepareCall(sql); 
            stm.registerOutParameter(1, java.sql.Types.INTEGER);
            stm.execute();
            System.out.println(stm.getInt(1));
            stm.close();    
        } catch (Exception ex){
            ex.printStackTrace();
        }finally
        {
            conexion.close();
        } 
    }
}
