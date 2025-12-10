package de.raik.tnttimer.core.tag.snapshot;

import net.labymod.api.laby3d.renderer.snapshot.ExtraKey;

public class TntTimerExtraKeys {

  public static final ExtraKey<TntSnapshot> PRIMED_TNT = ExtraKey.of(
      "tnttimer_tnt",
      TntSnapshot.class
  );

}
