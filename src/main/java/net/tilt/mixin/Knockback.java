package net.tilt.mixin;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class Knockback {
	@Inject(at = @At("HEAD"), method = "renderWorld")
	private void bobFix(float f, long j, MatrixStack l, CallbackInfo info) {
		LivingEntity player = (LivingEntity) MinecraftClient.getInstance().getCameraEntity();
		if (player != null) {
			double x = player.getVelocity().x;
			double z = player.getVelocity().z;
			player.knockbackVelocity = (float) (MathHelper.atan2(-z, -x) * 57.2957763671875D - (double) player.getYaw());
		}
	}
}
