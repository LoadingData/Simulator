package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;


public class ZeeKraan extends Node {

    public ZeeKraan(AssetManager assetManager) {

//        zeekraan = assetManager.loadModel("Models/zeekraan/zeekraan.j3o");
//        Material mat_default = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat_default.setColor("Color", ColorRGBA.Green);
//        zeekraan.setMaterial(mat_default);
//        zeekraan.rotate(0, -FastMath.PI / 2, 0);
//        //zeekraan.scale(1f);
        Material zeekraanMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        zeekraanMat.setColor("Color", ColorRGBA.Green);

        //Texture text = assetManager.loadTexture("Textures/test.png");
        //zeekraanMat.setTexture("ColorMap", text);
        /* A colored lit cube. Needs light source! */
        Spatial zeekraan1 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial zeekraan2 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial zeekraan3 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial zeekraan4 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial zeekraan5 = new Geometry("ColoredBox", new Box(1f, .5f, 2.5f));
        Spatial zeekraan6 = new Geometry("ColoredBox", new Box(1f, .5f, 2.5f));
        Spatial zeekraan7 = new Geometry("ColoredBox", new Box(10f, .5f, 1f));


        zeekraan1.setMaterial(zeekraanMat);
        zeekraan2.setMaterial(zeekraanMat);
        zeekraan3.setMaterial(zeekraanMat);
        zeekraan4.setMaterial(zeekraanMat);
        zeekraan5.setMaterial(zeekraanMat);
        zeekraan6.setMaterial(zeekraanMat);
        zeekraan7.setMaterial(zeekraanMat);

        zeekraan1.setLocalTranslation(0, 7, 0);
        zeekraan2.setLocalTranslation(0, 7, 4);
        zeekraan3.setLocalTranslation(4, 7, 0);
        zeekraan4.setLocalTranslation(4, 7, 4);
        zeekraan5.setLocalTranslation(0, 15, 2f);
        zeekraan6.setLocalTranslation(4, 15, 2f);
        zeekraan7.setLocalTranslation(-2, 16, 2f);


        attachChild(zeekraan1);
        attachChild(zeekraan2);
        attachChild(zeekraan3);
        attachChild(zeekraan4);
        attachChild(zeekraan5);
        attachChild(zeekraan6);
        attachChild(zeekraan7);


    }
}