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
 * Servlet implementation class EditVendorServlet
 */
@WebServlet("/editVendorServlet")
public class EditVendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVendorServlet() {
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
		String vendorName = request.getParameter("vendorName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Vendor vendorToUpdate = vh.searchForItemById(tempId);
		vendorToUpdate.setVendorName(vendorName);
		vh.updateItem(vendorToUpdate);
		getServletContext().getRequestDispatcher("/viewAllVendorsServlet").forward(request, response);
	}

}
