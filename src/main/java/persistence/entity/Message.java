package persistence.entity;

import persistence.model.MessageModel;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String message;

    private String author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void getMessageEntity(MessageModel messageModel) {
        this.id = messageModel.getId();
        this.message = messageModel.getMessage();
        this.author = messageModel.getAuthor();
    }
}
