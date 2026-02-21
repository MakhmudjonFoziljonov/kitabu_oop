import api.kitabu.dto.PostLikeRequest;
import api.kitabu.enums.LikeStatus;
import api.kitabu.ui.StartUI;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        StartUI startUI = new StartUI();
        startUI.run();
        /*var s = PostLikeRequest
                .builder()
                .profileId(UUID.randomUUID())
                .postId(UUID.randomUUID())
                .likeStatus(LikeStatus.LIKE)
                .build();*/
    }
}
