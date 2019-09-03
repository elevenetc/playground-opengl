package su.elevenetc.playground.opengl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val surfaceView = findViewById<MainGLSurfaceView>(R.id.surface_view)

        val eyeEditor = findViewById<AxisEditorView>(R.id.axis_editor_eye)

        eyeEditor.setData(
                "Eye",
                AxisEditorView.AxisController.SeekData(-10, 10, 0, 100f),
                AxisEditorView.AxisController.SeekData(-10, 10, 0, 100f),
                AxisEditorView.AxisController.SeekData(-10, 10, -6, 100f),
                {
                    surfaceView.renderer.eyeValue.x = it
                },
                {
                    surfaceView.renderer.eyeValue.y = it
                },
                {
                    surfaceView.renderer.eyeValue.z = it
                }
        )
    }


}
