package de.raik.tnttimer.core;

import de.raik.tnttimer.core.tag.DetonationTimeTag;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.entity.player.tag.PositionType;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class TntTimerAddon extends LabyAddon<TntTimerConfig> {

  public static final String PERMISSION = "tnttimer";

  @Override
  protected void enable() {
    this.registerSettingCategory();
    this.labyAPI().permissionRegistry().register(PERMISSION, true);
    this.labyAPI().tagRegistry().register(
        "detonation_time",
        PositionType.ABOVE_NAME,
        new DetonationTimeTag()
    );
  }

  @Override
  protected Class<TntTimerConfig> configurationClass() {
    return TntTimerConfig.class;
  }
}
