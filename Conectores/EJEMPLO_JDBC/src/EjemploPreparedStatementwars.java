import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploPreparedStatementwars {

    
    public static void main(String[] args) throws SQLException {
        Connection cnt = null;
        try {
            cnt = EstablecerConexion.getConnection();
            String sql = "SELECT * FROM characters WHERE hair_color = ?";
            PreparedStatement stm = cnt.prepareStatement(sql); 
            stm.setString(1, "blond");
            System.out.println("blond");
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
            rs.close();
            System.out.println("brown");
            stm.setString(1, "brown");
            rs = stm.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
            stm.close();
            
        } catch (Exception ex){
            ex.printStackTrace();
        }finally
        {
            cnt.close();
        } 
    }
}
