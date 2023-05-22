package com.adrian.itxtechnicaltest.usecase.price;

import com.adrian.itxtechnicaltest.entity.Price;
import com.adrian.itxtechnicaltest.repository.PriceRepository;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class GetPriceByProductUseCaseImplTest {

    @InjectMocks
    private GetPriceByProductUseCaseImpl getPriceListUseCase;

    @Mock
    private PriceRepository repository;

    @Test
    void getPriceList_WhenExistsDataInDB_ReturnInfo() {
        OffsetDateTime hora = OffsetDateTime.now();
        LocalDateTime horaLocal = LocalDateTime.now();
        final GetPriceByProductQuery query = new GetPriceByProductQuery(1, 1, hora);
        when(this.repository.findPriceByProduct(query)).thenReturn(new Price(1, horaLocal, horaLocal, 1, 1, 2.3, "EUR"));

        Price response = this.getPriceListUseCase.getPriceByProduct(query);

        assertNotNull(response.getBrandId());
        assertEquals(query.getBrandId(), response.getBrandId());
    }

}