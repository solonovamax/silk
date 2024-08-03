@file:Suppress("unused")

package net.silkmc.silk.rendering.screen

import net.minecraft.client.gui.Font
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component

/**
 * A wrapper for Screen to make it a bit nicer to use in kotlin
 *
 * Instead of overriding the `render*` methods, override the `rendering*`
 * and `draw*` methods. The difference between the `rendering*` methods
 * and the `draw*` methods is that the `rendering*` methods are for when
 * multiple things are rendered (such as the entire screen, all the
 * background elements, etc.), whereas the `draw*` methods are for drawing
 * a single concrete thing (such as a slot, the background image, a
 * tooltip, etc.)
 *
 * @param title The screen title
 */
abstract class SilkScreen(title: Component) : Screen(title), FontHolder {
    override val font: Font
        get() = super.font

    final override fun render(graphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
        with(graphics) { rendering(mouseX, mouseY, partialTick) }
    }

    final override fun renderBackground(graphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
        with(graphics) { renderingBackground(mouseX, mouseY, partialTick) }
    }

    final override fun renderPanorama(graphics: GuiGraphics, partialTick: Float) {
        with(graphics) { drawPanorama(partialTick) }
    }

    final override fun renderMenuBackground(graphics: GuiGraphics) {
        with(graphics) { drawMenuBackground() }
    }

    final override fun renderMenuBackground(graphics: GuiGraphics, x: Int, y: Int, width: Int, height: Int) {
        with(graphics) { drawMenuBackground(x, y, width, height) }
    }

    final override fun renderTransparentBackground(graphics: GuiGraphics) {
        with(graphics) { drawTransparentBackground() }
    }

    context(GuiGraphics)
    open fun rendering(mouseX: Int, mouseY: Int, partialTick: Float) {
        super.render(this@GuiGraphics, mouseX, mouseY, partialTick)
    }

    context(GuiGraphics)
    open fun renderingBackground(mouseX: Int, mouseY: Int, partialTick: Float) {
        super.renderBackground(this@GuiGraphics, mouseX, mouseY, partialTick)
    }

    context(GuiGraphics)
    open fun drawPanorama(partialTick: Float) {
        super.renderPanorama(this@GuiGraphics, partialTick)
    }

    context(GuiGraphics)
    open fun drawMenuBackground() {
        super.renderMenuBackground(this@GuiGraphics)
    }

    context(GuiGraphics)
    open fun drawMenuBackground(x: Int, y: Int, width: Int, height: Int) {
        super.renderMenuBackground(this@GuiGraphics, x, y, width, height)
    }

    context(GuiGraphics)
    open fun drawTransparentBackground() {
        super.renderTransparentBackground(this@GuiGraphics)
    }
}
