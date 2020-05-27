package service;

import persistence.DAO.MessageDAO;
import persistence.DAO.MessageDAOImpl;
import persistence.model.MessageModel;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    MessageDAO messageDAO = new MessageDAOImpl();

    @Override
    public MessageModel getMessage(long id) {
        return messageDAO.getMessage(id);
    }

    @Override
    public void deleteMessage(long id) {
        messageDAO.deleteMessage(id);
    }

    @Override
    public void editMessage(MessageModel messageModel) {
        messageDAO.editMessage(messageModel);
    }

    @Override
    public void addNewMessage(MessageModel message) {
        messageDAO.addNewMessage(message);
    }

    @Override
    public List<MessageModel> getAllMessages() {
        return messageDAO.getAllMessages();
    }
}
