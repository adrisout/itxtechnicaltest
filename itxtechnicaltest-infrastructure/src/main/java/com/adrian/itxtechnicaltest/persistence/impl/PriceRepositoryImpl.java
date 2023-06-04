package com.adrian.itxtechnicaltest.persistence.impl;

import com.adrian.itxtechnicaltest.entity.Price;
import com.adrian.itxtechnicaltest.persistence.jpa.price.PriceJPARepository;
import com.adrian.itxtechnicaltest.persistence.mapper.PriceMapper;
import com.adrian.itxtechnicaltest.repository.PriceRepository;
import com.adrian.itxtechnicaltest.usecase.GetPriceByProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJPARepository priceJPARepository;

    private final PriceMapper priceMapper;

    @Override
    public Price findPriceByProduct(final GetPriceByProductQuery query) {
        return
                this.priceMapper.toDomain(this.priceJPARepository.findByProductId(query.getProductId(),
                        query.getBrandId(), query.getActualDate().toLocalDateTime()));
    }
}
