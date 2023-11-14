package com.deku.eastwardjourneys.common.blocks.state;

import net.minecraft.util.StringRepresentable;

public enum GravelPattern implements StringRepresentable {
    STANDARD("standard"),
    NORTH_SOUTH("north_south"),
    EAST_WEST("east_west"),
    NORTH_EAST("north_east"),
    SOUTH_EAST("south_east"),
    SOUTH_WEST("south_west"),
    NORTH_WEST("north_west");

    private final String name;

    private GravelPattern(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public GravelPattern next() {
        return values()[(ordinal() + 1) % values().length];
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
