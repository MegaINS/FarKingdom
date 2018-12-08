package ru.megains.farlandsOld.gui.guibottom.playersList;


import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.player.Player;

import java.util.ArrayList;

public class PlayersTable extends Table {
    private Tree tree;
    Label notFarLabel;
    Tree.Node notFarNode;

    public PlayersTable() {
        this.left();
        this.top();
        this.padLeft(4.0F);
        this.tree = new Tree(Styles.guiSkin);
        this.notFarLabel = new Label("", Styles.labelBlack);
        this.notFarNode = new Tree.Node(this.notFarLabel);
    }

    public void draw(ArrayList<PlayerNode> playerNodes) {
        this.notFarNode.removeAll();
        this.tree.clearChildren();
        this.clear();
        PlayerNode playerNode = new PlayerNode(Const.game.getGame().getPlayer().getId(), Const.game.getGame().getPlayer().getName(), Const.game.getGame().getPlayer().getParameters().getLevel(), Const.game.getGame().getPlayer().getPlayerX(), Const.game.getGame().getPlayer().getPlayerY(), false);
        this.notFarLabel.setText("Недалеко (" + playerNodes.size() + ")");

        for(int i = 0; i < playerNodes.size(); ++i) {
            this.notFarNode.add((Tree.Node)playerNodes.get(i));
        }

        this.tree.add(this.notFarNode);
        this.tree.add(playerNode);
        this.add(this.tree).left();
        this.setNeighbors();
    }

    public void setNeighbors() {
        for(int i = 0; i < this.notFarNode.getChildren().size; ++i) {
            PlayerNode enemy = (PlayerNode)this.notFarNode.getChildren().get(i);
            Player player = Const.game.getGame().getPlayer();
            if (player.getPlayerX() == enemy.getX() && player.getPlayerY() == enemy.getY()) {
                this.notFarNode.remove(enemy);
                this.tree.add(enemy);
                enemy.setNeighbor();
                this.notFarLabel.setText("Недалеко (" + this.notFarNode.getChildren().size + ")");
            }
        }

    }
}
