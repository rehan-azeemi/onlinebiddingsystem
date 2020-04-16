package geeks.bidding.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.SellerBuyerAccountDaoImpl;
import hibernate_utility.SHAEncryption;
import model.SellerBuyerAccount;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int countAttempts;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordServlet() {
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
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;

		for (Cookie c : cookies) {

			if (c.getName().equals("attempts")) {
				cookie = c;
				break;
			}
		}
		PrintWriter pw = response.getWriter();
		if (cookie != null) {
			if (cookie.getValue().equals("2")) {
				pw.write("banned");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SellerBuyerAccountDaoImpl sellerBuyerAccountDaoImpl = new SellerBuyerAccountDaoImpl();
		SellerBuyerAccount sellerBuyerAccount = new SellerBuyerAccount();

		if (request.getParameter("type").equals("forgotpassword")) {

			String email = request.getParameter("email");
			String question = request.getParameter("question");
			String answer = request.getParameter("answer");

			if (!email.equals("") && !question.equals("") && !answer.equals("")) {
				sellerBuyerAccount.setEmail(email);
				sellerBuyerAccount.setQuestion(question);
				sellerBuyerAccount.setAnswer(answer);

				sellerBuyerAccount = sellerBuyerAccountDaoImpl.checkPasswordRecovery(sellerBuyerAccount);

				PrintWriter pw = response.getWriter();

				if (sellerBuyerAccount != null) {
					Cookie c = new Cookie("userEmail", email);
					response.addCookie(c);
					pw.write("success");
				} else {

					Cookie[] cookies = request.getCookies();
					String value = null;
					Cookie cookie = null;

					for (Cookie c : cookies) {

						if (c.getName().equals("attempts")) {
							value = c.getValue();
							cookie = c;
							break;
						}
					}

					if (value == null) {
						countAttempts = 1;
						Cookie c = new Cookie("attempts", String.valueOf(countAttempts));
						c.setMaxAge(2 * 60);
						response.addCookie(c);
					} else {
						if (Integer.parseInt(value) == 2) {
							pw.write("banned");
						} else {
							cookie.setValue(String.valueOf(++countAttempts));
							cookie.setMaxAge(2 * 60);
							response.addCookie(cookie);
						}
					}

					pw.write("failed");

				}
			}

		} else if (request.getParameter("type").equals("newpasswordrequest")) {
			String newPassword = request.getParameter("newpassword");
			String confirmPassword = request.getParameter("confirmpassword");

			Cookie[] cookies = request.getCookies();
			Cookie cookie = null;

			for (Cookie c : cookies) {

				if (c.getName().equals("userEmail")) {
					cookie = c;
					break;
				}
			}

			if (newPassword.equals(confirmPassword) && cookie != null) {
				String password = SHAEncryption.passwordEncryption(newPassword);
				sellerBuyerAccount.setPassword(password);
				sellerBuyerAccount.setEmail(cookie.getValue().toString());

				int result = sellerBuyerAccountDaoImpl.updatePassword(sellerBuyerAccount);
				PrintWriter pw = response.getWriter();

				if (result == 1) {
					pw.write("success");
				} else {
					pw.write("failed");
				}
			}
		} else if (request.getParameter("type").equals("changepassword")) {
			String oldPassword = request.getParameter("oldpassword");
			String newPassword = request.getParameter("newpassword");
			
			HttpSession session = request.getSession();
			
			sellerBuyerAccount.setEmail(session.getAttribute("email").toString());
			sellerBuyerAccount.setPassword(SHAEncryption.passwordEncryption(oldPassword));
			
			sellerBuyerAccount = sellerBuyerAccountDaoImpl.checkOldPassword(sellerBuyerAccount);
			PrintWriter pw = response.getWriter();
			
			if(sellerBuyerAccount != null){
				sellerBuyerAccount.setEmail(session.getAttribute("email").toString());
				sellerBuyerAccount.setPassword(SHAEncryption.passwordEncryption(newPassword));
				
				int result = sellerBuyerAccountDaoImpl.updatePassword(sellerBuyerAccount);
				
				if(result == 1){
					session.invalidate();
					pw.write("success");
				}
				
			}
			else{
				pw.write("wrongoldpassword");
			}
		}
	}

}
