package su.elevenetc.playground.opengl.drawables

import su.elevenetc.playground.opengl.Color
import su.elevenetc.playground.opengl.Vertex

class PlaneUnitYZ(color: Color = Color.Green) : Plane(
        Vertex(0f, 0f, 0f),
        Vertex(0f, 1f, 0f),
        Vertex(0f, 1f, 1f),
        Vertex(0f, 0f, 1f),
        color
)