package com.cameronbrowning.colorways;

import processing.core.PApplet;
import processing.opengl.PGraphics3D;

/**
 * Created by cameron.browning on 6/23/16.
 */
public class MoireCircles extends PGraphics3D {

    int[] colors = {		0x395273,
            0x395273,
            0xF2EDA0,
            0xD9A171,
            0x395273,
            0x395273,
            0x40211E,
            0x395273,
            0x40211E,
            0x395273};

final PApplet p;


    public MoireCircles(PApplet _p){
        p = _p;
        initialize(p.width,p.height, p, p.dataPath(""));
    }
    public void setup(){

    }
    public void draw(){
        beginDraw();
        // here is your draw method that contains all the good processing stuff


        background(0);
//	line(random(width),random(height),random(width),random(height));

        for(int i=0;i<72; i++){
            for(int j=0;j<72;j++){
                fill(red(colors[(i+j)%10]),green(colors[(i+j)%10]),blue(colors[(i+j)%10]));
                noStroke();
                float offset = (float)Math.sin((float)Math.cos(i/16.0f)*20.0f+(float)Math.sin((j+p.frameCount)/32.0f)*10.0f+p.frameCount/8.0f)*15+5;

                ellipse(i*10,j*10,offset,offset);
            }
        }


        endDraw();
    }

    public void initialize(int w, int h, PApplet p, String s) {
        setParent(p);
        setPrimary(false);
        setPath(s);
        setSize(w, h);
    }

}
