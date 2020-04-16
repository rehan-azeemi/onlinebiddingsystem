package transformer;

import dto.PostedBidProductsAndSellerBuyerAccountDTO;
import hibernate_utility.EncodeDecode;
import model.PostedBidProductsAndSellerBuyerAccount;

public class PostedBidProductsAndSellerBuyerAccountTransformer {
	public static PostedBidProductsAndSellerBuyerAccountDTO transform(PostedBidProductsAndSellerBuyerAccount postedBidProductsAndSellerBuyerAccount){
		PostedBidProductsAndSellerBuyerAccountDTO postedBidProductsAndSellerBuyerAccountDTO = new PostedBidProductsAndSellerBuyerAccountDTO();
		
		if(postedBidProductsAndSellerBuyerAccount.getPostedBidProductsSellerBuyerAccountId() != null){
			postedBidProductsAndSellerBuyerAccountDTO.setPostedBidProductsSellerBuyerAccountId(postedBidProductsAndSellerBuyerAccount.getPostedBidProductsSellerBuyerAccountId().toString());
		}
		if(postedBidProductsAndSellerBuyerAccount.getPostedBidProducts().getPostedBidProducts() != null){
			postedBidProductsAndSellerBuyerAccountDTO.setPostedBidProductsId(EncodeDecode.encodeData(postedBidProductsAndSellerBuyerAccount.getPostedBidProducts().getPostedBidProducts().toString()));
		}
		if(postedBidProductsAndSellerBuyerAccount.getPostedBidProducts().getTitle() != null){
			postedBidProductsAndSellerBuyerAccountDTO.setPostedBidProductsName(postedBidProductsAndSellerBuyerAccount.getPostedBidProducts().getTitle().toString());
		}
		if(postedBidProductsAndSellerBuyerAccount.getSellerBuyerAccount().getSbaId() != null){
			postedBidProductsAndSellerBuyerAccountDTO.setSellerBuyerAccountId(EncodeDecode.encodeData(postedBidProductsAndSellerBuyerAccount.getSellerBuyerAccount().getSbaId().toString()));
		}
		if(postedBidProductsAndSellerBuyerAccount.getSellerBuyerAccount().getName() != null){
			postedBidProductsAndSellerBuyerAccountDTO.setSellerBuyerAccountName(postedBidProductsAndSellerBuyerAccount.getSellerBuyerAccount().getName().toString());
		}
		if(postedBidProductsAndSellerBuyerAccount.getCurrentBid() != null){
			postedBidProductsAndSellerBuyerAccountDTO.setCurrentBid(postedBidProductsAndSellerBuyerAccount.getCurrentBid().toString());
		}
		
		return postedBidProductsAndSellerBuyerAccountDTO;
	}
}
