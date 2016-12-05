package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaggDAO;
import model.BagLinee;
import model.Bagg;
import model.Customer;

/**
 * Servlet implementation class ShowBaggServlet
 */
@WebServlet("/ShowBaggServlet")
public class ShowBaggServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBaggServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	      int customerId = ((Customer) session.getAttribute("customer")).getId();
	     
	      Bagg bag = BaggDAO.instance.getFromCustomerId(customerId);
	      
	      List<BagLinee> bagLines = bag.getContents();
	      request.setAttribute("bagLines", bagLines);

	      request.getRequestDispatcher("showBagg.jsp").forward(request, response);
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
