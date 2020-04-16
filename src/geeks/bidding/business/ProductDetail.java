package geeks.bidding.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.google.gson.GsonBuilder;

import daoImpl.NotificationsDaoImpl;
import daoImpl.PostedBidProductsAndSellerBuyerAccountDaoImpl;
import daoImpl.PostedBidProductsDaoImpl;
import dto.PostedBidProductsAndSellerBuyerAccountDTO;
import dto.PostedBidProductsDTO;
import hibernate_utility.EncodeDecode;
import model.Notifications;
import model.PostedBidProducts;
import model.PostedBidProductsAndSellerBuyerAccount;
import model.SellerBuyerAccount;
import transformer.PostedBidProductsAndSellerBuyerAccountTransformer;
import transformer.PostedBidProductsTransformer;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetail() {
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
		PostedBidProductsDaoImpl postedBidProductsDaoImpl = new PostedBidProductsDaoImpl();
		PostedBidProducts postedBidProducts = new PostedBidProducts();
		PrintWriter pw = response.getWriter();

		if (request.getParameter("type") != null) {
			String action = request.getParameter("type");

			if (action.equals("viewProductDetail")) {
//				HttpSession session = request.getSession();
//				String productId = session.getAttribute("productId").toString();
				String productId = request.getParameter("productCode").toString();
				postedBidProducts.setPostedBidProducts(Integer.parseInt(EncodeDecode.decodeData(productId)));
				postedBidProducts = postedBidProductsDaoImpl.getPostedBidProductsWithId(postedBidProducts);
				PostedBidProductsDTO postedBidProductsDTO = PostedBidProductsTransformer.transform(postedBidProducts);
				Gson json = new Gson();
				response.setContentType("application/json");
				String data = json.toJson(postedBidProductsDTO);
				System.out.println(data);
				pw.write(data);
			} else if (action.equals("biddingDetail")) {
//				HttpSession session = request.getSession();
//				String productId = session.getAttribute("productId").toString();
				
				String productId = request.getParameter("productCode").toString();

				if (productId != null && !productId.equals("")) {
					postedBidProducts.setPostedBidProducts(Integer.parseInt(EncodeDecode.decodeData(productId)));
					List<PostedBidProductsAndSellerBuyerAccount> postedBidProductsAndSellerBuyerAccountList = new PostedBidProductsAndSellerBuyerAccountDaoImpl()
							.getPostedBidProductsAndSellerBuyerAccountWithProductId(postedBidProducts);
					List<PostedBidProductsAndSellerBuyerAccountDTO> postedBidProductsAndSellerBuyerAccountDTOList = new ArrayList<PostedBidProductsAndSellerBuyerAccountDTO>();

					if (postedBidProductsAndSellerBuyerAccountList != null) {
						for (int i = 0; i < postedBidProductsAndSellerBuyerAccountList.size(); i++) {
							PostedBidProductsAndSellerBuyerAccountDTO postedBidProductsAndSellerBuyerAccountDTO = PostedBidProductsAndSellerBuyerAccountTransformer
									.transform(postedBidProductsAndSellerBuyerAccountList.get(i));
							postedBidProductsAndSellerBuyerAccountDTOList
									.add(postedBidProductsAndSellerBuyerAccountDTO);
						}

						Gson gson = new Gson();
						response.setContentType("application/json");
						String data = gson.toJson(postedBidProductsAndSellerBuyerAccountDTOList);
						System.out.println(data);
						pw.write(data);
					} else {
						pw.write("nodata");
					}
				} else {
					pw.write("noproduct");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PostedBidProductsAndSellerBuyerAccountDaoImpl postedBidProductsAndSellerBuyerAccountDaoImpl = new PostedBidProductsAndSellerBuyerAccountDaoImpl();
		PostedBidProductsAndSellerBuyerAccount postedBidProductsAndSellerBuyerAccount = new PostedBidProductsAndSellerBuyerAccount();
		NotificationsDaoImpl notificationsDaoImpl = new NotificationsDaoImpl();
		PrintWriter pw = response.getWriter();
		
		if(request.getParameter("type") != null){
			String action = request.getParameter("type");
			
			if(action.equals("myBid")){
				try{
				HttpSession session = request.getSession();
				SellerBuyerAccount sellerBuyerAccount = new SellerBuyerAccount();
				PostedBidProducts postedBidProducts = new PostedBidProducts();
				sellerBuyerAccount.setSbaId(Integer.parseInt(session.getAttribute("SBAid").toString()));
				postedBidProducts.setPostedBidProducts(Integer.parseInt(EncodeDecode.decodeData(request.getParameter("productCode").toString())));
				
				Integer currentBid = Integer.parseInt(request.getParameter("currentBid").toString());
				
				postedBidProductsAndSellerBuyerAccount.setSellerBuyerAccount(sellerBuyerAccount);
				postedBidProductsAndSellerBuyerAccount.setPostedBidProducts(postedBidProducts);
				postedBidProductsAndSellerBuyerAccount.setCurrentBid(currentBid);
				
				postedBidProductsAndSellerBuyerAccountDaoImpl.setUpdatedPostedBidProductsAndSellerBuyerAccount(postedBidProductsAndSellerBuyerAccount);
				
				Notifications notifications = new Notifications();
				
				notifications.setSellerBuyerAccount(sellerBuyerAccount);
				notifications.setPostedBidProducts(postedBidProducts);
				notifications.setNotification(String.valueOf(currentBid));
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				try {
					notifications.setNotificationTime(dateFormat.parse(dateFormat.format(date)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				notificationsDaoImpl.sendNotificationToAllUsers(notifications);
				
				List<PostedBidProductsAndSellerBuyerAccount> postedBidProductsAndSellerBuyerAccountList = postedBidProductsAndSellerBuyerAccountDaoImpl.getPostedBidProductsAndSellerBuyerAccountWithProductId(postedBidProducts);
						
				List<PostedBidProductsAndSellerBuyerAccountDTO> postedBidProductsAndSellerBuyerAccountDTOList = new ArrayList<PostedBidProductsAndSellerBuyerAccountDTO>();

				if (postedBidProductsAndSellerBuyerAccountList != null) {
					for (int i = 0; i < postedBidProductsAndSellerBuyerAccountList.size(); i++) {
						PostedBidProductsAndSellerBuyerAccountDTO postedBidProductsAndSellerBuyerAccountDTO = PostedBidProductsAndSellerBuyerAccountTransformer
								.transform(postedBidProductsAndSellerBuyerAccountList.get(i));
						postedBidProductsAndSellerBuyerAccountDTOList
								.add(postedBidProductsAndSellerBuyerAccountDTO);
					}

					Gson gson = new Gson();
					response.setContentType("application/json");
					String data = gson.toJson(postedBidProductsAndSellerBuyerAccountDTOList);
					System.out.println(data);
					pw.write(data);
				} else {
					pw.write("nodata");
				}
				
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}

	}

}
