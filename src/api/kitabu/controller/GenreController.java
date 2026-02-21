package api.kitabu.controller;

import api.kitabu.dto.GenreDTO;
import api.kitabu.dto.GenreDTOList;
import api.kitabu.dto.GenreResponse;
import api.kitabu.enums.BookLanguage;
import api.kitabu.service.GenreService;

import java.util.List;
import java.util.UUID;

public class GenreController {
    GenreService genreService = new GenreService();

    public String createGenre(GenreDTO genreDTO) {
        return genreService.createGenre(genreDTO);
    }

    public String updateGenre(UUID genreId, GenreDTO genreDTO) {
        return genreService.updateGenre(genreId, genreDTO);
    }

    public String deleteGenre(UUID genreId) {
        return genreService.deleteGenre(genreId);
    }

    public List<GenreDTOList> listGenre(BookLanguage bookLanguage) {
        return genreService.listGenre(bookLanguage);
    }

    public GenreResponse getGenreByLanguage(UUID genreId, BookLanguage bookLanguage) {
        return genreService.getGenreByIdLanguage(genreId, bookLanguage);
    }
}
