package com.amber.structures.util;

import com.mojang.logging.LogUtils;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;

public class RelictaUtil {

    public static int chunkDistanceTo(ChunkPos start, ChunkPos end) {
        return Mth.floor(distanceTo2D(end.x - start.x, end.z - start.z));
    }

    public static boolean chunkMatch(ChunkPos pos1, ChunkPos pos2) {
        return pos1.x == pos2.x && pos1.z == pos2.z;
    }

    public static double distanceTo2D(double side, double side2) {
        return  Math.sqrt(side * side + side2 * side2);
    }

    public static ChunkPos offsetChunk(ChunkPos pos, int xOffset, int zOffset) {
        return new ChunkPos(pos.x + xOffset, pos.z + zOffset);
    }
}
