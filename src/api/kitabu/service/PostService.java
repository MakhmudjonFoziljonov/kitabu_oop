package api.kitabu.service;

import api.kitabu.dto.PostRequest;
import api.kitabu.dto.PostResponse;
import api.kitabu.dto.ProfileResponse;
import api.kitabu.entity.PostEntity;
import api.kitabu.enums.BookLanguage;
import api.kitabu.repository.PostRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;


public class PostService {
    PostGenreService postGenreService = new PostGenreService();
    RegionService regionService = new RegionService();
    ProfileService profileService = new ProfileService();

    public String createPost(PostRequest postRequest) {
        PostEntity postEntity = new PostEntity();
        postEntity.setAuthorName(postRequest.authorName());
        postEntity.setDescription(postRequest.description());
        postEntity.setBookLanguage(postRequest.bookLanguage());
        postEntity.setLatitude(postRequest.latitude());
        postEntity.setLongitude(postRequest.longitude());
        postEntity.setConditionType(postRequest.conditionType());
        postEntity.setTitle(postRequest.title());
        postEntity.setExchangeType(postRequest.exchangeType());
        postEntity.setRegionId(postRequest.regionId());
        postEntity.setProfileId(postRequest.profileId());
        postEntity.setProfile(profileService.getProfile(postRequest.profileId()));
        PostRepository.postEntityList.add(postEntity);
        postGenreService.merge(postEntity.getId(), postRequest.genreIds());
        return "Created Post!";

    }

    public List<PostResponse> postList(BookLanguage bookLanguage) {
        List<PostResponse> postResponseList = new LinkedList<>();
        PostRepository.postEntityList.forEach(postEntity -> {
//            ProfileEntity profileEntity = profileService.getProfile(postEntity.getProfileId());
            PostResponse postResponse = mapToResponse(bookLanguage).apply(postEntity);
            postResponseList.add(postResponse);
        });
        return postResponseList;
    }

    public String updatePost(UUID postId, PostRequest postRequest) {
        PostEntity postEntity = getByIdPost(postId);
        int i = PostRepository.postEntityList.indexOf(postEntity);
        postEntity.setAuthorName(postRequest.authorName());
        postEntity.setDescription(postRequest.description());
        postEntity.setBookLanguage(postRequest.bookLanguage());
        postEntity.setLatitude(postRequest.latitude());
        postEntity.setLongitude(postRequest.longitude());
        postEntity.setConditionType(postRequest.conditionType());
        postEntity.setTitle(postRequest.title());
        postEntity.setExchangeType(postRequest.exchangeType());
        postEntity.setRegionId(postRequest.regionId());
        postEntity.setProfileId(postRequest.profileId());
        postEntity.setProfile(profileService.getProfile(postRequest.profileId()));
        PostRepository.postEntityList.set(i, postEntity);
        postGenreService.merge(postId, postRequest.genreIds());
        return "Updated Post!";
    }

    public PostEntity getByIdPost(UUID postId) {
        return PostRepository.postEntityList
                .stream()
                .filter(postEntity ->
                        postEntity.getId().equals(postId))
                .findFirst().orElse(null);
    }

    public PostResponse getPostById(UUID postId, BookLanguage bookLanguage) {
        return PostRepository.postEntityList.stream().filter(entity -> entity.getId().equals(postId))
                .map(postEntity -> mapToResponse(bookLanguage).apply(postEntity)).findAny().orElse(null);
    }

   /* private PostResponse getPostResponse(PostEntity postEntity) {
        return new PostResponse(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getDescription(),
                postEntity.getAuthorName(),
                postEntity.getExchangeType(),
                postEntity.getConditionType(),
                postEntity.getBookLanguage(),
                regionService.getRegionById(postEntity.getRegionId()).getNameEn(),
                postGenreService.getGenreByPostId(postEntity.getId()),
                new ProfileResponse.ProfileShort(
                        postEntity.getProfile().getName(),
                        postEntity.getProfile().getSurname(),
                        postEntity.getProfile().getPhone()));
    }*/

    public Function<PostEntity, PostResponse> mapToResponse(BookLanguage bookLanguage) {
        return postEntity -> new PostResponse(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getDescription(),
                postEntity.getAuthorName(),
                postEntity.getExchangeType(),
                postEntity.getConditionType(),
                postEntity.getBookLanguage(),
                regionService.getByLanguageName(postEntity.getRegionId(), bookLanguage),
                postGenreService.getGenreByPostId(postEntity.getId()),
                postEntity.getVisible(),
                postEntity.getLikeCount(),
                postEntity.getDislikeCount(),
                new ProfileResponse.ProfileShort(
                        postEntity.getProfile().getName(),
                        postEntity.getProfile().getSurname(),
                        postEntity.getProfile().getPhone()));
    }

    public String deletePost(UUID postId) {
        PostEntity byIdPost = getByIdPost(postId);
        if (byIdPost.getVisible().equals(Boolean.TRUE)) {
            byIdPost.setVisible(Boolean.FALSE);
        }
        return "Post Deleted!";
    }

    public void likeCountIncrement(UUID postId) {
        PostEntity entity = getByIdPost(postId);
        int i = PostRepository.postEntityList.indexOf(entity);
        entity.setLikeCount(entity.getLikeCount() + 1);
        PostRepository.postEntityList.set(i, entity);

    }

    public void dislikeCountIncrement(UUID postId) {
        PostEntity entity = getByIdPost(postId);
        int i = PostRepository.postEntityList.indexOf(entity);
        entity.setDislikeCount(entity.getDislikeCount() + 1);
        PostRepository.postEntityList.set(i, entity);
    }

    public void likeCountDecrement(UUID postId) {
        PostEntity entity = getByIdPost(postId);
        int i = PostRepository.postEntityList.indexOf(entity);
        if (entity.getLikeCount() >= 0) {
            entity.setLikeCount(entity.getLikeCount() - 1);
        }
        PostRepository.postEntityList.set(i, entity);
    }

    public void dislikeCountDecrement(UUID postId) {
        PostEntity entity = getByIdPost(postId);
        int i = PostRepository.postEntityList.indexOf(entity);
        entity.setDislikeCount(entity.getDislikeCount() - 1);
        PostRepository.postEntityList.set(i, entity);
    }
}
