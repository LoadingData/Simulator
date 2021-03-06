/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

/**
 *
 * @author User
 */
public class VrachtautoKraan extends Node{

    Spatial vrachtautokraan;

    public VrachtautoKraan(AssetManager assetManager) {
        Box boxshape1 = new Box(Vector3f.ZERO, 1f, 2f, 0.25f);
        Box boxshape2 = new Box(Vector3f.ZERO, 1f, 0.25f, 1.5f);
        
        Geometry zijkant1 = new Geometry("A Textured Box", boxshape1);
        Geometry bovenkant = new Geometry("A Textured Box", boxshape2);
        Geometry zijkant2 = new Geometry("A Textured Box", boxshape1);
        
        Material mat_tex = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_tex.setColor("Color", ColorRGBA.Red);
        
        zijkant1.setMaterial(mat_tex);
        zijkant2.setMaterial(mat_tex);
        bovenkant.setMaterial(mat_tex);
        
        attachChild(zijkant1);
        attachChild(zijkant2);
        attachChild(bovenkant);

        zijkant1.setLocalTranslation(0, 2f, 0);
        zijkant2.setLocalTranslation(0, 2f, 2.5f);
        bovenkant.setLocalTranslation(0, 4, 1.25f);
    }
}
