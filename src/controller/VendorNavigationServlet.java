package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnimalRescue;
import model.Vendor;

/**
 * Servlet implementation class VendorNavigationServlet
 */
@WebServlet("/vendorNavigationServlet")
public class VendorNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorNavigationServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		VendorHelper vh = new VendorHelper();
		String act = request.getParameter("doThisToItem");
		
		String path = "/viewAllVendorsServlet";
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Vendor itemToDelete = vh.searchForItemById(tempId);
				vh.deleteItem(itemToDelete);
				} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
				} 
		} 
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Vendor itemToEdit = vh.searchForItemById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/editVendor.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} 
		else if (act.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	
		if (act.equals("delete")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Vendor itemToDelete = vh.searchForItemById(tempId);
			vh.deleteItem(itemToDelete);
		}
	}
}
