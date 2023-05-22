package com.adrian.itxtechnicaltest.usecase.price;

import com.adrian.itxtechnicaltest.entity.Price;
import com.adrian.itxtechnicaltest.repository.PriceRepository;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductQuery;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPriceByProductUseCaseImpl implements GetPriceByProductUseCase {

    private final PriceRepository repository;

    @Override
    public Price getPriceByProduct(final GetPriceByProductQuery query) {
        return repository.findPriceByProduct(query);
    }

}
