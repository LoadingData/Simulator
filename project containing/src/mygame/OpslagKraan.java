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
public class OpslagKraan extends Node {

    Spatial opslagkraan;
    static int numberflessen;
    boolean terugweg = false;

    public OpslagKraan(AssetManager assetManager) {
        numberflessen++;

        Box boxshape1 = new Box(Vector3f.ZERO, 1f, 4f, 0.5f);
        Box boxshape2 = new Box(Vector3f.ZERO, 1f, 0.5f, 4f);

        Geometry zijkant1 = new Geometry("A Textured Box", boxshape1);
        Geometry bovenkant = new Geometry("A Textured Box", boxshape2);
        Geometry zijkant2 = new Geometry("A Textured Box", boxshape1);

        Material mat_tex = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_tex.setColor("Color", ColorRGBA.Blue);

        zijkant1.setMaterial(mat_tex);
        zijkant2.setMaterial(mat_tex);
        bovenkant.setMaterial(mat_tex);

        attachChild(zijkant1);
        attachChild(zijkant2);
        attachChild(bovenkant);

        zijkant1.setLocalTranslation(0, 4f, 0);
        zijkant2.setLocalTranslation(0, 4f, 8f);
        bovenkant.setLocalTranslation(0, 8, 4);
    }

    public void beweegheen(boolean isgeladen, float tpf, int rij, int hoogte, int kolom) {
        // ongeladen 3 m/s geladen 2 m/s
        Vector3f hoi = this.getLocalTranslation();

        
        System.out.println(tpf);
        if (isgeladen == false && terugweg == false && hoi.z > (-50 - (13 / 3 * rij))) {// ongeladen

            this.move(0, 0, -tpf * 3);

        } else if (hoi.z > (-50 - (13 / 3 * rij)) && terugweg == false) {// geladen

            this.move(0, 0, -tpf * 2);

        } else if (hoi.z < -50 && terugweg == true) {//hij is op de terugweg

            this.move(0, 0, tpf * 3);
        } else if (terugweg == false) {// hier neerzetten wanneer hij terug moet
            terugweg = true;
        } else { // hier moet code komen die beslist wanneer hij klaar is met zijn task.
            terugweg = false;
        }
        
    }
    
    public void beweegterug(boolean isgeladen, float tpf){
        
    }
    
    
}
