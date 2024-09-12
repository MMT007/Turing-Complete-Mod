package name.turingcomplete.data.provider;

import name.turingcomplete.init.blockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TuringCompleteRecipeProvider extends FabricRecipeProvider {
    public TuringCompleteRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, blockInit.LOGIC_BASE_PLATE_BLOCK, 12)
                .input('E', Blocks.SMOOTH_STONE_SLAB)
                .pattern("   ")
                .pattern("   ")
                .pattern("EEE")
                .criterion(hasItem(Blocks.SMOOTH_STONE_SLAB),conditionsFromItem(Blocks.SMOOTH_STONE_SLAB))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, blockInit.NAND_GATE, 3)
                .input('E', blockInit.LOGIC_BASE_PLATE_BLOCK)
                .input('T', Blocks.REDSTONE_TORCH)
                .input('R', Blocks.REDSTONE_WIRE)
                .pattern(" R ")
                .pattern("TRT")
                .pattern("EEE")
                .criterion(hasItem(Blocks.SMOOTH_STONE_SLAB),conditionsFromItem(Blocks.SMOOTH_STONE_SLAB))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, blockInit.NOT_GATE, 2)
                .input('N', blockInit.NAND_GATE)
                .input('R', Blocks.REDSTONE_WIRE)
                .pattern("RR ")
                .pattern("RN ")
                .pattern("RR ")
                .criterion(hasItem(Blocks.SMOOTH_STONE_SLAB),conditionsFromItem(Blocks.SMOOTH_STONE_SLAB))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, blockInit.AND_GATE, 1)
                .input('N', blockInit.NAND_GATE)
                .input('R', Blocks.REDSTONE_WIRE)
                .input('G', blockInit.NOT_GATE)
                .pattern("GR ")
                .pattern(" NG")
                .pattern("GR ")
                .criterion(hasItem(Blocks.SMOOTH_STONE_SLAB),conditionsFromItem(Blocks.SMOOTH_STONE_SLAB))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, blockInit.OR_GATE, 1)
                .input('N', blockInit.NAND_GATE)
                .input('R', Blocks.REDSTONE_WIRE)
                .input('G', blockInit.NOT_GATE)
                .pattern("GR ")
                .pattern(" N ")
                .pattern("GR ")
                .criterion(hasItem(Blocks.SMOOTH_STONE_SLAB),conditionsFromItem(Blocks.SMOOTH_STONE_SLAB))
                .offerTo(exporter);
    }
}