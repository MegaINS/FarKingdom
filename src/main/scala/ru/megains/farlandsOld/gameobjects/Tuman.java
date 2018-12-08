package ru.megains.farlandsOld.gameobjects;

import com.badlogic.gdx.scenes.scene2d.Group;
import ru.megains.farlandsOld.loaders.DangeAtlasLoader;

public class Tuman extends Group {
    private MyActor[][] maskMap;
    private int width;
    private int height;
    private Group konturGroup = new Group();

    public Tuman(int width, int height) {
        this.addActor(this.konturGroup);
        System.out.println("Create tuman");
        this.width = width;
        this.height = height;
        this.maskMap = new MyActor[width][height];

        for(int i = 0; i < width; ++i) {
            for(int j = 0; j < height; ++j) {
                this.maskMap[i][j] = new MyActor(DangeAtlasLoader.mask14);
            }
        }

        this.drawMask();
    }

    public synchronized void update(int x, int y) {
        if (this.maskMap[x][y] instanceof MyActor) {
            this.maskMap[x][y].remove();
            this.maskMap[x][y] = null;
        }

        this.drawKontur();
    }

    private synchronized void drawMask() {
        for(int i = 0; i < this.width; ++i) {
            for(int j = 0; j < this.height; ++j) {
                if (this.maskMap[i][j] != null) {
                    this.maskMap[i][j].setPosition((float)(i * 100), (float)(-j * 100));
                    this.addActor(this.maskMap[i][j]);
                }
            }
        }

    }

    private synchronized void drawKontur() {
        this.konturGroup.clearChildren();

        for(int i = 0; i < this.width; ++i) {
            for(int j = 0; j < this.height; ++j) {
                if (this.maskMap[i][j] == null) {
                    TumanMaskActor konturActor;
                    if ((i <= 0 || this.maskMap[i - 1][j] == null) && (i != 0 || j <= 0)) {
                        if ((i >= this.width - 1 || this.maskMap[i + 1][j] == null) && (i != this.width - 1 || j <= 0 || j >= this.height - 1)) {
                            if (j > 0 && i > 0 && this.maskMap[i][j - 1] != null || j == 0 && i > 0) {
                                konturActor = new TumanMaskActor(DangeAtlasLoader.mask8);
                                konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                                this.konturGroup.addActor(konturActor);
                            } else if (j < this.height - 1 && i < this.width - 1 && this.maskMap[i][j + 1] != null || j == this.height - 1 && i < this.width - 1) {
                                konturActor = new TumanMaskActor(DangeAtlasLoader.mask2);
                                konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                                this.konturGroup.addActor(konturActor);
                            }
                        } else {
                            konturActor = new TumanMaskActor(DangeAtlasLoader.mask6);
                            konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                            this.konturGroup.addActor(konturActor);
                        }
                    } else {
                        konturActor = new TumanMaskActor(DangeAtlasLoader.mask4);
                        konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                        this.konturGroup.addActor(konturActor);
                    }

                    if (i > 0 && j > 0 && this.maskMap[i - 1][j] != null && this.maskMap[i][j - 1] != null || i == 0 && j == 0 || i == 0 && j > 0 && this.maskMap[i][j - 1] != null || i > 0 && j == 0 && this.maskMap[i - 1][j] != null) {
                        konturActor = new TumanMaskActor(DangeAtlasLoader.mask7);
                        konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                        this.konturGroup.addActor(konturActor);
                    }

                    if (i > 0 && j < this.height - 1 && this.maskMap[i - 1][j] != null && this.maskMap[i][j + 1] != null || i == 0 && j == this.height - 1 || i > 0 && j == this.height - 1 && this.maskMap[i - 1][j] != null || i == 0 && j < this.height - 1 && this.maskMap[i][j + 1] != null) {
                        konturActor = new TumanMaskActor(DangeAtlasLoader.mask1);
                        konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                        this.konturGroup.addActor(konturActor);
                    }

                    if (i < this.width - 1 && j < this.height - 1 && this.maskMap[i + 1][j] != null && this.maskMap[i][j + 1] != null || i < this.width - 1 && i > 0 && j == this.height - 1 && this.maskMap[i + 1][j] != null || i == this.width - 1 && j == this.height - 1 || i == this.width - 1 && j < this.height - 1 && this.maskMap[i][j + 1] != null) {
                        konturActor = new TumanMaskActor(DangeAtlasLoader.mask3);
                        konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                        this.konturGroup.addActor(konturActor);
                    }

                    if (i < this.width - 1 && j > 0 && this.maskMap[i + 1][j] != null && this.maskMap[i][j - 1] != null || i > 0 && j == 0 && i < this.width - 1 && this.maskMap[i + 1][j] != null || i == this.width - 1 && j == 0 || i == this.width - 1 && j > 0 && this.maskMap[i][j - 1] != null) {
                        konturActor = new TumanMaskActor(DangeAtlasLoader.mask9);
                        konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                        this.konturGroup.addActor(konturActor);
                    }

                    if (i > 0 && j < this.height - 1 && this.maskMap[i - 1][j] == null && this.maskMap[i][j + 1] == null && this.maskMap[i - 1][j + 1] != null) {
                        konturActor = new TumanMaskActor(DangeAtlasLoader.mask11);
                        konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                        this.konturGroup.addActor(konturActor);
                    }

                    if (i > 0 && j > 0 && this.maskMap[i - 1][j] == null && this.maskMap[i][j - 1] == null && this.maskMap[i - 1][j - 1] != null) {
                        konturActor = new TumanMaskActor(DangeAtlasLoader.mask13);
                        konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                        this.konturGroup.addActor(konturActor);
                    }

                    if (i < this.width - 1 && j > 0 && this.maskMap[i + 1][j] == null && this.maskMap[i][j - 1] == null && this.maskMap[i + 1][j - 1] != null) {
                        konturActor = new TumanMaskActor(DangeAtlasLoader.mask12);
                        konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                        this.konturGroup.addActor(konturActor);
                    }

                    if (i < this.width - 1 && j < this.height - 1 && this.maskMap[i + 1][j] == null && this.maskMap[i][j + 1] == null && this.maskMap[i + 1][j + 1] != null) {
                        konturActor = new TumanMaskActor(DangeAtlasLoader.mask10);
                        konturActor.setPosition((float)(i * 100), (float)(-j * 100));
                        this.konturGroup.addActor(konturActor);
                    }
                }
            }
        }

    }

    public void act(float delta) {
        super.act(delta);
        this.setZIndex(2147483646);
    }

    public void dispose() {
        System.out.println("Dispose tuman");
        this.clearActions();
        this.clearChildren();
    }
}
