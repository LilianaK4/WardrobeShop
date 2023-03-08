package com.accessories;

import com.wardrobe_bases.Wardrobe;

public class Mirror extends WardrobeAcessoriesDecorator {

    private Wardrobe wardrobe;

    public Mirror(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    @Override
    public float price() {
        return wardrobe.price() + 250;
    }

    @Override
    public String description() {
        return wardrobe.description() + " with mirror";
    }
}
