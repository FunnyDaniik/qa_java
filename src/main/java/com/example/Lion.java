package com.example;

import java.util.List;

public class Lion { // Объявляем класс Lion

    private boolean hasMane; // Объявляем переменную hasMane типа boolean
    private Predator predator; // Объявляем переменную predator типа Predator

    public Lion(String sex, Predator predator) throws Exception { // Объявляем конструктор класса Lion, принимающий String sex и параметр predator типа Predator и выбрасывающий исключение типа Exception
        if ("Самец".equals(sex)) { // Проверяем, равно ли sex строке "Самец"
            hasMane = true; // Если равно, присваиваем hasMane значение true
        } else if ("Самка".equals(sex)) { // Иначе проверяем, равно ли sex строке "Самка"
            hasMane = false; // Если равно, присваиваем hasMane значение false
        } else { // Иначе (если sex не равно ни "Самец", ни "Самка")
            throw new Exception("Используйте допустимые значения пола животного - самей или самка"); // Выбрасываем исключение
        }
        this.predator = predator; // Присваиваем полю predator значение параметра predator
    }



    public int getKittens() { // Объявляем публичный метод getKittens, возвращающий int
        return predator.getKittens(); // Возвращаем результат вызова метода getKittens() у объекта feline
    }

    public boolean doesHaveMane() { // Объявляем публичный метод doesHaveMane, возвращающий boolean
        return hasMane; // Возвращаем значение переменной hasMane
    }

    public List<String> getFood() throws Exception { // Объявляем публичный метод getFood, возвращающий List<String> и выбрасывающий Exception
        return predator.eatMeat(); // Возвращаем результат вызова метода eatMeat() у объекта feline
    }
}


