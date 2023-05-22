package com.adrian.itxtechnicaltest.usecase;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class GetPriceByProductQuery implements Serializable {

    private Integer brandId;

    private Integer productId;

    private OffsetDateTime actualDate;

}
