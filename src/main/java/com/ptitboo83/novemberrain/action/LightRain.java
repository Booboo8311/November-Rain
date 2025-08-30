package com.ptitboo83.novemberrain.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;

import java.util.List;

public class LightRain extends StandEntityAction {
    public static final int RAIN_RADIUS = 5;
    public static final float DAMAGE = 1.5F;

    public LightRain(Builder builder) {
        super(builder);
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {

            AxisAlignedBB rainArea = new AxisAlignedBB(
                    standEntity.getX() - RAIN_RADIUS,
                    standEntity.getY() - 1,
                    standEntity.getZ() - RAIN_RADIUS,
                    standEntity.getX() + RAIN_RADIUS,
                    standEntity.getY() + 4,
                    standEntity.getZ() + RAIN_RADIUS
            );

            List<Entity> entities = world.getEntities(null, rainArea);

            for (Entity entity : entities) {
                if (entity != standEntity && entity != standEntity.getUser()) {
                    entity.hurt(DamageSource.DROWN, DAMAGE);
                }
            }
        } else {

            for (int i = 0; i < 20; i++) {
                double x = standEntity.getX() + (world.random.nextDouble() - 0.5) * RAIN_RADIUS * 2;
                double y = standEntity.getY() + 3;
                double z = standEntity.getZ() + (world.random.nextDouble() - 0.5) * RAIN_RADIUS * 2;

                world.addParticle(
                        ParticleTypes.RAIN,
                        x, y, z,
                        0, -0.5, 0
                );
            }
        }
    }
}

