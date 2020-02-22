package su.elevenetc.playground.opengl.drawables

import android.opengl.GLES30
import su.elevenetc.playground.opengl.Color
import su.elevenetc.playground.opengl.Color.Companion.Green
import su.elevenetc.playground.opengl.R
import su.elevenetc.playground.opengl.Vertex
import su.elevenetc.playground.opengl.Vertexes

/**
 * Clockwise order
 */
open class Plane(
        leftBottom: Vertex,
        leftTop: Vertex,
        rightTop: Vertex,
        rightBottom: Vertex,
        color: Color = Green,
        vertexResourceId: Int = R.raw.shader_vertex_basic,
        fragmentResourceId: Int = R.raw.shader_fragment_basic,
        mode: Int = GLES30.GL_TRIANGLES
) : Drawable(toTriangles(leftBottom, leftTop, rightTop, rightBottom), color, vertexResourceId, fragmentResourceId, mode) {
    companion object {
        private fun toTriangles(a: Vertex,
                                b: Vertex,
                                c: Vertex,
                                d: Vertex): Vertexes {
            return Vertexes(

                    //      y
                    //      |
                    //      |
                    //     / \
                    //  z /   \ x
                    //

                    //x   y   z
                    //
                    //1 (top triangle)
                    d.x, d.y, d.z,
                    b.x, b.y, b.z,
                    c.x, c.y, c.z,

                    //2 (bottom triangle)

                    d.x, d.y, d.z,
                    b.x, b.y, b.z,
                    a.x, a.y, a.z

//                    //x   y   z
//                    1f, 0f, 0f,//leftBottom
//                    0f, 1f, 0f,//leftTop
//                    1f, 1f, 0f,
//
//                    1f, 0f, 0f,//leftBottom
//                    0f, 1f, 0f,//leftTop
//                    0f, 0f, 0f
            )
        }
    }
}