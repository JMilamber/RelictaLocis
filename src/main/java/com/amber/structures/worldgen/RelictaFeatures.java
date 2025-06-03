package com.amber.structures.worldgen;

import com.amber.structures.RelictaLocis;
import com.amber.structures.util.FilterHolderSet;
import com.amber.structures.worldgen.custom.SnowyCampsite;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Map;

import static com.amber.structures.RelictaLocis.relictaLocation;

public class RelictaFeatures {

    public static final ResourceKey<Structure> SNOWY_CAMPSITE_KEY = registerStructureKey("snowy_cmapsite");

    public static void structureBootstrap(BootstrapContext<Structure> context) {
        var biomes = context.lookup(Registries.BIOME);
        context.register(SNOWY_CAMPSITE_KEY, new SnowyCampsite(new Structure.StructureSettings(new FilterHolderSet<>(biomes.getOrThrow(Tags.Biomes.IS_COLD_OVERWORLD), biomes.getOrThrow(Tags.Biomes.IS_COLD_OVERWORLD)), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE)));
    }

    public static void biomeBootstrap(BootstrapContext<BiomeModifier> biomeContext) {
        var placedFeatures = biomeContext.lookup(Registries.PLACED_FEATURE);
        var structures = biomeContext.lookup(Registries.STRUCTURE);
        var biomes = biomeContext.lookup(Registries.BIOME);

    }

    public static ResourceKey<Structure> registerStructureKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, relictaLocation(name));
    }

    private static ResourceKey<BiomeModifier> registerBiomeKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, relictaLocation(name));
    }

}
