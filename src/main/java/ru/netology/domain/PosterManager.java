package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.WatchMovie;


public class PosterManager {

    private WatchMovie[] movies = new WatchMovie[0];

    private PosterRepository repository;

    private int maxAdded = 10;
    public PosterManager( PosterRepository repository) {this.repository = repository; }
    public PosterManager(int resultLength, PosterRepository repository) {this.repository = repository;
    this.maxAdded = resultLength;}

    public void add (WatchMovie movie) {repository.save(movie); }
    public WatchMovie[] findAll() {
        return repository.findAll();
    }

    public WatchMovie[] findLast() {
        WatchMovie[] movies = findAll();
        if (movies.length < maxAdded) {
            maxAdded = movies.length;}
        else {
            maxAdded = this.maxAdded;
        }
        WatchMovie[] result = new WatchMovie[maxAdded];
        int i;
        for ( i=0; i < maxAdded; i++){
            int index  = movies.length - i - 1;
            result[i] = movies[index];
        }
        return  result;

    }
    public void findById(int id) {repository.findById(id);
    }
    public void removeById(int id) {repository.removeById(id);
    }

    public void removeAll() {repository.removeAll(); }
}
