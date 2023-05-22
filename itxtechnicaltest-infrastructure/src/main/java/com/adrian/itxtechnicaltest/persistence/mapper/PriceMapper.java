package com.adrian.itxtechnicaltest.persistence.mapper;

import com.adrian.itxtechnicaltest.entity.Price;
import com.adrian.itxtechnicaltest.persistence.jpa.price.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceMapper {

    @Mapping(source = "curr", target = "currency")
    @Mapping(source = "price", target = "productPrice")
    Price toDomain(final PriceEntity entity);
}
