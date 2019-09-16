package su.elevenetc.playground.opengl.drawables

import android.opengl.GLES30
import su.elevenetc.playground.opengl.*
import su.elevenetc.playground.opengl.Color.Companion.Green

class Plane(
        topLeft: Vertex,
        topRight: Vertex,
        bottomLeft: Vertex,
        bottomRight: Vertex,
        color: Color = Green,
        vertexResourceId: Int = R.raw.shader_vertex_basic,
        fragmentResourceId: Int =R.raw.shader_fragment_basic,
        mode: Int = GLES30.GL_TRIANGLES
) : Drawable(toTriangles(topLeft, topRight, bottomLeft, bottomRight), color, vertexResourceId, fragmentResourceId, mode) {
    companion object {
        fun toTriangles(topLeft: Vertex,
                        topRight: Vertex,
                        bottomLeft: Vertex,
                        bottomRight: Vertex): Vertexes {
            return Vertexes(
                    topLeft.x, topLeft.y, topLeft.z,
                    topRight.x, topRight.y, topRight.z,
                    bottomLeft.x, bottomLeft.y, bottomLeft.z,
//
                    topRight.x, topRight.y, topRight.z,
                    bottomRight.x, bottomRight.y, bottomRight.z,
                    bottomLeft.x, bottomLeft.y, bottomLeft.z
            )
        }
    }
}