package su.elevenetc.playground.opengl.drawables

import android.content.Context
import android.opengl.GLES30
import su.elevenetc.playground.opengl.Color
import su.elevenetc.playground.opengl.Vertex
import su.elevenetc.playground.opengl.Vertexes

class Line(
        vertexA: Vertex,
        vertexB: Vertex,
        vertexResourceId: Int,
        fragmentResourceId: Int,
        color: Color,
        context: Context
) : Drawable(
        Vertexes(vertexA.x, vertexA.y, vertexA.z, vertexB.x, vertexB.y, vertexB.z),
        color,
        vertexResourceId,
        fragmentResourceId,
        context,
        GLES30.GL_LINES
) {
}