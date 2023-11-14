package com.deku.eastwardjourneys.common.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ShojiPaper extends Item {
    private static final String BASE_PATTERN = "base";
    private static final String RED_SUN_PATTERN = "red_sun";
    private static final String WAVE_PATTERN = "wave";
    private static final String MOLDY_PATTERN = "moldy";
    private static final String GOLD_PATTERN = "gold";
    private static final String CHERRY_PATTERN = "cherry";

    public ShojiPaper() {
        super(new Item.Properties().stacksTo(16));
    }

    /**
     * Determines the pattern tied to this shoji paper item
     *
     * @param itemStack The item stack being checked
     * @return The string name for this shoji paper item
     */
    public static String determinePattern(ItemStack itemStack) {
        if (itemStack.is(Items.RED_DYE)) {
            return RED_SUN_PATTERN;
        } else if (itemStack.is(Items.BLUE_DYE)) {
            return WAVE_PATTERN;
        } else if (itemStack.is(Items.BLACK_DYE)) {
            return MOLDY_PATTERN;
        } else if (itemStack.is(Items.GOLD_NUGGET)) {
            return GOLD_PATTERN;
        } else if (itemStack.is(Items.PINK_PETALS)) {
            return CHERRY_PATTERN;
        }
        return BASE_PATTERN;
    }

    public static String[] getAllPatterns() {
        return new String[] {BASE_PATTERN, RED_SUN_PATTERN, WAVE_PATTERN, MOLDY_PATTERN, GOLD_PATTERN, CHERRY_PATTERN};
    }

    /**
     * Saves a pattern to this item stack as NBT data
     *
     * @param itemStack Stack of shoji paper this pattern is being saved to
     * @param pattern The pattern  to be saved as NBT data
     */
    public static void savePattern(ItemStack itemStack, String pattern) {
        CompoundTag tag = itemStack.getOrCreateTag();
        tag.putString("pattern", pattern);
    }

    /**
     * Gets the pattern tied to this item stack from NBT data
     *
     * @param itemStack Stack of shoji paper we are checking the pattern of
     * @return The pattern tied to this item
     */
    public static String getPattern(ItemStack itemStack) {
        CompoundTag tag = itemStack.getOrCreateTag();
        return tag.getString("pattern");
    }

    /**
     * Appends some additional text to the hover tooltip for this item stack
     * The additional text denotes what pattern the shoji paper contains
     *
     * @param itemStack Item stack being hovered over
     * @param level Level the item stack is in
     * @param components UI components being altered
     * @param tooltip Tooltip rendered on hover
     */
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltip) {
        super.appendHoverText(itemStack, level, components, tooltip);
        CompoundTag tag = itemStack.getTag();
        if (tag != null) {
            String pattern = tag.getString("pattern");
            if (!pattern.equals("base")) {
                components.add(Component.translatable("shoji.paper." + pattern));
            }
        }
    }
}
