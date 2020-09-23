package com.example.mongogroupaggregation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.mongogroupaggregation.OfferContextStateEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OfferContextRepositoryIntegrationTest {

    @Autowired
    private OfferContextRepository repository;

    private static final LocalDateTime today = LocalDateTime.of(2019, 5, 16, 8, 57, 41);
    private static final LocalDateTime yesterday = LocalDateTime.of(2019, 5, 15, 5, 3, 35);

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
        OfferProductTyp product = OfferProductTyp.HAUSHALT_DHA;
        repository.save(OfferContext.builder().productType(product).state(OFFER_PURCHASED).created(today).build());
        repository.save(OfferContext.builder().productType(product).state(OFFER_PLACED).created(yesterday).build());
        repository.save(OfferContext.builder().productType(product).state(OFFER_PLACED).created(yesterday).build());
        repository.save(OfferContext.builder().productType(product).state(OFFER_PLACED).created(yesterday).build());
        repository.save(OfferContext.builder().productType(product).state(OFFER_PLACED).created(yesterday).build());
        repository.save(OfferContext.builder().productType(product).state(OFFER_UW_CASE).created(yesterday).build());
        repository.save(OfferContext.builder().productType(product).state(OFFER_PURCHASED).created(yesterday).build());
    }

    @Test
    public void should_aggregate_operating_figures() {
        List<OperatingFigure> operatingFigures = repository.aggregateOperatingFigures(OfferProductTyp.HAUSHALT_DHA);
        assertEquals(3, operatingFigures.size());
        // state is null, why?
        assertNotNull(operatingFigures.get(0).getState());
    }

    @Test
    public void should_list_operating_figures() {
        List<OperatingFigure> operatingFigures = repository.listOperatingFigures(OfferProductTyp.HAUSHALT_DHA);
        assertEquals(7, operatingFigures.size());
        // state is not null as expected
        assertNotNull(operatingFigures.get(0).getState());
    }
}
