package com.adrian.itxtechnicaltest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@AutoConfigureMockMvc
@SpringBootTest(classes = ItxTechnicalTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricesControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPricesList_WhenDate14Hour10_Return200OKAndPrice3550() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices/price-by-product")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T10:00:00Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productPrice").value(35.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59Z"));
    }

    @Test
    void getPricesList_WhenDate14Hour16_Return200OKAndPrice2545() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices/price-by-product")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T16:00:00Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productPrice").value(25.45))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T15:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14T18:30:00Z"));
    }

    @Test
    void getPricesList_WhenDate14Hour21_Return200OKAndPrice3550() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices/price-by-product")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T21:00:00Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productPrice").value(35.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59Z"));
    }

    @Test
    void getPricesList_WhenDate15Hour10_Return200OKAndPrice3050() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices/price-by-product")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-15T10:00:00Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productPrice").value(30.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T00:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15T11:00:00Z"));
    }

    @Test
    void getPricesList_WhenDate15Hour21_Return200OKAndPrice3895() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices/price-by-product")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-16T21:00:00Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productPrice").value(38.95))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T16:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59Z"));
    }

    @ParameterizedTest
    @CsvSource({
            "3s5455,        1,         2020-06-14T10:00:00Z",
            "35455,         X,         2020-06-14T10:00:00Z",
            "35455,         2,         2020-06-14T10:w00:00Z",
    })
    void getPricesList_WhenIncorrectType_Return400KO(String productId, String brandId, String date) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices/price-by-product")
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .param("applicationDate", date)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getPricesList_WhenProductIdMissing_Return400KO() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices/price-by-product")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-16T21:00:00Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getPricesList_WhenBrandIdMissing_Return400KO() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices/price-by-product")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16T21:00:00Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getPricesList_WhenApplicationDateTimedMissing_Return400KO() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices/price-by-product")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getPricesList_WhenWrongMethod_Return405KO() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/prices/price-by-product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

}