package com.example.bearnapp;

import java.util.Arrays;
import java.util.List;

class Shop {
    private static final String STORAGE = "shop";

    public static Shop get() {
        return new Shop();
    }

    public List<Item> getData() {
        return Arrays.asList(
                new Item(R.drawable.apple),
                new Item(R.drawable.bg_mi),
                new Item(R.drawable.bg_nokia),
                new Item(R.drawable.bg_rolex));
    }

}
