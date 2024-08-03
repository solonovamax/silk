@file:Suppress("unused")

package net.silkmc.silk.rendering

import com.github.ajalt.colormath.Color
import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.blaze3d.vertex.VertexConsumer
import net.minecraft.client.renderer.block.model.BakedQuad


fun VertexConsumer.setColor(color: Color): VertexConsumer = color.toSRGB().let { rgb ->
    setColor(rgb.redInt, rgb.greenInt, rgb.blueInt, rgb.alphaInt)
}

// alias for yarn
fun VertexConsumer.color(color: Color): VertexConsumer = setColor(color)

fun VertexConsumer.addVertex(
    x: Float,
    y: Float,
    z: Float,
    color: Color,
    u: Float,
    v: Float,
    overlay: Int,
    light: Int,
    normalX: Float,
    normalY: Float,
    normalZ: Float,
) = color.toSRGB().toRGBInt().toRGBA().toInt().let { rgba ->
    addVertex(x, y, z, rgba, u, v, overlay, light, normalX, normalY, normalZ)
}

// alias for yarn
fun VertexConsumer.vertex(
    x: Float,
    y: Float,
    z: Float,
    color: Color,
    u: Float,
    v: Float,
    overlay: Int,
    light: Int,
    normalX: Float,
    normalY: Float,
    normalZ: Float,
) = addVertex(x, y, z, color, u, v, overlay, light, normalX, normalY, normalZ)

fun VertexConsumer.putBulkData(
    pose: PoseStack.Pose,
    quad: BakedQuad,
    color: Color,
    light: Int,
    overlay: Int,
) = color.toSRGB().let { rgb -> putBulkData(pose, quad, rgb.r, rgb.g, rgb.b, rgb.alpha, light, overlay) }

// alias for yarn
fun VertexConsumer.quad(
    pose: PoseStack.Pose,
    quad: BakedQuad,
    color: Color,
    light: Int,
    overlay: Int,
) = putBulkData(pose, quad, color, light, overlay)

fun VertexConsumer.putBulkData(
    pose: PoseStack.Pose,
    quad: BakedQuad,
    brightness: FloatArray,
    color: Color,
    lightmap: IntArray,
    overlay: Int,
    readAlpha: Boolean,
) = color.toSRGB().let { rgb -> putBulkData(pose, quad, brightness, rgb.r, rgb.g, rgb.b, rgb.alpha, lightmap, overlay, readAlpha) }

// alias for yarn
fun VertexConsumer.quad(
    pose: PoseStack.Pose,
    quad: BakedQuad,
    brightness: FloatArray,
    color: Color,
    lightmap: IntArray,
    overlay: Int,
    readAlpha: Boolean,
) = putBulkData(pose, quad, brightness, color, lightmap, overlay, readAlpha)

/**
 * Function for scoping all transformations to the [PoseStack].
 *
 * This is a convenience method to help avoid cases where you forget to
 * [PoseStack.popPose] after you [PoseStack.pushPose].
 *
 * @param action The scoped matrix transformations
 */
inline fun PoseStack.scoped(crossinline action: () -> Unit) {
    pushPose()
    action()
    popPose()
}
