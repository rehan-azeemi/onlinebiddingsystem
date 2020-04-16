package transformer;

import dto.MessagesDTO;
import dto.NotificationsDTO;
import model.BidNotifications;

public class NotificationsTransformer {
	public static NotificationsDTO transform(BidNotifications bidNotifications){
		NotificationsDTO notificationsDTO = new NotificationsDTO();
		
		if(bidNotifications.getNotificationId().getNotificationId() != null){
			notificationsDTO.setNotificationId(bidNotifications.getNotificationId().getNotificationId().toString());
		}
		if(bidNotifications.getNotificationId().getNotification() != null){
			notificationsDTO.setNotification(bidNotifications.getNotificationId().getNotification());
		}
		if(bidNotifications.getNotificationId().getNotificationTime() != null){
			notificationsDTO.setNotificationTime(bidNotifications.getNotificationId().getNotificationTime().toString());
		}
		if(bidNotifications.getNotificationId().getPostedBidProducts().getTitle() != null){
			notificationsDTO.setPostedBidProducts(bidNotifications.getNotificationId().getPostedBidProducts().getTitle());
		}
		if(bidNotifications.getNotificationId().getSellerBuyerAccount().getName() !=  null){
			notificationsDTO.setSellerBuyerAccount(bidNotifications.getNotificationId().getSellerBuyerAccount().getName());
		}
		if(bidNotifications.getBidNotificationId() != null){
			notificationsDTO.setBidNotificationId(bidNotifications.getBidNotificationId().toString());
		}
		
		return notificationsDTO;
	}
}
