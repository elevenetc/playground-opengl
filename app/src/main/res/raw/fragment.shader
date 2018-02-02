precision mediump float;
uniform vec4 vColor;
uniform float time;
void main() {
    //gl_FragColor = vColor;
    //gl_FragColor = vec4(1.0, 1.0, 1.0, 0.0);
    //gl_FragColor = vec4(time, 0.0, 0.0, 0.0);
    gl_FragColor = vec4(abs(sin(time)), abs(cos(time)), abs(sin(time)), 1.0);
}