precision mediump float;
uniform vec4 uColor;

uniform vec2 uResolution;
uniform float uTime;

bool sin(){
    vec2 position = ( gl_FragCoord.xy / uResolution.xy );

    float phaze = (uTime * -1.) / 10.;
	float yShift = 0.5;

    float px = position.x + phaze;
    float py = position.y - yShift;

    float midY =  sin(px * 10.) /10.;
    float thickness = 0.004;

    return ((py + thickness) >= midY) && (py - thickness <= midY);
}

bool axis(){
    vec2 position = ( gl_FragCoord.xy / uResolution.xy );
    float thinkness = 0.002;

    bool horiz = position.y >= 0.5 && position.y <= (0.5 + thinkness);
    bool vert = position.x >= 0.5 && position.x <= (0.5 + thinkness);

 	return horiz || vert;
}

void main() {
    vec2 st = gl_FragCoord.xy/uResolution.xy;
    st.x *= uResolution.x/uResolution.y;

    vec3 color = vec3(0.);

    if(run()){
    	color.r = 1.;
    }else if(horiz()){
     	color.g = 1.;
    }

    gl_FragColor = vec4(color,1.0);
}