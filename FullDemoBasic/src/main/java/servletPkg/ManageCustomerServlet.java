package servletPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Customer;
import manager.CustomerManager;

public class ManageCustomerServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			CustomerManager myCustomerManager = new CustomerManager();
			int count = myCustomerManager.getByteData();
			String mode = request.getParameter("mode");
			String target = "home.jsp";

			if (count == 0) {
				out.print(count);
				request.setAttribute("msg", "Do not any customer registed !");
			} else {

				// check mode value = view
				if (mode.equals("view")) {
					ArrayList<Customer> listCustomers = myCustomerManager.getListCustomers();
					System.out.println("Servlet get " + listCustomers.size() + " customers");
					target = "manageCustomerRemake.jsp";
					request.setAttribute("listCustomers", listCustomers);

				}
			}
			// check mode value = delete
			if (mode.equals("delete")) {
				String id = request.getParameter("id");
				String msg = "nothing";
				if (myCustomerManager.deleteCustomerByID(id)) {
					msg = "Delete Customer Success";
					out.print(id);
					myCustomerManager.saveByteData();
				} else {
					msg = "Delete Customer Unsuccess";
				}

				target = "ManageCustomerServlet?mode=view";
				request.setAttribute("msg", msg);
			}

			RequestDispatcher requestDispatch = request.getRequestDispatcher(target);
			requestDispatch.forward(request, response);

		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
