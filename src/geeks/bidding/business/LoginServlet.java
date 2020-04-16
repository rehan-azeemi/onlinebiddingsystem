package geeks.bidding.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.SellerBuyerAccountDaoImpl;
import hibernate_utility.SHAEncryption;
import model.SellerBuyerAccount;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SellerBuyerAccountDaoImpl sellerBuyerAccountDaoImpl = new SellerBuyerAccountDaoImpl();
		SellerBuyerAccount sellerBuyerAccount = new SellerBuyerAccount();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(email != null && password != null){
			sellerBuyerAccount.setEmail(email);
			sellerBuyerAccount.setPassword(SHAEncryption.passwordEncryption(password));
			sellerBuyerAccount = sellerBuyerAccountDaoImpl.checkLogin(sellerBuyerAccount);
			
			PrintWriter pw = response.getWriter();
			
			if(sellerBuyerAccount != null){
				HttpSession session = request.getSession(true);
				session.setAttribute("email", sellerBuyerAccount.getEmail());
				session.setAttribute("name", sellerBuyerAccount.getName());
				session.setAttribute("SBAid", sellerBuyerAccount.getSbaId());
				
				pw.write("success");
			}
			else{
				pw.write("failed");
				
			}
		}
	}

}
