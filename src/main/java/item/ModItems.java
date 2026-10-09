package item;

import net.croethy.testingmod.TestingMod;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    //tutorial stuff below
    public static final Item SIFTITE = registerItem("siftite", Item::new);
    public static final Item RAW_SIFTITE = registerItem("raw_siftite", Item::new);
// helper method
    private static Item registerItem(String name, Function<Item.Properties, Item> function) {

        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TestingMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        TestingMod.LOGGER.info("registering items for" + TestingMod.MOD_ID);
// Putting item on creative mode tab
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> output.accept(SIFTITE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> output.accept(RAW_SIFTITE));
    }
}
