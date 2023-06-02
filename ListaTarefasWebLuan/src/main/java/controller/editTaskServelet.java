package controller;

import java.io.IOException;

import dao.TarefaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;

@WebServlet("/editTarefa")

public class editTaskServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TarefaDao tarefaDAO = new TarefaDao();

    /**
     * Default constructor. 
     */
    public editTaskServelet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/EdicaoTarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tarefa task = new Tarefa();
		task.getId();
		
		String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String datacriacao = request.getParameter("data_criacao");
        String dataconclusao= request.getParameter("data_conclusao");
        String status = request.getParameter("status");

        task.setTitulo(titulo);
        task.setDescriacao(datacriacao);	
        task.setData_criacao(datacriacao);
        task.setData_conclusao(dataconclusao);
      //  task.setStatus(status);
     

        try {
         //   tarefaDAO.registerTask(task);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/EdicaoTarefa.jsp");
		dispatcher.forward(request, response);
    }
	

}