package dao;


import model.Notifications;

public interface NotificationsDao {
	Boolean sendNotificationToAllUsers(Notifications notifications);
}
