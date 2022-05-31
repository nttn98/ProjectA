package servletPkg;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entity.Product;
import configPkg.ConfigInfo;
import manager.ProductManager;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)

public class UpdateProductServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			ProductManager myProductManager = new ProductManager();
			int count = myProductManager.getByteData();

			String mode = request.getParameter("mode");
			String target = "home.jsp";
			// -------------------------------------------------
			if (mode.equals("view")) {

				String id = request.getParameter("id");
				Product tempProduct = myProductManager.getProductByID(id);

				target = "updateProduct.jsp";
				request.setAttribute("tempProduct", tempProduct);
			}
			// -----------------------------------------------------------
			if (mode.equals("edit")) {
				String id, name, title;
				float price;
				int quantity;

				id = request.getParameter("productID");
				name = request.getParameter("productName");
				title = request.getParameter("productTitle");
				price = Float.parseFloat(request.getParameter("productPrice"));
				quantity = Integer.parseInt(request.getParameter("productQuantity"));

				Part imgFilePart = request.getPart("fileImg");
				String imgName = id + ".jpg";
				

				Product editProduct = new Product(id, name, title, price, quantity);

				String msg = "nothing";
//				System.out.println("----------------------hhehehe------"+name);
				if (myProductManager.updateProduct(editProduct)) {
					msg = "Update Success";
					myProductManager.saveByteData();
					String imgLocation = ConfigInfo.getCtxRealPath() + "\\productImage\\";
					imgFilePart.write(imgLocation + imgName);
//					System.out.println("----------------------------"+editProduct.getProductID());
				} else {
					msg = "Update Unsuccess";
				}
				request.setAttribute("msg", msg);

				target = "ManageProductServlet?mode=view";
			}

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
