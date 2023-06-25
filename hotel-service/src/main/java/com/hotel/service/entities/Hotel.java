package com.hotel.service.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "micro_hotels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelId;

    private String name;

    private String location;

    private String about;

}
