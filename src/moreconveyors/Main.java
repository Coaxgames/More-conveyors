package moreconveyors;

import mindustry.content.Blocks;
import mindustry.Vars;
import mindustry.mod.Mod;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.Conveyor;

public class Main extends Mod {
    @Override
    public void init() {
        Conveyor titaniumConveyor = (Conveyor)Blocks.titaniumConveyor;
        titaniumConveyor.junctionReplacement = findBlock("distribution-titanium-junction");
        titaniumConveyor.bridgeReplacement = findBlock("distribution-titanium-bridge-conveyor");
    }

    private Block findBlock(String name) {
        Block block = Vars.content.blocks().find(candidate ->
            candidate.name.equals(name) || candidate.name.endsWith("-" + name)
        );
        if (block == null) {
            throw new IllegalStateException("Missing required mod block: " + name);
        }
        return block;
    }
}
