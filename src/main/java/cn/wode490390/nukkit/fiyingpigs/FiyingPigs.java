package cn.wode490390.nukkit.fiyingpigs;

import cn.nukkit.entity.passive.EntityPig;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.NukkitRunnable;

public class FiyingPigs extends PluginBase {

    @Override
    public void onEnable() {
        new NukkitRunnable() {
            @Override
            public void run() {
                getServer().getOnlinePlayers().values().stream()
                        .filter(player -> player.riding != null && player.riding.getNetworkId() == EntityPig.NETWORK_ID)
                        .forEach(player -> player.riding.setMotion(player.getDirectionVector().multiply(1)));
            }
        }.runTaskTimer(this, 5, 5);

        try {
            new MetricsLite(this);
        } catch (Throwable ignore) {

        }
    }
}
