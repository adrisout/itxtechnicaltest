package com.adrian.itxtechnicaltest.controller;

import com.adrian.itxtechnicaltest.mapper.PricesRestMapper;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductUseCase;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductQuery;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.PricesApi;
import org.openapitools.model.PriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
public class PricesController implements PricesApi {

    private final PricesRestMapper pricesRestMapper;

    private final GetPriceByProductUseCase getPriceByProductUseCase;

    @Override
    public ResponseEntity<PriceDTO> getPriceByProduct(final Integer productId, final Integer brandId, final OffsetDateTime applicationDate) {
        final GetPriceByProductQuery query = new GetPriceByProductQuery(brandId, productId, applicationDate);
        return ResponseEntity.ok().body(pricesRestMapper.toDto(getPriceByProductUseCase.getPriceByProduct(query)));
    }

}
