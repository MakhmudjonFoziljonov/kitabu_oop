package api.kitabu.entity;

import api.kitabu.enums.GeneralStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class BaseEntity {
    private UUID id = UUID.randomUUID();
    private Boolean visible = Boolean.TRUE;
    private GeneralStatus generalStatus = GeneralStatus.ACTIVE;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime deletedDate;
    private UUID deletedId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public GeneralStatus getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(GeneralStatus generalStatus) {
        this.generalStatus = generalStatus;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public UUID getDeletedId() {
        return deletedId;
    }

    public void setDeletedId(UUID deletedId) {
        this.deletedId = deletedId;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", visible=" + visible +
                ", generalStatus=" + generalStatus +
                ", createdDate=" + createdDate +
                ", deletedDate=" + deletedDate +
                ", deletedId=" + deletedId +
                '}';
    }
}
