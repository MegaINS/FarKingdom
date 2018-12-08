package ru.megains.farlandsOld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Levels;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gameobjects.player.Player;
import ru.megains.farlandsOld.gameobjects.player.PlayerAction;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.helpers.PathFinder;
import ru.megains.farlandsOld.loaders.*;
import ru.megains.farlandsOld.net.SendPasket;

import java.util.ArrayList;

public class GameScreen implements Screen {
    private Gui gui;
    private MainGame game;
    private TiledMap tiledMap;
    private TiledMapTileLayer collisionLayer;
    private OrthogonalTiledMapRenderer renderer;
    private float unitScale = 1.0F;
    private PathFinder pathFinder = new PathFinder();
    private ArrayList<Vector2> path;
    private Vector3 transformation = new Vector3();
    private InputMultiplexer multiplexer = new InputMultiplexer();
    private int levelId;
    private boolean isTiled = false;
    private Vector2 lastTargetPoint;
    private String levelName;
    private AssetManager assetManager = new AssetManager();

    public GameScreen(int levelId, int levelType, String levelName) {
        this.levelId = levelId;
        this.levelName = levelName;
        if (levelId < 500) {
            this.isTiled = true;
        }

        if (this.isTiled) {
            this.assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
            this.assetManager.load(Levels.getLevel(levelId), TiledMap.class);
            this.assetManager.finishLoading();
            this.tiledMap = (TiledMap)this.assetManager.get(Levels.getLevel(levelId));
            this.collisionLayer = (TiledMapTileLayer)this.tiledMap.getLayers().get(0);
            this.renderer = new OrthogonalTiledMapRenderer(this.tiledMap, this.unitScale);
        }

        if (!this.isTiled) {
            DangeAtlasLoader.load(levelType);
            DangePathsAtlasLoader.load(levelType);
            ResAtlasLoader.load();
            PlayersAtlasLoader.loadLocAnimations(levelType);
            Const.game.getGame().getPlayer().loadLocAnimations();
        }

    }

    public void show() {
        this.game = Const.game.getGame();
        this.gui = Const.game.getGui();
        Const.screen = this;
        this.multiplexer.addProcessor(this.gui);
        this.multiplexer.addProcessor(this.game);
        Gdx.input.setInputProcessor(this.multiplexer);
        if (!this.isTiled) {
            this.game.getLevel();
            SendPasket.getLocRectangle();
        }

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(16384);
        if (this.isTiled) {
            this.renderer.setView(this.game.getGameCam());
            this.renderer.render();
        }

        this.game.act(delta);
        this.gui.act(delta);
        this.move();
        this.game.setIndexes();
        this.game.draw();
        this.gui.draw();
    }

    public void resize(int width, int height) {
        this.game.getViewport().update(width, height, true);
        this.game.getCamera().viewportWidth = (float)width;
        this.game.getCamera().viewportHeight = (float)height;
        if (this.isTiled) {
            this.renderer.setView(this.game.getGameCam());
        }

        this.gui.getViewport().update(width, height, true);
        this.gui.resize(width, height);
        Const.game.getGame().centerCam();
    }

    public void pause() {
    }

    public void resume() {
        Const.game.getGame().centerCam();
    }

    public void hide() {
        this.dispose();
    }

    public void dispose() {
        this.assetManager.dispose();
        this.game.disposeEnemies();
        this.game.disposeLevel();
    }

    public synchronized void click2path(int targetX, int targetY) {
        if (!Const.game.getGame().getPlayer().isBlocked() || Const.game.getGame().getPlayer().isMove()) {
            if (this.path != null && this.path.size() > 0 && Const.game.getGame().getPlayer().isMove()) {
                this.lastTargetPoint = new Vector2(((Vector2)this.path.get(0)).x, ((Vector2)this.path.get(0)).y);
                this.path.clear();
            } else {
                int[][] pathMap = (int[][])null;
                int startX;
                int startY;
                if (this.isTiled) {
                    pathMap = new int[this.collisionLayer.getWidth()][this.collisionLayer.getHeight()];

                    for(startX = 0; startX < this.collisionLayer.getWidth(); ++startX) {
                        for(startY = 0; startY < this.collisionLayer.getHeight(); ++startY) {
                            if (this.collisionLayer.getCell(startX, startY).getTile().getProperties().containsKey("blocked")) {
                                pathMap[startX][startY] = -2;
                            } else {
                                pathMap[startX][startY] = -1;
                            }
                        }
                    }
                }

                if (!this.isTiled) {
                    pathMap = this.game.getLevel().getPathMap();
                }

                this.transformation.set((float)targetX, (float)targetY, 0.0F);
                this.game.getGameCam().unproject(this.transformation);
                if (this.lastTargetPoint != null) {
                    startX = (int)this.lastTargetPoint.x;
                    startY = (int)this.lastTargetPoint.y;
                } else {
                    startX = this.game.getPlayer().getPlayerX();
                    startY = this.game.getPlayer().getPlayerY();
                }

                if (this.isTiled) {
                    this.path = this.pathFinder.FindingPath(pathMap, startX, startY, (int)this.transformation.x / 100, (int)this.transformation.y / 100, false);
                } else {
                    this.path = this.pathFinder.FindingPath(pathMap, startX, Math.abs(startY), (int)this.transformation.x / 100, ((int)this.transformation.y - 100) / -100, true);
                }

                if (this.lastTargetPoint != null && this.path != null && this.path.size() > 0) {
                    this.path.add(0, new Vector2(0.0F, 0.0F));
                    this.lastTargetPoint = null;
                }
//Todo
                if (path != null && path.size()>1) {
                    Vector2 temp = path.get(path.size()-1);
                    path = new ArrayList<Vector2>();
                    path.add(temp);

                }

            }
        }
    }

    public void stopMove(int x, int y) {
        if (this.path == null) {
            Const.game.getGame().getPlayer().stopMove();
        } else {
            this.path.clear();
            Const.game.getGame().playerMove(x, y);
        }
    }

    public void move() {
        this.drawPath();
        if (this.path != null) {
            if (!Const.game.getGame().getPlayer().isMove() && this.path.size() == 0) {
                this.lastTargetPoint = null;
            }

            if (this.path.size() > 0) {
                Player player = Const.game.getGame().getPlayer();
                if (!Const.game.getGame().getPlayer().isMove()) {
                    if ((float)player.getPlayerX() > ((Vector2)this.path.get(0)).x) {
                        Const.game.getGame().getPlayer().startMove(PlayerAction.MOVE_LEFT);
                    } else if ((float)player.getPlayerX() < ((Vector2)this.path.get(0)).x) {
                        Const.game.getGame().getPlayer().startMove(PlayerAction.MOVE_RIGHT);
                    } else if ((float)player.getPlayerY() < ((Vector2)this.path.get(0)).y) {
                        Const.game.getGame().getPlayer().startMove(PlayerAction.MOVE_TOP);
                    } else if ((float)player.getPlayerY() > ((Vector2)this.path.get(0)).y) {
                        Const.game.getGame().getPlayer().startMove(PlayerAction.MOVE_DOWN);
                    }

                    SendPasket.playerMove((int)((Vector2)this.path.get(0)).x, (int)((Vector2)this.path.get(0)).y, this.levelId);
                }

            }
        }
    }

    public void removePathPoint() {
        if (this.path != null) {
            if (this.path.size() > 0) {
                this.path.remove(0);
            }
        }
    }

    public void drawPath() {
        this.game.getPathCursorGroup().clear();
        if (this.path != null) {
            if (this.path.size() > 0) {
                Vector2 last = (Vector2)this.path.get(this.path.size() - 1);
                MyActor target = new MyActor(CursorsAtlasLoader.c0);
                this.game.getPathCursorGroup().addActor(target);
                target.setPosition(last.x * 100.0F, last.y * 100.0F);

                for(int i = 0; i < this.path.size() - 1; ++i) {
                    Vector2 curent = (Vector2)this.path.get(i);
                    Vector2 next = (Vector2)this.path.get(i + 1);
                    MyActor cursor = null;
                    if (next.x == curent.x && next.y > curent.y) {
                        cursor = new MyActor(CursorsAtlasLoader.c8);
                    } else if (next.x == curent.x && next.y < curent.y) {
                        cursor = new MyActor(CursorsAtlasLoader.c2);
                    } else if (next.x > curent.x && next.y == curent.y) {
                        cursor = new MyActor(CursorsAtlasLoader.c6);
                    } else if (next.x < curent.x && next.y == curent.y) {
                        cursor = new MyActor(CursorsAtlasLoader.c4);
                    } else if (next.x > curent.x && next.y > curent.y) {
                        cursor = new MyActor(CursorsAtlasLoader.c9);
                    } else if (next.x > curent.x && next.y < curent.y) {
                        cursor = new MyActor(CursorsAtlasLoader.c3);
                    } else if (next.x < curent.x && next.y > curent.y) {
                        cursor = new MyActor(CursorsAtlasLoader.c7);
                    } else if (next.x < curent.x && next.y < curent.y) {
                        cursor = new MyActor(CursorsAtlasLoader.c1);
                    }

                    if (cursor != null) {
                        this.game.getPathCursorGroup().addActor(cursor);
                        cursor.setPosition(((Vector2)this.path.get(i)).x * 100.0F, ((Vector2)this.path.get(i)).y * 100.0F);
                    }
                }

            }
        }
    }

    public int getLevelId() {
        return this.levelId;
    }

    public String getLevelName() {
        return this.levelName;
    }
}

