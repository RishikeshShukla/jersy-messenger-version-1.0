package org.learn.rs.messenger.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.learn.rs.messenger.model.Message;
import org.learn.rs.messenger.service.MessageService;

@Path("/messages")
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MessageResource {

	MessageService messageMervice = new MessageService();

	@GET
	public List<Message> getMessages() {
		List<Message> messages = messageMervice.getMessages();
		return messages;
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId) {
		Message message = messageMervice.getMessage(messageId);
		return message;
	}

	@POST
	public Message addMessage(Message message) {
		return messageMervice.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") Long messageId, Message message) {
		message.setId(messageId);
		return messageMervice.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public String deleteMessage(@PathParam("messageId") Long messageId) {
		return messageMervice.deleteMessage(messageId);
	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
