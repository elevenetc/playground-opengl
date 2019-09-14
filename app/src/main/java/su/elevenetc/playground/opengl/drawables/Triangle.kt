package su.elevenetc.playground.opengl.drawables

import su.elevenetc.playground.opengl.*


/**
 * Created by eugene.levenetc on 02/02/2018.
 */
open class Triangle(
        topVertex: Vertex,
        bottomLeftVertex: Vertex,
        bottomRightVertex: Vertex,
        color: Color = Red,
        vertexResourceId: Int = R.raw.shader_vertex_basic,
        fragmentResourceId: Int = R.raw.shader_fragment_basic
) : Drawable(Vertexes(
        topVertex.x, topVertex.y, topVertex.z,
        bottomLeftVertex.x, bottomLeftVertex.y, bottomLeftVertex.z,
        bottomRightVertex.x, bottomRightVertex.y, bottomRightVertex.z
),
        color, vertexResourceId, fragmentResourceId)