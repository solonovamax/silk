@file:Suppress("unused")

package net.silkmc.silk.core.math.quaternion

import org.joml.AxisAngle4d
import org.joml.AxisAngle4f
import org.joml.Quaterniond
import org.joml.Quaternionf


// Quaternion initialization

fun quaternionfOf(): Quaternionf = Quaternionf()
fun quaternionfOf(x: Float, y: Float, z: Float, w: Float): Quaternionf = Quaternionf(x, y, z, w)
fun quaternionfOf(quaternion: Quaternionf): Quaternionf = Quaternionf(quaternion)
fun quaternionfOf(quaternion: Quaterniond): Quaternionf = Quaternionf(quaternion)
fun quaternionfOf(axis: AxisAngle4f): Quaternionf = Quaternionf(axis)
fun quaternionfOf(axis: AxisAngle4d): Quaternionf = Quaternionf(axis)

fun quaterniondOf(): Quaternionf = Quaternionf()
fun quaterniondOf(x: Double, y: Double, z: Double, w: Double): Quaterniond = Quaterniond(x, y, z, w)
fun quaterniondOf(quaternion: Quaternionf): Quaterniond = Quaterniond(quaternion)
fun quaterniondOf(quaternion: Quaterniond): Quaterniond = Quaterniond(quaternion)
fun quaterniondOf(axis: AxisAngle4f): Quaterniond = Quaterniond(axis)
fun quaterniondOf(axis: AxisAngle4d): Quaterniond = Quaterniond(axis)

// Quaternionf operations

operator fun Quaternionf.unaryMinus(): Quaternionf = Quaternionf(this).mul(-1.0f)

operator fun Quaternionf.not(): Quaternionf = Quaternionf(this).invert()

operator fun Quaternionf.plus(n: Int): Quaternionf = n.toFloat().let { nFloat -> Quaternionf(this).add(nFloat, nFloat, nFloat, nFloat) }
operator fun Quaternionf.plus(n: Long): Quaternionf = n.toFloat().let { nFloat -> Quaternionf(this).add(nFloat, nFloat, nFloat, nFloat) }
operator fun Quaternionf.plus(n: Float): Quaternionf = Quaternionf(this).add(n, n, n, n)
operator fun Quaternionf.plus(n: Double): Quaternionf = n.toFloat().let { nFloat -> Quaternionf(this).add(nFloat, nFloat, nFloat, nFloat) }
operator fun Quaternionf.plus(n: Number): Quaternionf = n.toFloat().let { nFloat -> Quaternionf(this).add(nFloat, nFloat, nFloat, nFloat) }

// TODO: should difference be used instead of just the inverse of plus?
//       Unsure about this, as it violates the implicit contract of A + B - B = A
operator fun Quaternionf.minus(n: Int): Quaternionf = (-n.toFloat()).let { nFloat -> Quaternionf(this).add(nFloat, nFloat, nFloat, nFloat) }
operator fun Quaternionf.minus(n: Long): Quaternionf =
    (-n.toFloat()).let { nFloat -> Quaternionf(this).add(nFloat, nFloat, nFloat, nFloat) }

operator fun Quaternionf.minus(n: Float): Quaternionf = Quaternionf(this).add(-n, -n, -n, -n)
operator fun Quaternionf.minus(n: Double): Quaternionf =
    (-n.toFloat()).let { nFloat -> Quaternionf(this).add(nFloat, nFloat, nFloat, nFloat) }

operator fun Quaternionf.minus(n: Number): Quaternionf =
    (-n.toFloat()).let { nFloat -> Quaternionf(this).add(nFloat, nFloat, nFloat, nFloat) }

operator fun Quaternionf.times(n: Int): Quaternionf = Quaternionf(this).mul(n.toFloat())
operator fun Quaternionf.times(n: Long): Quaternionf = Quaternionf(this).mul(n.toFloat())
operator fun Quaternionf.times(n: Float): Quaternionf = Quaternionf(this).mul(n)
operator fun Quaternionf.times(n: Double): Quaternionf = Quaternionf(this).mul(n.toFloat())
operator fun Quaternionf.times(n: Number): Quaternionf = Quaternionf(this).mul(n.toFloat())

operator fun Quaternionf.div(n: Int): Quaternionf = Quaternionf(this).times(1.0f / n.toFloat())
operator fun Quaternionf.div(n: Long): Quaternionf = Quaternionf(this).times(1.0f / n.toFloat())
operator fun Quaternionf.div(n: Float): Quaternionf = Quaternionf(this).times(1.0f / n)
operator fun Quaternionf.div(n: Double): Quaternionf = Quaternionf(this).times(1.0f / n.toFloat())
operator fun Quaternionf.div(n: Number): Quaternionf = Quaternionf(this).times(1.0f / n.toFloat())

operator fun Quaternionf.plus(quaternion: Quaternionf): Quaternionf = Quaternionf(this).add(quaternion)

operator fun Quaternionf.minus(quaternion: Quaternionf): Quaternionf = Quaternionf(this).add(-quaternion)

operator fun Quaternionf.times(quaternion: Quaternionf): Quaternionf = Quaternionf(this).mul(quaternion)

operator fun Quaternionf.div(quaternion: Quaternionf): Quaternionf = Quaternionf(this).div(quaternion)

infix fun Quaternionf.dot(quaternion: Quaternionf): Float = Quaternionf(this).dot(quaternion)

operator fun Quaternionf.component1() = x
operator fun Quaternionf.component2() = y
operator fun Quaternionf.component3() = z
operator fun Quaternionf.component4() = w


// Quaterniond operations

operator fun Quaterniond.unaryMinus(): Quaterniond = Quaterniond(this).mul(-1.0)

operator fun Quaterniond.not(): Quaterniond = Quaterniond(this).invert()

operator fun Quaterniond.plus(n: Int): Quaterniond =
    n.toDouble().let { nDouble -> Quaterniond(this).add(nDouble, nDouble, nDouble, nDouble) }

operator fun Quaterniond.plus(n: Long): Quaterniond =
    n.toDouble().let { nDouble -> Quaterniond(this).add(nDouble, nDouble, nDouble, nDouble) }

operator fun Quaterniond.plus(n: Float): Quaterniond =
    n.toDouble().let { nDouble -> Quaterniond(this).add(nDouble, nDouble, nDouble, nDouble) }

operator fun Quaterniond.plus(n: Double): Quaterniond = Quaterniond(this).add(n, n, n, n)
operator fun Quaterniond.plus(n: Number): Quaterniond =
    n.toDouble().let { nDouble -> Quaterniond(this).add(nDouble, nDouble, nDouble, nDouble) }

// TODO: should difference be used instead of just the inverse of plus?
//       Unsure about this, as it violates the implicit contract of A + B - B = A
operator fun Quaterniond.minus(n: Int): Quaterniond =
    (-n.toDouble()).let { nDouble -> Quaterniond(this).add(nDouble, nDouble, nDouble, nDouble) }

operator fun Quaterniond.minus(n: Long): Quaterniond =
    (-n.toDouble()).let { nDouble -> Quaterniond(this).add(nDouble, nDouble, nDouble, nDouble) }

operator fun Quaterniond.minus(n: Float): Quaterniond =
    (-n.toDouble()).let { nDouble -> Quaterniond(this).add(nDouble, nDouble, nDouble, nDouble) }

operator fun Quaterniond.minus(n: Double): Quaterniond = Quaterniond(this).add(-n, -n, -n, -n)
operator fun Quaterniond.minus(n: Number): Quaterniond =
    (-n.toDouble()).let { nDouble -> Quaterniond(this).add(nDouble, nDouble, nDouble, nDouble) }

operator fun Quaterniond.times(n: Int): Quaterniond = Quaterniond(this).mul(n.toDouble())
operator fun Quaterniond.times(n: Long): Quaterniond = Quaterniond(this).mul(n.toDouble())
operator fun Quaterniond.times(n: Float): Quaterniond = Quaterniond(this).mul(n.toDouble())
operator fun Quaterniond.times(n: Double): Quaterniond = Quaterniond(this).mul(n)
operator fun Quaterniond.times(n: Number): Quaterniond = Quaterniond(this).mul(n.toDouble())

operator fun Quaterniond.div(n: Int): Quaterniond = Quaterniond(this).times(1.0 / n.toDouble())
operator fun Quaterniond.div(n: Long): Quaterniond = Quaterniond(this).times(1.0 / n.toDouble())
operator fun Quaterniond.div(n: Float): Quaterniond = Quaterniond(this).times(1.0 / n.toDouble())
operator fun Quaterniond.div(n: Double): Quaterniond = Quaterniond(this).times(1.0 / n)
operator fun Quaterniond.div(n: Number): Quaterniond = Quaterniond(this).times(1.0 / n.toDouble())

operator fun Quaterniond.plus(quaternion: Quaterniond): Quaterniond = Quaterniond(this).add(quaternion)

operator fun Quaterniond.minus(quaternion: Quaterniond): Quaterniond = Quaterniond(this).add(-quaternion)

operator fun Quaterniond.times(quaternion: Quaterniond): Quaterniond = Quaterniond(this).mul(quaternion)

operator fun Quaterniond.div(quaternion: Quaterniond): Quaterniond = Quaterniond(this).div(quaternion)

infix fun Quaterniond.dot(quaternion: Quaterniond): Double = Quaterniond(this).dot(quaternion)

operator fun Quaterniond.component1() = x
operator fun Quaterniond.component2() = y
operator fun Quaterniond.component3() = z
operator fun Quaterniond.component4() = w
