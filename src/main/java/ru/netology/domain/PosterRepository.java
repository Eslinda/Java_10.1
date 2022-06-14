package ru.netology.domain;

public class PosterRepository {

    private WatchMovie[] movies = new WatchMovie[0];


    public void save (WatchMovie movie) {
        int length = movies.length + 1;
        WatchMovie[] tmp = new WatchMovie[length];
        System.arraycopy (movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp [lastIndex] = movie;
        movies = tmp;
    }

    public WatchMovie[] findAll() { return movies; }

    public void findById (int id) {
        WatchMovie[] tmp = new WatchMovie[1];
        int index = 0;
        for (WatchMovie movie:movies ) {
            if (movie.getId() == id) {
                tmp[index] = movie;
                index++;
            }
            movies = tmp;
        }

    }

    public void removeById (int id) {
        int length = movies.length - 1;
        WatchMovie[] tmp = new WatchMovie[length];
        int index = 0;
        for (WatchMovie movie : movies) {
            if (movie.getId() != id) {
               tmp[index] = movie;
               index++;
            }
            movies = tmp;
        }

    }

    public void removeAll() {
        WatchMovie[] tmp = new WatchMovie[0];
        movies = tmp;
    }
}
