package ru.megains.farlandsOld.helpers;


import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;

public class PathFinder {
    private int mapWidht;
    private int mapHeight;
    private boolean add;
    private boolean stopIteration;
    private int[][] cMap;
    private int step;
    private ArrayList<Vector2> path;

    public PathFinder() {
    }

    public ArrayList<Vector2> FindingPath(int[][] map, int startX, int startY, int targetX, int targetY, boolean inLoc) {
        this.mapWidht = map.length;
        this.mapHeight = map[0].length;
        this.path = new ArrayList();
        if (targetX < map.length && targetY < map[0].length && targetX >= 0 && targetY >= 0) {
            if (map[targetX][targetY] == -2) {
                this.path.clear();
                return this.path;
            } else {
                if (targetX >= 0 && targetY >= 0 && targetX < this.mapWidht && targetY < this.mapHeight) {
                    this.add = true;
                    this.step = 0;
                    this.cMap = map;
                    if (this.cMap[targetX][targetY] != -2) {
                        this.cMap[targetX][targetY] = 0;
                    }

                    while(this.add) {
                        this.add = false;

                        for(int x = 0; x < this.mapWidht; ++x) {
                            for(int y = 0; y < this.mapHeight; ++y) {
                                if (this.cMap[x][y] == this.step) {
                                    if (x - 1 >= 0 && this.cMap[x - 1][y] == -1) {
                                        this.cMap[x - 1][y] = this.step + 1;
                                    }

                                    if (y - 1 >= 0 && this.cMap[x][y - 1] == -1) {
                                        this.cMap[x][y - 1] = this.step + 1;
                                    }

                                    if (x + 1 < this.mapWidht && this.cMap[x + 1][y] == -1) {
                                        this.cMap[x + 1][y] = this.step + 1;
                                    }

                                    if (y + 1 < this.mapHeight && this.cMap[x][y + 1] == -1) {
                                        this.cMap[x][y + 1] = this.step + 1;
                                    }

                                    if (!inLoc) {
                                        if (x - 1 >= 0 && y + 1 < this.mapHeight && this.cMap[x - 1][y + 1] == -1) {
                                            this.cMap[x - 1][y + 1] = this.step + 1;
                                        }

                                        if (x + 1 < this.mapWidht && y + 1 < this.mapHeight && this.cMap[x + 1][y + 1] == -1) {
                                            this.cMap[x + 1][y + 1] = this.step + 1;
                                        }

                                        if (x - 1 >= 0 && y - 1 >= 0 && this.cMap[x - 1][y - 1] == -1) {
                                            this.cMap[x - 1][y - 1] = this.step + 1;
                                        }

                                        if (x + 1 < this.mapWidht && y - 1 >= 0 && this.cMap[x + 1][y - 1] == -1) {
                                            this.cMap[x + 1][y - 1] = this.step + 1;
                                        }
                                    }
                                }
                            }
                        }

                        ++this.step;
                        this.add = true;
                        if (this.cMap[startX][startY] != -1) {
                            for(this.add = false; this.step > 0; --this.step) {
                                this.stopIteration = false;
                                if (startX - 1 >= 0 && !this.stopIteration && this.cMap[startX - 1][startY] == this.step - 1) {
                                    this.path.add(new Vector2((float)(startX - 1), (float)startY));
                                    --startX;
                                    this.stopIteration = true;
                                }

                                if (startX + 1 < this.mapWidht && !this.stopIteration && this.cMap[startX + 1][startY] == this.step - 1) {
                                    this.path.add(new Vector2((float)(startX + 1), (float)startY));
                                    ++startX;
                                    this.stopIteration = true;
                                }

                                if (startY - 1 >= 0 && !this.stopIteration && this.cMap[startX][startY - 1] == this.step - 1) {
                                    this.path.add(new Vector2((float)startX, (float)(startY - 1)));
                                    --startY;
                                    this.stopIteration = true;
                                }

                                if (startY + 1 < this.mapHeight && !this.stopIteration && this.cMap[startX][startY + 1] == this.step - 1) {
                                    this.path.add(new Vector2((float)startX, (float)(startY + 1)));
                                    ++startY;
                                    this.stopIteration = true;
                                }

                                if (!inLoc) {
                                    if (startX - 1 >= 0 && startY + 1 < this.mapHeight && !this.stopIteration && this.cMap[startX - 1][startY + 1] == this.step - 1) {
                                        this.path.add(new Vector2((float)(startX - 1), (float)(startY + 1)));
                                        --startX;
                                        ++startY;
                                        this.stopIteration = true;
                                    }

                                    if (startX + 1 < this.mapWidht && startY + 1 < this.mapHeight && !this.stopIteration && this.cMap[startX + 1][startY + 1] == this.step - 1) {
                                        this.path.add(new Vector2((float)(startX + 1), (float)(startY + 1)));
                                        ++startX;
                                        ++startY;
                                        this.stopIteration = true;
                                    }

                                    if (startX - 1 >= 0 && startY - 1 >= 0 && !this.stopIteration && this.cMap[startX - 1][startY - 1] == this.step - 1) {
                                        this.path.add(new Vector2((float)(startX - 1), (float)(startY - 1)));
                                        --startX;
                                        --startY;
                                        this.stopIteration = true;
                                    }

                                    if (startX + 1 < this.mapWidht && startY - 1 >= 0 && !this.stopIteration && this.cMap[startX + 1][startY - 1] == this.step - 1) {
                                        this.path.add(new Vector2((float)(startX + 1), (float)(startY - 1)));
                                        ++startX;
                                        --startY;
                                        this.stopIteration = true;
                                    }
                                }
                            }
                        }

                        if (this.step > this.mapWidht * this.mapHeight) {
                            this.add = false;
                        }
                    }
                }

                Vector2 coord;
                if (inLoc) {
                    for(Iterator var9 = this.path.iterator(); var9.hasNext(); coord.y *= -1.0F) {
                        coord = (Vector2)var9.next();
                    }
                }

                return this.path;
            }
        } else {
            this.path.clear();
            return this.path;
        }
    }
}

