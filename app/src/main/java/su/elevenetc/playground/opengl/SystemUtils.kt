package su.elevenetc.playground.opengl

import android.content.Context
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by eugene.levenetc on 02/02/2018.
 */
fun loadRawResource(context: Context, rawResourceId: Int): String {
    val stream = context.resources.openRawResource(rawResourceId)
    return readStream(stream)
}

fun readStream(stream: InputStream): String {
    val bufferSize = 1024
    val buffer = CharArray(bufferSize)
    val out = StringBuilder()
    val `in` = InputStreamReader(stream, "UTF-8")
    while (true) {
        val rsz = `in`.read(buffer, 0, buffer.size)
        if (rsz < 0)
            break
        out.append(buffer, 0, rsz)
    }
    return out.toString()
}