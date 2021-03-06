package tc.oc.pgm.command;

import static tc.oc.pgm.util.text.TextException.exception;

import app.ashcon.intake.Command;
import app.ashcon.intake.bukkit.parametric.annotation.Sender;
import org.bukkit.entity.Player;
import tc.oc.pgm.api.match.Match;
import tc.oc.pgm.inventory.ViewInventoryMatchModule;

public final class InventoryCommand {

  @Command(
      aliases = {"inventory", "inv", "vi"},
      desc = "View a player's inventory")
  public void inventory(Match match, @Sender Player viewer, Player holder) {
    final ViewInventoryMatchModule inventories = match.needModule(ViewInventoryMatchModule.class);

    if (inventories.canPreviewInventory(viewer, holder)) {
      inventories.previewInventory(viewer, holder.getInventory());
    } else {
      throw exception("preview.notViewable");
    }
  }
}
