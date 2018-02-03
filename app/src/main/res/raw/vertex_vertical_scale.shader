#pragma debug(on)
#pragma optimize(off)

uniform mat4 uMvp;
attribute vec4 aPosition;

void main(){

    float xScale = 1.;
    float yScale = 2.;
    float zScale = 1.;

    mat4 scale = mat4(
        vec4(xScale, .0, .0, .0),
        vec4(.0, yScale, .0, .0),
        vec4(.0, .0, zScale, .0),
        vec4(.0, .0, .0, 1.)
    );

    gl_Position =  uMvp * scale * aPosition;
}