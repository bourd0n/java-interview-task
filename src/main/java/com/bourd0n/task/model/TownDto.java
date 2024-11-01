package com.bourd0n.task.model;

import java.util.concurrent.atomic.AtomicInteger;

public class TownDto {
    private String name;
    private AtomicInteger population;

    public TownDto(String name, int population) {
        this.name = name;
        this.population = new AtomicInteger(population);
    }

    public String getNAme() {
        return this.name;
    }

    public int getPopulation() {
        return this.population.get();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population.set(population);
    }

    public boolean equals(final Object o) {
        if (o == this) return true;

        if (!(o instanceof TownDto)) return false;

        final TownDto other = (TownDto) o;

        if (!other.canEqual((Object) this)) return false;

        final Object this$name = this.getNAme();

        final Object other$name = other.getNAme();

        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TownDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getNAme();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "TownDto(name=" + this.getNAme() + ", population=" + this.getPopulation() + ")";
    }
}
