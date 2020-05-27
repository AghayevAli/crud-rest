package persistence.DAO;

import persistence.model.MessageModel;

import java.util.List;

public interface MessageDAO {
    List<MessageModel> getAllMessages();

    void addNewMessage(MessageModel message);

    void editMessage(MessageModel messageModel);

    void deleteMessage(long id);

    MessageModel getMessage(long id);
}
