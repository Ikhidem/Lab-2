package indy.servlet;

import indywinners.Pack.IndyWinner;
import indywinners_Dao.IndyWinnerDAO;
import indywinners_Dao.Dao_Indy_Implementation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


public class servletwinners extends HttpServlet {
	private IndyWinnerDAO indyWinnerDAO = new Dao_Indy_Implementation();
	
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int page = 1;
	int winnersPerPage = 10;
	
	if (request.getParameter("page") != null) {
		page = Integer.parseInt(request.getParameter("page"));
	}
	
	int offset = (page -1) * winnersPerPage;
	
	List<IndyWinner> winners = indyWinnerDAO.getIndyWinners(offset, winnersPerPage);
	int totalWinners = indyWinnerDAO.getTotalCount();
	int totalPages = (int) Math.ceil((double) totalWinners / winnersPerPage);
	
	request.setAttribute("winners", winners);
	request.setAttribute("currentPage", page);
	request.setAttribute("totalPages", totalPages);
	
	request.getRequestDispatcher("indyWinners.jsp").forward(request, response);
}
}
