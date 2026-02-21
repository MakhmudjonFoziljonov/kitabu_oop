package api.kitabu.repository;


import api.kitabu.entity.ProfileEntity;
import api.kitabu.enums.ProfileRole;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ProfileRepository {
    public static List<ProfileEntity> profileEntityList = new LinkedList<>();

    static {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId(UUID.fromString("ed999475-6519-4c49-b0ad-13ecb1d379be"));
        profileEntity.setName("Mahmud");
        profileEntity.setSurname("Foziljonov");
        profileEntity.setRole(ProfileRole.ADMIN);
        profileEntity.setPhone("12345");
        profileEntity.setPassword("12345");
        profileEntityList.add(profileEntity);
    }
}
