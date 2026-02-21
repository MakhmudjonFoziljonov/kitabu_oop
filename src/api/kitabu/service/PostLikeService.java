package api.kitabu.service;

import api.kitabu.dto.PostLikeRequest;
import api.kitabu.entity.PostLikeEntity;
import api.kitabu.entity.ProfileEntity;
import api.kitabu.enums.LikeStatus;
import api.kitabu.repository.PostLikeRepository;

import java.util.UUID;

public class PostLikeService {
    PostService postService = new PostService();

    public PostLikeRequest likeOrDislike(PostLikeRequest postLikeRequest) {
        PostLikeEntity entity = getById(postLikeRequest.postId(), postLikeRequest.profileId());
        if (entity != null) {
            if (postLikeRequest.likeStatus().equals(LikeStatus.LIKE)) {
                if (entity.getStatus().equals(LikeStatus.LIKE)) {
                    PostLikeRepository.postLikeEntities.remove(entity);
                    postService.likeCountDecrement(entity.getPostId());
                }
            } else if (postLikeRequest.likeStatus().equals(LikeStatus.DISLIKE)) {
                if (entity.getStatus().equals(LikeStatus.DISLIKE)) {
                    PostLikeRepository.postLikeEntities.remove(entity);
                    postService.dislikeCountDecrement(entity.getPostId());
                }
            }
        } else {
            if (postLikeRequest.likeStatus().equals(LikeStatus.LIKE)) {
                PostLikeEntity postLikeEntity = new PostLikeEntity();
                postLikeEntity.setStatus(postLikeRequest.likeStatus());
                postLikeEntity.setPostId(postLikeRequest.postId());
                postLikeEntity.setProfileId(postLikeRequest.profileId());
                PostLikeRepository.postLikeEntities.add(postLikeEntity);
                postService.likeCountIncrement(postLikeEntity.getPostId());
            } else if (postLikeRequest.likeStatus().equals(LikeStatus.DISLIKE)) {
                PostLikeEntity postLikeEntity = new PostLikeEntity();
                postLikeEntity.setStatus(postLikeRequest.likeStatus());
                postLikeEntity.setPostId(postLikeRequest.postId());
                postLikeEntity.setProfileId(postLikeRequest.profileId());
                PostLikeRepository.postLikeEntities.add(postLikeEntity);
                postService.dislikeCountIncrement(postLikeEntity.getPostId());

            }
        }
        return postLikeRequest;
    }

    public PostLikeEntity getById(UUID postId, UUID profileId) {
        return PostLikeRepository.postLikeEntities.stream()
                .filter(entity ->
                        entity.getPostId().equals(postId) && entity.getProfileId().equals(profileId)
                ).findAny().orElse(null);
    }

    public ProfileEntity profileLike(ProfileEntity profileEntity) {
        PostLikeRepository.postLikeEntities.stream()
                .filter(profiles -> profiles.getProfileId().equals(profileEntity.getId()));
        return null;
    }
}
