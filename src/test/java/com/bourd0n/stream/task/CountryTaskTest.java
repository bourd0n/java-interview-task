package com.bourd0n.stream.task;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.bourd0n.stream.task.CountryTask.*;
import static org.assertj.core.api.Assertions.*;

public class CountryTaskTest {

    Continent northAmerica = new Continent("North America");
    Continent africa = new Continent("Africa");
    Continent australia = new Continent("Australia");

    Country usa = new Country("USA",
            List.of(new Town("Boston", 20), new Town("New-York", 50)),
            northAmerica);

    Country canada = new Country("Canada",
            List.of(new Town("Toronto", 11)),
            northAmerica);

    Country angola = new Country("Angola",
            List.of(new Town("Luanda", 23), new Town("Lobito", 74)),
            africa);

    Country egypt = new Country("Egypt",
            List.of(new Town("Alexandria", 44), new Town("Cairo", 100)),
            africa);

    Country australiaCountry = new Country("Australia",
            List.of(new Town("Sydney", 55), new Town("Melbourne", 97)),
            australia);


    @Test
    void test1() {
        assertThat(getPopulationByContinents(
                List.of(usa, canada), List.of(northAmerica, africa)
        )).isEqualTo(
                Map.of(northAmerica.getName(), 81)
        );
    }

    @Test
    void test2() {
        assertThat(getPopulationByContinents(
                List.of(usa, australiaCountry), List.of(africa)
        )).isEqualTo(
                Collections.emptyMap()
        );
    }

    @Test
    void test3() {
        assertThat(getPopulationByContinents(
                List.of(usa, angola, egypt, australiaCountry), List.of(africa, northAmerica)
        )).isEqualTo(
                Map.of(
                        northAmerica.getName(), 70,
                        africa.getName(), 241
                )
        );
    }

    @Test
    void test4() {
        assertThat(getPopulationByContinents(
                List.of(usa, canada, angola, egypt, australiaCountry), List.of(africa, northAmerica, australia)
        )).isEqualTo(
                Map.of(
                        northAmerica.getName(), 81,
                        africa.getName(), 241,
                        australia.getName(), 152
                )
        );
    }
}
