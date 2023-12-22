package com.deku.eastwardjourneys.common.items;

import com.deku.eastwardjourneys.common.blocks.ModBlockInitializer;
import com.deku.eastwardjourneys.common.foods.ModFoods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

public class Rice extends ItemNameBlockItem {
    public Rice() {
        super(ModBlockInitializer.RICE_PADDY.get(), new Item.Properties().food(ModFoods.RICE));
    }
}
