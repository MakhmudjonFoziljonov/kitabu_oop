package api.kitabu.service;

import api.kitabu.entity.GenreEntity;
import api.kitabu.entity.PostEntity;
import api.kitabu.entity.PostGenreEntity;
import api.kitabu.repository.PostGenreRepository;
import api.kitabu.repository.PostRepository;

import java.util.*;
import java.util.stream.Collectors;

public class PostGenreService {
    GenreService genreService = new GenreService();

    private void delete(UUID item) {
        PostGenreRepository.postGenreEntities.removeIf(
                postGenreEntity -> postGenreEntity.getGenreId().equals(item)
        );
    }

    public void merge(UUID postId, Set<UUID> newList) {
        List<UUID> oldList = PostGenreRepository.postGenreEntities.
                stream().
                filter(postGenreEntity -> postGenreEntity.getPostId().equals(postId)).
                map(PostGenreEntity::getGenreId).collect(Collectors.toCollection(LinkedList::new));

        newList.stream().filter(genreId -> !oldList.contains(genreId)).forEach(
                item -> {
                    create(postId, item);
                });
        oldList.stream().filter(genreId -> !newList.contains(genreId)).forEach(this::delete);
    }

    private static void create(UUID postId, UUID item) {
        PostGenreEntity entity = new PostGenreEntity();
        entity.setGenreId(item);
        entity.setPostId(postId);
        PostGenreRepository.postGenreEntities.add(entity);
    }

    public String getGenreByPostId(UUID postId) {
        List<UUID> listGenreId = new ArrayList<>();
        for (PostGenreEntity entity : PostGenreRepository.postGenreEntities) {
            if (entity != null && entity.getPostId().equals(postId)) {
                listGenreId.add(entity.getGenreId());
            }
        }
        return String.valueOf(genreService.getNames(listGenreId));
    }

}
