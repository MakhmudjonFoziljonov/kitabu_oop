package api.kitabu.controller;

import api.kitabu.entity.ProfileEntity;
import api.kitabu.service.ProfileService;

import java.util.List;
import java.util.UUID;

public class ProfileController {
    ProfileService profileService = new ProfileService();

    public String register(String name, String surname, String password, String phone) {
        return profileService.register(name, surname, password, phone);
    }

    public ProfileEntity login(String phone, String password) {
        return profileService.login(phone, password);
    }

    public List<ProfileEntity> profileList() {
        return profileService.profileList();
    }


    /*public ProfileDTO getProfileById(UUID profileId) {
        return profileService.getProfileById(profileId);
    }*/

    public String updateProfile(UUID id, String phone) {
        return profileService.updateProfile(id, phone);
    }

    public String deleteProfile(UUID id) {
        return profileService.deleteProfile(id);
    }
}
