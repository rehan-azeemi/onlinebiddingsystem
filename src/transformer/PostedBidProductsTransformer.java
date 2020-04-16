package transformer;

import java.util.ArrayList;
import java.util.List;

import dto.ImagesDTO;
import dto.PostedBidProductsDTO;
import hibernate_utility.EncodeDecode;
import model.Images;
import model.PostedBidProducts;

public class PostedBidProductsTransformer {
	public static PostedBidProductsDTO transform(PostedBidProducts postedBidProducts){
		PostedBidProductsDTO postedBidProductsDTO = new PostedBidProductsDTO();
		if(postedBidProducts.getPostedBidProducts() != null){
			postedBidProductsDTO.setPostedBidProducts(EncodeDecode.encodeData(postedBidProducts.getPostedBidProducts().toString()));
		}
		if(postedBidProducts.getTitle() != null){
			postedBidProductsDTO.setTitle(postedBidProducts.getTitle().toString());
		}
		if(postedBidProducts.getDescription() != null){
			postedBidProductsDTO.setDescription(postedBidProducts.getDescription().toString());
		}
		if(postedBidProducts.getCategory().getName() != null){
			postedBidProductsDTO.setCategory(postedBidProducts.getCategory().getName().toString());
		}
		if(postedBidProducts.getSellerBuyerAccount().getSbaId() != null){
			postedBidProductsDTO.setSellerBuyerAccount(postedBidProducts.getSellerBuyerAccount().getSbaId().toString());
		}
		if(postedBidProducts.getMinPrice() != null){
			postedBidProductsDTO.setMinPrice(postedBidProducts.getMinPrice().toString());
		}
		if(postedBidProducts.getStartBid() != null){
			postedBidProductsDTO.setStartBid(postedBidProducts.getStartBid().toString());
		}
		if(postedBidProducts.getEndBid() != null){
			postedBidProductsDTO.setEndBid(postedBidProducts.getEndBid().toString());
		}
		if(postedBidProducts.getImagesPath() != null){
			List<Images> imagesList = postedBidProducts.getImagesPath();
			List<ImagesDTO> imagesDTOList = new ArrayList<>();
			for(int i=0; i<imagesList.size(); i++){
				ImagesDTO imagesDTO = ImagesTransformer.transform(imagesList.get(i));
				imagesDTOList.add(imagesDTO);
			}
			
			postedBidProductsDTO.setImagesPath(imagesDTOList);
		}
		if(postedBidProducts.getSellerBuyerAccount().getName() != null){
			postedBidProductsDTO.setSellerBuyerAccountName(postedBidProducts.getSellerBuyerAccount().getName().toString());
		}
		
		return postedBidProductsDTO;
	}
}
