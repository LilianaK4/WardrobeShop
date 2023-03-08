package com.accessories;

import com.wardrobe_bases.Wardrobe;

public class MeshBasket extends WardrobeAcessoriesDecorator {

    private Wardrobe wardrobe;

    public MeshBasket(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    @Override
    public float price() {
        return wardrobe.price() + 159;
    }

    @Override
    public String description() {
        return wardrobe.description() + " with mesh basket";
    }
}
