package com.deku.eastwardjourneys.common.recipes;

import com.deku.eastwardjourneys.common.items.ModItemTags;
import com.deku.eastwardjourneys.common.items.ModItems;
import com.deku.eastwardjourneys.common.items.ShojiPaper;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class ShojiPaperRecipe extends CustomRecipe {
    public ShojiPaperRecipe(CraftingBookCategory category) {
        super(category);
    }

    /**
     * Checks if the ingredients in the crafting grid match what's expected for this recipe.
     * The recipe should only match on a combination of 2 paper and 2 rice, with an additional floating slot for determining the pattern on the paper item
     *
     * @param container The crafting menu and inventory
     * @param level The level the player is crafting within
     * @return If the ingredients in this recipe are fulfilled
     */
    @Override
    public boolean matches(CraftingContainer container, Level level) {
        int paperCount = 0;
        int riceCount = 0;
        int dyeCount = 0;
        boolean isValidRecipe = true;
        for(int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack itemstack = container.getItem(i);
            if (!itemstack.isEmpty()) {
                if (itemstack.is(Items.PAPER)) {
                    paperCount++;
                } else if(itemstack.is(ModItems.RICE)) {
                    riceCount++;
                } else if (itemstack.is(ModItemTags.SHOJI_PATTERN_ITEMS)) {
                    dyeCount++;
                } else if(!itemstack.is(ModItemTags.SHOJI_PATTERN_ITEMS)) {
                    isValidRecipe = false;
                }
            }
        }
        return paperCount == 2 && riceCount == 2 && dyeCount <= 1 && isValidRecipe;
    }

    /**
     * Assembles the resulting item for this recipe.
     * In this case, the recipe is hardcoded to make a copy of shoji paper and apply any pattern via NBT.
     * Pattern is determined by an additional ingredient in the crafting container.
     * If there's no additional ingredient, the default pattern (base) is used.
     *
     * @param container The crafting menu and inventory the shoji paper is being assembled within
     * @param registryAccess The accessor for registries
     * @return The instance of the shoji paper with NBT data saved that will build our result
     */
    @Override
    public ItemStack assemble(CraftingContainer container, RegistryAccess registryAccess) {
        ItemStack result = new ItemStack(ModItems.SHOJI_PAPER);
        result.setCount(4);

        String pattern = "base";
        for(int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack itemstack = container.getItem(i);
            if (!itemstack.isEmpty() && !(itemstack.is(Items.PAPER) || itemstack.is(ModItems.RICE))) {
                pattern = ShojiPaper.determinePattern(itemstack);
                break;
            }
        }

        ShojiPaper.savePattern(result, pattern);
        return result;
    }

    /**
     * Determines if the crafting grid is large enough to craft this recipe.
     * This recipe only uses 4 ingredients so any crafting grid should be fine with a 2x2.
     * The additional item for determining the pattern can be applied separately to this and should not affect the base recipe's validity.
     *
     * @param craftingWidth The width of the grid this recipe is being crafted in
     * @param craftingHeight The height of the grid this recipe is being crafted in
     * @return Whether this recipe can be crafted within the given dimensions
     */
    @Override
    public boolean canCraftInDimensions(int craftingWidth, int craftingHeight) {
        return craftingWidth * craftingHeight >= 2;
    }

    /**
     * The recipe serializer associated with this recipe
     *
     * @return The serializer associated with this recipe
     */
    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializerInitializer.SHOJI_PAPER_SERIALIZER.get();
    }
}
