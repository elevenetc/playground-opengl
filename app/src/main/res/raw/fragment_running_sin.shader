precision mediump float;
uniform vec4 uColor;
uniform float uTime;
uniform vec2 uResolution;

bool runningSin(){

	vec2 position = ( gl_FragCoord.xy / uResolution.xy );

    float phaze = uTime;

    float px = position.x + phaze;
    float py = position.y;

    float yShift = abs(sin(phaze));

    return py - yShift >= sin(px * 10.) /10.;
}

void main() {
    vec4 col = uColor;
    col.r = runningSin() ? 1. : 0.;
    gl_FragColor = col;
}