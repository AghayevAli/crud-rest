package controller;

import persistence.entity.Message;
import persistence.model.MessageModel;
import service.MessageService;
import service.MessageServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
public class MessageController {

    MessageService messageService = new MessageServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageModel> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageModel getMessage(@PathParam("id") long id) {
        return messageService.getMessage(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addNewMessage(MessageModel message) {
        messageService.addNewMessage(message);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editMessage(MessageModel messageModel) {
        messageService.editMessage(messageModel);
    }

    @DELETE
    @Path("/{id}")
    public void deleteMessage(@PathParam("id") long id) {
        messageService.deleteMessage(id);
    }
}

















