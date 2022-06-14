package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.WatchMovie;

public class PosterManagerTest {

    PosterRepository repo = new PosterRepository();
    WatchMovie first = new WatchMovie(145, "http://1", "Аллея кошмаров", "20 января 2022", "Драма");
    WatchMovie second = new WatchMovie(15, "http://2", "Анчартед: На картах не значится", "8 февраля 2022", "Приключения");
    WatchMovie third = new WatchMovie(367, "http://3", "Смерть на Ниле", "10 февраля 2022", "Детектив");
    WatchMovie fourth = new WatchMovie(862, "http://4", "Я краснею", "01 марта 2022", "Мультфильм");
    WatchMovie fifth = new WatchMovie(834, "http://5", "Фантастические твари: Тайны Дамблдора", "6 апреля 2022", "Фентези");
    WatchMovie sixth = new WatchMovie(9250, "http://6", "Пропавшая", "9 июня 2022", "Боевик");
    WatchMovie seventh = new WatchMovie(30, "http://7", "Бэтмен ", "1 марта 2022", "Детектив");
    WatchMovie eighth = new WatchMovie(3489, "http://8", "Одна", "9 июня 2022", "Драма");
    WatchMovie ninth = new WatchMovie(178, "http://9", "Затерянный город", "12 марта 2022", "Комедия");
    WatchMovie tenth = new WatchMovie(248, "http://10", "Доктор Стрэндж: В мультивселенной безумия", "2 мая 2022", "Фэнтези");
    WatchMovie eleventh = new WatchMovie(308, "http://11", "Ника", "19 мая 2022", "Биография");


    @Test
    public void addTest() {
        PosterManager manager = new PosterManager(repo);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        WatchMovie[] actual = manager.findAll();
        WatchMovie[] expected = { first, second, third, fourth, fifth, sixth, seventh };

        Assertions.assertArrayEquals(actual, expected);

    }


    @Test
    public  void  findLastTest(){
        PosterManager manager = new PosterManager(5, (repo));
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        WatchMovie[] actual = manager.findLast();
        WatchMovie[] expected = { seventh, sixth, fifth, fourth, third };

        Assertions.assertArrayEquals(actual, expected);

    }
    @Test
    public  void  findLastMaxTest(){
        PosterManager manager = new PosterManager(repo);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        WatchMovie[] actual = manager.findLast();
        WatchMovie[] expected = { eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second };

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public  void  findLastIncompleteTest(){
        PosterManager manager = new PosterManager(repo);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        WatchMovie[] actual = manager.findLast();
        WatchMovie[] expected = { fourth, third, second, first };

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public  void findById() {
        PosterManager manager = new PosterManager(repo);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.findById(15);

        WatchMovie[] actual = manager.findAll();
        WatchMovie[] expected = {second};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public  void removeByIdTest(){
        PosterManager manager = new PosterManager(repo);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.removeById (367);

        WatchMovie[] actual = manager.findAll();
        WatchMovie[] expected = { first, second, fourth, fifth, sixth };
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public  void removeAll(){
        PosterManager manager = new PosterManager(repo);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.removeAll();

        WatchMovie[] actual = manager.findAll();
        WatchMovie[] expected = {};
        Assertions.assertArrayEquals(actual, expected);

    }

}