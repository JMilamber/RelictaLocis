package com.amber.structures.datagen;

import com.amber.structures.RelictaLocis;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = RelictaLocis.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class RelictaDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new RelictaStructureTagProvider(packOutput, lookupProvider, RelictaLocis.MOD_ID, existingFileHelper));
        generator.addProvider(event.includeServer(), new RelictaBiomeTagProvider(packOutput, lookupProvider, RelictaLocis.MOD_ID, existingFileHelper));
        generator.addProvider(event.includeServer(), new RelictaInstrumentTagProvider(packOutput, lookupProvider, RelictaLocis.MOD_ID, existingFileHelper));

        /* SUPER IMPORTANT -- Must use lookup provider from WorldGenProvider (which extends DatapackBuiltinEntriesProvider) for datapackRegistry tags
          otherwise it can't find the registries. */
        DatapackBuiltinEntriesProvider datapackprovider = new RelictaWorldGenProvider(packOutput, lookupProvider);
        generator.addProvider(event.includeServer(), datapackprovider);
    }
}
