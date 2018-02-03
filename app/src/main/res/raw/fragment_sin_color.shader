precision mediump float;
uniform vec4 uColor;
uniform float uTime;
void main() {
    gl_FragColor = vec4(abs(sin(uTime)), abs(cos(uTime)), abs(sin(uTime)), 1.0);
}