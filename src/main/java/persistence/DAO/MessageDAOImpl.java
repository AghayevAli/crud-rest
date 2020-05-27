package persistence.DAO;

import exception.DataNotFoundException;
import persistence.entity.Message;
import persistence.model.MessageModel;
import utility.EntityManagerConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class MessageDAOImpl implements MessageDAO {
    @Override
    public MessageModel getMessage(long id) {
        EntityManager entityManager = EntityManagerConfig.entityOpen("start");
        entityManager.getTransaction().begin();
        Message message = entityManager.find(Message.class, id);
        if (message == null)
            throw new DataNotFoundException("Message with id " + id + " not found");
        MessageModel messageModel = new MessageModel(message.getId(), message.getMessage(), message.getAuthor());
        return messageModel;
    }

    @Override
    public void deleteMessage(long id) {
        EntityManager entityManager = EntityManagerConfig.entityOpen("start");
        entityManager.getTransaction().begin();
        Message message = entityManager.find(Message.class, id);
        entityManager.remove(message);
        entityManager.getTransaction().commit();
    }

    @Override
    public void editMessage(MessageModel messageModel) {
        EntityManager entityManager = EntityManagerConfig.entityOpen("start");
        entityManager.getTransaction().begin();
        Message message = entityManager.find(Message.class, messageModel.getId());
        message.setMessage(messageModel.getMessage());
        message.setAuthor(messageModel.getAuthor());
        entityManager.getTransaction().commit();
    }

    @Override
    public void addNewMessage(MessageModel message) {
        Message messageEntity = new Message();
        messageEntity.getMessageEntity(message);

        EntityManager entityManager = EntityManagerConfig.entityOpen("start");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(messageEntity);
        try {
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List<MessageModel> getAllMessages() {
        EntityManager entityManager = EntityManagerConfig.entityOpen("start");

        String query = "select s from Student s";
        List<Message> messageList = entityManager.createQuery(query).getResultList();
        List<MessageModel> messages = new ArrayList<>();
        for (Message message : messageList)
            messages.add(new MessageModel(message.getId(), message.getMessage(), message.getAuthor()));
        return messages;
    }
}
