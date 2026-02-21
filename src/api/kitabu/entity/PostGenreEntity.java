package api.kitabu.entity;

import java.util.UUID;

public class PostGenreEntity {
    private UUID id;
    private UUID genreId;
    private GenreEntity genreEntity;
    private UUID postId;
    private PostEntity postEntity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getGenreId() {
        return genreId;
    }

    public void setGenreId(UUID genreId) {
        this.genreId = genreId;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "PostGenreEntity{" +
                "id=" + id +
                ", genreId=" + genreId +
                ", postId=" + postId +
                '}';
    }
}
