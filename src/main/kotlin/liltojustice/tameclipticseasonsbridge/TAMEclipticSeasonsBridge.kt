package liltojustice.tameclipticseasonsbridge

import liltojustice.trueadaptivemusicapi.TAMAPI
import net.minecraft.client.Minecraft
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

/**
 * Main mod class.
 *
 * An example for blocks is in the `blocks` package of this mod.
 */
@Mod(TAMEclipticSeasonsBridge.ID)
@EventBusSubscriber()
@Suppress("unused")
object TAMEclipticSeasonsBridge {
    const val ID = "tameclipticseasonsbridge"

    // the logger for our mod
    val LOGGER: Logger = LogManager.getLogger(ID)

    init {
        val obj = runForDist(clientTarget = {
            MOD_BUS.addListener(::onClientSetup)
            Minecraft.getInstance()
        }, serverTarget = {
            MOD_BUS.addListener(::onServerSetup)
            "test"
        })

        println(obj)
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        TAMAPI.registerPredicateType(SeasonPredicate)
    }

    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
    }

    @SubscribeEvent
    fun onCommonSetup(event: FMLCommonSetupEvent) {
    }
}
