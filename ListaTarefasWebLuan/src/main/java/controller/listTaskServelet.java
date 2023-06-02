package controller;

import java.io.IOException;
import java.util.List;

import dao.TarefaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;


	@WebServlet("/PaginaPrincipal")

public class ListTaskServelet extends HttpServlet{
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       
			int id_user = (Integer) request.getAttribute("idUser");
			
			TarefaDao tarefaDao = new TarefaDao();
			List<Tarefa> tarefas = null;
			
			try {
				tarefas = tarefaDao.buscarPorIdUser(id_user);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			request.setAttribute("tarefas", tarefas);
			request.setAttribute("id_usuario", id_user);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/principal.jsp");
			dispatcher.forward(request, response);
		}

	}
