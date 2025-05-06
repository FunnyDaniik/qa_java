package com.example;

import java.util.List;

public interface Predator { // Объявляем интерфейс Predator

    List<String> eatMeat() throws Exception; // Объявляем абстрактный метод eatMeat, возвращающий List<String> (возвращал список строк) и выбрасывающий Exception
    int getKittens(); // Объявляем абстрактный метод getKittens, возвращающий int
    /**
     * Внедрение зависимости через интерфейс: чтобы разорвать эту зависимость, было решено внедрить зависимость через интерфейс Predator.
     */
}


