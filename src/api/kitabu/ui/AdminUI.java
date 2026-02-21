package api.kitabu.ui;

import api.kitabu.controller.GenreController;
import api.kitabu.controller.PostController;
import api.kitabu.controller.ProfileController;
import api.kitabu.controller.RegionController;
import api.kitabu.dto.*;
import api.kitabu.entity.ProfileEntity;
import api.kitabu.entity.RegionEntity;
import api.kitabu.enums.BookLanguage;
import api.kitabu.enums.ConditionType;
import api.kitabu.enums.ExchangeType;

import java.util.*;

public class AdminUI {
    ProfileController profileController = new ProfileController();
    RegionController regionController = new RegionController();
    GenreController genreController = new GenreController();
    PostController postController = new PostController();

    public void start(ProfileEntity profileEntity) {
        while (true) {
            int menu = menu();
            switch (menu) {
                case 1 -> profileList();
                case 2 -> getProfileById();
                case 3 -> updateProfile();
                case 4 -> deleteProfile();
                case 5 -> createRegion();
                case 6 -> listRegion();
                case 7 -> updateRegion();
                case 8 -> deleteRegion();
                case 9 -> createGenre();
                case 10 -> updateGenre();
                case 11 -> deleteGenre();
                case 12 -> listGenre();
                case 13 -> createPost(profileEntity);
                case 14 -> postList();
                case 15 -> updatePost(profileEntity);
                case 16 -> getPostById();
                case 17 -> deletePost();
                case 18 -> getGenreByLanguage();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid menu");
            }
        }
    }

    private void getGenreByLanguage() {
        System.out.print("Enter genre ID: ");
        UUID genreId = UUID.fromString(new Scanner(System.in).nextLine());
        System.out.print("Enter language: ");
        BookLanguage bookLanguage = BookLanguage.valueOf(new Scanner(System.in).next().toUpperCase());
        GenreResponse genreResponse = genreController.getGenreByLanguage(genreId,bookLanguage);
        System.out.println(genreResponse);
    }

    private void deletePost() {
        System.out.print("Enter post ID: ");
        UUID postId = UUID.fromString(new Scanner(System.in).nextLine());
        String result = postController.deletePost(postId);
        System.out.println(result);
    }

    private void getPostById() {
        System.out.print("Enter PostID: ");
        UUID postId = UUID.fromString(new Scanner(System.in).nextLine());
        System.out.print("Enter language: ");
        BookLanguage bookLanguage = BookLanguage.valueOf(new Scanner(System.in).next().toUpperCase());
        PostResponse postResponse = postController.getPostById(postId, bookLanguage);
        System.out.println(postResponse);
    }

    private void updatePost(ProfileEntity profileEntity) {
        System.out.print("Enter ID:");
        UUID postId = UUID.fromString(new Scanner(System.in).nextLine());
        System.out.print("Enter post title: ");
        String title = new Scanner(System.in).nextLine();
        System.out.print("Enter post description: ");
        String description = new Scanner(System.in).nextLine();
        System.out.print("Enter post author: ");
        String author = new Scanner(System.in).nextLine();
        System.out.print("Enter post Exchange type : ");
        ExchangeType exchangeType = ExchangeType.valueOf(new Scanner(System.in).nextLine());
        System.out.print("Enter post Condition type : ");
        ConditionType conditionType = ConditionType.valueOf(new Scanner(System.in).nextLine());
        System.out.print("Enter post BookLanguage type : ");
        BookLanguage bookLanguage = BookLanguage.valueOf(new Scanner(System.in).nextLine());
        System.out.print("Enter post longitude : ");
        double longitude = new Scanner(System.in).nextDouble();
        System.out.print("Enter post latitude : ");
        double latitude = new Scanner(System.in).nextDouble();
        UUID profileId = profileEntity.getId();
        System.out.print("Enter post Region id : ");
        int regionId = new Scanner(System.in).nextInt();
        System.out.print("Enter post Genre count: ");
        int genreCount = new Scanner(System.in).nextInt();
        Set<UUID> genreIds = new TreeSet<>();
        for (int i = 0; i < genreCount; i++) {
            System.out.print("Enter Genre ID: ");
            UUID genreId = UUID.fromString(new Scanner(System.in).nextLine());
            genreIds.add(genreId);
        }
        String result = postController.updatePost(postId, new PostRequest(
                title,
                description,
                author,
                exchangeType,
                conditionType,
                bookLanguage,
                longitude, latitude,
                profileId,
                regionId,
                genreIds));
        System.out.println(result);

    }

    private void postList() {
        System.out.print("Enter language: ");
        BookLanguage bookLanguage = BookLanguage.valueOf(new Scanner(System.in).nextLine().toUpperCase());
        List<PostResponse> postResponses = postController.postList(bookLanguage);
        postResponses.forEach(System.out::println);
    }

    private void createPost(ProfileEntity profileEntity) {
        System.out.print("Enter post title: ");
        String title = new Scanner(System.in).nextLine();
        System.out.print("Enter post description: ");
        String description = new Scanner(System.in).nextLine();
        System.out.print("Enter post author: ");
        String author = new Scanner(System.in).nextLine();
        System.out.print("Enter post Exchange type : ");
        ExchangeType exchangeType = ExchangeType.valueOf(new Scanner(System.in).nextLine());
        System.out.print("Enter post Condition type : ");
        ConditionType conditionType = ConditionType.valueOf(new Scanner(System.in).nextLine());
        System.out.print("Enter post BookLanguage type : ");
        BookLanguage bookLanguage = BookLanguage.valueOf(new Scanner(System.in).nextLine());
        System.out.print("Enter post longitude : ");
        double longitude = new Scanner(System.in).nextDouble();
        System.out.print("Enter post latitude : ");
        double latitude = new Scanner(System.in).nextDouble();
        UUID profileId = profileEntity.getId();
        System.out.print("Enter post Region id : ");
        int regionId = new Scanner(System.in).nextInt();
        System.out.print("Enter post Genre count: ");
        int genreCount = new Scanner(System.in).nextInt();
        Set<UUID> genreIds = new TreeSet<>();
        for (int i = 0; i < genreCount; i++) {
            System.out.print("Enter Genre ID: ");
            UUID genreId = UUID.fromString(new Scanner(System.in).nextLine());
            genreIds.add(genreId);
        }
        String result = postController.createPost(new PostRequest(
                title,
                description,
                author,
                exchangeType,
                conditionType,
                bookLanguage,
                longitude, latitude,
                profileId,
                regionId,
                genreIds));
        System.out.println(result);
    }

    private void listGenre() {
        System.out.print("Enter language: ");
        BookLanguage bookLanguage = BookLanguage.valueOf(new Scanner(System.in).nextLine().toUpperCase());
        List<GenreDTOList> genreDTOS = genreController.listGenre(bookLanguage);
        genreDTOS.forEach(System.out::println);
    }

    private void deleteGenre() {
        System.out.print("Enter Genre ID: ");
        Scanner scanner = new Scanner(System.in);
        UUID genreId = UUID.fromString(scanner.next());
        System.out.println(genreController.deleteGenre(genreId));
    }

    private void updateGenre() {
        System.out.print("Enter genre id: ");
        Scanner scanner = new Scanner(System.in);
        UUID genreId = UUID.fromString(scanner.next());
        System.out.print("Enter genre titleUz: ");
        String titleUz = new Scanner(System.in).nextLine();
        System.out.print("Enter genre titleRu: ");
        String titleRu = new Scanner(System.in).nextLine();
        System.out.print("Enter genre titleEn: ");
        String titleEn = new Scanner(System.in).nextLine();
        String result = genreController.updateGenre(genreId, new GenreDTO(titleUz, titleRu, titleEn));
        System.out.print(result);

    }

    private void createGenre() {
        System.out.print("Enter genre titleUz: ");
        String titleUz = new Scanner(System.in).nextLine();
        System.out.print("Enter genre titleRu: ");
        String titleRu = new Scanner(System.in).nextLine();
        System.out.print("Enter genre titleEn: ");
        String titleEn = new Scanner(System.in).nextLine();
        String result = genreController.createGenre(new GenreDTO(titleUz, titleRu, titleEn));
        System.out.println(result);

    }

    private void deleteRegion() {
        System.out.print("Enter region ID: ");
        Scanner scanner = new Scanner(System.in);
        int regionId = scanner.nextInt();
        String result = regionController.deleteRegion(regionId);
        System.out.println(result);
    }

    private void updateRegion() {
        System.out.print("Enter region id: ");
        Scanner scanner = new Scanner(System.in);
        int regionId = scanner.nextInt();
        System.out.print("Enter region nameUz: ");
        String nameUz = new Scanner(System.in).nextLine();
        System.out.print("Enter region nameRu: ");
        String nameRu = new Scanner(System.in).nextLine();
        System.out.print("Enter region nameEn: ");
        String nameEn = new Scanner(System.in).nextLine();
        String result = regionController.updateRegion(regionId, new RegionDTO(nameUz, nameRu, nameEn));
        System.out.print(result);
    }


    private void listRegion() {
        List<RegionDTO> regionDTOS = regionController.listRegion();
        regionDTOS.forEach(System.out::println);
    }

    private void createRegion() {
        System.out.print("Enter region nameUz: ");
        String nameUz = new Scanner(System.in).nextLine();
        System.out.print("Enter region nameRu: ");
        String nameRu = new Scanner(System.in).nextLine();
        System.out.print("Enter region nameEn: ");
        String nameEn = new Scanner(System.in).nextLine();
        String result = regionController.createRegion(new RegionDTO(nameUz, nameRu, nameEn));
        System.out.println(result);
    }

    private void deleteProfile() {
        System.out.print("Enter Id: ");
        Scanner scanner = new Scanner(System.in);
        UUID id = UUID.fromString(scanner.next());
        String result = profileController.deleteProfile(id);
        System.out.println(result);
    }

    private void updateProfile() {
        System.out.print("Enter Id: ");
        Scanner scanner = new Scanner(System.in);
        UUID id = UUID.fromString(scanner.next());
        System.out.print("Enter new phone: ");
        String phone = scanner.next();
        String result = profileController.updateProfile(id, phone);
        System.out.println(result);
    }

    private void getProfileById() {
        System.out.print("Enter ID: ");
        Scanner scanner = new Scanner(System.in);
        UUID profileId = UUID.fromString(scanner.next());
        /*ProfileDTO profileDTO = profileController.getProfileById(profileId);
        System.out.println(profileDTO);*/
        return;
    }

    private void profileList() {
        List<ProfileEntity> profileEntityList = profileController.profileList();
        profileEntityList.forEach(System.out::println);
    }


    public int menu() {
        String menu = """
                *****Profile****
                1.Profile Lists
                2.Get Profile
                3.Update Profile
                4.Delete Profile
                *****Region****
                5.Create Region
                6.Region Lists
                7.Update Region
                8.Delete Region
                *****Genre****
                9.Create Genre
                10.Update Genre
                11.Delete Genre
                12.List Genre
                ******Post*****
                13.Create Post
                14.Post List
                15.Update Post
                16.Get Post By ID
                17.Delete Post
                18.Get Genre By ID
                """;
        System.out.println(menu);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return sc.nextByte();
    }
}
