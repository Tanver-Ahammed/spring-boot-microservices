package com.rating.service.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("rating")
public class Rating {

    @Id
    private String ratingId;

    private long userId;

    private long hotelId;

    private int rating;

    private String remark;

    private String feedback;

}
