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

bool xxx(){
    vec2 position = ( gl_FragCoord.xy / uResolution.xy );
    return uResolution.x >= 50.01;
}

void main() {
    vec4 col = vec4(1.0, 0.0, 0.0, 1.0);
    col.r = runningSin() ? 1. : 0.;
    gl_FragColor = col;
}