package de.raik.tnttimer.core.tag;

import de.raik.tnttimer.core.tag.snapshot.TntSnapshot;
import de.raik.tnttimer.core.tag.snapshot.TntTimerExtraKeys;
import java.util.Collections;
import java.util.List;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.entity.player.tag.tags.ComponentNameTag;
import net.labymod.api.client.render.matrix.Stack;
import net.labymod.api.client.render.state.entity.EntitySnapshot;
import net.labymod.api.laby3d.render.queue.SubmissionCollector;
import org.jetbrains.annotations.NotNull;

public class DetonationTimeTag extends ComponentNameTag {

  @Override
  protected @NotNull List<Component> buildComponents(EntitySnapshot snapshot) {
    if (!snapshot.has(TntTimerExtraKeys.PRIMED_TNT)) {
      return super.buildComponents(snapshot);
    }
    TntSnapshot primedTnt = snapshot.get(TntTimerExtraKeys.PRIMED_TNT);
    if (!primedTnt.isTagEnabled() || primedTnt.getSeconds() < 0) {
      return super.buildComponents(snapshot);
    }

    return Collections.singletonList(primedTnt.getFuseComponent());
  }

  @Override
  protected void renderSingle(Stack stack, SubmissionCollector submissionCollector,
      EntitySnapshot snapshot, Component component) {
    this.submitText(stack, submissionCollector, snapshot, component, 0.0F, -45.0F);
  }
}
