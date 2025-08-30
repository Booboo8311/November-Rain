package com.ptitboo83.novemberrain.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityBlock;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.ptitboo83.novemberrain.AddonMain;
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
                    .staminaCost(2.0F)
                    .standRecoveryTicks(20)));


    public static final RegistryObject<StandEntityAction> EXAMPLE_STAND_BLOCK = ACTIONS.register("example_stand_block", 
            () -> new StandEntityBlock());


    // ...then create the Stand type instance. Moves, stats, entity sizes, and a few other things are determined here.
    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<NovemberRainEntity>> STAND_EXAMPLE_STAND =
            new EntityStandRegistryObject<>("november_rain",
                    STANDS, 
                    () -> new EntityStandType.Builder<StandStats>()
                    .color(0x2967a2)
                    .storyPartName(ModStandsInit.PART_9_NAME)
                    .leftClickHotbar(
                            )
                    .rightClickHotbar(
                            LIGHT_RAIN.get()
                            )
                    .defaultStats(StandStats.class, new StandStats.Builder()
                            .tier(6)
                            .power(1.7)
                            .speed(9)
                            .range(9, 9)
                            .durability(14)
                            .precision(13.6)
                            .build())
                    .addSummonShout(InitSounds.EXAMPLE_STAND_SUMMON_VOICELINE)
                    .addOst(InitSounds.EXAMPLE_STAND_OST)
                    .build(),
                    
                    InitEntities.ENTITIES,
                    () -> new StandEntityType<NovemberRainEntity>(NovemberRainEntity::new, 0.7F, 2.1F)
                    .summonSound(InitSounds.EXAMPLE_STAND_SUMMON_SOUND)
                    .unsummonSound(InitSounds.EXAMPLE_STAND_UNSUMMON_SOUND))
            .withDefaultStandAttributes();
    

    
    // ======================================== ??? ========================================
    
    
    
}
