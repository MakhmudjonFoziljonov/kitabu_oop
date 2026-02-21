package api.kitabu.dto;

import api.kitabu.enums.LikeStatus;
import lombok.Builder;

import java.util.UUID;
@Builder
public record PostLikeRequest(
        UUID profileId,
        UUID postId,
        LikeStatus likeStatus
) {
}
