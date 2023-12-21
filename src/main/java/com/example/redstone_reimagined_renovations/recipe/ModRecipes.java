package com.example.redstone_reimagined_renovations.recipe;

import com.example.redstone_reimagined_renovations.RedstoneReimaginedRenovations;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(RedstoneReimaginedRenovations.MOD_ID, FreezerRecipe.Serializer.ID),
                FreezerRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(RedstoneReimaginedRenovations.MOD_ID, FreezerRecipe.Type.ID),
                FreezerRecipe.Type.INSTANCE);
    }
}
