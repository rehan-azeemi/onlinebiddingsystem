package geeks.bidding.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.SellerBuyerAccountDaoImpl;
import hibernate_utility.SHAEncryption;
import model.SellerBuyerAccount;

/**
 * Servlet implementation class RegisterationServlet
 */
@WebServlet("/RegisterationServlet")
public class RegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		SellerBuyerAccountDaoImpl sellerBuyerAccountDaoImpl = new SellerBuyerAccountDaoImpl();
		SellerBuyerAccount sellerBuyerAccount = new SellerBuyerAccount();
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		sellerBuyerAccount.setEmail(email);

		if (!email.equals("") && sellerBuyerAccountDaoImpl.emailVerification(sellerBuyerAccount)) {

			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String password = request.getParameter("password");
			String question = request.getParameter("question");
			String answer = request.getParameter("answer");
			String contact = request.getParameter("contact");
			String address = request.getParameter("address");

			if (!fname.equals("") && !lname.equals("") && !email.equals("") && !password.equals("")
					&& !question.equals("") && !answer.equals("") && !contact.equals("") && !address.equals("")) {
				sellerBuyerAccount.setEmail(email);
				sellerBuyerAccount.setName(fname + " " + lname);
				sellerBuyerAccount.setPassword(SHAEncryption.passwordEncryption(password));
				sellerBuyerAccount.setQuestion(question);
				sellerBuyerAccount.setAnswer(answer);
				sellerBuyerAccount.setContact(contact);
				sellerBuyerAccount.setAddress(address);

				Boolean CheckRegisteration = sellerBuyerAccountDaoImpl.registeration(sellerBuyerAccount);

				if (CheckRegisteration) {
					
					pw.write("success");
				} else {
					pw.write("failed");
				}
			} else {
				System.out.println("Form is not filled");
			}

		} else {
			pw.write("email is not valid");
		}

	}

}
