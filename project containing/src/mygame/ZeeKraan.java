package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class ZeeKraan extends Node {

    boolean onLocation = false;
    boolean getContainer = false;
    private int getContainerInt = 1;

    public ZeeKraan(AssetManager assetManager) {

        Material zeekraanMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        zeekraanMat.setColor("Color", ColorRGBA.Green);

        Spatial zeekraan1 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial zeekraan2 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial zeekraan3 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial zeekraan4 = new Geometry("ColoredBox", new Box(1f, 7.5f, .5f));
        Spatial zeekraan5 = new Geometry("ColoredBox", new Box(1f, .5f, 3.5f));
        Spatial zeekraan6 = new Geometry("ColoredBox", new Box(1f, .5f, 3.5f));
        Spatial zeekraan7 = new Geometry("ColoredBox", new Box(10f, .5f, 1f));

        zeekraan1.setMaterial(zeekraanMat);
        zeekraan2.setMaterial(zeekraanMat);
        zeekraan3.setMaterial(zeekraanMat);
        zeekraan4.setMaterial(zeekraanMat);
        zeekraan5.setMaterial(zeekraanMat);
        zeekraan6.setMaterial(zeekraanMat);
        zeekraan7.setMaterial(zeekraanMat);

        zeekraan1.setLocalTranslation(0, 7, 0);
        zeekraan2.setLocalTranslation(0, 7, 6);
        zeekraan3.setLocalTranslation(4, 7, 0);
        zeekraan4.setLocalTranslation(4, 7, 6);
        zeekraan5.setLocalTranslation(0, 15, 3f);
        zeekraan6.setLocalTranslation(4, 15, 3f);
        zeekraan7.setLocalTranslation(-2, 16, 3f);

        attachChild(zeekraan1);
        attachChild(zeekraan2);
        attachChild(zeekraan3);
        attachChild(zeekraan4);
        attachChild(zeekraan5);
        attachChild(zeekraan6);
        attachChild(zeekraan7);
    }

    public void getContainer(Container container, float tpf, int location, AssetManager assetManager) {
        switch (getContainerInt) {
            case 1:
                if ((int) this.getLocalTranslation().z < location) {
                    this.move(0, 0, tpf * 1f);

                } else if ((int) this.getLocalTranslation().z > location) {
                    this.move(0, 0, -tpf * 1f);
                }

                if ((int) this.getLocalTranslation().z == location) {
                    getContainerInt++;
                    this.attachChild(container);
                    container.setLocalTranslation(-10, 13.5f, 3);
                    ParticleEmitter debrisEffect = new ParticleEmitter("Debris", ParticleMesh.Type.Triangle, 10);
                    Material debrisMat = new Material(assetManager, "Common/MatDefs/Misc/Particle.j3md");
                    debrisMat.setTexture("Texture", assetManager.loadTexture("Effects/Explosion/Debris.png"));
                    debrisEffect.setMaterial(debrisMat);
                    debrisEffect.setImagesX(3);
                    debrisEffect.setImagesY(3); // 3x3 texture animation
                    debrisEffect.setRotateSpeed(4);
                    debrisEffect.setSelectRandomImage(true);
                    debrisEffect.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 4, 0));
                    debrisEffect.setStartColor(new ColorRGBA(1f, 1f, 1f, 1f));
                    debrisEffect.setGravity(0f, 6f, 0f);
                    debrisEffect.getParticleInfluencer().setVelocityVariation(.60f);
                    this.attachChild(debrisEffect);
                    debrisEffect.emitAllParticles();

                }
                break;
            case 2:
                if ((int) container.getLocalTranslation().x < 7f) {
                    container.move(1 * tpf, 0, 0);

                } else {
                    getContainerInt++;
                    this.detachChild(container);
                    super.parent.attachChild(container);
                    container.setLocalTranslation(this.getLocalTranslation().x + 7, 1, this.getLocalTranslation().z + 2);
                }
                break;
        }
    }
}