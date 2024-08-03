@file:Suppress("unused")

package net.silkmc.silk.rendering.screen

import com.github.ajalt.colormath.Color
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner
import net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.FormattedText
import net.minecraft.network.chat.Style
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.FormattedCharSequence
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.inventory.tooltip.TooltipComponent
import net.minecraft.world.item.ItemStack
import java.util.Optional

context(GuiGraphics)
fun hLine(x1: Int, x2: Int, y: Int, color: Color) = hLine(x1, x2, y, color.toSRGB().toRGBInt().argb.toInt())

// alias for yarn
context(GuiGraphics)
fun drawHorizontalLine(x1: Int, x2: Int, y: Int, color: Color) = hLine(x1, x2, y, color)

context(GuiGraphics)
fun hLine(layer: RenderType, x1: Int, x2: Int, y: Int, color: Color) = hLine(layer, x1, x2, y, color.toSRGB().toRGBInt().argb.toInt())

// alias for yarn
context(GuiGraphics)
fun drawHorizontalLine(layer: RenderType, x1: Int, x2: Int, y: Int, color: Color) = hLine(layer, x1, x2, y, color)

context(GuiGraphics)
fun vLine(x: Int, y1: Int, y2: Int, color: Color) = vLine(x, y1, y2, color.toSRGB().toRGBInt().argb.toInt())

// alias for yarn
context(GuiGraphics)
fun drawVerticalLine(x: Int, y1: Int, y2: Int, color: Color) = vLine(x, y1, y2, color)

context(GuiGraphics)
fun vLine(layer: RenderType, x: Int, y1: Int, y2: Int, color: Color) = vLine(layer, x, y1, y2, color.toSRGB().toRGBInt().argb.toInt())

// alias for yarn
context(GuiGraphics)
fun drawVerticalLine(layer: RenderType, x: Int, y1: Int, y2: Int, color: Color) = vLine(layer, x, y1, y2, color)

context(GuiGraphics)
fun enableScissor(x1: Int, y1: Int, x2: Int, y2: Int) = enableScissor(x1, y1, x2, y2)

context(GuiGraphics)
fun disableScissor() = disableScissor()

context(GuiGraphics)
fun containsPointInScissor(x: Int, y: Int): Boolean = containsPointInScissor(x, y)

context(GuiGraphics)
fun setColor(color: Color) = color.toSRGB().let { rgb -> setColor(rgb.r, rgb.g, rgb.b, rgb.alpha) }

// alias for yarn
context(GuiGraphics)
fun setShaderColor(color: Color) = setColor(color)

context(GuiGraphics)
fun fill(x1: Int, y1: Int, x2: Int, y2: Int, color: Color) = fill(x1, y1, x2, y2, color.toSRGB().toRGBInt().argb.toInt())

context(GuiGraphics)
fun fill(x1: Int, y1: Int, x2: Int, y2: Int, z: Int, color: Color) = fill(x1, y1, x2, y2, z, color.toSRGB().toRGBInt().argb.toInt())

context(GuiGraphics)
fun fill(layer: RenderType, x1: Int, y1: Int, x2: Int, y2: Int, color: Color) {
    return fill(layer, x1, y1, x2, y2, color.toSRGB().toRGBInt().argb.toInt())
}

context(GuiGraphics)
fun fill(layer: RenderType, x1: Int, y1: Int, x2: Int, y2: Int, z: Int, color: Color) {
    return fill(layer, x1, y1, x2, y2, z, color.toSRGB().toRGBInt().argb.toInt())
}

context(GuiGraphics)
fun fillGradient(startX: Int, startY: Int, endX: Int, endY: Int, colorStart: Color, colorEnd: Color) {
    val colorStartInt = colorStart.toSRGB().toRGBInt().argb.toInt()
    val colorEndInt = colorEnd.toSRGB().toRGBInt().argb.toInt()
    return fillGradient(startX, startY, endX, endY, colorStartInt, colorEndInt)
}

context(GuiGraphics)
fun fillGradient(startX: Int, startY: Int, endX: Int, endY: Int, z: Int, colorStart: Color, colorEnd: Color) {
    val colorStartInt = colorStart.toSRGB().toRGBInt().argb.toInt()
    val colorEndInt = colorEnd.toSRGB().toRGBInt().argb.toInt()
    return fillGradient(startX, startY, endX, endY, z, colorStartInt, colorEndInt)
}

context(GuiGraphics)
fun fillGradient(
    layer: RenderType,
    startX: Int,
    startY: Int,
    endX: Int,
    endY: Int,
    colorStart: Color,
    colorEnd: Color,
    z: Int,
) {
    val colorStartInt = colorStart.toSRGB().toRGBInt().argb.toInt()
    val colorEndInt = colorEnd.toSRGB().toRGBInt().argb.toInt()
    return fillGradient(layer, startX, startY, endX, endY, colorStartInt, colorEndInt, z)
}

context(GuiGraphics)
fun fillRenderType(layer: RenderType, startX: Int, startY: Int, endX: Int, endY: Int, z: Int) {
    return fillRenderType(layer, startX, startY, endX, endY, z)
}

// alias for yarn
context(GuiGraphics)
fun fillWithLayer(layer: RenderType, startX: Int, startY: Int, endX: Int, endY: Int, z: Int) {
    return fillRenderType(layer, startX, startY, endX, endY, z)
}


context(GuiGraphics, FontHolder)
fun drawCenteredString(text: String, centerX: Int, y: Int, color: Color) {
    return drawCenteredString(this@FontHolder.font, text, centerX, y, color.toSRGB().toRGBInt().argb.toInt())
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawCenteredText(text: String, centerX: Int, y: Int, color: Color) {
    return drawCenteredString(text, centerX, y, color)
}

context(GuiGraphics, FontHolder)
fun drawCenteredString(text: Component, centerX: Int, y: Int, color: Color) {
    return drawCenteredString(this@FontHolder.font, text, centerX, y, color.toSRGB().toRGBInt().argb.toInt())
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawCenteredText(text: Component, centerX: Int, y: Int, color: Color) {
    return drawCenteredString(text, centerX, y, color)
}

context(GuiGraphics, FontHolder)
fun drawCenteredString(text: FormattedCharSequence, centerX: Int, y: Int, color: Color) {
    return drawCenteredString(this@FontHolder.font, text, centerX, y, color.toSRGB().toRGBInt().argb.toInt())
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawCenteredText(text: FormattedCharSequence, centerX: Int, y: Int, color: Color) {
    return drawCenteredString(text, centerX, y, color)
}

context(GuiGraphics, FontHolder)
fun drawString(text: String, x: Int, y: Int, color: Color, shadow: Boolean = true): Int {
    return drawString(this@FontHolder.font, text, x, y, color.toSRGB().toRGBInt().argb.toInt(), shadow)
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawText(text: String, x: Int, y: Int, color: Color, shadow: Boolean = true): Int {
    return drawString(text, x, y, color, shadow)
}

context(GuiGraphics, FontHolder)
fun drawString(text: FormattedCharSequence, x: Int, y: Int, color: Color, shadow: Boolean = true): Int {
    return drawString(this@FontHolder.font, text, x, y, color.toSRGB().toRGBInt().argb.toInt(), shadow)
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawText(text: FormattedCharSequence, x: Int, y: Int, color: Color, shadow: Boolean = true): Int {
    return drawString(text, x, y, color, shadow)
}

context(GuiGraphics, FontHolder)
fun drawString(text: Component, x: Int, y: Int, color: Color, shadow: Boolean = true): Int {
    return drawString(this@FontHolder.font, text, x, y, color.toSRGB().toRGBInt().argb.toInt(), shadow)
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawText(text: Component, x: Int, y: Int, color: Color, shadow: Boolean = true): Int {
    return drawString(text, x, y, color, shadow)
}

context(GuiGraphics, FontHolder)
fun drawWordWrap(text: FormattedText, x: Int, y: Int, lineWidth: Int, color: Color, shadow: Boolean = true) {
    return if (shadow) {
        var tempY = y
        for (formattedCharSequence in this@FontHolder.font.split(text, lineWidth)) {
            drawString(formattedCharSequence, x, tempY, color, true)
            tempY += 9
        }
    } else {
        drawWordWrap(this@FontHolder.font, text, x, y, lineWidth, color.toSRGB().toRGBInt().argb.toInt())
    }
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawTextWrapped(text: FormattedText, x: Int, y: Int, width: Int, color: Color, shadow: Boolean = true) {
    return drawWordWrap(text, x, y, width, color, shadow)
}

context(GuiGraphics, FontHolder)
fun drawStringWithBackdrop(text: Component, x: Int, y: Int, width: Int, color: Color): Int {
    return drawStringWithBackdrop(this@FontHolder.font, text, x, y, width, color.toSRGB().toRGBInt().argb.toInt())
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawTextWithBackground(text: Component, x: Int, y: Int, width: Int, color: Color): Int {
    return drawStringWithBackdrop(text, x, y, width, color)
}


context(GuiGraphics)
fun renderOutline(x: Int, y: Int, width: Int, height: Int, color: Color) {
    return renderOutline(x, y, width, height, color.toSRGB().toRGBInt().argb.toInt())
}

// alias for yarn
context(GuiGraphics)
fun drawOutline(x: Int, y: Int, width: Int, height: Int, color: Color) {
    return renderOutline(x, y, width, height, color)
}


context(GuiGraphics)
fun blit(x: Int, y: Int, z: Int = 0, width: Int, height: Int, sprite: TextureAtlasSprite) {
    return blit(x, y, z, width, height, sprite)
}

// alias for yarn
context(GuiGraphics)
fun drawSprite(x: Int, y: Int, z: Int = 0, width: Int, height: Int, sprite: TextureAtlasSprite) {
    return blit(x, y, z, width, height, sprite)
}

context(GuiGraphics)
fun blit(x: Int, y: Int, z: Int = 0, width: Int, height: Int, sprite: TextureAtlasSprite, color: Color) {
    return blit(x, y, z, width, height, sprite, color)
}

// alias for yarn
context(GuiGraphics)
fun drawSprite(x: Int, y: Int, z: Int = 0, width: Int, height: Int, sprite: TextureAtlasSprite, color: Color) {
    return blit(x, y, z, width, height, sprite, color)
}

context(GuiGraphics)
fun blitSprite(id: ResourceLocation, x: Int, y: Int, z: Int = 0, width: Int, height: Int) = blitSprite(id, x, y, z, width, height)

// alias for yarn
context(GuiGraphics)
fun drawGuiTexture(id: ResourceLocation, x: Int, y: Int, z: Int = 0, width: Int, height: Int) = blitSprite(id, x, y, z, width, height)

context(GuiGraphics)
fun blitSprite(
    id: ResourceLocation,
    textureWidth: Int,
    textureHeight: Int,
    u: Int,
    v: Int,
    x: Int,
    y: Int,
    z: Int = 0,
    width: Int,
    height: Int,
) = blitSprite(id, textureWidth, textureHeight, u, v, x, y, z, width, height)

// alias for yarn
context(GuiGraphics)
fun drawGuiTexture(
    id: ResourceLocation,
    textureWidth: Int,
    textureHeight: Int,
    u: Int,
    v: Int,
    x: Int,
    y: Int,
    z: Int = 0,
    width: Int,
    height: Int,
) = blitSprite(id, textureWidth, textureHeight, u, v, x, y, z, width, height)

context(GuiGraphics)
fun blit(
    id: ResourceLocation,
    x: Int,
    y: Int,
    z: Int = 0,
    u: Float,
    v: Float,
    width: Int,
    height: Int,
    textureWidth: Int,
    textureHeight: Int,
) = blit(id, x, y, z, u, v, width, height, textureWidth, textureHeight)

// alias for yarn
context(GuiGraphics)
fun drawTexture(
    id: ResourceLocation,
    x: Int,
    y: Int,
    z: Int = 0,
    u: Float,
    v: Float,
    width: Int,
    height: Int,
    textureWidth: Int,
    textureHeight: Int,
) = blit(id, x, y, z, u, v, width, height, textureWidth, textureHeight)

context(GuiGraphics)
fun blit(
    id: ResourceLocation,
    x: Int,
    y: Int,
    width: Int,
    height: Int,
    u: Float,
    v: Float,
    regionWidth: Int,
    regionHeight: Int,
    textureWidth: Int,
    textureHeight: Int,
) = blit(id, x, y, width, height, u, v, regionWidth, regionHeight, textureWidth, textureHeight)

// alias for yarn
context(GuiGraphics)
fun drawTexture(
    id: ResourceLocation,
    x: Int,
    y: Int,
    width: Int,
    height: Int,
    u: Float,
    v: Float,
    regionWidth: Int,
    regionHeight: Int,
    textureWidth: Int,
    textureHeight: Int,
) = blit(id, x, y, width, height, u, v, regionWidth, regionHeight, textureWidth, textureHeight)

context(GuiGraphics)
fun blit(id: ResourceLocation, x: Int, y: Int, u: Float, v: Float, width: Int, height: Int, textureWidth: Int, textureHeight: Int) {
    return blit(id, x, y, u, v, width, height, textureWidth, textureHeight)
}

// alias for yarn
context(GuiGraphics)
fun drawTexture(id: ResourceLocation, x: Int, y: Int, u: Float, v: Float, width: Int, height: Int, textureWidth: Int, textureHeight: Int) {
    return blit(id, x, y, u, v, width, height, textureWidth, textureHeight)
}

context(GuiGraphics)
fun renderItem(stack: ItemStack, x: Int, y: Int, seed: Int = 0, z: Int = 0) = renderItem(stack, x, y, seed, z)

// alias for yarn
context(GuiGraphics)
fun drawItem(stack: ItemStack, x: Int, y: Int, seed: Int = 0, z: Int = 0) = renderItem(stack, x, y, seed, z)

context(GuiGraphics)
fun renderFakeItem(stack: ItemStack, x: Int, y: Int, seed: Int = 0) = renderFakeItem(stack, x, y, seed)

// alias for yarn
context(GuiGraphics)
fun drawItemWithoutEntity(stack: ItemStack, x: Int, y: Int, seed: Int = 0) = renderFakeItem(stack, x, y, seed)

context(GuiGraphics)
fun renderItem(entity: LivingEntity, stack: ItemStack, x: Int, y: Int, seed: Int = 0) = renderItem(entity, stack, x, y, seed)

// alias for yarn
context(GuiGraphics)
fun drawItem(entity: LivingEntity, stack: ItemStack, x: Int, y: Int, seed: Int = 0) = renderItem(entity, stack, x, y, seed)

context(GuiGraphics, FontHolder)
fun renderItemDecorations(stack: ItemStack, x: Int, y: Int, countOverride: String? = null) {
    return renderItemDecorations(this@FontHolder.font, stack, x, y, countOverride)
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawItemInSlot(stack: ItemStack, x: Int, y: Int, countOverride: String? = null) = renderItemDecorations(stack, x, y, countOverride)

context(GuiGraphics, FontHolder)
fun renderTooltip(stack: ItemStack, x: Int, y: Int) = renderTooltip(this@FontHolder.font, stack, x, y)

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawItemTooltip(stack: ItemStack, x: Int, y: Int) = renderTooltip(stack, x, y)

context(GuiGraphics, FontHolder)
fun renderTooltip(list: List<Component>, data: Optional<TooltipComponent>, x: Int, y: Int) {
    return renderTooltip(this@FontHolder.font, list, data, x, y)
}

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawItemTooltip(list: List<Component>, data: Optional<TooltipComponent>, x: Int, y: Int) = renderTooltip(list, data, x, y)

context(GuiGraphics, FontHolder)
fun renderTooltip(component: Component, x: Int, y: Int) = renderTooltip(listOf(component.visualOrderText), x, y)

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawItemTooltip(component: Component, x: Int, y: Int) = renderTooltip(component, x, y)

context(GuiGraphics, FontHolder)
fun renderTooltip(
    list: List<Component>,
    x: Int,
    y: Int,
    positioner: ClientTooltipPositioner = DefaultTooltipPositioner.INSTANCE,
) = renderTooltip(list.map(Component::getVisualOrderText), x, y, positioner)

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawTooltip(
    list: List<Component>,
    x: Int,
    y: Int,
    positioner: ClientTooltipPositioner = DefaultTooltipPositioner.INSTANCE,
) = renderTooltip(list, x, y, positioner)

context(GuiGraphics, FontHolder)
fun renderTooltip(
    list: List<FormattedCharSequence>,
    x: Int,
    y: Int,
    positioner: ClientTooltipPositioner = DefaultTooltipPositioner.INSTANCE,
) = renderTooltip(this@FontHolder.font, list, positioner, x, y)

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawTooltip(
    list: List<FormattedCharSequence>,
    x: Int,
    y: Int,
    positioner: ClientTooltipPositioner = DefaultTooltipPositioner.INSTANCE,
) = renderTooltip(list, x, y, positioner)

context(GuiGraphics, FontHolder)
fun renderComponentHoverEffect(style: Style? = null, x: Int, y: Int) = renderComponentHoverEffect(this@FontHolder.font, style, x, y)

// alias for yarn
context(GuiGraphics, FontHolder)
fun drawHoverEvent(style: Style? = null, x: Int, y: Int) = renderComponentHoverEffect(style, x, y)
