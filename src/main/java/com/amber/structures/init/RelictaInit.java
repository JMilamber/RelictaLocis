package com.amber.structures.init;

import com.amber.structures.RelictaLocis;
import com.amber.structures.worldgen.custom.SnowyCampsite;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RelictaInit {

    public static final DeferredRegister<Structure> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE, RelictaLocis.MOD_ID);
     public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registries.STRUCTURE_TYPE, RelictaLocis.MOD_ID);
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENTS = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, RelictaLocis.MOD_ID);
    public static final DeferredRegister<Instrument> INSTRUMENTS = DeferredRegister.create(Registries.INSTRUMENT, RelictaLocis.MOD_ID);

    public static final DeferredHolder<StructureType<?>, StructureType<SnowyCampsite>> SNOWY_CAMPSITE = DEFERRED_REGISTRY_STRUCTURE.register("snowy_cmapsite", () -> explicitStructureTypeTyping(SnowyCampsite.CODEC));

    private static <T extends Structure> Supplier<T> registerStructure(String name, Supplier<T> structure) {
        return STRUCTURES.register(name, structure);
    }

    /**
     * ** TelepathicGrunt Structure Tutorial 1.20.2 neoforge **
     * Originally, I had a double lambda ()->()-> for the RegistryObject line above, but it turns out that
     * some IDEs cannot resolve the typing correctly. This method explicitly states what the return type
     * is so that the IDE can put it into the DeferredRegistry properly.
     */
    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(MapCodec<T> structureCodec) {
        return () -> structureCodec;
    }

    public static void register(IEventBus eventBus) {

        PLACEMENTS.register(eventBus);

    }
}
