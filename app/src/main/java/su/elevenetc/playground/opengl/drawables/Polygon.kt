package su.elevenetc.playground.opengl.drawables

import su.elevenetc.playground.opengl.Color
import su.elevenetc.playground.opengl.R
import su.elevenetc.playground.opengl.Vertexes

class Polygon(planes: List<Plane>,
              color: Color,
              vertexResourceId: Int = R.raw.shader_vertex_basic,
              fragmentResourceId: Int = R.raw.shader_fragment_basic
) : Drawable(
        combinePlanes(planes),
        color,
        vertexResourceId,
        fragmentResourceId
) {
    companion object {
        private fun combinePlanes(planes: List<Plane>): Vertexes {

            var size = 0
            planes.forEach { size += it.vertexes.coords.size }

            val fa = FloatArray(size)
            var i = 0

            for (plane in planes) {

                for (f in plane.vertexes.coords) {
                    fa[i] = f
                    i += 1
                }
            }

            return Vertexes(*fa)
        }
    }
}