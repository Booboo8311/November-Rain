package com.ptitboo83.novemberrain.client.render;

import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandModelRegistry;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;
import com.ptitboo83.novemberrain.AddonMain;
import com.ptitboo83.novemberrain.entity.NovemberRainEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class ExampleStandRenderer extends StandEntityRenderer<NovemberRainEntity, StandEntityModel<NovemberRainEntity>> {
    
    public ExampleStandRenderer(EntityRendererManager renderManager) {
        super(renderManager, 
                StandModelRegistry.registerModel(new ResourceLocation(AddonMain.MOD_ID, "november_rain"), ExampleStandModel::new),
                new ResourceLocation(AddonMain.MOD_ID, "textures/entity/stand/november_rain.png"), 0);
    }
}
