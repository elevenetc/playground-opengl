package su.elevenetc.playground.opengl

import java.nio.FloatBuffer

/**
 * Created by eugene.levenetc on 03/02/2018.
 */
class Vertexes {

    val coords: FloatArray
    private var buffer: FloatBuffer? = null

    constructor(vararg coords: Float) {
        this.coords = coords
    }

//    constructor(coords: FloatArray) {
//        this.coords = coords
//    }

    fun getBuffer(): FloatBuffer {
        if (buffer == null) {
            buffer = initVertices(coords)
        }
        return buffer!!
    }

}