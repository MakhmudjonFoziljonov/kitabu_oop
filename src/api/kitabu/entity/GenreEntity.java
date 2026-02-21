package api.kitabu.entity;

import java.util.UUID;

public class GenreEntity {
    private UUID id = UUID.randomUUID();
    private String titleUz;
    private String titleEn;
    private String titleRu;

    public GenreEntity() {
    }

    public GenreEntity(UUID id, String titleEn, String titleRu, String titleUz) {
        this.id = id;
        this.titleUz = titleUz;
        this.titleEn = titleEn;
        this.titleRu = titleRu;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitleUz() {
        return titleUz;
    }

    public void setTitleUz(String titleUz) {
        this.titleUz = titleUz;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleRu() {
        return titleRu;
    }

    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu;
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "id=" + id +
                ", titleUz='" + titleUz + '\'' +
                ", titleEn='" + titleEn + '\'' +
                ", titleRu='" + titleRu + '\'' +
                '}';
    }
}
