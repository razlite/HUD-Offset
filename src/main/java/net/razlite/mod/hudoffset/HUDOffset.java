package net.razlite.mod.hudoffset;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Razlite on 2016/10/23.
 */

@Mod(modid = HUDOffset.MODID, version = HUDOffset.VERSION)
public class HUDOffset
{
    public static final String MODID    = "HUD-Offset";
    public static final String VERSION  = "1.0.1";

    /* Offset Configs */
    // スコアボード
//    public static int scoreboard_x;
//    public static int scoreboard_y;

    // TabList
    public static int tabList_x;
    public static int tabList_y;

    // ボスの体力バー
    public static int bossHealth_x;
    public static int bossHealth_y;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        // Configの処理
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());

        try
        {
            cfg.load();
            
            // スコアボード
//            scoreboard_x = cfg.getInt("ScoreBoard-Offset-X", "HUD", 0, 0, 0, "");
//            scoreboard_y = cfg.getInt("ScoreBoard-Offset-Y", "HUD", 0, 0, 0, "");

            // TabList
            tabList_x = cfg.getInt("TabList-Offset-X", "HUD", 0, 0, 0, "");
            tabList_y = cfg.getInt("TabList-Offset-Y", "HUD", 0, 0, 0, "");

            // ボスの体力バー
            bossHealth_x = cfg.getInt("BossHud-Offset-X", "HUD", 0, 0, 0, "");
            bossHealth_y = cfg.getInt("BossHud-Offset-Y", "HUD", 0, 0, 0, "");
        }
        catch(Exception e)
        {
        }
        finally
        {
            cfg.save();
        }
    }

    @EventHandler
    public static void Init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new HudOffsetEventHandler());
    }
}
