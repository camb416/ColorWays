package com.cameronbrowning.colorways;
import processing.core.PApplet;
import processing.core.PImage;
import processing.opengl.PGraphics3D;
/**
 * Created by cameron.browning on 6/23/16.
 */
public class NoiseScroller extends PGraphics3D {
    final PApplet p;

    float noiseScale = (float)0.02f;
    PImage img;
    int myFrameCount;
    PImage palette;


    public NoiseScroller(PApplet _p){
        p = _p;
        initialize(p.width,p.height, p, p.dataPath("/Users/cameron.browning/IdeaProjects/Colorways/data"));
        myFrameCount = 0;
        p.println(p.dataPath("/Users/cameron.browning/IdeaProjects/Colorways/data"));
        palette = p.loadImage("/Users/cameron.browning/IdeaProjects/Colorways/data/palette.png");
        palette.loadPixels();
        // NoiseScrollerp.noiseSeed(0);
        img = p.createImage(1280, 720, RGB);
        img.loadPixels();
        for (int y = 0; y < 720; y++) {
            for (int x = 0; x < 1280; x++) {
                img.pixels[y*1280+x] = color(palette.pixels[(int)(p.noise(x/500.0f,(float)y/500.0f)*255)+myFrameCount] );
            }
        }
        myFrameCount+=1;
        img.updatePixels();
//image(img, 17, 17);
    }
    public void setup(){
        for (int y = 0; y < 720; y++) {
            for (int x = 0; x < 1280; x++) {
                img.pixels[y*1280+x] = color(palette.pixels[(int)(p.noise(x/500.0f,(float)y/500.0f)*255)+myFrameCount] );
            }
        }
        myFrameCount+=1;
        img.updatePixels();
    }
    public void draw(){
        beginDraw();
        // here is your draw method that contains all the good processing stuff

        background(0);

        image(img,0, 0);

        endDraw();

    }
    public void initialize(int w, int h, PApplet p, String s) {
        setParent(p);
        setPrimary(false);
        setPath(s);
        setSize(w, h);
    }


}
