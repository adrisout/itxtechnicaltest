package com.adrian.itxtechnicaltest.usecase;

import com.adrian.itxtechnicaltest.entity.Price;

public interface GetPriceByProductUseCase {

    Price getPriceByProduct(GetPriceByProductQuery query);
}
