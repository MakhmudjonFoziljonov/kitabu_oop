package api.kitabu.dto;

import api.kitabu.enums.BookLanguage;
import api.kitabu.enums.ConditionType;
import api.kitabu.enums.ExchangeType;
import lombok.Builder;

import java.util.Set;
import java.util.UUID;
@Builder
public record PostResponse(
        UUID id,
        String title,
        String description,
        String authorName,
        ExchangeType exchangeType,
        ConditionType conditionType,
        BookLanguage bookLanguage,
        String regionName,
        String genreName,
        Boolean visible,
        Integer like,
        Integer dislike,
        ProfileResponse.ProfileShort profile

) {
}
