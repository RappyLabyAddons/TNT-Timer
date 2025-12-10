package de.raik.tnttimer.core.tag.snapshot;

import de.raik.tnttimer.core.TntTimerAddon;
import net.labymod.api.client.entity.item.PrimedTnt;
import net.labymod.api.laby3d.renderer.snapshot.Extras;
import net.labymod.api.laby3d.renderer.snapshot.LabySnapshotFactory;
import net.labymod.api.service.annotation.AutoService;

@AutoService(LabySnapshotFactory.class)
public class TntSnapshotFactory extends LabySnapshotFactory<PrimedTnt, TntSnapshot> {

  private final TntTimerAddon addon;

  public TntSnapshotFactory(TntTimerAddon addon) {
    super(TntTimerExtraKeys.PRIMED_TNT);
    this.addon = addon;
  }

  @Override
  public TntSnapshot create(PrimedTnt primedTnt, Extras extras) {
    return new TntSnapshot(primedTnt, extras, this.addon);
  }
}
