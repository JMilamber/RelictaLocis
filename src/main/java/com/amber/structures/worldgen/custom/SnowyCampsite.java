package com.amber.structures.worldgen.custom;

import com.amber.structures.init.RelictaInit;
import com.amber.structures.util.FilterHolderSet;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;


import java.util.Map;
import java.util.Optional;

public class SnowyCampsite extends Structure {
    public static final MapCodec<StructureSettings> CUSTOM_STRUCTURE_SETTINGS_CODEC = RecordCodecBuilder.mapCodec(
            codecBuilder -> codecBuilder.group(
                            FilterHolderSet.codec(Registries.BIOME, Biome.CODEC, false).fieldOf("biomes").forGetter(x -> x.biomes() instanceof FilterHolderSet<Biome> filterHolderSet ? filterHolderSet : new FilterHolderSet<>(x.biomes(), HolderSet.empty())),
                            Codec.simpleMap(MobCategory.CODEC, StructureSpawnOverride.CODEC, StringRepresentable.keys(MobCategory.values()))
                                    .fieldOf("spawn_overrides")
                                    .forGetter(StructureSettings::spawnOverrides),
                            GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(StructureSettings::step),
                            TerrainAdjustment.CODEC
                                    .optionalFieldOf("terrain_adaptation", new StructureSettings(
                                            HolderSet.direct(), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE
                                    ).terrainAdaptation())
                                    .forGetter(StructureSettings::terrainAdaptation)
                    )
                    .apply(codecBuilder, StructureSettings::new)
    );

    public static final MapCodec<SnowyCampsite> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    CUSTOM_STRUCTURE_SETTINGS_CODEC.forGetter(structureInfo -> structureInfo.modifiableStructureInfo().getOriginalStructureInfo().structureSettings())
            ).apply(instance, SnowyCampsite::new));

    public SnowyCampsite(StructureSettings settings) {
        super(settings);
    }

    public static <S extends Structure> RecordCodecBuilder<S, Structure.StructureSettings> settingsCodec(RecordCodecBuilder.Instance<S> instance) {
        return Structure.StructureSettings.CODEC.forGetter(p_226595_ -> p_226595_.modifiableStructureInfo().getOriginalStructureInfo().structureSettings()); // FORGE: Patch codec to ignore field redirect coremods.
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        return Optional.empty();
    }

    @Override
    public StructureType<?> type() {
        return RelictaInit.SNOWY_CAMPSITE.get();
    }
}
