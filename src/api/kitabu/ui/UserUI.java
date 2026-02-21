package api.kitabu.ui;

import api.kitabu.controller.PostLikeController;
import api.kitabu.dto.PostLikeRequest;
import api.kitabu.entity.ProfileEntity;
import api.kitabu.enums.LikeStatus;
import api.kitabu.repository.PostLikeRepository;

import java.util.Scanner;
import java.util.UUID;

public class UserUI {
    PostLikeController postLikeController = new PostLikeController();

    public void start(ProfileEntity profileEntity) {
        while (true) {
            int menu = menu();
            switch (menu) {
                case 1 -> likeOrDislike(profileEntity);
                case 2 -> profileLike(profileEntity);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private void profileLike(ProfileEntity profileEntity) {
        ProfileEntity profile = postLikeController.profileLike(profileEntity);
        System.out.print(profile);

    }

    private void likeOrDislike(ProfileEntity profileEntity) {
        System.out.print("Enter Post ID: ");
        UUID postId = UUID.fromString(new Scanner(System.in).nextLine());
        System.out.print("Status Like/Dislike: ");
        LikeStatus likeStatus = LikeStatus.valueOf(new Scanner(System.in).nextLine().toUpperCase());
        PostLikeRequest postLikeRequest = postLikeController.likeOrDislike(new PostLikeRequest(profileEntity.getId(),
                postId, likeStatus));
        System.out.println(postLikeRequest);
    }

    public int menu() {
        String menu = """
                1.Like
                2.Profile Like
                0.Exit
                """;
        System.out.println(menu);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return sc.nextByte();
    }
}
