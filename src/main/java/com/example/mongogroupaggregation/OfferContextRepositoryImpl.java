package com.example.mongogroupaggregation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@RequiredArgsConstructor
public class OfferContextRepositoryImpl implements OfferContextCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<OperatingFigure> aggregateOperatingFigures(OfferProductTyp productTyp) {
        Aggregation agg = newAggregation(
                match(where("productType").is(productTyp)),
                group("state").count().as("total")
        );
        AggregationResults<OperatingFigure> result = mongoTemplate.aggregate(agg, OfferContext.class, OperatingFigure.class);
        return result.getMappedResults();
    }

    @Override
    public List<OperatingFigure> listOperatingFigures(OfferProductTyp productTyp) {
        Aggregation agg = newAggregation(
                match(where("productType").is(productTyp))
        );
        AggregationResults<OperatingFigure> result = mongoTemplate.aggregate(agg, OfferContext.class, OperatingFigure.class);
        return result.getMappedResults();
    }
}
