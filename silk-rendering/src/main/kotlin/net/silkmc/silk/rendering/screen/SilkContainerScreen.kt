@file:Suppress("unused")

package net.silkmc.silk.rendering.screen

import net.minecraft.client.gui.Font
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.Slot

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
 * @param menu The [AbstractContainerMenu]
 * @param inventory The player's inventory
 * @param title The screen title
 */
abstract class SilkContainerScreen<T : AbstractContainerMenu>(
    menu: T,
    inventory: Inventory,
    title: Component,
) : AbstractContainerScreen<T>(menu, inventory, title), FontHolder {
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

    final override fun renderTooltip(graphics: GuiGraphics, x: Int, y: Int) {
        with(graphics) { drawTooltip(x, y) }
    }

    final override fun renderLabels(graphics: GuiGraphics, mouseX: Int, mouseY: Int) {
        with(graphics) { drawForeground(mouseX, mouseY) }
    }

    final override fun renderBg(guiGraphics: GuiGraphics, partialTick: Float, mouseX: Int, mouseY: Int) {
        with(guiGraphics) { drawBackground(partialTick, mouseX, mouseY) }
    }

    final override fun renderSlot(guiGraphics: GuiGraphics, slot: Slot) {
        with(guiGraphics) { drawSlot(slot) }
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
    abstract fun drawBackground(partialTick: Float, mouseX: Int, mouseY: Int)

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

    context(GuiGraphics)
    open fun drawTooltip(x: Int, y: Int) {
        super.renderTooltip(this@GuiGraphics, x, y)
    }

    context(GuiGraphics)
    open fun drawForeground(mouseX: Int, mouseY: Int) {
        super.renderLabels(this@GuiGraphics, mouseX, mouseY)
    }

    context(GuiGraphics)
    open fun drawSlot(slot: Slot) {
        super.renderSlot(this@GuiGraphics, slot)
    }

    context(GuiGraphics)
    fun drawSlotHighlight(x: Int, y: Int, z: Int) = renderSlotHighlight(this@GuiGraphics, x, y, z)
}
