precision mediump float;
uniform vec4 uColor;
void main() {

    vec4 color = vec4(uColor);

    if(gl_FragCoord.x >= 300.5 && gl_FragCoord.x <= 350.5){
        color[1] = 0.0;
        color[2] = 0.0;
    }

    gl_FragColor = color;
}