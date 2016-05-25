package cumt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cumt.dao.GuitarDao;
import cumt.pojo.Guitar;

public class GuitarServlet extends HttpServlet {

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GuitarDao dao=new GuitarDao();
		String pageNo=request.getParameter("pageNo");
				Guitar guitar=dao.getGuitarByNum(pageNo);
				
				if(guitar!=null){
					request.setAttribute("guitar",guitar);
				}
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
