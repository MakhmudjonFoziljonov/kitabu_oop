package api.kitabu.repository;

import api.kitabu.entity.GenreEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GenreRepository {

    public static List<GenreEntity> genreEntities = new ArrayList<>();

    static {
        GenreEntity genreEntity1 = new GenreEntity(UUID.fromString("b278925a-2549-4da5-a6ff-3ab70a0fe085"), "Fiction", "Художественная литература", "Hududiy adabiyot");
        GenreEntity genreEntity2 = new GenreEntity(UUID.fromString("c7c627a9-abac-4529-8489-49054371d5b1"), "Non-Fiction", "Научная литература", "Ilmiy adabiyot");
        GenreEntity genreEntity3 = new GenreEntity(UUID.fromString("c0136547-739d-4061-97cc-01786c415f74"), "Biography", "Биография", "Biografiya");
        GenreEntity genreEntity4 = new GenreEntity(UUID.fromString("bf7edcb2-1e7d-4816-ad3c-5c9837b17e09"), "Science Fiction", "Научная фантастика", "Ilmiy fantastika");
        GenreEntity genreEntity5 = new GenreEntity(UUID.fromString("ba0774c6-6a07-405a-ab8d-5f9512233018"), "Fantasy", "Фэнтези", "Fantaziya");
        GenreEntity genreEntity6 = new GenreEntity(UUID.fromString("4c244097-317b-4fcd-8097-83117bf34a9e"), "Mystery", "Детектив", "Detektiv");
        GenreEntity genreEntity7 = new GenreEntity(UUID.fromString("45a6adeb-1c39-4d5b-be9c-a0ad08032790"), "Horror", "Ужасы", "Qo`rqinchli");
        GenreEntity genreEntity8 = new GenreEntity(UUID.fromString("ed999475-6519-4c49-b0ad-13ecb0d379be"), "Romance", "Романтика", "Romantika");
        GenreEntity genreEntity9 = new GenreEntity(UUID.fromString("72592157-7442-469e-8877-e2a4e136f42e"), "Historical", "Исторический", "Tarixiy");
        genreEntities.add(genreEntity1);
        genreEntities.add(genreEntity2);
        genreEntities.add(genreEntity3);
        genreEntities.add(genreEntity4);
        genreEntities.add(genreEntity5);
        genreEntities.add(genreEntity6);
        genreEntities.add(genreEntity7);
        genreEntities.add(genreEntity8);
        genreEntities.add(genreEntity9);
    }
}
