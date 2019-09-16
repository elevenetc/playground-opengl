package su.elevenetc.playground.opengl.drawables

import android.opengl.GLES30
import su.elevenetc.playground.opengl.*
import su.elevenetc.playground.opengl.Color.Companion.Red

class Line(
        vertexA: Vertex,
        vertexB: Vertex,
        vertexResourceId: Int = R.raw.shader_vertex_basic,
        fragmentResourceId: Int = R.raw.shader_fragment_basic,
        color: Color = Red
) : Drawable(
        Vertexes(vertexA.x, vertexA.y, vertexA.z, vertexB.x, vertexB.y, vertexB.z),
        color,
        vertexResourceId,
        fragmentResourceId,
        GLES30.GL_LINES
) {
}