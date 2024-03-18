function uvSphere(radius, slices, stacks, color = [255, 255, 0]) {
    var i,j;
    glColor3ubv(color);
    for (j = 0; j < stacks; j++) {
        var latitude1 = (Math.PI/stacks) * j - Math.PI/2;
        var latitude2 = (Math.PI/stacks) * (j+1) - Math.PI/2;
        var sinLat1 = Math.sin(latitude1);
        var cosLat1 = Math.cos(latitude1);
        var sinLat2 = Math.sin(latitude2);
        var cosLat2 = Math.cos(latitude2);
        glBegin(GL_TRIANGLE_STRIP);
        for (i = 0; i <= slices; i++) {
            var longitude = (2*Math.PI/slices) * i;
            var sinLong = Math.sin(longitude);
            var cosLong = Math.cos(longitude);
            var x1 = cosLong * cosLat1;
            var y1 = sinLong * cosLat1;
            var z1 = sinLat1;
            var x2 = cosLong * cosLat2;
            var y2 = sinLong * cosLat2;
            var z2 = sinLat2;
            glNormal3d(x2,y2,z2);
	    glVertex3d(radius*x2,radius*y2,radius*z2);
	    glNormal3d(x1,y1,z1);
            glVertex3d(radius*x1,radius*y1,radius*z1);
        }
        glEnd();
    }
}

function drawCylinder() {
    var i;
    var rgba;
    glBegin(GL_TRIANGLE_STRIP);
    for (i = 0; i <= 64; i++) {
        var angle = 2*Math.PI/64 * i;
        var x = Math.cos(angle);
        var y = Math.sin(angle);
        rgba = colorArrayForHue(i/64.0, 1, 0.6);
        glColor3dv(rgba);
        glNormal3d( x, y, 0 );  // Normal for both vertices at this angle.
        glVertex3d( x, y, 1 );  // Vertex on the top edge.
        glVertex3d( x, y, -1 ); // Vertex on the bottom edge.
    }
    glEnd();
    glNormal3d( 0, 0, 1 );
    glBegin(GL_TRIANGLE_FAN);  // Draw the top, in the plane z = 1.
    glColor3d(1,1,1);  // ambient and diffuse for center
    glVertex3d( 0, 0, 1);
    for (i = 0; i <= 64; i++) {
        var angle = 2*Math.PI/64 * i;
        var x = Math.cos(angle);
        var y = Math.sin(angle);
        rgba = colorArrayForHue(i/64.0, 1, 0.6);
        glColor3dv(rgba);
        glVertex3d( x, y, 1 );
    }
    glEnd();
    glNormal3f( 0, 0, -1 );  
    glBegin(GL_TRIANGLE_FAN);  // Draw the bottom, in the plane z = -1
    glColor3d(1,1,1);  // ambient and diffuse for center
    glVertex3d( 0, 0, -1);
    for (i = 64; i >= 0; i--) {
        var angle = 2*Math.PI/64 * i;
        var x = Math.cos(angle);
        var y = Math.sin(angle);
        rgba = colorArrayForHue(i/64.0, 1, 0.6);
        glColor3dv(rgba);
        glVertex3d( x, y, -1 );
    }
    glEnd();    
}