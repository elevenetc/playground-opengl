uniform mat4 uMvp;
uniform float uTime;
attribute vec4 aPosition;

void main(){

    float x = aPosition.x;
    float y = aPosition.y;

    vec4 pos = vec4(aPosition);

    pos.x = x * cos(uTime) - y * sin(uTime);
    pos.y = y * cos(uTime) + x * sin(uTime);

    gl_Position =  uMvp * pos;
}