package servletPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import configPkg.ConfigInfo;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 try (PrintWriter out = response.getWriter()) {
	            //get context path
	            
	            ServletContext servletctx=request.getServletContext();
	            System.out.println("context form Init"+servletctx.getRealPath("/"));
	            String ctxFullPath=servletctx.getRealPath("\\");
	            ConfigInfo.setCtxRealPath(ctxFullPath);

	            String target="LoginServlet?mode=homeOnly";
	           
	            RequestDispatcher reqDispatch = request.getRequestDispatcher(target);
	            reqDispatch.forward(request, response);

	        }
		
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
