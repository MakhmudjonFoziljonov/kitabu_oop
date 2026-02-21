package api.kitabu.entity;

import api.kitabu.enums.BookLanguage;
import api.kitabu.enums.ConditionType;
import api.kitabu.enums.ExchangeType;

import java.util.UUID;

public class PostEntity extends BaseEntity {
    private String title;
    private String description;
    private String authorName;
    private ExchangeType exchangeType;
    private ConditionType conditionType;
    private BookLanguage bookLanguage;
    private Double longitude;
    private Double latitude;
    private Integer likeCount = 0;
    private Integer dislikeCount = 0;
    private Integer viewCount = 0;
    private UUID profileId;
    private ProfileEntity profile;
    private Integer regionId;
    private RegionEntity region;

    public String getTitle() {
        return title;
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public BookLanguage getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(BookLanguage bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public UUID getProfileId() {
        return profileId;
    }

    public void setProfileId(UUID profileId) {
        this.profileId = profileId;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public RegionEntity getRegion() {
        return region;
    }

    public void setRegion(RegionEntity region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authorName='" + authorName + '\'' +
                ", exchangeType=" + exchangeType +
                ", conditionType=" + conditionType +
                ", bookLanguage=" + bookLanguage +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                ", viewCount=" + viewCount +
                ", profileId=" + profileId +
                ", profile=" + profile +
                ", regionId=" + regionId +
                ", region=" + region +
                '}';
    }
}
