package transformer;


import dto.SellerBuyerAccountDTO;

import model.SellerBuyerAccount;

public class SellerBuyerAccountTransformer {
	public static SellerBuyerAccountDTO transform(model.Messages message){
		SellerBuyerAccountDTO sellerBuyerAccountDTO = new SellerBuyerAccountDTO();
		
		if(message.getSendBy().getSbaId() != null){
			sellerBuyerAccountDTO.setSbaId(message.getSendBy().getSbaId().toString());
		}
		if(message.getSendBy().getName() != null){
			sellerBuyerAccountDTO.setName(message.getSendBy().getName().toString());
		}
		
		return sellerBuyerAccountDTO;
		
	}

}
