package ru.megains.farlandsOld.gui.guibottom.playersList;

import com.badlogic.gdx.scenes.scene2d.ui.Tree;

public class PlayerNode extends Tree.Node {
    private long id;
    private String name;
    private int level;
    private int x;
    private int y;

    public PlayerNode(long id, String name, int level, int x, int y, boolean isClan) {
        super(new PlayerNodeTable(id, name, level, isClan));
        this.id = id;
        this.name = name;
        this.level = level;
        this.x = x;
        this.y = y;
    }

    public void setNeighbor() {
        ((PlayerNodeTable)this.getActor()).setNeighbor();
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
