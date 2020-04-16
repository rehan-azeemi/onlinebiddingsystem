package transformer;

import dto.UsersAndProductsDTO;
import model.Messages;


public class UsersAndProductsTransformer {
	public static UsersAndProductsDTO transform(Messages message){
		UsersAndProductsDTO usersAndProductsDTO = new UsersAndProductsDTO();
		if(message.getPostedBidProducts().getTitle() != null){
			usersAndProductsDTO.setPostedBidProductsName(message.getPostedBidProducts().getTitle().toString());
		}
		if(message.getSendBy().getSbaId() != null){
			usersAndProductsDTO.setSbaId(message.getSendBy().getSbaId().toString());
		}
		if(message.getSendBy().getName() != null){
			usersAndProductsDTO.setName(message.getSendBy().getName().toString());
		}
		if(message.getPostedBidProducts().getPostedBidProducts() != null){
			usersAndProductsDTO.setPostedBidProductsId(message.getPostedBidProducts().getPostedBidProducts().toString());
		}
		
		return usersAndProductsDTO;
	}
}
