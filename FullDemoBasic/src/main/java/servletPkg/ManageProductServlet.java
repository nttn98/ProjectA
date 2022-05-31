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
import javax.servlet.http.Part;

import org.eclipse.jdt.internal.compiler.env.IGenericField;

import configPkg.ConfigInfo;
import entity.Product;
import manager.ProductManager;

 
public class ManageProductServlet extends HttpServlet {


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			ProductManager myProductManager = new ProductManager();
			int count = myProductManager.getByteData();
			String mode = request.getParameter("mode");
			String target = "home.jsp";

			if (count == 0) {
				out.print(count);
				target = "newProduct.jsp";
				request.setAttribute("msg", "Do not have product !");
			} else {

				// check mode value = view
				if (mode.equals("view")) {
					ArrayList<Product> listProduct = myProductManager.getListProduct();
					System.out.println("Servlet get " + listProduct.size() + " products");
					target = "manageProductRemake.jsp";
					request.setAttribute("listProduct", listProduct);

				}
			}
			// check mode value = delete
			if (mode.equals("delete")) {
				String id = request.getParameter("id");
				String msg = "nothing";
				if (myProductManager.deleteProductByID(id)) {
					msg = "Delete Success";
					myProductManager.saveByteData();
				} else {
					msg = "Delete Unsuccess";
				}
				target = "ManageProductServlet?mode=view";

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
