package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)//load the data when needed. The second type is EAGER and it download all the data directly and when downloading it download cinema also. But when we use LAZY it only download movie when needed.
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;



}
