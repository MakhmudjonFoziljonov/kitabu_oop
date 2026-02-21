package api.kitabu.entity;

import api.kitabu.enums.LikeStatus;

import java.util.UUID;

public class PostLikeEntity {
    private UUID id;
    private UUID profileId;
    private ProfileEntity profile;
    private UUID postId;
    private PostEntity post;
    private LikeStatus status;

    public LikeStatus getStatus() {

        return status;
    }

    public void setStatus(LikeStatus status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProfileId() {
        return profileId;
    }

    public void setProfileId(UUID profileId) {
        this.profileId = profileId;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }
}
