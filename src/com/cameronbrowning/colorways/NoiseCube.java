package com.cameronbrowning.colorways;

import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PGraphics3D;

/**
 * Created by cameron.browning on 6/24/16.
 */
public class NoiseCube extends PGraphics3D {

    final PApplet p;

    float noiseScale = (float)0.02f;
    PImage img;
    int myFrameCount;
    PImage palette;


    public NoiseCube(PApplet _p){
        p = _p;
        initialize(p.width,p.height, p, p.dataPath("/Users/cameron.browning/IdeaProjects/Colorways/data"));
        myFrameCount = 0;
        // p.println(p.dataPath("/Users/cameron.browning/IdeaProjects/Colorways/data"));
        palette = p.loadImage("/Users/cameron.browning/IdeaProjects/Colorways/data/palette.png");
        palette.loadPixels();
        // NoiseScrollerp.noiseSeed(0);
        img = p.createImage(32,32, RGB);
        img.loadPixels();
        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 32; x++) {
                img.pixels[y*32+x] = color(palette.pixels[(int)(p.noise(x/10.0f,(float)y/10.0f)*255)+myFrameCount] );
            }
        }
        myFrameCount+=1;
        img.updatePixels();
    }

    public void setup(){
        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 32; x++) {
                img.pixels[y*32+x] = color(palette.pixels[(int)(p.noise(x/10.0f,(float)y/10.0f)*255)+myFrameCount] );
            }
        }
        myFrameCount+=5;
        img.updatePixels();
    }
    public void draw(){
        beginDraw();
        // here is your draw method that contains all the good processing stuff

        background(0);
        pushMatrix();
        translate(width/2,height/2);
        rotateY((float)myFrameCount/1000.0f);
        rotateX((float)Math.cos(myFrameCount/100.0f)/50.0f+20.0f);
//        rotateX(p.mouseY/10.0f);
//        rotateY(p.mouseX/10.0f);

        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 32; x++) {
                for(int z = 0; z < 32; z++){
                   // stroke(color(palette.pixels[(int)(p.noise(x/10.0f,(float)y/10.0f)*255)+myFrameCount] ));
                    noStroke();
                    fill(color(palette.pixels[(int)(p.noise(x/10.0f,(float)y/10.0f, (float)z/10.0f)*255)+myFrameCount] ));
                 //   point(x*10-160,y*10-160, z*10-160);
                pushMatrix();
                    translate(x*10-160,y*10-160,z*10-160);
                    box(green(color(palette.pixels[(int)(p.noise((float)x/10.0f,(float)y/10.0f,(float)z/10.0f)*255)+myFrameCount] ))/((float)Math.sin(myFrameCount/100.0f)*50.0f+76.0f));
                popMatrix();
                }

            }
        }
popMatrix();
        image(img,0, 50);


        endDraw();

    }

    public void initialize(int w, int h, PApplet p, String s) {
        setParent(p);
        setPrimary(false);
        setPath(s);
        setSize(w, h);
    }

}
