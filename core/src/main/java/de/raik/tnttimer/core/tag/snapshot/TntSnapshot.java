package de.raik.tnttimer.core.tag.snapshot;

import de.raik.tnttimer.core.TntTimerAddon;
import java.text.DecimalFormat;
import net.labymod.api.Laby;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.component.format.TextColor;
import net.labymod.api.client.entity.item.PrimedTnt;
import net.labymod.api.laby3d.renderer.snapshot.AbstractLabySnapshot;
import net.labymod.api.laby3d.renderer.snapshot.Extras;
import net.labymod.api.util.math.MathHelper;

public class TntSnapshot extends AbstractLabySnapshot {

  private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

  private final boolean enabled;
  private final float seconds;
  private final Component fuseComponent;

  protected TntSnapshot(PrimedTnt tnt, Extras extras, TntTimerAddon addon) {
    super(extras);
    this.enabled = Laby.labyAPI().permissionRegistry().isPermissionEnabled(
        TntTimerAddon.PERMISSION,
        addon.configuration().enabled().get()
    );
    this.seconds = tnt.getFuse() / 20F;
    this.fuseComponent = Component.text(
        FORMAT.format(this.seconds) + "s",
        addon.configuration().colored().get() ? this.getColor(tnt.getFuse()) : NamedTextColor.WHITE
    );
  }

  public boolean isTagEnabled() {
    return this.enabled;
  }

  public float getSeconds() {
    return this.seconds;
  }

  public Component getFuseComponent() {
    return this.fuseComponent;
  }

  private TextColor getColor(int ticks) {
    int green = MathHelper.clamp(255 * ticks / 80, 0, 255);
    return TextColor.color(255 - green, green, 0);
  }
}
