package persistence.model;

public class MessageModel {
    private long id;
    private String message;
    private String author;

    public MessageModel(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    public MessageModel() {
    }

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

    @Override
    public String toString() {
        return "MessageModel{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
