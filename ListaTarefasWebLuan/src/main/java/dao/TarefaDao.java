package dao;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import model.Tarefa;

public class TarefaDao {
	
	private int chaveSequencial = 0;
	 
	public int registerTask( Tarefa tarefa) throws ClassNotFoundException {
		String SELECT_TAREFA = "SELECT max(id_tarefa) FROM tarefas";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = (Connection) DriverManager
		.getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");
		
		// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(SELECT_TAREFA)) {
		
		System.out.println(preparedStatement);
		// Step 3: Execute the query or update query
		try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
		if (resultSet.next()) {
			chaveSequencial = resultSet.getInt("max(id_tarefa)");
			chaveSequencial++;
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		} catch (SQLException e) {
		// process sql exception
		e.printStackTrace();
		}
	
    String INSERT_TAREFAS_SQL = "INSERT INTO tarefas" +
        "  (idTarefa, titulo, descricao, data_criacao, data_conclusao, status, idUser) VALUES " +
        " (?,?,?,?,?,?,?);";

    int result = 0;

    Class.forName("com.mysql.jdbc.Driver");

    try (Connection connection = (Connection) DriverManager
        .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT_TAREFAS_SQL)) {
        preparedStatement.setInt(1, chaveSequencial);
        preparedStatement.setString(2, tarefa.getTitulo());
        preparedStatement.setString(3, tarefa.getDescriacao());
        preparedStatement.setString(4, tarefa.getData_criacao());
        preparedStatement.setString(5, tarefa.getData_conclusao());
        preparedStatement.setBoolean(6, tarefa.isStatus());
        preparedStatement.setInt(7, tarefa.getIdUser());

        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        result = preparedStatement.executeUpdate();

    } catch (SQLException e) {
        // process sql exception
        e.printStackTrace();
    }
    return result;
	    }




	public Tarefa getId(int id) throws ClassNotFoundException {
		   String LOG_USERS_SQL = "SELECT (idTarefa) FROM tarefas" +
	        		" WHERE idTarefa=?";

		   Tarefa task = null;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = (Connection) DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(LOG_USERS_SQL)) {
	            preparedStatement.setInt(1, id);

	            System.out.println(preparedStatement);
	            try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
	            	if(resultSet.next()) {
	            		task = new Tarefa();
	            		task.setId(id);
	            		task.setTitulo(resultSet.getString("titulo"));
	            		task.setDescriacao(resultSet.getString("descricao"));
	            		task.setData_criacao(resultSet.getString("data_craicao"));
	            		task.setData_conclusao(resultSet.getString("data_conclusao"));
	            		task.setStatus(resultSet.getBoolean("status"));


	            	}
	            } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		            

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        
	        return task;
	}
	
	public List<Tarefa> buscarPorIdUser(int id) throws ClassNotFoundException {
		String SELECT_TAREFA = "SELECT idTarefa, titulo, descricao, data_criacao, data_conclusao, status, idUser FROM tarefas" +
								" WHERE idUser=?;";
		
		List<Tarefa> tarefas = null;
		Tarefa tarefa = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = (Connection) DriverManager
		    .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");
		
		    // Step 2:Create a statement using connection object
		    PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(SELECT_TAREFA)) {
		    preparedStatement.setInt(1, id);
		
		    System.out.println(preparedStatement);
		    // Step 3: Execute the query or update query
		    try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();) {
		    	tarefas = new ArrayList<>();
		    	while (resultSet.next()) {
		    		tarefa = new Tarefa();
		    		tarefa.setId(resultSet.getInt("idTarefa"));
		    		tarefa.setTitulo(resultSet.getString("titulo"));
		    		tarefa.setDescriacao(resultSet.getString("descricao"));
		    		tarefa.setData_criacao(resultSet.getString("data_criacao"));
		    		tarefa.setData_conclusao(resultSet.getString("data_conclusao"));
		    		tarefa.setStatus(resultSet.getBoolean("status"));
		    		tarefa.setIdUser(resultSet.getInt("idUser"));
		    		tarefas.add(tarefa);
		    	}
		    }
		    catch (SQLException e) {
					e.printStackTrace();
				}
		
		} catch (SQLException e) {
		    // process sql exception
		    e.printStackTrace();
		}
		return tarefas;
	}
	
	public int deletarTarefa(int id_tarefa) throws ClassNotFoundException {
		String REMOVE_TAREFA = "DELETE FROM tarefas" +
				" WHERE idTarefa=?;";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = (Connection) DriverManager
				.getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");
				
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(REMOVE_TAREFA)) {
				preparedStatement.setInt(1, id_tarefa);
				
				System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
	}
	
	
}
