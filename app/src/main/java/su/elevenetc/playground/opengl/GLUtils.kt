package su.elevenetc.playground.opengl

import android.app.ActivityManager
import android.content.Context
import android.opengl.GLES30
import android.opengl.GLES31
import android.opengl.GLES32
import android.support.v7.app.AppCompatActivity
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer


/**
 * Created by eugene.levenetc on 02/02/2018.
 */

fun supportsOpenGL32(): Boolean {
    val vers = IntArray(2)
    GLES32.glGetIntegerv(GLES32.GL_MAJOR_VERSION, vers, 0)
    GLES32.glGetIntegerv(GLES32.GL_MINOR_VERSION, vers, 1)
    return vers[0] > 3 || (vers[0] == 3 && vers[1] >= 2)
}

fun supportsOpenGL31(): Boolean {
    val vers = IntArray(2)
    GLES31.glGetIntegerv(GLES31.GL_MAJOR_VERSION, vers, 0)
    GLES31.glGetIntegerv(GLES31.GL_MINOR_VERSION, vers, 1)
    return vers[0] > 3 || (vers[0] == 3 && vers[1] >= 1)
}

fun supportsOpenGL30(): Boolean {
    val vers = IntArray(2)
    GLES30.glGetIntegerv(GLES30.GL_MAJOR_VERSION, vers, 0)
    GLES30.glGetIntegerv(GLES30.GL_MINOR_VERSION, vers, 1)
    return vers[0] > 3 || (vers[0] == 3 && vers[1] >= 0)
}

fun supportedOpenGL(activity: AppCompatActivity): String {
    val activityManager = activity.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val configurationInfo = activityManager.deviceConfigurationInfo
    return configurationInfo.glEsVersion
}

fun loadVertexShader(source: String): Int {
    return loadShader(GLES30.GL_VERTEX_SHADER, source)
}

fun loadFragmentShader(source: String): Int {
    return loadShader(GLES30.GL_FRAGMENT_SHADER, source)
}

fun loadShader(type: Int, shaderCode: String): Int {

    val shader = GLES30.glCreateShader(type)

    GLES30.glShaderSource(shader, shaderCode)
    GLES30.glCompileShader(shader)

    return shader
}

fun initVertices(coordinates: FloatArray): FloatBuffer {
    // initialize vertex byte buffer for shape coordinates
    val bb = ByteBuffer.allocateDirect(
            // (number of coordinate values * 4 bytes per float)
            coordinates.size * 4)
    // use the device hardware's native byte order
    bb.order(ByteOrder.nativeOrder())

    // create a floating point buffer from the ByteBuffer
    val vertexBuffer = bb.asFloatBuffer()
    // add the coordinates to the FloatBuffer
    vertexBuffer.put(coordinates)
    // set the buffer to read the first coordinate
    vertexBuffer.position(0)
    return vertexBuffer
}

fun initShaders(program: Int, vertexResourceId: Int, fragmentResourceId: Int, context: Context) {
    val vertexShader = loadVertexShader(loadRawResource(context, vertexResourceId))
    val fragmentShader = loadFragmentShader(loadRawResource(context, fragmentResourceId))

    GLES30.glAttachShader(program, vertexShader)
    GLES30.glAttachShader(program, fragmentShader)
    GLES30.glLinkProgram(program)
}

fun setV4(program: Int, name: String, data: FloatArray) {
    GLES30.glUniform4fv(
            GLES30.glGetUniformLocation(program, name),
            1, data, 0
    )
}

fun setV4Matrix(program: Int, name: String, data: FloatArray) {
    GLES30.glUniformMatrix4fv(
            GLES30.glGetUniformLocation(program, name),
            1, false, data, 0
    )
}

fun setFloat(program: Int, name: String, data: Float) {
    GLES30.glUniform1f(
            GLES30.glGetUniformLocation(program, name),
            data
    )
}

fun coordinate(x: Float, y: Float, z: Float) {

}
