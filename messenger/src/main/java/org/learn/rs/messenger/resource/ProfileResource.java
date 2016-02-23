package org.learn.rs.messenger.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.learn.rs.messenger.model.Message;
import org.learn.rs.messenger.model.Profile;
import org.learn.rs.messenger.service.MessageService;
import org.learn.rs.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ProfileResource {

	private ProfileService profileService = new ProfileService();

	/*@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
*/
	@GET
	public List<Profile> getProfiles() {
		List<Profile> profiles = profileService.getAllProfiles();
		List<Profile> resultList = new ArrayList<>();
		 Map<Long, Message> messages =  new MessageService().getAllMessages();
		for(Profile profile : profiles){
			profile.addMessage(messages.get(profile.getId()));
			
			resultList.add(profile);
		}
		return resultList;
	}

	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}

	@GET
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId") Long id) {
		return profileService.getProfile(id);
	}

	@PUT
	@Path("/{profileId}")
	public Profile updateprofile(@PathParam("profileId") Long profileId, Profile profile) {
		profile.setId(profileId);
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{profileId}")
	public Profile deleteProfile(@PathParam("profileId") Long profileId) {
		return profileService.removeProfile(profileId);
	}

}