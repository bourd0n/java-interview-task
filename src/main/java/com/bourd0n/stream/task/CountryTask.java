package com.bourd0n.stream.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CountryTask {
    @Data
    @AllArgsConstructor
    public static class Country {
        private String name;
        private List<Town> towns;
        private Continent continent;
        //getters, setters
    }

    @Data
    @AllArgsConstructor
    public static class Town {
        private String name;
        private int population;
        //getters, setters
    }

    @Data
    @AllArgsConstructor
    public static class Continent {
        private String name;
        //getters, setters
    }

    public static Map<String, Integer> getPopulationByContinents(List<Country> countries, List<Continent> continentsToInclude) {
        return Collections.emptyMap();
    }

}