package com.ptitboo83.novemberrain.action;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3d;

public class HeavyRain extends LightRain {

    public HeavyRain(Builder builder) {
        super(builder);
        this.DAMAGE_PER_TICK *= 1.5f;
    }
    
    @Override
    protected void affectEntity(Entity targetEntity) {
        super.affectEntity(targetEntity);
        Vector3d curMotion = targetEntity.getDeltaMovement();
        Vector3d newMotion = new Vector3d(0, curMotion.y - 0.5, 0);
        // moves the target downwards
        targetEntity.setDeltaMovement(newMotion); 
        // this is to sync the player velocity (because in Minecraft's code the player motion is decided on the client, not on the server)
        targetEntity.hurtMarked = true; 
    }
}

