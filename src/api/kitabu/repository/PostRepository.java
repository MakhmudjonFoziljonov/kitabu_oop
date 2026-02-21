package api.kitabu.repository;

import api.kitabu.dto.PostRequest;
import api.kitabu.entity.PostEntity;
import api.kitabu.entity.ProfileEntity;
import api.kitabu.entity.RegionEntity;
import api.kitabu.enums.BookLanguage;
import api.kitabu.enums.ConditionType;
import api.kitabu.enums.ExchangeType;
import api.kitabu.enums.ProfileRole;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PostRepository {
    public static List<PostEntity> postEntityList = new LinkedList<>();

    static {

        PostEntity postEntity = new PostEntity();
        postEntity.setId(UUID.fromString("ed999475-8519-4c49-b0ad-13ecb0d379be"));
        postEntity.setTitle("Atomic habits");
        postEntity.setDescription("NULL");
        postEntity.setAuthorName("James Clear");
        Random random = new Random();
        ExchangeType[] values = ExchangeType.values();
        ExchangeType randomValue = values[random.nextInt(values.length)];
        postEntity.setExchangeType(randomValue);

        ConditionType[] values1 = ConditionType.values();
        ConditionType randomValue1 = values1[random.nextInt(values1.length)];
        postEntity.setConditionType(randomValue1);

        BookLanguage[] values2 = BookLanguage.values();
        BookLanguage randomValue2 = values2[random.nextInt(values2.length)];
        postEntity.setBookLanguage(randomValue2);
        postEntity.setRegionId(1);

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId(UUID.fromString("ed999475-6519-4c49-b0ad-13ecb1d379be"));
        profileEntity.setName("Mahmud");
        profileEntity.setSurname("Foziljonov");
        profileEntity.setRole(ProfileRole.ADMIN);
        profileEntity.setPhone("12345");
        profileEntity.setPassword("12345");
        postEntity.setProfile(profileEntity);
        postEntity.setProfileId(UUID.fromString("ed999475-6519-4c49-b0ad-13ecb1d379be"));
        postEntityList.add(postEntity);
    }

}
