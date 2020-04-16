package dao;
import java.util.List;

import model.Messages;
public interface MessagesDao {
	public List<Messages> getAllMessages(Messages messages);
	public Boolean sendMessage(Messages messages);
}
