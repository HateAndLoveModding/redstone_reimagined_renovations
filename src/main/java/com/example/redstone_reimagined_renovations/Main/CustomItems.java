package com.example.redstone_reimagined_renovations.Main;

import com.example.redstone_reimagined_renovations.CustomItemClasses.FiniteWater;
import com.example.redstone_reimagined_renovations.CustomItemClasses.InfiniteWater;
import com.example.redstone_reimagined_renovations.RedstoneReimaginedRenovations;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class CustomItems {
    public static final Item INFINITE_WATER_BUCKET = registerItem("infinite_water_bucket",
            new InfiniteWater(new FabricItemSettings()));
    public static final Item FINITE_WATER_BUCKET = registerItem("finite_water_bucket",
            new FiniteWater(new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RedstoneReimaginedRenovations.MOD_ID, name), item);
    }
    public static void addItemsToItemGroups() {
        addToItemGroup(ItemGroups.FUNCTIONAL, INFINITE_WATER_BUCKET);
        addToItemGroup(ItemGroups.FUNCTIONAL, FINITE_WATER_BUCKET);
    }
    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        RedstoneReimaginedRenovations.LOGGER.debug("Registering Mod Items for " + RedstoneReimaginedRenovations.MOD_ID);
        addItemsToItemGroups();
    }
}
