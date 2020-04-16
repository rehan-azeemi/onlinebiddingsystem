package transformer;

import dto.MessagesDTO;
import model.Messages;

public class MessagesTransformer {
	public static MessagesDTO transform(Messages message){
		MessagesDTO messagesDTO = new MessagesDTO();
		
		if(message.getMessageId() != null){
			messagesDTO.setMessageId(message.getMessageId().toString());
		}
		if(message.getMessage() != null){
			messagesDTO.setMessage(message.getMessage());
		}
		if(message.getMessageArrivalTime() != null){
			messagesDTO.setMessageArrivalTime(message.getMessageArrivalTime().toString());
		}
		if(message.getSendBy().getSbaId() != null){
			messagesDTO.setSendById(message.getSendBy().getSbaId().toString());
		}
		if(message.getSendBy().getName() != null){
			messagesDTO.setSendByName(message.getSendBy().getName().toString());
		}
		if(message.getSendTo().getSbaId() != null){
			messagesDTO.setSendToId(message.getSendTo().getSbaId().toString());
		}
		if(message.getSendTo().getName() != null){
			messagesDTO.setSendToName(message.getSendTo().getName().toString());
		}
		if(message.getStatus() != null){
			messagesDTO.setStatus(message.getStatus().toString());
		}
		
		return messagesDTO;
		
	}
}
