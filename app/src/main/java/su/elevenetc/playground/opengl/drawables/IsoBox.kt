package su.elevenetc.playground.opengl.drawables

import su.elevenetc.playground.opengl.Color
import su.elevenetc.playground.opengl.Vertexes

class IsoBox(val x: Float,
             val z: Float,
             val size: Float) : Drawable(toTriangles(), Color.Blue, 0, 0) {

    companion object {

        private fun toTriangles(): Vertexes {
            return null!!
        }
    }
}