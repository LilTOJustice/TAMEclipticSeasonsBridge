package liltojustice.tameclipticseasonsbridge

import com.teamtea.eclipticseasons.api.constant.solar.Season
import com.teamtea.eclipticseasons.api.util.EclipticUtil
import liltojustice.trueadaptivemusic.client.trigger.predicate.MusicPredicate
import net.minecraft.client.Minecraft

class SeasonPredicate(private val season: Season): MusicPredicate() {
    override fun test(): Boolean {
        val player = Minecraft.getInstance().player ?: return false
        return EclipticUtil.INSTANCE.getAgroSeason(player.level(), player.blockPosition()) == season
    }
}