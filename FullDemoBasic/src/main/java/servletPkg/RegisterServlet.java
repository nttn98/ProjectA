package servletPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.CustomerManager;
import entity.Customer;

public class RegisterServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			CustomerManager myCustomerManager = new CustomerManager();
			myCustomerManager.getByteData();
			String target = "home.jsp";

			String id, name, address, userName, pass;
			long phone;

			id = request.getParameter("customerID");
			name = request.getParameter("customerName");
			userName = request.getParameter("customerUserName");
			pass = request.getParameter("customerPass");
			address = request.getParameter("customerAddress");
			phone = Long.parseLong(request.getParameter("customerPhone"));

			id=String.valueOf(myCustomerManager.getListCustomers().size()+1);
			
			Customer newCustomer = new Customer(id, name, address, userName, pass, phone);

			String msg = "nothing";
			if (myCustomerManager.addCustomer(newCustomer)) {
				msg = "Registed successful";
				myCustomerManager.saveByteData();
			} else {
				msg = "Registed fail";
			}
			request.setAttribute("msg", msg);
			target = "login.jsp";

			RequestDispatcher requestDispatch = request.getRequestDispatcher(target);
			requestDispatch.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
