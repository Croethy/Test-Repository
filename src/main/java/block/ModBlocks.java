package block;

import net.croethy.testingmod.TestingMod;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class ModBlocks {

    public static final Block SIFT_FUZZ = registerBlock("sift_fuzz", properties -> new Block(properties.strength(4f)
                    .mapColor(MapColor.GRASS).randomTicks().strength(0.6F).sound(SoundType.NYLIUM))

            );

// Registers blocks
    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name), toRegister);


    }
// Registers the item of blocks
    private static void registerBlockItem(String name, Block block) {

        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name)))));


    }

    public static void registerModBlocks() {
        TestingMod.LOGGER.info("Registering Mod Blocks for" + TestingMod.MOD_ID);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output -> output.accept(SIFT_FUZZ));

    }
}
