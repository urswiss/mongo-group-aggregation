package com.example.mongogroupaggregation;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OfferContext implements Persistable<String> {
    @Id
    private String id;

    private OfferContextStateEnum state;

    private OfferProductTyp productType;

    @CreatedDate
    private LocalDateTime created;

    @Override
    public boolean isNew() {
        return getCreated() == null;
    }
}
