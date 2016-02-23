package org.learn.rs.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.learn.rs.messenger.database.DataBaseClass;
import org.learn.rs.messenger.model.Comment;
import org.learn.rs.messenger.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = DataBaseClass.getAllMessages();

	public MessageService() {
		Message msg1 = new Message(1, "Rishikesh", "India will win asia cup.");
		Message msg2 = new Message(2, "Jitender", "India will win world cup.");
		Message msg3 = new Message(3, "Praveen", "I dont like criket.");

		Comment comment1 = new Comment(1, "comment for message 1", "Rishikesh");
		Comment comment2 = new Comment(2, "comment for message 2", "Jitender");
		Comment comment3 = new Comment(3, "comment for message 3", "Praveen");

		msg1.addComment(comment1);
		msg2.addComment(comment2);
		msg3.addComment(comment3);
		
		messages.put(1L, msg1);
		messages.put(2L, msg2);
		messages.put(3L, msg3);
	}

	public List<Message> getMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(Long messageId) {
		return messages.get(messageId);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public String deleteMessage(Long messageId) {
		if (messages.get(messageId) != null) {
			messages.remove(messageId);
			return "message " + messageId + " has been deleted.";
		} else {
			return "message with id " + messageId + " not found.";
		}
	}

	public Message updateMessage(Message message) {
		return messages.put(message.getId(), message);
	}

	public Map<Long, Message> getAllMessages() {
		return messages;
	}
}