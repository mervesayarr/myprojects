package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoviesDAO;
import model.Movies;

/**
 * Servlet implementation class CreateMoviesServlet
 */
@WebServlet("/CreateMoviesServlet")
public class CreateMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMoviesServlet() {
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
		
		      String movieName = request.getParameter("movieName");
		      String writerName = request.getParameter("writerName");
		      String directorName = request.getParameter("directorName");
		      String imdbRatingString = request.getParameter("imdbRating");
		      Double imdbRating = Double.parseDouble(imdbRatingString);
		      String genre = request.getParameter("genre");

		      Movies movies = new Movies(movieName,writerName,directorName ,imdbRating,genre);
		      MoviesDAO.instance.save(movies);

		      request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
