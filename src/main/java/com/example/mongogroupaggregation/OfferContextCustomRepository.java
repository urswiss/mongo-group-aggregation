package com.example.mongogroupaggregation;

import java.util.List;

public interface OfferContextCustomRepository {
    List<OperatingFigure> aggregateOperatingFigures(OfferProductTyp productTyp);
    List<OperatingFigure> listOperatingFigures(OfferProductTyp productTyp);
}
