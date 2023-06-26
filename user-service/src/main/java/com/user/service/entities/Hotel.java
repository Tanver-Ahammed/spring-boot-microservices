package com.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    private long hotelId;

    private String name;

    private String location;

    private String about;

}
