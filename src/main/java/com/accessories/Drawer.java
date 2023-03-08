package com.accessories;

import com.wardrobe_bases.Wardrobe;

public class Drawer extends WardrobeAcessoriesDecorator {

    private Wardrobe wardrobe;

    public Drawer(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    @Override
    public float price() {
        return this.wardrobe.price() + 99;
    }

    @Override
    public String description() {
        return this.wardrobe.description() + " with additional drawer";
    }
}
