package com.ptitboo83.novemberrain.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.ptitboo83.novemberrain.AddonMain;
import com.ptitboo83.novemberrain.action.HeavyRain;
import com.ptitboo83.novemberrain.action.LightRain;
import com.ptitboo83.novemberrain.entity.NovemberRainEntity;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), AddonMain.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), AddonMain.MOD_ID);
    
 // ======================================== November Rain ========================================
    public static final RegistryObject<StandEntityAction> LIGHT_RAIN = ACTIONS.register("light_rain",
            () -> new LightRain(new StandEntityAction.Builder()
                    .holdType()
                    .staminaCostTick(2.0F)
                    .standRecoveryTicks(5)));
    
    public static final RegistryObject<StandEntityAction> HEAVY_RAIN = ACTIONS.register("heavy_rain",
            () -> new HeavyRain(new StandEntityAction.Builder()
                    .holdType()
                    .staminaCostTick(5.0F)
                    .standRecoveryTicks(20)));


//    public static final RegistryObject<StandEntityAction> EXAMPLE_STAND_BLOCK = ACTIONS.register("example_stand_block", 
//            () -> new StandEntityBlock());


    // ...then create the Stand type instance. Moves, stats, entity sizes, and a few other things are determined here.
    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<NovemberRainEntity>> NOVEMBER_RAIN =
            new EntityStandRegistryObject<>("november_rain",
                    STANDS, 
                    () -> new EntityStandType.Builder<StandStats>()
                    .color(0x2967a2)
                    .storyPartName(ModStandsInit.PART_9_NAME)
                    .leftClickHotbar(
                            LIGHT_RAIN.get()
                            )
                    .rightClickHotbar(
                            HEAVY_RAIN.get()
                            )
                    .defaultStats(StandStats.class, new StandStats.Builder()
                            .power(1.7)
                            .speed(9)
                            .range(9, 9)
                            .durability(14)
                            .precision(13.6)
                            .build())
                    .addSummonShout(InitSounds.NOVEMBER_RAIN_SUMMON_VOICELINE)
                    .addOst(InitSounds.NOVEMBER_RAIN_OST)
                    .build(),
                    
                    InitEntities.ENTITIES,
                    () -> new StandEntityType<NovemberRainEntity>(NovemberRainEntity::new, 0.7F, 2.1F)
                    .summonSound(InitSounds.NOVEMBER_RAIN_SUMMON_SOUND)
                    .unsummonSound(InitSounds.NOVEMBER_RAIN_UNSUMMON_SOUND))
            .withDefaultStandAttributes();
    

    
    // ======================================== ??? ========================================
    
    
    
}
