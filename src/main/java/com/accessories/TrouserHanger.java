package com.accessories;

import com.wardrobe_bases.Wardrobe;

public class TrouserHanger extends WardrobeAcessoriesDecorator {
    private Wardrobe wardrobe;

    public TrouserHanger(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    @Override
    public float price() {
        return wardrobe.price() + 173;
    }

    @Override
    public String description() {
        return wardrobe.description() + " with pull-out trouser hanger";
    }
}
