package com.bourd0n.task.model;

import com.bourd0n.task.ContinentModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.concurrent.Immutable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@Immutable
public class Country {
    private final String name;
    private final ArrayList<TownDto> townsList;
    private ContinentModel continent;
}
