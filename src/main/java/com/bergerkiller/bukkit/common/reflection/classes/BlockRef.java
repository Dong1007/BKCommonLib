package com.bergerkiller.bukkit.common.reflection.classes;

import org.bukkit.craftbukkit.v1_8_R2.util.CraftMagicNumbers;

import net.minecraft.server.v1_8_R2.Block;
import net.minecraft.server.v1_8_R2.BlockPosition;
import net.minecraft.server.v1_8_R2.Explosion;
import net.minecraft.server.v1_8_R2.IBlockData;

import com.bergerkiller.bukkit.common.reflection.ClassTemplate;
import com.bergerkiller.bukkit.common.reflection.FieldAccessor;
import com.bergerkiller.bukkit.common.reflection.MethodAccessor;
import com.bergerkiller.bukkit.common.reflection.SafeDirectField;

import com.bergerkiller.bukkit.common.reflection.NMSClassTemplate;

public class BlockRef {

    public static final ClassTemplate<?> TEMPLATE = NMSClassTemplate.create("Block");
    public static final FieldAccessor<String> name = TEMPLATE.getField("name");
    public static final MethodAccessor<Void> dropNaturally = TEMPLATE.getMethod("dropNaturally", WorldRef.TEMPLATE.getType(), BlockPosition.class, IBlockData.class, float.class, int.class);
    public static final MethodAccessor<Void> ignite = TEMPLATE.getMethod("wasExploded", WorldRef.TEMPLATE.getType(), BlockPosition.class, Explosion.class);

    @Deprecated
    public static final FieldAccessor<Integer> id = new SafeDirectField<Integer>() {
        @Override
        public Integer get(Object instance) {
            return getBlockId(instance);
        }

        @Override
        public boolean set(Object instance, Integer value) {
            return false;
        }
    };

    @Deprecated
    public static int getBlockId(Object instance) {
        return CraftMagicNumbers.getId((Block) instance);
    }
}
