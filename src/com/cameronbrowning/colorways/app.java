package com.cameronbrowning.colorways;
import processing.core.PApplet;

/**
 * Created by cameron.browning on 6/23/16.
 */

public class app extends PApplet {

//    MoireCircles mc;
//    NoiseScroller ns;
    NoiseCube nc;

    public void settings(){
        size(1280,720, P3D);

    }

public void setup(){
    frameRate(120);
    background(0);
    nc = new NoiseCube(this);
    nc.setup();




}
    public void draw(){
        nc.setup();

        background(255);




        nc.draw();
        image(nc,0,0);
        //saveFrame("/Users/cameron.browning/IdeaProjects/Colorways/data/screen-"+nf(frameCount,4)+".png");



        fill(0);
        rect(0,0,100,30);
        fill(255);
        text(frameRate,0,10);




    }
    public void keyPressed(){
        nc.setup();
    }

}
