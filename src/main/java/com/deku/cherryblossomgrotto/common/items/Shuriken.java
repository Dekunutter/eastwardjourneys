package com.deku.cherryblossomgrotto.common.items;

import com.deku.cherryblossomgrotto.common.entity.projectile.ShurikenEntity;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class Shuriken extends ShootableItem implements IVanishable {
    private static final float FLIGHT_DROP = 0.0f;
    private static final float FLIGHT_SPEED = 6.0f;
    private static final float VARIATION = 0.0f;

    public Shuriken() {
        super(new Item.Properties().stacksTo(16).tab(ItemGroup.TAB_COMBAT));
        setRegistryName("shuriken");
    }

    /**
     * Gets the use action animation that plays out when a living entity uses this item.
     *
     * @param itemStack The item being used
     * @return The use action animation to invoke
     */
    @Override
    public UseAction getUseAnimation(ItemStack itemStack) {
        return UseAction.BOW;
    }

    /**
     * Logic that plays out whenever a player uses this item.
     * This item passes along an action result that allows us to process subsequent usage actions like
     * processing a player holding back the item in subsequent function calls.
     *
     * @param world The world the item is being used within
     * @param player The player using the item
     * @param hand The hand the player is using the item with
     * @return The action result of using this item
     */
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);

        return ActionResult.pass(itemstack);
    }

    /**
     * Logic that is called during every tick that the user is continuing to use this item
     *
     * @param world The world the item is being used within
     * @param user The entity using this item
     * @param itemstack The item being used
     * @param ticks The number of ticks that this item has been used for
     */
    @Override
    public void onUseTick(World world, LivingEntity user, ItemStack itemstack, int ticks) {
    }

    /**
     * Logic that is called whenever the user completes a use action on this item.
     * Spawns an entity in the world for this item.
     *
     * @param itemstack The item being used
     * @param world The world the item is being used within
     * @param user The entity using this item
     * @param ticks The number of ticks that this item was being used for
     */
    public void releaseUsing(ItemStack itemstack, World world, LivingEntity user, int ticks) {
        if (!world.isClientSide) {
            ShurikenEntity entity = new ShurikenEntity(user, world);

            entity.shootFromRotation(user, user.xRot, user.yRot, FLIGHT_DROP, FLIGHT_SPEED, VARIATION);

            world.addFreshEntity(entity);
        }

        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.abilities.instabuild) {
                itemstack.shrink(1);
            }
        }
    }

    /**
     * Sets a flag that means the item will not be used up until the entity releases the use action
     *
     * @param itemStack The item being used
     * @return Result of the flag for whether item is used on press, or on release
     */
    @Override
    public boolean useOnRelease(ItemStack itemStack) {
        return true;
    }

    /**
     * Gets the duration that the item can be used for
     *
     * @param itemStack The item being used
     * @return The use duration for this item
     */
    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 200;
    }

    /**
     * A list of all projectiles that this shootable item is compatible with
     *
     * @return all items that this shooter is compatible with, in a predicate
     */
    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (itemStack) -> itemStack.getItem() == ModItems.SHURIKEN;
    }

    /**
     * Gets the default range of projectiles from this shooter
     *
     * @return The default range for projectiles from this shooter
     */
    @Override
    public int getDefaultProjectileRange() {
        return 10;
    }
}
