package net.mcreator.instantbuidlings.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import net.mcreator.instantbuidlings.InstantBuidlingsElements;

@InstantBuidlingsElements.ModElement.Tag
public class Place_guardpostProcedure extends InstantBuidlingsElements.ModElement {
	public Place_guardpostProcedure(InstantBuidlingsElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Place_guardpost!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Place_guardpost!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Place_guardpost!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Place_guardpost!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
					.getTemplateDefaulted(new ResourceLocation("instantbuidlings", "guardpost"));
			if (template != null) {
				template.addBlocksToWorldChunk(world, new BlockPos((int) x, (int) y, (int) z),
						new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
			}
		}
	}
}
