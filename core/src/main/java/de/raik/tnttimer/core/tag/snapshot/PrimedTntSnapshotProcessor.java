package de.raik.tnttimer.core.tag.snapshot;

import net.labymod.api.client.entity.Entity;
import net.labymod.api.client.entity.item.PrimedTnt;
import net.labymod.api.client.render.state.entity.EntitySnapshotProcessor;
import net.labymod.api.client.render.state.entity.EntitySnapshotRegistry;
import net.labymod.api.laby3d.renderer.snapshot.ExtrasWriter;
import net.labymod.api.service.annotation.AutoService;

@AutoService(EntitySnapshotProcessor.class)
public class PrimedTntSnapshotProcessor extends EntitySnapshotProcessor<PrimedTnt> {

  protected PrimedTntSnapshotProcessor(EntitySnapshotRegistry registry) {
    super(registry);
  }

  @Override
  public boolean supports(Entity entity) {
    return entity instanceof PrimedTnt;
  }

  @Override
  public void process(PrimedTnt primedTnt, float partialTicks, ExtrasWriter entityWriter) {
    this.registry().captureSnapshot(entityWriter, TntTimerExtraKeys.PRIMED_TNT, primedTnt);
  }
}
