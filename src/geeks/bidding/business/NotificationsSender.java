package geeks.bidding.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import daoImpl.NotificationsDaoImpl;
import dto.NotificationsDTO;
import model.BidNotifications;
import model.SellerBuyerAccount;
import transformer.NotificationsTransformer;

/**
 * Servlet implementation class NotificationsSender
 */
@WebServlet("/NotificationsSender")
public class NotificationsSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationsSender() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		NotificationsDaoImpl notificationsDaoImpl = new NotificationsDaoImpl();
		PrintWriter pw = response.getWriter();
		
		if(action != null){
			if(action.equals("getNotifications")){
				response.setContentType("application/json");
				HttpSession session = request.getSession(true);	
				Integer SBAId = Integer.parseInt(session.getAttribute("SBAid").toString());
				SellerBuyerAccount sellerBuyerAccount = new SellerBuyerAccount();
				sellerBuyerAccount.setSbaId(SBAId);
				
				List<BidNotifications> bidNotificationsList = notificationsDaoImpl.getAllUnNotifyNotifications(sellerBuyerAccount);
				List<NotificationsDTO> bidNotificationsDTO = new ArrayList<>();
				NotificationsDTO bidNotificationDTO = null;
				
				for(int i=0; i<bidNotificationsList.size(); i++){
					bidNotificationDTO = NotificationsTransformer.transform(bidNotificationsList.get(i));
					bidNotificationsDTO.add(bidNotificationDTO);
				}
				
				Gson gson = new Gson();
				String data = gson.toJson(bidNotificationsDTO);
				System.out.println(data);
				pw.write(data);
			}
			else if(action.equals("updateAllNotifications")){
				response.setContentType("application/json");
				Integer bidNotificationId = Integer.parseInt(request.getParameter("notificationId").toString());
				notificationsDaoImpl.updateNotifications(bidNotificationId);
				
				pw.write("success");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
