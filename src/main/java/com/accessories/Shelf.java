package com.accessories;

import com.wardrobe_bases.Wardrobe;

public class Shelf extends WardrobeAcessoriesDecorator {

    private Wardrobe wardrobe;

    public Shelf(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    @Override
    public float price() {
        return wardrobe.price() + 129;
    }

    @Override
    public String description() {
        return wardrobe.description() + " with additional shelf";
    }

}
