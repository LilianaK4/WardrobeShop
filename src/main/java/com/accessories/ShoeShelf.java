package com.accessories;

import com.wardrobe_bases.Wardrobe;

public class ShoeShelf extends WardrobeAcessoriesDecorator {

    private Wardrobe wardrobe;

    public ShoeShelf(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    @Override
    public float price() {
        return wardrobe.price() + 56;
    }

    @Override
    public String description() {
        return wardrobe.description() + " with shoe shelf";
    }
}
