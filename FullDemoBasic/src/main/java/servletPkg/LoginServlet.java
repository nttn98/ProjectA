package servletPkg;

import configPkg.ConfigInfo;
import entity.Customer;
import entity.Product;
import manager.CustomerManager;
import manager.ProductManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			// get context path
//			ServletContext servletctx = request.getServletContext();
//			System.out.println("context-----------" + servletctx.getRealPath("/"));
//			String ctxFullPath = servletctx.getRealPath("\\");
//			ConfigInfo.setCtxRealPath(ctxFullPath);

			CustomerManager myCustomerManager = new CustomerManager();
			int countCust = myCustomerManager.getByteData();

			ArrayList<Customer> listCustomers = myCustomerManager.getListCustomers();

			String adminUser = "admin";
			String adminPass = "admin";

			String mode = request.getParameter("mode");
			String target = "home.jsp";
			String msg = "nothing";

			if (mode.equals("login")) {
				int flag = 0;
				String userName = request.getParameter("userName");
				String userPass = request.getParameter("userPassword");
				if (userName.equals(adminUser) && userPass.equals(adminPass)) {
					flag = 1;
				} else {

					for (int i = 0; i < listCustomers.size(); i++) {
						String customerUser = listCustomers.get(i).getCustomerUserName();
						String customerPass = listCustomers.get(i).getCustomerPass();
						if (userName.equals(customerUser) && userPass.equals(customerPass)) {
							flag = 2;
						}
					}

				}
				if (flag == 1) {
					target = "home.jsp";
					msg = "Login Success";
					HttpSession mySession = request.getSession();
					mySession.setAttribute("logedUser", userName);
				} else {
					if (flag == 2) {
						target = "viedeli.jsp";
						msg = "Login Success";
						HttpSession mySession = request.getSession();
						mySession.setAttribute("logedUser", userName);
					} else {
						target = "login.jsp";
						msg = "Login Failed";
					}
				}
			}

			if (mode.equals("logout")) {

				HttpSession mySession = request.getSession();
				mySession.removeAttribute("logedUser");

				target = "login.jsp";
				msg = "User loged out";

			}
			
			if(mode.equals("homeOnly"))
			{
				target = "viedeli.jsp";
			}

			ProductManager myProductManager = new ProductManager();
			int count = myProductManager.getByteData();
			ArrayList<Product> listProduct = myProductManager.getListProduct();			
			request.setAttribute("listProduct", listProduct);
			
			
			request.setAttribute("msg", msg);
			RequestDispatcher reqDispatch = request.getRequestDispatcher(target);
			reqDispatch.forward(request, response);

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
