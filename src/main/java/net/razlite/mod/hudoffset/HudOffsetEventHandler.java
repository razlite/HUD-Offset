package net.razlite.mod.hudoffset;

import com.google.common.eventbus.Subscribe;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by Razlite on 2016/10/23.
 */
public class HudOffsetEventHandler
{
    @SubscribeEvent
    public void renderPreEvent(RenderGameOverlayEvent.Pre event)
    {
        // Tabメニュー
        if(event.type.equals(RenderGameOverlayEvent.ElementType.PLAYER_LIST))
        {
            int posX = HUDOffset.tabList_x;
            int posY = HUDOffset.tabList_y;
            int posZ = 0;

            GL11.glTranslated(posX, posY, posZ);
        }

        // ボスの体力バー
        if(event.type.equals(RenderGameOverlayEvent.ElementType.BOSSHEALTH))
        {
            int posX = HUDOffset.bossHealth_x;
            int posY = HUDOffset.bossHealth_y;
            int posZ = 0;

            GL11.glTranslated(posX, posY, posZ);
        }
    }
}
