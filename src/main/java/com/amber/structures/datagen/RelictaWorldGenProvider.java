package com.amber.structures.datagen;

import com.amber.structures.RelictaLocis;
import com.amber.structures.worldgen.RelictaFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RelictaWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.STRUCTURE, RelictaFeatures::structureBootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, RelictaFeatures::biomeBootstrap);

    public RelictaWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of("minecraft", RelictaLocis.MOD_ID));
    }
}
