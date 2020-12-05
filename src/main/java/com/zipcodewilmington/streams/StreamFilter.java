package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.MyFunction;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        this.startingCharacter = String.valueOf(RandomUtils.createCharacter('A','Z'));
        this.personStream = Stream.generate(PersonFactory::createRandomPerson)
                .limit(100);

    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this.startingCharacter = String.valueOf(startingCharacter);
        this.personStream = Arrays.stream(people)
                .filter(person -> person.getName().startsWith(this.startingCharacter));
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this.startingCharacter = String.valueOf(startingCharacter);
        this.personStream = people.stream()
                .filter(person -> person.getName().startsWith(this.startingCharacter));

    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {

        MyFunction function = () -> this.personStream
                .filter(person -> person.getName().startsWith(this.startingCharacter))
                .filter(p -> StringUtils.isPalindromeIgnoreCase(p.getName()))
                .collect(Collectors.toList());
//        List<Person> people = new ArrayList<Person>(function.apply());
        return function.apply();
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return this.personStream
                .filter(p -> p.getName().startsWith(this.startingCharacter))
                .filter(p -> StringUtils.isPalindromeIgnoreCase(p.getName()))
                .collect(Collectors.toList());
    }

    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return personStream
                .filter(p -> {
                    return p.getName().startsWith(this.startingCharacter);
                }).filter(p -> StringUtils.isPalindromeIgnoreCase(p.getName()))
                .toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO

    public Person[] toArrayMultiLine() {

        return personStream
                .filter(p -> {
                    return p.getName().startsWith(this.startingCharacter);
                }).filter(p -> StringUtils.isPalindromeIgnoreCase(p.getName()))
                .toArray(Person[]::new);
    }

}
