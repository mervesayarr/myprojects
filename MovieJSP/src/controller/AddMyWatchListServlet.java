package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BagLineeDAO;
import dao.BaggDAO;
import dao.MoviesDAO;
import model.BagLinee;
import model.Bagg;
import model.Customer;
import model.Movies;

/**
 * Servlet implementation class AddMyWatchListServlet
 */
@WebServlet("/AddMyWatchListServlet")
public class AddMyWatchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMyWatchListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String review= request.getParameter("review");
		
		Movies movies = MoviesDAO.instance.get(Integer.parseInt(id));
		HttpSession session = request.getSession();
		int customerId = ((Customer) session.getAttribute("customer")).getId();
		
		Bagg bag = BaggDAO.instance.getFromCustomerId(customerId);
		
		BagLinee line = new BagLinee(movies,review);
        BagLineeDAO.instance.save(line);
        bag.addLine(line);
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
