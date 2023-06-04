package com.adrian.itxtechnicaltest.persistence.impl;

import com.adrian.itxtechnicaltest.entity.Price;
import com.adrian.itxtechnicaltest.persistence.jpa.price.PriceEntity;
import com.adrian.itxtechnicaltest.persistence.jpa.price.PriceJPARepository;
import com.adrian.itxtechnicaltest.persistence.mapper.PriceMapperImpl;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryImplTest {

    @InjectMocks
    private PriceRepositoryImpl priceRepository;

    @Mock
    private PriceJPARepository jpaRepository;

    @Spy
    private PriceMapperImpl priceMapper;

    @Test
    void find_WhenQueryDataOk_ReturnPriceObjectWithData() {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setId(1);
        priceEntity.setBrandId(1);
        priceEntity.setProductId(35455);
        priceEntity.setPriceList(1);
        priceEntity.setCurr("EUR");
        priceEntity.setStartDate(LocalDateTime.parse("2020-06-14T10:00:00"));
        priceEntity.setEndDate(LocalDateTime.parse("2020-06-14T21:00:00"));
        priceEntity.setPriority(1);
        priceEntity.setPrice(35.5);

        OffsetDateTime hora = OffsetDateTime.now();
        final GetPriceByProductQuery query = new GetPriceByProductQuery(1, 35455, hora);

        doReturn(priceEntity).when(this.jpaRepository).findByProductId(35455, 1, hora.toLocalDateTime());

        Price response = this.priceRepository.findPriceByProduct(query);

        assertNotNull(response);
        assertEquals(query.getBrandId(), response.getBrandId());
        assertEquals(query.getProductId(), response.getProductId());
    }
}
