package controller;

import java.io.IOException;
import java.sql.Date;

import model.Tarefa;

import dao.TarefaDao;
import jakarta.servlet.RequestDispatcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CadastroDeTarefa")
public class CadTaskServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TarefaDao tarefaDAO = new TarefaDao();
	Tarefa tarefa = new Tarefa();
    /**
     * Default constructor. 
     *

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("idUser");
		int id_usuario = Integer.valueOf(paramId);
		
		System.out.println(id_usuario);
		
		tarefa.setIdUser(id_usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/CadastroDeTarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String data_criacao = request.getParameter("data_criacao");
		String data_conclusao = request.getParameter("data_conclusao");
		String status = request.getParameter("status");
		
		tarefa.setTitulo(titulo);
		tarefa.setDescriacao(descricao);
		
		java.util.Date dataCriacao = null;
		java.util.Date dataConclusao = null;
		
		//Verifica se o formato esta correto!!!
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dataCriacao = sdf.parse(data_criacao);
			dataConclusao = sdf.parse(data_conclusao);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		tarefa.setData_criacao(data_criacao);
		tarefa.setData_conclusao(data_conclusao);
		
		if(status == null) {
			tarefa.setStatus(false);
		} else {
			tarefa.setStatus(true);
		}
		
		try {
			tarefaDAO.registerTask(tarefa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generasted catch block
			e.printStackTrace();
		}
		
		request.setAttribute("idUser", tarefa.getIdUser());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaPrincipal");
		dispatcher.forward(request, response);
	}

}