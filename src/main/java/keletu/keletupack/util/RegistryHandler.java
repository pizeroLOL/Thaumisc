package keletu.keletupack.util;

import keletu.keletupack.init.ModBlocks;
import keletu.keletupack.items.*;
import keletu.keletupack.keletupack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber

public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister( RegistryEvent.Register<Item> event )
    {
        event.getRegistry().registerAll( ModItems.ITEMS.toArray( new Item[0] ) );
        event.getRegistry().registerAll(new Cleansingamulet());
        event.getRegistry().registerAll(new warppaper());
        event.getRegistry().registerAll(new coin_witchery());
        event.getRegistry().registerAll(new coin_adventure());
        event.getRegistry().registerAll(new coin_bleed());
        event.getRegistry().registerAll(new coin_magic());
        event.getRegistry().registerAll(new EnderShard());
        event.getRegistry().registerAll(new NetherShard());
        event.getRegistry().registerAll(new Ichor());
        event.getRegistry().registerAll(new IchorCloth());
        event.getRegistry().registerAll(new IchorIngot());
        event.getRegistry().registerAll(new IchorBucket());
    }
    @SubscribeEvent
    public static void onModelRegister( ModelRegistryEvent event )
    {
        for ( Item item : ModItems.ITEMS )
        {
            if ( item instanceof IHasModel )
            {
                ( (IHasModel) item).registerModels();
            }
        }
        //新加入对于block的信息注册
        for (net.minecraft.block.Block block: ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel)block).registerModels();
            }
        }

    }
    //新加入对物品的注册事件
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }
}
