package com.example;

import java.util.Arrays;
import java.util.List;

public class AlexLion extends Lion { // Объявляем класс AlexLion, который наследуется от класса Lion

    public AlexLion(Predator predator) throws Exception { // Создаем конструктор для класса AlexLion, принимающий объект Predator
        super("Самец", predator); // Вызываем конструктор родительского класса Lion, передавая пол "Самец" и объект Predator.  Алекс - самец, поэтому пол фиксирован.
    }

    public List<String> getFriends() { // Создаем метод getFriends(), возвращающий список друзей Алекса
        return Arrays.asList("Марти", "Глория", "Мелман"); // Возвращаем список имен друзей Алекса
    }

    public String getPlaceOfLiving() { // Создаем метод getPlaceOfLiving(), возвращающий место жительства Алекса
        return "New York Zoo"; // Возвращаем строку с местом жительства Алекса
    }

    @Override // Аннотация @Override указывает, что мы переопределяем метод из родительского класса
    public int getKittens() { // Переопределяем метод getKittens() из класса Lion
        return 0; // У Алекса нет котят (возвращаем 0)
    }
}
