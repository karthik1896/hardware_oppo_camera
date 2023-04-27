precision mediump float;
varying vec2 vTextureCoord;
varying vec2 vTextureCoordMask;
uniform sampler2D aTexture;

vec4 rad(vec4 image, vec2 v, float radius) {
    float distance = 0.0;

    if ((v.x < radius) && (v.y < radius)) {
        distance = sqrt(pow(v.x - radius, 2.0) + pow(v.y - radius, 2.0));
    } else if ((v.x < radius) && (v.y > (1.0 - radius))) {
        distance = sqrt(pow(v.x - radius, 2.0) + pow(v.y - (1.0 - radius), 2.0));
    } else if ((v.x > (1.0 - radius)) && (v.y < radius)) {
        distance = sqrt(pow(v.x - (1.0 - radius), 2.0) + pow(v.y - radius, 2.0));
    } else if ((v.x > (1.0 - radius)) && (v.y > (1.0 - radius))) {
        distance = sqrt(pow(v.x - (1.0 - radius), 2.0) + pow(v.y - (1.0 - radius), 2.0));
    }

    image.a = distance > radius ? 0.0 : 1.0;
    return image;
}

void main() {
    vec4 image = texture2D(aTexture, vTextureCoord);
    image = rad(image, vTextureCoordMask, 0.23);
    gl_FragColor = image;
}