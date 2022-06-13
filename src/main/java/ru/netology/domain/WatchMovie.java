package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class WatchMovie {
    private int id;
    private String movieImageUrl;
    private String movieTitle;
    private String moviePremiere;
    private String movieGenre;


}
