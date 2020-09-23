package com.example.mongogroupaggregation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperatingFigure {

    private OfferContextStateEnum state;

    private int total;
}
