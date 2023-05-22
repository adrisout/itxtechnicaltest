package com.adrian.itxtechnicaltest.mapper;

import com.adrian.itxtechnicaltest.entity.Price;
import org.mapstruct.Mapper;
import org.openapitools.model.PriceDTO;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper
public interface PricesRestMapper {

    PriceDTO toDto(Price price);

    default OffsetDateTime toOffsetDateTime(LocalDateTime value) {

        return value.atOffset(ZoneOffset.UTC);
    }
}
