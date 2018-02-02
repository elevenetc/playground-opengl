uniform mat4 uMVPMatrix;
attribute vec4 position;

void main(){
    //vPosition.x = vPosition.x + 0.0;
    //vec4 xxx = vec4(0.0, 0.0, 0.0, 0.0);
    gl_Position =  uMVPMatrix * position;
}