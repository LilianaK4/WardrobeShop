package com.accessories;

import com.wardrobe_bases.Wardrobe;

public class ClothesRail extends WardrobeAcessoriesDecorator {


    private Wardrobe wardrobe;

    public ClothesRail(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    @Override
    public float price() {
        return wardrobe.price() + 117;
    }

    @Override
    public String description() {
        return wardrobe.description() + " with clothes rail";
    }
}
