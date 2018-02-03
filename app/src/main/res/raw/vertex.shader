#pragma debug(on)
#pragma optimize(off)

uniform mat4 uMvp;
attribute vec4 aPosition;

void main(){
    gl_Position =  uMvp * aPosition;
}