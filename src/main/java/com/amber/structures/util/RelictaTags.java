package com.amber.structures.util;

import com.amber.structures.RelictaLocis;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

import static com.amber.structures.RelictaLocis.relictaLocation;

public class RelictaTags {
    public static class Blocks {


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RelictaLocis.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(RelictaLocis.MOD_ID, name));
        }
    }

    public static class Structures {


        private static TagKey<Structure> createTag(String name) {
            return create(relictaLocation(name));
        }

        public static TagKey<Structure> create(final ResourceLocation name) {
            return TagKey.create(Registries.STRUCTURE, name);
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> CAMPSITE_BIOMES = createTag("worldgen/has_structure/campsite_biomes");

        private static TagKey<Biome> createTag(String name) {
            return create(relictaLocation(name));
        }

        public static TagKey<Biome> create(final ResourceLocation name) {
            return TagKey.create(Registries.BIOME, name);
        }
    }

    public static class Instruments {
        public static TagKey<Instrument> RELIC_INSTRUMENTS = createTag("relic_instruments");

        private static TagKey<Instrument> createTag(String name) {
            return  create(relictaLocation(name));
        }

        public static TagKey<Instrument> create(final ResourceLocation name) {
            return TagKey.create(Registries.INSTRUMENT, name);
        }
    }

}
