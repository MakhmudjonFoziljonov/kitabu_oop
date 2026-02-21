package api.kitabu.dto;

import api.kitabu.entity.ProfileEntity;
import api.kitabu.entity.RegionEntity;
import api.kitabu.enums.BookLanguage;
import api.kitabu.enums.ConditionType;
import api.kitabu.enums.ExchangeType;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record PostRequest(
        String title,
        String description,
        String authorName,
        ExchangeType exchangeType,
        ConditionType conditionType,
        BookLanguage bookLanguage,
        Double longitude,
        Double latitude,
        UUID profileId,
        Integer regionId,
        Set<UUID> genreIds
) {
}
