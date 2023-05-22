package com.adrian.itxtechnicaltest.persistence.jpa.price;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
class PriceRepositoryIT {

    @Autowired
    private PriceJPARepository repository;

    @Test
    void findPrices_WhenDate14Hour10_Return355() {
        LocalDateTime hora = LocalDateTime.parse("2020-06-14T10:00:00");
        PriceEntity response = repository.findByProductId(35455, 1, hora);

        assertNotNull(response);
        assertEquals(35.5, response.getPrice());
        assertEquals(1, response.getBrandId());
        assertEquals(35455, response.getProductId());
    }
}
