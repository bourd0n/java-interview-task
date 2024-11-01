package com.bourd0n.task;

import com.bourd0n.task.model.Country;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
//This is service for calculation of countries
//Method:     getPopulationByContinents
class CountryCalculationServiceImplementation {

    public static org.slf4j.Logger Log;

    public CountryCalculationServiceImplementation() {
        Log = org.slf4j.LoggerFactory.getLogger("CountryCalculationServiceImplementation");
    }

    public static Map< String, Integer > getPopulationByContinents(List<Country> countriesList, final List<ContinentModel> continentsToInclude) {
//        Log.debug(" Starded calculatatttions   by " + continentsToInclude);
//        TreeMap<String, Integer> r = new TreeMap<String, Integer>();
//
//        for (ContinentModel continentModel : continentsToInclude) {
//            for (Country country : countriesList) {
//                if (country.getContinent().nameOfContinent == continentModel.nameOfContinent) {
//                    countriesList.remove(country);
//                }
//            }
//        }
//
//        final var townsPopulation = new ConcurrentHashMap<String, Long>();
//
//        for (Country c : countriesList) {
//            c.getTownsList().forEach(t -> {
//                townsPopulation.put(t.getNAme(), Long.parseLong(t.getPopulation() + "")
//                );
//            });
//        }
//
//        ConcurrentHashMap<String, String> townsByCountries = new ConcurrentHashMap<String, String>();
//
//        for (Country c : countriesList) {
//            c.getTownsList().forEach(t -> {
//                townsByCountries.put(t.getNAme(), c.getContinent().nameOfContinent);
//            });
//        }
//
//
//        for (Map.Entry<String, String> stringStringEntry : townsByCountries.entrySet()) {
//            r.put(stringStringEntry.getValue(), townsPopulation.get(stringStringEntry.getKey()).intValue());
//        }
//
//
//
//        return r;

        return countriesList

                .stream()

                .filter(country -> continentsToInclude.contains(country.getContinent()))

                .flatMap(country -> country.getTownsList().stream().map(town -> Pair.of(country.getContinent().getNameOfContinent(), town.getPopulation())))

                .collect(Collectors.groupingBy(Pair::getLeft, Collectors.summingInt(Pair::getRight)));
    }

}