package api.kitabu.controller;

import api.kitabu.dto.PostLikeRequest;
import api.kitabu.entity.ProfileEntity;
import api.kitabu.service.PostLikeService;

public class PostLikeController {
    PostLikeService postLikeService = new PostLikeService();
    public PostLikeRequest likeOrDislike(PostLikeRequest postLikeRequest) {
        return postLikeService.likeOrDislike(postLikeRequest);
    }

    public ProfileEntity profileLike(ProfileEntity profileEntity) {
        return postLikeService.profileLike(profileEntity);
    }
}
