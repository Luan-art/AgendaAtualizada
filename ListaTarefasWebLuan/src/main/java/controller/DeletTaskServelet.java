package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.TarefaDao;

@WebServlet("/DeletarTarefa")
public class DeletTaskServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paramId_tarefa = request.getParameter("idTarefa");
        int id_tarefa = Integer.valueOf(paramId_tarefa);

        String paramId_usuario = request.getParameter("idUser");
        int id_usuario = Integer.valueOf(paramId_usuario);

        System.out.println(id_tarefa);

        TarefaDao tarefaDao = new TarefaDao();

        try {
            tarefaDao.deletarTarefa(id_tarefa);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("idUser", id_usuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaPrincipal");
        dispatcher.forward(request, response);
    }
}