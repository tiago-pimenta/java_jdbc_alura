import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.
				getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");
		
		Statement stm = con.createStatement();
		
		stm.execute("select id, nome, descricao from produto");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("id");
			System.out.println(id);
			
			String nome = rst.getString("nome");
			System.out.println(nome);
			
			String descricao = rst.getString("descricao");
			System.out.println(descricao);
		}
		
		con.close();
		
	}
	
}
