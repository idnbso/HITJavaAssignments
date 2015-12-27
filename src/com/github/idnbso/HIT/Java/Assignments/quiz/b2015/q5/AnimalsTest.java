package com.github.idnbso.hit.java.assignments.quiz.b2015.q5;

import java.util.*;

public class AnimalsTest
{

    public static void main(String[] args)
    {
        List<Animal> list = new ArrayList<Animal>();
        list.add(new Cat());
        list.add(new Dog());
        list.add(new Cat());
        feedThemAll(list);
    }

    public static void feedThemAll(List<Animal> list) {
        for(Animal animal: list)
            animal.eat();
    }
}
