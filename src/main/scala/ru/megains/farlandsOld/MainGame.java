package ru.megains.farlandsOld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.*;
import ru.megains.farlandsOld.gameobjects.mob.Mob;
import ru.megains.farlandsOld.gameobjects.player.Player;
import ru.megains.farlandsOld.gameobjects.res.ResCell;
import ru.megains.farlandsOld.gameobjects.trap.Trap;

import java.util.Iterator;

public class MainGame extends Stage {
    private Viewport view;
    private Player player;
    private OrthographicCamera cam = new OrthographicCamera();
    private boolean isDown = false;
    private int downX;
    private int downY;
    private GeneratedLevel level = null;
    private Tuman tuman = null;
    private Vector3 transformation;
    private Group warpsGroup;
    private Group pathCursorsGroup;
    private float w;
    private float h;

    public MainGame() {
        this.cam.setToOrtho(false, (float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
        this.view = new ExtendViewport((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight(), this.cam);
        this.setViewport(this.view);
        this.warpsGroup = new Group();
        this.player = new Player();
        this.player.setWidth(100.0F);
        this.player.setHeight(100.0F);
        this.pathCursorsGroup = new Group();
        this.addActor(this.warpsGroup);
        this.addActor(this.pathCursorsGroup);
        this.addActor(this.player);
        this.player.toFront();
        this.transformation = new Vector3();
    }

    public boolean touchDragged(int x, int y, int pointer) {
        super.touchDragged(x, y, pointer);
        if (Gdx.input.isButtonPressed(0)) {
            this.view.getCamera().translate((float)(-Gdx.input.getDeltaX()), (float) Gdx.input.getDeltaY(), 0.0F);
            this.view.getCamera().update();
        }

        return true;
    }

    public boolean touchDown(int x, int y, int pointer, int button) {
        super.touchDown(x, y, pointer, button);
        if (button == 0) {
            this.isDown = true;
            this.downX = x;
            this.downY = y;
        }

        return true;
    }

    public boolean touchUp(int x, int y, int pointer, int button) {
        super.touchUp(x, y, pointer, button);
        if (button == 0 && this.isDown && this.downX == x && this.downY == y) {
            this.transformation.set((float)x, (float)y, 0.0F);
            this.cam.unproject(this.transformation);
            this.cancelTouchFocus(this.tuman);
            Actor hitActor = this.hit(this.transformation.x, this.transformation.y, false);
            if (hitActor instanceof GameCell) {
                ((GameCell)hitActor).hitAction();
            } else if (hitActor instanceof ResCell) {
                ((ResCell)hitActor).hitAction();
            } else if (hitActor instanceof Mob) {
                ((Mob)hitActor).hitAction();
            } else if (hitActor instanceof Trap) {
                ((Trap)hitActor).hitAction();
            }

            Const.screen.click2path(x, y);
        }

        return true;
    }

    public Player getPlayer() {
        return this.player;
    }

    public OrthographicCamera getGameCam() {
        return this.cam;
    }

    public void playerChangeLoc(JSONObject packet) {
        Const.game.getScreen().dispose();
        Const.game.setScreen(new GameScreen(((Long)packet.get("loc")).intValue(), ((Long)packet.get("restype")).intValue(), (String)packet.get("locName")));
        this.player.setPosition((float)((Long)packet.get("x")).intValue(), (float)((Long)packet.get("y")).intValue());
        this.player.stopMove();
        this.player.stopRest();
        this.centerCam();
    }

    public void setVisibleEnemies(JSONArray packet) throws ParseException {
        Iterator var2 = this.getActors().iterator();

        while(var2.hasNext()) {
            Actor actor = (Actor)var2.next();
            if (actor instanceof EnemyPlayer) {
                actor.addAction(Actions.removeActor());
            }
        }

        JSONParser parser = new JSONParser();

        for(int i = 0; i < packet.size(); ++i) {
            Object obj = parser.parse(packet.get(i).toString());
            JSONObject jsonObj = (JSONObject)obj;
            this.enemyMove(jsonObj);
        }

    }

    public void playerMove(int x, int y) {
        this.player.setPosition((float)x, (float)y);
        this.player.stopMove();
        this.player.toFront();
    }

    public void playerMove(JSONObject jsonObj) {
        this.player.setPosition((float)((Long)jsonObj.get("x")).intValue(), (float)((Long)jsonObj.get("y")).intValue());
        this.player.stopMove();
        this.player.toFront();
    }

    public void enemyMove(JSONObject packet) {
        int enemyX = ((Long)packet.get("x")).intValue();
        int enemyY = ((Long)packet.get("y")).intValue();
        String enemyName = (String)packet.get("name");
        this.addEnemyPlayer(enemyName, enemyX, enemyY);
    }

    private void addEnemyPlayer(String name, int enemyX, int enemyY) {
        EnemyPlayer enemy = new EnemyPlayer(new Sprite(new Texture("players/spr_enemy_0.png")), name);
        this.addActor(enemy);
        enemy.setPosition((float)enemyX, (float)enemyY);
        enemy.setZIndex(6);
        this.player.toFront();
    }

    public void setWarps(JSONArray array) throws ParseException {
        this.warpsGroup.clear();
        JSONParser parser = new JSONParser();

        for(int i = 0; i < array.size(); ++i) {
            Object obj = parser.parse(array.get(i).toString());
            JSONObject jsonObj = (JSONObject)obj;
            Warp warp = new Warp((String)jsonObj.get("title"), ((Long)jsonObj.get("warpid")).intValue(), new Vector2((float)((Long)jsonObj.get("warpx")).intValue(), (float)((Long)jsonObj.get("warpy")).intValue()));
            int type = ((Long)jsonObj.get("type")).intValue();
            if (type == 3) {
                warp.setSpriteOut();
            } else if (type == 2) {
                warp.setSpriteIn();
            }

            this.warpsGroup.addActor(warp);
        }

    }

    public void disposeEnemies() {
        Iterator var1 = this.getActors().iterator();

        while(var1.hasNext()) {
            Actor actor = (Actor)var1.next();
            if (actor instanceof EnemyPlayer) {
                actor.remove();
            }
        }

    }

    public synchronized GeneratedLevel getLevel() {
        if (this.level == null) {
            this.level = new GeneratedLevel(this.getTuman(50, 50));
            this.addActor(this.level);
            return this.level;
        } else {
            return this.level;
        }
    }

    public synchronized Tuman getTuman(int w, int h) {
        if (this.tuman == null) {
            this.tuman = new Tuman(w, h);
            this.addActor(this.tuman);
            return this.tuman;
        } else {
            return this.tuman;
        }
    }

    public void disposeLevel() {
        if (this.level != null) {
            this.level.dispose();
        }

        this.level = null;
        if (this.tuman != null) {
            this.tuman.dispose();
            this.tuman = null;
        }

    }

    public Group getWarps() {
        return this.warpsGroup;
    }

    public void setIndexes() {
        if (this.level != null) {
            this.level.setZIndex(1);
        }

        this.warpsGroup.setZIndex(2);
        this.pathCursorsGroup.setZIndex(3);
        if (this.tuman != null) {
            this.tuman.setZIndex(4);
        }

    }

    public void centerCam() {
        Vector3 transformation = new Vector3();
        transformation.set(this.player.getX(), this.player.getY(), 0.0F);
        this.view.getCamera().position.x = transformation.x;
        this.view.getCamera().position.y = transformation.y;
        System.out.println("center cam");
    }

    public Group getPathCursorGroup() {
        return this.pathCursorsGroup;
    }

    public void borderLimit() {
        if (this.view.getCamera().position.x > 500.0F) {
            this.view.getCamera().translate((float)(-Gdx.input.getDeltaX()), (float) Gdx.input.getDeltaY(), 0.0F);
            this.view.getCamera().update();
        } else {
            this.cam.position.set(501.0F, this.view.getCamera().position.y, 0.0F);
        }

        if (this.view.getCamera().position.x < 800.0F) {
            this.view.getCamera().translate((float)(-Gdx.input.getDeltaX()), (float) Gdx.input.getDeltaY(), 0.0F);
            this.view.getCamera().update();
        } else {
            this.cam.position.set(799.0F, this.view.getCamera().position.y, 0.0F);
        }

        if (this.view.getCamera().position.y > 200.0F) {
            this.view.getCamera().translate((float)(-Gdx.input.getDeltaX()), (float) Gdx.input.getDeltaY(), 0.0F);
            this.view.getCamera().update();
        } else {
            this.cam.position.set(this.view.getCamera().position.x, 201.0F, 0.0F);
        }

        if (this.view.getCamera().position.y < 750.0F) {
            this.view.getCamera().translate((float)(-Gdx.input.getDeltaX()), (float) Gdx.input.getDeltaY(), 0.0F);
            this.view.getCamera().update();
        } else {
            this.cam.position.set(this.view.getCamera().position.x, 749.0F, 0.0F);
        }

    }
}