package com.adrian.itxtechnicaltest.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Price implements Serializable {

    private final Integer brandId;

    private final LocalDateTime startDate;

    private final LocalDateTime endDate;

    private final Integer priceList;

    private final Integer productId;

    private final Double productPrice;

    private final String currency;
}
