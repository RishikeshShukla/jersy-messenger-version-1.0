package org.learn.rs.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.learn.rs.messenger.database.DataBaseClass;
import org.learn.rs.messenger.model.Profile;

public class ProfileService {

	private Map<Long, Profile> profiles = DataBaseClass.gatAllProfiles();
	

	public ProfileService() {
		
		profiles.put(1L, new Profile(1L, "Rishikesh", "Shukla", "User"));
		profiles.put(2L, new Profile(1L, "Jitender", "Chahar", "User"));
		profiles.put(3L, new Profile(1L, "Praveen", "Kumar", "Admin"));

		/*System.out.println("PPPPPPPPPPP"+profiles.size());
		profiles.get(1).addMessage(messages.get(1));
		profiles.get(2).addMessage(messages.get(2));
		profiles.get(3).addMessage(messages.get(3));*/
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(Long id) {
		return profiles.get(id);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getId(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profiles.get(profile.getId()) == null) {
			return null;
		}
		profiles.put(profile.getId(), profile);
		return profile;
	}

	public Profile removeProfile(Long profileId) {
		return profiles.remove(profileId);
	}

}