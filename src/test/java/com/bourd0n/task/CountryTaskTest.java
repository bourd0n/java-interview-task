package com.bourd0n.task;

import com.bourd0n.task.model.Country;
import com.bourd0n.task.model.TownDto;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.bourd0n.task.CountryCalculationServiceImplementation.*;
import static org.assertj.core.api.Assertions.*;

public class CountryTaskTest {

    ContinentModel northAmerica = new ContinentModel("North America");
    ContinentModel africa = new ContinentModel("Africa");
    ContinentModel australia = new ContinentModel("Australia");

    Country usa = new Country("USA",
            Lists.newArrayList(new TownDto("Boston", 20), new TownDto("New-York", 50)),
            northAmerica);

    Country canada = new Country("Canada",
            Lists.newArrayList(new TownDto("Toronto", 11)),
            northAmerica);

    Country angola = new Country("Angola",
            Lists.newArrayList(new TownDto("Luanda", 23), new TownDto("Lobito", 74)),
            africa);

    Country egypt = new Country("Egypt",
            Lists.newArrayList(new TownDto("Alexandria", 44), new TownDto("Cairo", 100)),
            africa);

    Country australiaCountry = new Country("Australia",
            Lists.newArrayList(new TownDto("Sydney", 55), new TownDto("Melbourne", 97)),
            australia);


    @Test
    void test1() {
        assertThat(getPopulationByContinents(
                List.of(usa, canada), List.of(northAmerica, africa)
        )).isEqualTo(
                Map.of(northAmerica.getNameOfContinent(), 81)
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
                        northAmerica.getNameOfContinent(), 70,
                        africa.getNameOfContinent(), 241
                )
        );
    }

    @Test
    void test4() {
        assertThat(getPopulationByContinents(
                List.of(usa, canada, angola, egypt, australiaCountry), List.of(africa, northAmerica, australia)
        )).isEqualTo(
                Map.of(
                        northAmerica.getNameOfContinent(), 81,
                        africa.getNameOfContinent(), 241,
                        australia.getNameOfContinent(), 152
                )
        );
    }
}
