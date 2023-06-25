package com.user.service.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private long ratingId;
    private long userId;
    private long hotelId;
    private int rating;
    private String remark;
    private String feedback;

}
