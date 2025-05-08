package com.example;

import java.util.List;

public interface Predator { // Объявляем интерфейс Predator

    List<String> eatMeat() throws Exception; // Объявляем абстрактный метод eatMeat, возвращающий List<String> (возвращал список строк) и выбрасывающий Exception

}


