/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

/**
 *
 * @author User
 */
public class BinnenVaartKraan extends Node {
    //dezelfde clas als binnenvaartkraan alleen dan straks met andere
    //properties voor de kraan

    Spatial binnenvaartkraan;

    public BinnenVaartKraan(AssetManager assetManager) {
      

        Material binnenvaartkraanMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        binnenvaartkraanMat.setColor("Color", ColorRGBA.Black);

        //Texture text = assetManager.loadTexture("Textures/test.png");
        //binnenvaartkraanMat.setTexture("ColorMap", text);
        /* A colored lit cube. Needs light source! */
        Spatial binnenvaartkraan1 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial binnenvaartkraan2 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial binnenvaartkraan3 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial binnenvaartkraan4 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial binnenvaartkraan5 = new Geometry("ColoredBox", new Box(1f, .5f, 2.5f));
        Spatial binnenvaartkraan6 = new Geometry("ColoredBox", new Box(1f, .5f, 2.5f));
        Spatial binnenvaartkraan7 = new Geometry("ColoredBox", new Box(10f, .5f, 1f));


        binnenvaartkraan1.setMaterial(binnenvaartkraanMat);
        binnenvaartkraan2.setMaterial(binnenvaartkraanMat);
        binnenvaartkraan3.setMaterial(binnenvaartkraanMat);
        binnenvaartkraan4.setMaterial(binnenvaartkraanMat);
        binnenvaartkraan5.setMaterial(binnenvaartkraanMat);
        binnenvaartkraan6.setMaterial(binnenvaartkraanMat);
        binnenvaartkraan7.setMaterial(binnenvaartkraanMat);

        binnenvaartkraan1.setLocalTranslation(0, 7, 0);
        binnenvaartkraan2.setLocalTranslation(0, 7, 4);
        binnenvaartkraan3.setLocalTranslation(4, 7, 0);
        binnenvaartkraan4.setLocalTranslation(4, 7, 4);
        binnenvaartkraan5.setLocalTranslation(0, 15, 2f);
        binnenvaartkraan6.setLocalTranslation(4, 15, 2f);
        binnenvaartkraan7.setLocalTranslation(-2, 16, 2f);


        attachChild(binnenvaartkraan1);
        attachChild(binnenvaartkraan2);
        attachChild(binnenvaartkraan3);
        attachChild(binnenvaartkraan4);
        attachChild(binnenvaartkraan5);
        attachChild(binnenvaartkraan6);
        attachChild(binnenvaartkraan7);

    }

    public void links(float tpf) {
        this.move(4 * tpf, 0, 0);
    }

    public void rechts(float tpf) {
        this.move(4 * tpf, 0, 0);
    }
}
