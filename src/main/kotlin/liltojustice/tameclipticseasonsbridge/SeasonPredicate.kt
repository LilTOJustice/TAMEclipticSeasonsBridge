package liltojustice.tameclipticseasonsbridge

import com.teamtea.eclipticseasons.api.constant.solar.Season
import com.teamtea.eclipticseasons.api.util.EclipticUtil
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.predicate.type.StaticPredicateType
import net.minecraft.client.Minecraft
import kotlin.reflect.typeOf

object SeasonPredicate: StaticPredicateType<SeasonPredicate.Arguments>(
    "season", typeOf<Arguments>()
) {
    data class Arguments(val season: Season): TriggerArguments()

    override fun test(arguments: Arguments): Boolean {
        val player = Minecraft.getInstance().player ?: return false
        return EclipticUtil.INSTANCE.getAgroSeason(player.level(), player.blockPosition()) == arguments.season
    }
}