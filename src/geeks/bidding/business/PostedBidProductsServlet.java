package geeks.bidding.business;

import java.io.File;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import daoImpl.PostedBidProductsDaoImpl;
import dto.CategoryDTO;
import dto.PostedBidProductsDTO;
import hibernate_utility.EncodeDecode;
import model.Category;
import model.Images;
import model.PostedBidProducts;
import model.SellerBuyerAccount;
import transformer.CategoryTransformer;
import transformer.PostedBidProductsTransformer;

/**
 * Servlet implementation class PostedBidProductsServlet
 */
@WebServlet("/PostedBidProductsServlet")
public class PostedBidProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostedBidProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostedBidProductsDaoImpl postedBidProductsDaoImpl = new PostedBidProductsDaoImpl();
		response.setContentType("application/json");
		
		if(request.getParameter("type").equals("getallcategories")){
			List<Category> categories = postedBidProductsDaoImpl.getAllCategories();
			List<CategoryDTO> categoryDTOs = new ArrayList<>();
			
			for(int i=0; i<categories.size(); i++){
				CategoryDTO categoryDTO = CategoryTransformer.transform(categories.get(i));
				categoryDTOs.add(categoryDTO);
			}
			Gson gson = new Gson();
			String categoryJson = gson.toJson(categoryDTOs);
			PrintWriter pw = response.getWriter();
			pw.write(categoryJson);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PostedBidProductsDaoImpl postedBidProductsDaoImpl = new PostedBidProductsDaoImpl();
		PostedBidProducts postedBidProducts = new PostedBidProducts();
		ArrayList<Images> imagesPathList = new ArrayList<>();
		PrintWriter pw = response.getWriter();
		
		if (ServletFileUpload.isMultipartContent(request)) {

			try {

				List<FileItem> multiparts = new ServletFileUpload(
				new DiskFileItemFactory()).parseRequest((request));

				for (FileItem item : multiparts) {

					if (!item.isFormField()) {

						String name = new File(item.getName()).getName();
						String path = "D:\\BidImages" + File.separator + String.valueOf(System.currentTimeMillis()) + name;
						item.write(new File(path));
						Images img = new Images();
						img.setPath(path);
						imagesPathList.add(img);

					} 
					
					if (item.isFormField()) {
						if (item.getFieldName().equals("title")) {
							String title = item.getString();
							postedBidProducts.setTitle(title);
							
						}
					} 
					
					if (item.isFormField()) {
						if (item.getFieldName().equals("description")) {
							String description = item.getString();
							postedBidProducts.setDescription(description);
							
						}
					} 
					
					if (item.isFormField()) {
						if (item.getFieldName().equals("category")) {
							String category = item.getString();
							Integer categoryId = Integer.parseInt(category);
							Category categoryModel = new Category();
							categoryModel.setCategoryId(categoryId);
							postedBidProducts.setCategory(categoryModel);
							
						}
					} 
					
					if (item.isFormField()) {
						if (item.getFieldName().equals("minprice")) {
							String minprice = item.getString();
							postedBidProducts.setMinPrice(Integer.parseInt(minprice));
						
						}
					}
					
					if (item.isFormField()) {
						if (item.getFieldName().equals("date")) {
							String date = item.getString();
							DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
							DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");	
							Date startBid = dateFormat.parse(dateFormat.format(new Date()));
							Date endBid = dateFormat2.parse(date);
							postedBidProducts.setEndBid(endBid);
							postedBidProducts.setStartBid(startBid);
							
						}
					}

				}
				
				HttpSession session = request.getSession();
				Integer sbaid = Integer.parseInt(session.getAttribute("SBAid").toString());
				SellerBuyerAccount sellerBuyerAccount = new SellerBuyerAccount();
				sellerBuyerAccount.setSbaId(sbaid);
				postedBidProducts.setSellerBuyerAccount(sellerBuyerAccount);
				postedBidProducts.setImagesPath(imagesPathList);
				
				Boolean status = postedBidProductsDaoImpl.addPostedBidProduct(postedBidProducts);
				
				if(status){
					pw.write("success");
				}

			} catch (Exception ex) {

				ex.printStackTrace();

			}

		}
		else if(request.getParameter("type") != null){
			String action = request.getParameter("type");
			if(action.equals("getAllPostedBidProducts")){
				List<PostedBidProducts> postedBidProductsList = postedBidProductsDaoImpl.getAllPostedBidProducts();
				List<PostedBidProductsDTO> DTOList = new ArrayList<>();
				
				for(int i=0; i<postedBidProductsList.size(); i++){
					PostedBidProducts posteBidProducts = postedBidProductsList.get(i);
					DTOList.add(PostedBidProductsTransformer.transform(posteBidProducts));
				}

				Gson json = new Gson();
				response.setContentType("application/json");
				String postedBidProductsjson = json.toJson(DTOList);
				System.out.println(postedBidProductsjson);
				pw.write(postedBidProductsjson);
				
			}
			else if(action.equals("viewProduct")){
//				HttpSession s = request.getSession();
//				s.setAttribute("productId", request.getParameter("productId").toString());
				pw.write("success");
			}
		}
	}

}
