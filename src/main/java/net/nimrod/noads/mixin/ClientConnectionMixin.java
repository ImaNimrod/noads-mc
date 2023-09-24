package net.nimrod.noads.mixin;

import net.nimrod.noads.blocker.blockers.AdvancementBlocker;
import net.nimrod.noads.blocker.BlockerManager;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.AdvancementUpdateS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {

    @Inject(method = "handlePacket", at = @At("HEAD"), cancellable = true)
    private static <T extends PacketListener> void onHandlePacket(Packet<T> packet, PacketListener listener, CallbackInfo ci) {
        if (BlockerManager.getBlocker(AdvancementBlocker.class).getEnabled() && packet instanceof AdvancementUpdateS2CPacket) ci.cancel();
    }

}
