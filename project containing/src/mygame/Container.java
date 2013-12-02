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
import com.jme3.scene.shape.Box;

/**
 *
 * @author User
 */
public class Container extends Node{
    int ID;
    Vector3f locatie;
    
    public Container(AssetManager assetManager, int ID){
        this.ID = ID;
        
        Box box = new Box(Vector3f.ZERO, 13f / 6, 2.5f / 6, 2.5f / 6);
        Geometry container = new Geometry("A Textured Box", box);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        
        container.setMaterial(mat);
        attachChild(container);
        
        //container.rotate(0f, FastMath.PI / 2, 0);

}
}
