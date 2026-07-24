package liltojustice.tameclipticseasonsbridge

import liltojustice.trueadaptivemusicapi.TAMAPI
import net.minecraftforge.fml.common.Mod

@Mod("tameclipticseasonsbridge")
class TAMEclipticSeasonsBridge {
    init {
        TAMAPI.registerPredicateType(SeasonPredicate)
    }
}