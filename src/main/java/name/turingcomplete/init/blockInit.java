package name.turingcomplete.init;

import name.turingcomplete.TuringComplete;
import name.turingcomplete.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class blockInit {
    public static final NAND_Gate_Block NAND_GATE = registerWithItem("nand_gate_block",
            new NAND_Gate_Block(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));


    public static final NOT_Gate_Block NOT_GATE = registerWithItem("not_gate_block",
            new NOT_Gate_Block(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final AND_Gate_Block AND_GATE = registerWithItem("and_gate_block",
            new AND_Gate_Block(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Logic_Base_Plate_Block LOGIC_BASE_PLATE_BLOCK = registerWithItem("logic_base_plate_block",
            new Logic_Base_Plate_Block(Block.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)
            ));

    public static final OR_Gate_Block OR_GATE = registerWithItem("or_gate_block",
            new OR_Gate_Block(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static <T extends Block> T register(String name, T block){
        return Registry.register(Registries.BLOCK, TuringComplete.id(name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings){
        T registered = register(name, block);
        itemInit.register(name, new BlockItem(registered, settings));
        return registered;
    }

    public static <T extends Block> T registerWithItem(String name, T block){
        return registerWithItem(name, block, new Item.Settings());
    }

    public static void load(){}
}