package su.elevenetc.playground.opengl

import java.nio.FloatBuffer

/**
 * Created by eugene.levenetc on 03/02/2018.
 */
class Vertexes(vararg coords: Float) {

    val buffer: FloatBuffer = initVertices(coords)
}