package ru.megains.farlandsOld.gameobjects;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.megains.farlandsOld.gameobjects.mob.Mob;
import ru.megains.farlandsOld.gameobjects.res.ResCell;
import ru.megains.farlandsOld.gameobjects.trap.Trap;
import ru.megains.farlandsOld.loaders.DangePathsAtlasLoader;

import java.util.ArrayList;
import java.util.Iterator;

public class GeneratedLevel extends Group {
    private GameCell[][] level;
    private ResCell[][] resMap;
    private Mob[][] mobMap;
    private Trap[][] trapMap;
    private Group resGroup;
    private Group cellsGroup;
    private Group mobGroup;
    private Group trapsGroup;
    private Tuman tuman;
    private int width = 50;
    private int height = 50;

    public GeneratedLevel(Tuman tuman) {
        this.tuman = tuman;
        this.level = new GameCell[this.width][this.height];
        this.resMap = new ResCell[this.width][this.height];
        this.mobMap = new Mob[this.width][this.height];
        this.trapMap = new Trap[this.width][this.height];
        this.resGroup = new Group();
        this.cellsGroup = new Group();
        this.mobGroup = new Group();
        this.trapsGroup = new Group();
        this.addActor(this.cellsGroup);
        this.addActor(this.resGroup);
        this.addActor(this.mobGroup);
        this.addActor(this.trapsGroup);

        int i;
        for(i = 0; i < this.width; ++i) {
            CellNumMask num = new CellNumMask(i);
            num.setPosition((float)(i * 100), 100.0F);
            this.addActor(num);
        }

        for(i = 0; i < this.height; ++i) {
            CellTextMask text = new CellTextMask(i);
            text.setPosition(-100.0F, (float)(i * 100 * -1));
            this.addActor(text);
        }

    }

    public void setLevelRectangle(JSONObject cellsRectangle) {
        this.clearRes();
        this.clearMob();
        this.clearTraps();
        JSONArray cellsArray = (JSONArray)cellsRectangle.get("cells");
        JSONArray resArray = (JSONArray)cellsRectangle.get("res");
        JSONArray mobArray = (JSONArray)cellsRectangle.get("mobs");
        JSONArray trapArray = (JSONArray)cellsRectangle.get("traps");

        for(int i = 0; i < cellsArray.size(); ++i) {
            ArrayList<Object> tempArray = (ArrayList)cellsArray.get(i);
            int tmpX = ((Long)tempArray.get(0)).intValue();
            int tmpY = ((Long)tempArray.get(1)).intValue();
            int type = ((Long)tempArray.get(2)).intValue();
            int count = ((Long)tempArray.get(3)).intValue();
            int damage = ((Long)tempArray.get(4)).intValue();
            int mask = ((Long)tempArray.get(5)).intValue();
            this.clearGameCell(tmpX, tmpY);
            this.level[tmpX][tmpY] = new GameCell(tmpX, tmpY, type, count, damage, mask);
            if (this.tuman != null) {
                this.tuman.update(tmpX, tmpY);
            }

            tempArray.clear();
            tempArray = (ArrayList)resArray.get(i);
            int id;
            int trapDamage;
            int conc;
            if (((Long)tempArray.get(2)).intValue() != 0) {
                tmpX = ((Long)tempArray.get(0)).intValue();
                tmpY = ((Long)tempArray.get(1)).intValue();
                id = ((Long)tempArray.get(2)).intValue();
                trapDamage = ((Long)tempArray.get(3)).intValue();
                String resName = (String)tempArray.get(4);
                conc = ((Long)tempArray.get(5)).intValue();
                if (trapDamage > 0) {
                    this.resMap[tmpX][tmpY] = new ResCell(tmpX, tmpY, id, trapDamage, resName, conc);
                }
            }

            tempArray.clear();
            tempArray = (ArrayList)trapArray.get(i);
            int level;
            if (((Long)tempArray.get(1)).intValue() != 0) {
                tmpX = ((Long)tempArray.get(0)).intValue();
                tmpY = ((Long)tempArray.get(1)).intValue();
                String name = (String)tempArray.get(2);
                trapDamage = ((Long)tempArray.get(3)).intValue();
                level = ((Long)tempArray.get(4)).intValue();
                conc = ((Long)tempArray.get(5)).intValue();
                if (conc != 0) {
                    this.trapMap[tmpX][tmpY] = new Trap(conc, tmpX, tmpY, name, trapDamage, level);
                }
            }

            tempArray.clear();
            tempArray = (ArrayList)mobArray.get(i);
            if (((Long)tempArray.get(2)).intValue() != 0) {
                tmpX = ((Long)tempArray.get(0)).intValue();
                tmpY = ((Long)tempArray.get(1)).intValue();
                id = ((Long)tempArray.get(2)).intValue();
                String mobName = (String)tempArray.get(3);
                level = ((Long)tempArray.get(4)).intValue();
                conc = ((Long)tempArray.get(5)).intValue();
                int hpMax = ((Long)tempArray.get(6)).intValue();
                int hpCurent = ((Long)tempArray.get(7)).intValue();
                int mobDamage = ((Long)tempArray.get(8)).intValue();
                int damageRange = ((Long)tempArray.get(9)).intValue();
                int crit = ((Long)tempArray.get(10)).intValue();
                int defence = ((Long)tempArray.get(11)).intValue();
                int antiCrit = ((Long)tempArray.get(12)).intValue();
                if (id != 0) {
                    this.mobMap[tmpX][tmpY] = new Mob(tmpX, tmpY, id, mobName, level, conc, hpMax, hpCurent, mobDamage, damageRange, crit, defence, antiCrit);
                }
            }

            tempArray.clear();
        }

        this.update();
    }

    private synchronized void clearRes() {
        for(int i = 0; i < this.resMap.length; ++i) {
            for(int j = 0; j < this.resMap[0].length; ++j) {
                if (this.resMap[i][j] != null) {
                    this.resMap[i][j] = null;
                }
            }
        }

        this.resGroup.clearChildren();
    }

    private synchronized void clearTraps() {
        for(int i = 0; i < this.trapMap.length; ++i) {
            for(int j = 0; j < this.trapMap[0].length; ++j) {
                if (this.trapMap[i][j] != null) {
                    this.trapMap[i][j] = null;
                }
            }
        }

        this.trapsGroup.clearChildren();
    }

    private synchronized void clearMob() {
        for(int i = 0; i < this.mobMap.length; ++i) {
            for(int j = 0; j < this.mobMap[0].length; ++j) {
                if (this.mobMap[i][j] != null) {
                    this.mobMap[i][j] = null;
                }
            }
        }

        this.mobGroup.clearChildren();
    }

    private synchronized void clearGameCell(int cellX, int cellY) {
        Iterator var3 = this.cellsGroup.getChildren().iterator();

        while(var3.hasNext()) {
            Actor actor = (Actor)var3.next();
            if (actor instanceof GameCell && (int)actor.getX() == cellX * 100 && (int)actor.getY() == -cellY * 100) {
                this.level[cellX][cellY] = null;
                actor.addAction(Actions.removeActor());
            }
        }

    }

    private synchronized void update() {
        for(int i = 0; i < this.width; ++i) {
            for(int j = 0; j < this.height; ++j) {
                if (this.level[i][j] != null) {
                    GameCell cell = this.level[i][j];
                    cell.setPosition((float)(i * 100), (float)(-j * 100));
                    this.setCellSprite(cell);
                    this.cellsGroup.addActor(cell);
                }

                if (this.resMap[i][j] != null) {
                    ResCell resCell = this.resMap[i][j];
                    resCell.setPosition((float)(i * 100), (float)(-j * 100));
                    this.resGroup.addActor(resCell);
                }

                if (this.mobMap[i][j] != null) {
                    Mob mob = this.mobMap[i][j];
                    mob.setPosition((float)(i * 100), (float)(-j * 100));
                    this.mobGroup.addActor(mob);
                }

                if (this.trapMap[i][j] != null) {
                    Trap trap = this.trapMap[i][j];
                    trap.setPosition((float)(i * 100), (float)(-j * 100));
                    this.trapsGroup.addActor(trap);
                }
            }
        }

    }

    private void setCellSprite(GameCell cell) {
        int xx = cell.getCellX();
        int yy = cell.getCellY();
        if (this.level[xx][yy].isEmpty()) {
            boolean lCell = false;
            boolean rCell = false;
            boolean uCell = false;
            boolean dCell = false;
            if (xx - 1 >= 0 && this.level[xx - 1][yy] != null) {
                lCell = this.level[xx - 1][yy].isEmpty();
            }

            if (xx + 1 < this.width && this.level[xx + 1][yy] != null) {
                rCell = this.level[xx + 1][yy].isEmpty();
            }

            if (yy + 1 < this.height && this.level[xx][yy + 1] != null) {
                dCell = this.level[xx][yy + 1].isEmpty();
            }

            if (yy - 1 >= 0 && this.level[xx][yy - 1] != null) {
                uCell = this.level[xx][yy - 1].isEmpty();
            }

            if (!lCell && !rCell && !uCell && !dCell) {
                cell.setSprite(DangePathsAtlasLoader.path0);
            } else if (!lCell && rCell && uCell && !dCell) {
                cell.setSprite(DangePathsAtlasLoader.path1);
            } else if (lCell && rCell && uCell && !dCell) {
                cell.setSprite(DangePathsAtlasLoader.path2);
            } else if (lCell && !rCell && uCell && !dCell) {
                cell.setSprite(DangePathsAtlasLoader.path3);
            } else if (!lCell && rCell && uCell && dCell) {
                cell.setSprite(DangePathsAtlasLoader.path4);
            } else if (lCell && rCell && uCell && dCell) {
                cell.setSprite(DangePathsAtlasLoader.path5);
            } else if (lCell && !rCell && uCell && dCell) {
                cell.setSprite(DangePathsAtlasLoader.path6);
            } else if (!lCell && rCell && !uCell && dCell) {
                cell.setSprite(DangePathsAtlasLoader.path7);
            } else if (lCell && rCell && !uCell && dCell) {
                cell.setSprite(DangePathsAtlasLoader.path8);
            } else if (lCell && !rCell && !uCell && dCell) {
                cell.setSprite(DangePathsAtlasLoader.path9);
            } else if (!lCell && !rCell && uCell && dCell) {
                cell.setSprite(DangePathsAtlasLoader.path10);
            } else if (lCell && rCell && !uCell && !dCell) {
                cell.setSprite(DangePathsAtlasLoader.path11);
            } else if (!lCell && rCell && !uCell && !dCell) {
                cell.setSprite(DangePathsAtlasLoader.path12);
            } else if (lCell && !rCell && !uCell && !dCell) {
                cell.setSprite(DangePathsAtlasLoader.path13);
            } else if (!lCell && !rCell && uCell && !dCell) {
                cell.setSprite(DangePathsAtlasLoader.path14);
            } else if (!lCell && !rCell && !uCell && dCell) {
                cell.setSprite(DangePathsAtlasLoader.path15);
            }
        }
    }

    public synchronized int[][] getPathMap() {
        int[][] result = (int[][])null;
        int fx = 0;
        int fy = 0;

        int i;
        int j;
        for(i = 0; i < this.level.length; ++i) {
            for(j = 0; j < this.level[0].length; ++j) {
                if (this.level[i][j] != null) {
                    if (fx < i) {
                        fx = i;
                    }

                    if (fy < j) {
                        fy = j;
                    }
                }
            }
        }

        result = new int[fx + 1][fy + 1];

        for(i = 0; i < result.length; ++i) {
            for(j = 0; j < result[0].length; ++j) {
                result[i][j] = -2;
                if (this.level[i][j] != null && this.level[i][j].isEmpty() && this.resMap[i][j] == null) {
                    result[i][j] = -1;
                }
            }
        }

        return result;
    }

    public void dispose() {
        this.clearActions();
        this.clearChildren();
    }
}
