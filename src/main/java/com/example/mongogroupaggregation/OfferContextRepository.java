package com.example.mongogroupaggregation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OfferContextRepository extends MongoRepository<OfferContext, String>, OfferContextCustomRepository {
    List<OperatingFigure> aggregateOperatingFigures(OfferProductTyp productTyp);
}
