package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaggDAO;
import dao.CustomerDAO;
import model.Bagg;
import model.Customer;

/**
 * Servlet implementation class HelloControllerServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public RegisterServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String password = request.getParameter("password");
      
      Customer customer = new Customer(name, password);
    
	CustomerDAO.instance.save(customer);

      Bagg bag = new Bagg("CustomerBag");
      BaggDAO.instance.save(bag);

      CustomerDAO.instance.linkBag(customer, bag);

      request.getRequestDispatcher("index.jsp").forward(request, response);
   }

}
