package com.amber.structures.util;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;

import java.util.ArrayList;

public class RelictaData extends SavedData {

    // Create new instance of saved data
    public static RelictaData create() {
        return new RelictaData();
    }

    public static RelictaData instance(DimensionDataStorage storage) {
        return storage.computeIfAbsent(new Factory<>(RelictaData::create, RelictaData::load), "path_data");
    }

    // Load existing instance of saved data
    public static RelictaData load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        RelictaData data = RelictaData.create();
        // Load saved data
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider registries) {
        return tag;
    }
}
