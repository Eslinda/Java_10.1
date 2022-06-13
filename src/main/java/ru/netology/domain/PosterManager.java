package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.WatchMovie;


@NoArgsConstructor
public class PosterManager {

    private WatchMovie[] movies = new WatchMovie[0];
    private int resultLength = 10;

    public PosterManager (int maxAdded) {
        this.resultLength = maxAdded;
    }

    public void add (WatchMovie movie) {
        int length = movies.length + 1;
        WatchMovie[] tmp = new WatchMovie[length];
        System.arraycopy (movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp [lastIndex] = movie;
        movies = tmp;
    }
    public WatchMovie[] findAll() { return movies; }

    public WatchMovie[] findLast() {
        WatchMovie[] movies = findAll();
        if (movies.length < resultLength) {
            resultLength = movies.length;}
        else {
            resultLength = this.resultLength;
        }
        WatchMovie[] result = new WatchMovie[resultLength];
        int i;
        for ( i=0; i < resultLength; i++){
            int index  = movies.length - i - 1;
            result[i] = movies[index];
        }
        return  result;

    }
}
