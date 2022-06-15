package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.PosterRepository;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class PosterManagerMockitoTest {

    private PosterRepository repository = Mockito.mock(PosterRepository.class);
    private PosterManager manager = new PosterManager(4, repository);
    private WatchMovie first = new WatchMovie(145, "http://1", "Аллея кошмаров", "20 января 2022", "Драма");
    private WatchMovie second = new WatchMovie(15, "http://2", "Анчартед: На картах не значится", "8 февраля 2022", "Приключения");
    private WatchMovie third = new WatchMovie(367, "http://3", "Смерть на Ниле", "10 февраля 2022", "Детектив");
    private WatchMovie fourth = new WatchMovie(862, "http://4", "Я краснею", "01 марта 2022", "Мультфильм");
    private WatchMovie fifth = new WatchMovie(834, "http://5", "Фантастические твари: Тайны Дамблдора", "6 апреля 2022", "Фентези");

    @Test
    public void findLastTest() {
        WatchMovie[] returned = new WatchMovie[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();


        WatchMovie[] actual = manager.findLast();
        WatchMovie[] expected = {fifth, fourth, third, second};
        Assertions.assertArrayEquals(actual, expected);
        verify(repository).findAll();
    }

}
