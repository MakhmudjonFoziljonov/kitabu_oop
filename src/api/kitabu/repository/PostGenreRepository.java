package api.kitabu.repository;

import api.kitabu.entity.PostGenreEntity;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class PostGenreRepository {
    public static List<PostGenreEntity> postGenreEntities = new LinkedList<>();

    static {
        PostGenreEntity postGenreEntity = new PostGenreEntity();
        postGenreEntity.setId(UUID.randomUUID());
        postGenreEntity.setPostId(UUID.fromString("ed999475-8519-4c49-b0ad-13ecb0d379be"));
        postGenreEntity.setGenreId(UUID.fromString("ed999475-6519-4c49-b0ad-13ecb0d379be"));
        postGenreEntities.add(postGenreEntity);
    }
}
