package su.elevenetc.playground.opengl.drawables

import android.content.Context
import su.elevenetc.playground.opengl.Color
import su.elevenetc.playground.opengl.Vertex
import su.elevenetc.playground.opengl.Vertexes


/**
 * Created by eugene.levenetc on 02/02/2018.
 */
open class Triangle(
        context: Context,
        vertexResourceId: Int,
        fragmentResourceId: Int,
        topVertex: Vertex,
        bottomLeftVertex: Vertex,
        bottomRightVertex: Vertex,
        color: Color
) : Drawable(Vertexes(
        topVertex.x, topVertex.y, topVertex.z,
        bottomLeftVertex.x, bottomLeftVertex.y, bottomLeftVertex.z,
        bottomRightVertex.x, bottomRightVertex.y, bottomRightVertex.z
),
        color, vertexResourceId, fragmentResourceId, context)