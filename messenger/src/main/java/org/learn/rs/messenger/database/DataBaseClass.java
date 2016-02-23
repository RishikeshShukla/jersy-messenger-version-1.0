package org.learn.rs.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.learn.rs.messenger.model.Message;
import org.learn.rs.messenger.model.Profile;

public class DataBaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getAllMessages() {
		return messages;
	}

	public static Map<Long, Profile> gatAllProfiles() {
		return profiles;
	}
}
