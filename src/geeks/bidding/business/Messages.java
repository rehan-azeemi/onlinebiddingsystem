package geeks.bidding.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import daoImpl.MessagesDaoImpl;
import daoImpl.PostedBidProductsAndSellerBuyerAccountDaoImpl;
import daoImpl.PostedBidProductsDaoImpl;
import daoImpl.SellerBuyerAccountDaoImpl;
import dto.MessagesDTO;
import dto.PostedBidProductsDTO;
import dto.SellerBuyerAccountDTO;
import dto.UsersAndProductsDTO;
import hibernate_utility.EncodeDecode;
import model.PostedBidProducts;
import model.PostedBidProductsAndSellerBuyerAccount;
import model.SellerBuyerAccount;
import transformer.MessagesTransformer;
import transformer.PostedBidProductsTransformer;
import transformer.SellerBuyerAccountTransformer;
import transformer.UsersAndProductsTransformer;
import model.*;

/**
 * Servlet implementation class Messages
 */
@WebServlet("/Messages")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostedBidProductsAndSellerBuyerAccountDaoImpl postedBidProductsAndSellerBuyerAccountDaoImpl = new PostedBidProductsAndSellerBuyerAccountDaoImpl();
		PostedBidProducts postedBidProducts = null;
		List<PostedBidProductsDTO> postedBidProductsDTOList = new ArrayList<>();
		PrintWriter pw = response.getWriter();
		
		
		if(request.getParameter("type") != null){
			String action = request.getParameter("type").toString();
				
			if(action.equals("getAllUsers")){
					HttpSession session = request.getSession();
					SellerBuyerAccount sellerBuyerAccount = new SellerBuyerAccount();
					sellerBuyerAccount.setSbaId(Integer.parseInt(session.getAttribute("SBAid").toString()));
					
					List<model.Messages> sendersList = new SellerBuyerAccountDaoImpl().getAllUsers(sellerBuyerAccount);
					
					List<SellerBuyerAccountDTO> sellerBuyerAccountDTOList = new ArrayList<>();
					
					for(int i=0; i<sendersList.size(); i++){
						SellerBuyerAccountDTO sellerBuyerAccountDTO = new SellerBuyerAccountDTO();
						sellerBuyerAccountDTO = SellerBuyerAccountTransformer.transform(sendersList.get(i));
						sellerBuyerAccountDTOList.add(sellerBuyerAccountDTO);
					}
					
					Gson gson = new Gson();
					String data = gson.toJson(sellerBuyerAccountDTOList);
					System.out.println(data);
					response.setContentType("application/json");
					pw.write(data);
				}
			else if(action.equals("getAllBidedProducts")){
				HttpSession session = request.getSession();
				SellerBuyerAccount sellerBuyerAccount = new SellerBuyerAccount();
				sellerBuyerAccount.setSbaId(Integer.parseInt(session.getAttribute("SBAid").toString()));
				List<PostedBidProductsAndSellerBuyerAccount> postedBidProductsAndSellerBuyerAccountList = postedBidProductsAndSellerBuyerAccountDaoImpl.getAllBidedProducts(sellerBuyerAccount);
				
				for(int i=0; i<postedBidProductsAndSellerBuyerAccountList.size(); i++){
					postedBidProducts = new PostedBidProducts();
					postedBidProducts = postedBidProductsAndSellerBuyerAccountList.get(i).getPostedBidProducts();
					PostedBidProductsDTO postedBidProductsDTO = PostedBidProductsTransformer.transform(postedBidProducts);
					postedBidProductsDTOList.add(postedBidProductsDTO);
				}
				
				Gson gson = new Gson();
				response.setContentType("application/json");
				String data = gson.toJson(postedBidProductsDTOList);
				System.out.println(data);
				pw.write(data);
			}
			else if(action.equals("getAllChat") && request.getParameter("sellerBuyerAccountId") != null){
				
				MessagesDaoImpl messagesDaoImpl = new MessagesDaoImpl();
				
				HttpSession session = request.getSession();
				SellerBuyerAccount sendBy = new SellerBuyerAccount();
				sendBy.setSbaId(Integer.parseInt(session.getAttribute("SBAid").toString()));
				
				SellerBuyerAccount sendTo = new SellerBuyerAccount();
				sendTo.setSbaId(Integer.parseInt(request.getParameter("sellerBuyerAccountId").toString()));
				
				model.Messages messages = new model.Messages();
				
				messages.setSendBy(sendBy);
				messages.setSendTo(sendTo);
				
				List<model.Messages> messagesList = messagesDaoImpl.getAllMessages(messages);
				
				List<MessagesDTO> MessagesDTOList = new ArrayList<>();
				
				for(int i=0; i<messagesList.size(); i++){
					MessagesDTO messagesDTO = new MessagesDTO();
					
					messagesDTO = MessagesTransformer.transform(messagesList.get(i));
					MessagesDTOList.add(messagesDTO);
				}
				
				response.setContentType("application/json");
				
				Gson gson = new Gson();
				String data = gson.toJson(MessagesDTOList);
				System.out.println(data);
				
				pw.write(data);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("type") != null){
			String action = request.getParameter("type").toString();
			PrintWriter pw = response.getWriter();
			
			if(action.equals("sendMessages") && request.getParameter("sendTo") != null && request.getParameter("msg") != null){
				HttpSession session = request.getSession();
				SellerBuyerAccount sendBy = new SellerBuyerAccount();
				sendBy.setSbaId(Integer.parseInt(session.getAttribute("SBAid").toString()));
				
				SellerBuyerAccount sendTo = new SellerBuyerAccount();
				sendTo.setSbaId(Integer.parseInt(request.getParameter("sendTo").toString()));
				
				model.Messages message = new model.Messages();
				message.setMessage(request.getParameter("msg").toString());
				message.setStatus(1);
				message.setSendBy(sendBy);
				message.setSendTo(sendTo);
				message.setMessageArrivalTime(new Date(System.currentTimeMillis()));
				
				MessagesDaoImpl messagesDaoImpl = new MessagesDaoImpl();
				
				Boolean status = messagesDaoImpl.sendMessage(message);
				
				if(status){
					pw.write("success");
				}
			}
		}
	}

}
