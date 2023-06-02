package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import model.Usuario;

public class UserDao {
	
	private int contadorSequencial = 0;

	 public int registerUser( Usuario user) throws ClassNotFoundException {
	        
		 	String SELECT_USUARIO = "SELECT max(id) FROM usuarios;";
		 	
	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");
	        		
	        		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(SELECT_USUARIO)) {
	    		
	    		System.out.println(preparedStatement);
	    		// Step 3: Execute the query or update query
	    		try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	    		if (resultSet.next()) {
	    			contadorSequencial = resultSet.getInt("max(id)");
	    			System.out.println(contadorSequencial);
	    			contadorSequencial++;
	    		}
	    		}
	    		catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	    		
	    		} catch (SQLException e) {
	    		// process sql exception
	    		e.printStackTrace();
	    		}
	        	
	        	String INSERT_USERS_SQL = "INSERT INTO usuarios" +
	                "  (id, nome, login, senha, email) VALUES " +
	                " (?,?,?,?,?);";

	            int result = 0;

	            Class.forName("com.mysql.jdbc.Driver");

	            try (Connection connection = (Connection) DriverManager
	                    .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, contadorSequencial);
	            preparedStatement.setString(2, user.getLogin());
	            preparedStatement.setString(3, user.getNome());
	            preparedStatement.setString(4, user.getSenha());
	            preparedStatement.setString(5, user.getEmail());
	   

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }




	public Usuario getUser(String username) throws ClassNotFoundException {
		   String SELECT_LOGIN = "SELECT id, nome, login, senha, email FROM usuarios" +
	        		" WHERE login=?";

		   Usuario user = new Usuario();

	        Class.forName("com.mysql.jdbc.Driver");
	       	

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(SELECT_LOGIN)) {
	            preparedStatement.setString(1, username);

	            System.out.println(preparedStatement);
	            try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	            	if(resultSet.next()) {
	            		user.setId(resultSet.getInt("id"));
	            		user.setLogin(resultSet.getString("login"));
	            		user.setSenha(resultSet.getString("senha"));
	            		user.setNome(resultSet.getString("nome"));
	            		user.setEmail(resultSet.getString("email"));

	            	}
	            } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		            

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        
	        return user;
	}
	
	public Usuario getPassword(String password) throws ClassNotFoundException {
		   String LOG_SENHA = "SELECT id, nome, login, senha, email FROM usuarios" +
	        		" WHERE senha=?";

		   Usuario user = new Usuario();

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(LOG_SENHA)) {
	            preparedStatement.setString(1, password);

	            System.out.println(preparedStatement);
	            try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	            	if(resultSet.next()) {
	            		user.setId(resultSet.getInt("id"));
	            		user.setLogin(resultSet.getString("login"));
	            		user.setNome(resultSet.getString("nome"));
	            		user.setSenha(resultSet.getString("senha"));
	            		user.setEmail(resultSet.getString("email"));

	            	}
	            } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		            

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        
	        return user;
	}
	
	
}
