import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class EjemploTransactionwars {
   
    public static void main(String[] args) throws SQLException {
        Connection cnt = null;
        try {
            cnt = EstablecerConexion.getConnection();
            //UTILIZAREMOS UNA TRANSACCIÓN MANUAL
            cnt.setAutoCommit(false);
            try {
                String query = "UPDATE characters SET hair_color = 'blond'";
                Statement stm = cnt.createStatement();
                //PRIMERA SENTENCIA DE LA TRANSACCIÓN
                stm.executeUpdate(query);

                String query2 = "UPDATE characters SET hair_color = 'blue' where id = 1";
                //SEGUDA SENTENCIA DE LA TRANSACCIÓN
                stm.executeUpdate(query2);
                //CONFIRMAMOS LA TRANSACCIÓN
                cnt.commit();
            }catch (Exception ex) 
            {
                ex.printStackTrace();
                //ROLLBACK POR SI SE PRODUCE CUALQUIER ERROR
                cnt.rollback();
            }
            
            //DEJAMOS DE UTILIZAR TRANSACCIONES
            cnt.setAutoCommit(true);

            String query3 = "UPDATE characters SET skin_color = 'gold'";
            Statement stm2 = cnt.createStatement();
            stm2.executeUpdate(query3);

        } catch (Exception ex){
            ex.printStackTrace();
        }finally
        {
            cnt.close();
        } 
    }
}
