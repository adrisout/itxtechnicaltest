package com.adrian.itxtechnicaltest.repository;

import com.adrian.itxtechnicaltest.entity.Price;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductQuery;

public interface PriceRepository {

    Price findPriceByProduct(GetPriceByProductQuery query);
}
