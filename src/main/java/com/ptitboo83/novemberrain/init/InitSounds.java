package com.ptitboo83.novemberrain.init;

import java.util.function.Supplier;

import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.util.mc.OstSoundList;
import com.ptitboo83.novemberrain.AddonMain;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, AddonMain.MOD_ID); // TODO sounds.json
    
    public static final RegistryObject<SoundEvent> NOVEMBER_RAIN_SUMMON_VOICELINE = SOUNDS.register("jodio_november_rain", 
            () -> new SoundEvent(new ResourceLocation(AddonMain.MOD_ID, "jodio_november_rain")));

    public static final Supplier<SoundEvent> NOVEMBER_RAIN_SUMMON_SOUND = ModSounds.STAND_SUMMON_DEFAULT;
    
    public static final Supplier<SoundEvent> NOVEMBER_RAIN_UNSUMMON_SOUND = ModSounds.STAND_UNSUMMON_DEFAULT;
    
//    public static final Supplier<SoundEvent> NOVEMBER_RAIN_PUNCH_LIGHT = ModSounds.STAND_PUNCH_LIGHT;
//    
//    public static final Supplier<SoundEvent> NOVEMBER_RAIN_PUNCH_HEAVY = ModSounds.STAND_PUNCH_HEAVY;
//    
//    public static final Supplier<SoundEvent> NOVEMBER_RAIN_PUNCH_BARRAGE = ModSounds.STAND_PUNCH_LIGHT;
    
    public static final OstSoundList NOVEMBER_RAIN_OST = new OstSoundList(
            new ResourceLocation(AddonMain.MOD_ID, "november_rain_ost"), SOUNDS);
}
