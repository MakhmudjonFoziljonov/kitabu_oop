package api.kitabu.service;

import api.kitabu.dto.GenreDTO;
import api.kitabu.dto.GenreDTOList;
import api.kitabu.dto.GenreResponse;
import api.kitabu.entity.GenreEntity;
import api.kitabu.enums.BookLanguage;
import api.kitabu.repository.GenreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GenreService {
    public String createGenre(GenreDTO genreDTO) {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setTitleUz(genreDTO.titleUz());
        genreEntity.setTitleRu(genreDTO.titleRu());
        genreEntity.setTitleEn(genreDTO.titleEn());
        GenreRepository.genreEntities.add(genreEntity);
        return "Genre created";
    }

    public String updateGenre(UUID genreId, GenreDTO genreDTO) {
        GenreEntity genreEntity = getGenreById(genreId);
        int index = GenreRepository.genreEntities.indexOf(genreEntity);
        genreEntity.setTitleUz(genreDTO.titleUz());
        genreEntity.setTitleRu(genreDTO.titleRu());
        genreEntity.setTitleEn(genreDTO.titleEn());
        GenreRepository.genreEntities.set(index, genreEntity);
        return "Genre updated";
    }

    public GenreEntity getGenreById(UUID genreId) {
        return GenreRepository.genreEntities.stream().filter(genreEntity -> genreEntity.getId().equals(genreId))
                .findFirst().orElse(null);

    }

    public String deleteGenre(UUID genreId) {
        return GenreRepository.genreEntities.remove(getGenreById(genreId)) ? "Genre deleted" : "Genre not deleted";
    }

    public List<GenreDTOList> listGenre(BookLanguage bookLanguage) {
        List<GenreDTOList> genreDTOS = new ArrayList<>();
        GenreRepository.genreEntities
                .forEach(genreEntity -> {
                    GenreDTOList genreDTO = new GenreDTOList(genreEntity.getId(),
                            switch (bookLanguage) {
                                case EN -> genreEntity.getTitleEn();
                                case RU -> genreEntity.getTitleRu();
                                case UZ -> genreEntity.getTitleUz();
                            });
                    genreDTOS.add(genreDTO);
                });
        return genreDTOS;
    }

    public StringBuilder getNames(List<UUID> genreIds) {
        StringBuilder names = new StringBuilder();
        for (UUID genreId : genreIds) {
            for (GenreEntity genreEntity : GenreRepository.genreEntities) {
                if (genreEntity.getId().equals(genreId)) {
                    names.append(genreEntity.getTitleUz()).append(" ");
                }
            }
        }
        return names;
    }

    public GenreResponse getGenreByIdLanguage(UUID genreId, BookLanguage bookLanguage) {
        var entity = getGenreById(genreId);
        return new GenreResponse(entity.getId(),
                switch (bookLanguage) {
                    case UZ -> entity.getTitleUz();
                    case RU -> entity.getTitleRu();
                    case EN -> entity.getTitleEn();
                });
    }
}
