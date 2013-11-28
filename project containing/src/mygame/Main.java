package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;
import com.jme3.util.SkyFactory;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    int tilex = 120; // aantal tiles in de breedte
    int tiley = 47; // aantal tiles in de lengte, deze even oneven houden voor kleuren
    OpslagKraan[] opslagkranen = new OpslagKraan[45];
    Container[] containers = new Container[100];
    ZeeKraan[] zeekranen = new ZeeKraan[4];
    BinnenVaartKraan[] binnenvaartkranen = new BinnenVaartKraan[3];
    TreinKraan[] treinkranen = new TreinKraan[4];
    VrachtautoKraan[] vrachtautokranen = new VrachtautoKraan[20];

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(100f);
        initFloor();
        makecontainer();

        //kranen initialiseren en plaatsen
        initBinnenVaartKraan();
        initOpslagKraan();
        initZeeKraan();
        initTreinKraan();
        initVrachtautoKraan();


        Node sceneNode = new Node("Scene");
        sceneNode.attachChild(SkyFactory.createSky(assetManager, "Textures/BrightSky.dds", false));
        rootNode.attachChild(sceneNode);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //opslagkranen[1].move(0, 0, tpf * 5);
        //for (int i = 0; i < 43; i++) {
            if(opslagkranen[1].beweegheen(true, tpf, 5, 5, 5)){
                opslagkranen[1].beweegterug(false, tpf);
            
            }
        //}
    }

    @Override
    public void simpleRender(RenderManager rm) {
    }

    public void makecontainer() {
        for (int i = 0; i < 30; i++) {

            containers[i] = new Container(assetManager);
            rootNode.attachChild(containers[i]);
            containers[i].setLocalTranslation(100f, 2.5f / 6 + (2.5f / 3) * i, -50f);
            containers[i].rotate(0, FastMath.PI / 2, 0);

            //[i].setLocalTranslation(77f + 13f / 3 + 2.5f / 3 * 12, (2.5f / 3 * 14) + ((13/3) * i), -50f);
        }
    }

    public void initFloor() {
        Box box = new Box(Vector3f.ZERO, 250f, 0.02f, 100f);//13 bij 2.5

        Geometry grond = new Geometry("A Textured Box", box);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Texture text = assetManager.loadTexture("Textures/gras.jpg");
        mat.setTexture("ColorMap", text);

        grond.setMaterial(mat);
        rootNode.attachChild(grond);
        grond.setLocalTranslation(250f, -0.020f, -100f);
    }
    // 13 lang 2.5 breed en 2.5 hoog

    //1500 500 250 3
    public void initOpslagKraan() {

        for (int i = 0; i < 45; i++) {

            opslagkranen[i] = new OpslagKraan(assetManager);
            rootNode.attachChild(opslagkranen[i]);
            opslagkranen[i].setLocalTranslation(60f + (9.3f * i), 0, -50f);
            opslagkranen[i].rotate(0, FastMath.PI / 2, 0);
        }

    }

    public void initZeeKraan() {

        for (int i = 0; i < 4; i++) {
            zeekranen[i] = new ZeeKraan(assetManager);
            rootNode.attachChild(zeekranen[i]);
            zeekranen[i].setLocalTranslation(1f, .5f, -(10f + (63f * i)));
        }
    }

    public void initBinnenVaartKraan() {
        for (int i = 0; i < 3; i++) {

            binnenvaartkranen[i] = new BinnenVaartKraan(assetManager);
            rootNode.attachChild(binnenvaartkranen[i]);
            binnenvaartkranen[i].setLocalTranslation(25f + (80f * i), 0.5f, -1f);
            binnenvaartkranen[i].rotate(0, FastMath.PI / 2, 0);
        }

    }

    public void initTreinKraan() {
        for (int i = 0; i < 4; i++) {

            treinkranen[i] = new TreinKraan(assetManager);
            rootNode.attachChild(treinkranen[i]);
            treinkranen[i].setLocalTranslation(100f + (125f * i), 0, -199f);
        }
    }

    public void initVrachtautoKraan() {
        for (int i = 0; i < 20; i++) {

            vrachtautokranen[i] = new VrachtautoKraan(assetManager);
            rootNode.attachChild(vrachtautokranen[i]);
            vrachtautokranen[i].setLocalTranslation(400f + (4.5f * i), 0, -1f);
            vrachtautokranen[i].rotate(0, FastMath.PI / 2, 0);
        }
    }
}
