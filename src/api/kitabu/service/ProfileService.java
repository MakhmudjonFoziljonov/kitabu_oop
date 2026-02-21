package api.kitabu.service;

import api.kitabu.entity.ProfileEntity;
import api.kitabu.enums.ProfileRole;
import api.kitabu.repository.ProfileRepository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProfileService {

    public String register(String name, String surname, String password, String phone) {
        if (ifExists(phone, password)) {
            return "Student is exists";
        }
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName(name);
        profileEntity.setSurname(surname);
        profileEntity.setPassword(password);
        profileEntity.setPhone(phone);
        profileEntity.setRole(ProfileRole.USER);
        ProfileRepository.profileEntityList.add(profileEntity);
        return "Profile added";
    }

    public ProfileEntity login(String phone, String password) {
        for (ProfileEntity profileEntity : ProfileRepository.profileEntityList) {
            if (profileEntity.getPhone().equals(phone) && profileEntity.getPassword().equals(password)) {
                return profileEntity;
            }
        }
        return null;
    }

    public boolean ifExists(String phone, String password) {
        Optional<ProfileEntity> first = ProfileRepository.profileEntityList.stream().filter(profileEntity -> profileEntity.getPhone().equals(phone)
                && profileEntity.getPassword().equals(password)).findFirst();
        return first.isPresent();
    }

    public List<ProfileEntity> profileList() {
        return ProfileRepository.profileEntityList;
    }

   /* public ProfileDTO getProfileById(UUID profileId) {
        ProfileEntity entity = getProfile(profileId);
        return new ProfileDTO(entity.getName(),
                entity.getSurname(),
                entity.getPhone());
    }
*/

    public ProfileEntity getProfile(UUID profileId) {
        return ProfileRepository.profileEntityList.stream().filter(item -> item.getId().equals(profileId)).findFirst().orElse(null);
    }

    public String updateProfile(UUID id, String phone) {
        ProfileEntity entity = getProfile(id);
        int i = ProfileRepository.profileEntityList.indexOf(entity);
        entity.setPhone(phone);
        ProfileRepository.profileEntityList.set(i, entity);
        return "Phone updated!";
    }

    public String deleteProfile(UUID id) {
        ProfileEntity profileEntity = getProfile(id);
        int index = ProfileRepository.profileEntityList.indexOf(profileEntity);
        profileEntity.setVisible(Boolean.FALSE);
        ProfileRepository.profileEntityList.set(index, profileEntity);
        return "Profile deleted!";
    }
}
