package net.silkmc.silk.rendering

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.core.Vec3i
import net.minecraft.world.phys.Vec3
import org.joml.Matrix4f
import org.joml.Quaternionf
import org.joml.Vector3d
import org.joml.Vector3f
import org.joml.Vector3i


// vector scaling

operator fun PoseStack.timesAssign(scale: Vec3i) = scale(scale.x.toFloat(), scale.y.toFloat(), scale.z.toFloat())
operator fun PoseStack.timesAssign(scale: Vec3) = scale(scale.x.toFloat(), scale.y.toFloat(), scale.z.toFloat())
operator fun PoseStack.timesAssign(scale: Vector3i) = scale(scale.x.toFloat(), scale.y.toFloat(), scale.z.toFloat())
operator fun PoseStack.timesAssign(scale: Vector3f) = scale(scale.x, scale.y, scale.z)
operator fun PoseStack.timesAssign(scale: Vector3d) = scale(scale.x.toFloat(), scale.y.toFloat(), scale.z.toFloat())


// constant scaling (scale all axes by the same amount)

operator fun PoseStack.timesAssign(scale: Int) = scale.toFloat().let { nFloat -> scale(nFloat, nFloat, nFloat) }
operator fun PoseStack.timesAssign(scale: Long) = scale.toFloat().let { nFloat -> scale(nFloat, nFloat, nFloat) }
operator fun PoseStack.timesAssign(scale: Float) = scale(scale, scale, scale)
operator fun PoseStack.timesAssign(scale: Double) = scale.toFloat().let { nFloat -> scale(nFloat, nFloat, nFloat) }


// vector translation

operator fun PoseStack.plusAssign(scale: Vec3i) = translate(scale.x.toFloat(), scale.y.toFloat(), scale.z.toFloat())
operator fun PoseStack.plusAssign(scale: Vec3) = translate(scale.x.toFloat(), scale.y.toFloat(), scale.z.toFloat())
operator fun PoseStack.plusAssign(scale: Vector3i) = translate(scale.x.toFloat(), scale.y.toFloat(), scale.z.toFloat())
operator fun PoseStack.plusAssign(scale: Vector3f) = translate(scale.x, scale.y, scale.z)
operator fun PoseStack.plusAssign(scale: Vector3d) = translate(scale.x.toFloat(), scale.y.toFloat(), scale.z.toFloat())


// constant translation (translate all axes by the same amount)

operator fun PoseStack.plusAssign(scale: Int) = scale.toFloat().let { nFloat -> translate(nFloat, nFloat, nFloat) }
operator fun PoseStack.plusAssign(scale: Long) = scale.toFloat().let { nFloat -> translate(nFloat, nFloat, nFloat) }
operator fun PoseStack.plusAssign(scale: Float) = translate(scale, scale, scale)
operator fun PoseStack.plusAssign(scale: Double) = translate(scale, scale, scale)


// multiply by matrix or quaternion

operator fun PoseStack.timesAssign(quaternion: Quaternionf) = mulPose(quaternion)
operator fun PoseStack.timesAssign(matrix: Matrix4f) = mulPose(matrix)

