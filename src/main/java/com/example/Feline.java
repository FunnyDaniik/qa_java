package com.example;

import java.util.List;

public class Feline extends Animal implements Predator { // Объявляем класс Feline, который наследуется от Animal и реализует интерфейс Predator

    @Override // Указываем, что метод переопределяет метод из суперкласса или интерфейса
    public List<String> eatMeat() throws Exception { // Объявляем публичный метод eatMeat, возвращающий List<String> и выбрасывающий Exception
        return getFood("Хищник"); // Возвращаем результат вызова метода getFood("Хищник")
    }

    @Override // Указываем, что метод переопределяет метод из суперкласса или интерфейса
    public String getFamily() { // Объявляем публичный метод getFamily, возвращающий String
        return "Кошачьи"; // Возвращаем строку "Кошачьи"
    }

    public int getKittens() { // Объявляем публичный метод getKittens, возвращающий int
        return getKittens(1); // Возвращаем результат вызова метода getKittens(1)
    }

    public int getKittens(int kittensCount) { // Объявляем публичный метод getKittens, возвращающий int и принимающий int kittensCount
        return kittensCount; // Возвращаем значение kittensCount
    }
}

