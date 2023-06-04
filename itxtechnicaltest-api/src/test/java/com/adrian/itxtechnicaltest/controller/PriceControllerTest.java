package com.adrian.itxtechnicaltest.controller;

import com.adrian.itxtechnicaltest.entity.Price;
import com.adrian.itxtechnicaltest.mapper.PricesRestMapper;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductQuery;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.PriceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@ExtendWith({MockitoExtension.class})
class PriceControllerTest {
    @InjectMocks
    private PricesController pricesController;

    @Mock
    private GetPriceByProductUseCase getPriceByProductUseCase;

    @Spy
    private PricesRestMapper pricesRestMapper;

    @Test
    void getPricesList_WhenDataOk_Return200OK() {
        OffsetDateTime hora = OffsetDateTime.now();
        final GetPriceByProductQuery query = new GetPriceByProductQuery(1, 1, hora);
        Price price = new Price(1, LocalDateTime.now(), LocalDateTime.now(), 1, 1, 35.5, "EUR");
        doReturn(price).when(this.getPriceByProductUseCase).getPriceByProduct(query);

        final ResponseEntity<PriceDTO> response = this.pricesController.getPriceByProduct(1, 1, hora);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
