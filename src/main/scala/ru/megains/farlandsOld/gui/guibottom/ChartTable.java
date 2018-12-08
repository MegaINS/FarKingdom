package ru.megains.farlandsOld.gui.guibottom;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.GifDecoder;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Fonts;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyAnimatedActor;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartTable extends Table {
    private ChartScrollPane pane;
    private List<ChartMessageDAO> messages = new ArrayList();
    private Map<String, Smile> smiles = new HashMap();
    private TextField inputMessage;
    private boolean logFilter;
    private Label.LabelStyle simpleStyle;
    private Label.LabelStyle boldStyle;
    private Label.LabelStyle boldPvt;
    private Label.LabelStyle boldAdresed;
    private Label.LabelStyle logMsgStyle;
    private Label.LabelStyle systemMsgStyle;

    public ChartTable(TextField inputMessage) {
        this.padLeft(10.0F);
        this.left();
        this.loadSmiles(inputMessage);
        this.logFilter = false;
        this.inputMessage = inputMessage;
        this.simpleStyle = new Label.LabelStyle();
        this.simpleStyle.fontColor = Color.BLACK;
        this.simpleStyle.font = Styles.chatFont;
        this.boldPvt = new Label.LabelStyle();
        this.boldPvt.fontColor = Color.BLACK;
        this.boldPvt.font = Styles.chatFontBolb;
        this.boldPvt.background = new SpriteDrawable(GuiAtlasLoader.bg_pvt);
        this.boldAdresed = new Label.LabelStyle();
        this.boldAdresed.fontColor = Color.BLACK;
        this.boldAdresed.font = Styles.chatFontBolb;
        this.boldAdresed.background = new SpriteDrawable(GuiAtlasLoader.bg_addresed);
        this.boldStyle = new Label.LabelStyle();
        this.boldStyle.fontColor = Color.BLACK;
        this.boldStyle.font = Styles.chatFontBolb;
        this.logMsgStyle = new Label.LabelStyle();
        this.logMsgStyle.fontColor = new Color(16843263);
        this.logMsgStyle.font = Fonts.CHAT_LOG_MESSAGE.get();
        this.systemMsgStyle = new Label.LabelStyle();
        this.systemMsgStyle.fontColor = new Color(269488383);
        this.systemMsgStyle.font = Styles.chatFontItalic;
        this.systemMsgStyle.background = new SpriteDrawable(GuiAtlasLoader.bg_system);
    }

    public void addMessage(JSONObject packet) {
        this.messages.add(new ChartMessageDAO((String)packet.get("sender"), (Long)packet.get("senderId"), (String)packet.get("responser"), (Long)packet.get("responserId"), (String)packet.get("text"), (String)packet.get("date"), (Boolean)packet.get("isAdresed"), (Boolean)packet.get("isPrivate")));
        this.drawMessages();
    }

    public void drawMessages() {
        this.clear();

        for(int i = 0; i < this.messages.size(); ++i) {
            if (((ChartMessageDAO)this.messages.get(i)).isPrivate()) {
                this.addPrivateMessage((ChartMessageDAO)this.messages.get(i));
            } else if (((ChartMessageDAO)this.messages.get(i)).isAdresed()) {
                this.addAdresedMessage((ChartMessageDAO)this.messages.get(i));
            } else if (((ChartMessageDAO)this.messages.get(i)).isLogMessage()) {
                this.addLogMessage((ChartMessageDAO)this.messages.get(i));
            } else if (((ChartMessageDAO)this.messages.get(i)).isSystemMessage()) {
                this.addSystemMessage((ChartMessageDAO)this.messages.get(i));
            } else {
                this.addSimpleMessage((ChartMessageDAO)this.messages.get(i));
            }
        }

        this.addBlankMessage();
        this.pane.update();
    }

    private void addSimpleMessage(ChartMessageDAO msg) {
        float w = 30.0F;
        if (!msg.getSender().equals(Const.game.getGame().getPlayer().getName())) {
            w += 56.0F;
        }

        Table leftTable = this.getLeftTable(msg).left();
        Table msgTable = (new Table()).left();
        Label date = new Label(msg.getDate() + " ", this.simpleStyle);
        msgTable.add(date).left();
        w += date.getWidth();
        Label senser = new Label(msg.getSender() + " : ", this.boldStyle);
        msgTable.add(senser).left();
        w += senser.getWidth();
        leftTable.add(msgTable);
        ArrayList<Table> msgTables = this.createSmileTable(msg.getText(), (float)((int)((float) Gdx.graphics.getWidth() * Const.game.getGui().getSplitPane().getSplitAmount()) - 60), w);
        if (msgTables.size() > 0) {
            leftTable.add((Actor)msgTables.get(0));
            msgTables.set(0, leftTable);
        }

        for(int i = 0; i < msgTables.size(); ++i) {
            this.add((Actor)msgTables.get(i)).left().padBottom(5.0F);
            this.row().left().padBottom(5.0F);
        }

    }

    private void addAdresedMessage(ChartMessageDAO msg) {
        float w = 30.0F;
        if (!msg.getSender().equals(Const.game.getGame().getPlayer().getName())) {
            w += 56.0F;
        }

        Table leftTable = this.getLeftTable(msg).left();
        Table dateTable = (new Table()).left();
        Label date = new Label(msg.getDate() + " ", this.simpleStyle);
        dateTable.add(date).left();
        w += date.getWidth();
        Table msgTable = (new Table()).left();
        Label senser;
        Label responser;
        if (msg.getSenderId() != Const.game.getGame().getPlayer().getId() && msg.getResponserId() != Const.game.getGame().getPlayer().getId()) {
            senser = new Label(msg.getSender(), this.boldStyle);
            msgTable.add(senser).left();
            w += senser.getWidth();
            responser = new Label(" к " + msg.getResponser() + " : ", this.boldStyle);
            w += responser.getWidth();
            msgTable.add(responser).left();
        } else {
            senser = new Label(msg.getSender(), this.boldAdresed);
            msgTable.add(senser).left();
            w += senser.getWidth();
            responser = new Label(" к " + msg.getResponser() + " : ", this.boldAdresed);
            w += responser.getWidth();
            msgTable.add(responser).left();
        }

        leftTable.add(dateTable).left();
        leftTable.add(msgTable).left();
        ArrayList<Table> msgTables = this.createSmileTable(msg.getText(), (float)((int)((float) Gdx.graphics.getWidth() * Const.game.getGui().getSplitPane().getSplitAmount()) - 60), w);
        if (msgTables.size() > 0) {
            leftTable.add((Actor)msgTables.get(0)).left();
            msgTables.set(0, leftTable);
        }

        for(int i = 0; i < msgTables.size(); ++i) {
            this.add((Actor)msgTables.get(i)).left().padBottom(5.0F);
            this.row().left().padBottom(5.0F);
        }

    }

    private void addPrivateMessage(ChartMessageDAO msg) {
        float w = 30.0F;
        if (!msg.getSender().equals(Const.game.getGame().getPlayer().getName())) {
            w += 56.0F;
        }

        Table leftTable = this.getLeftTable(msg).left();
        Table dateTable = (new Table()).left();
        Label date = new Label(msg.getDate() + " ", this.simpleStyle);
        dateTable.add(date).left();
        w += date.getWidth();
        Table msgTable = (new Table()).left();
        Label senser = new Label(msg.getSender(), this.boldPvt);
        msgTable.add(senser).left();
        w += senser.getWidth();
        Label responser;
        if (msg.getSenderId() == Const.game.getGame().getPlayer().getId()) {
            responser = new Label(" к " + msg.getResponser() + " : ", this.boldPvt);
            w += responser.getWidth();
            msgTable.add(responser).left();
        } else {
            responser = new Label(" к " + msg.getResponser() + " : ", this.boldPvt);
            w += responser.getWidth();
            msgTable.add(responser).left();
        }

        leftTable.add(dateTable).left();
        leftTable.add(msgTable).left();
        ArrayList<Table> msgTables = this.createSmileTable(msg.getText(), (float)((int)((float) Gdx.graphics.getWidth() * Const.game.getGui().getSplitPane().getSplitAmount()) - 60), w);
        if (msgTables.size() > 0) {
            leftTable.add((Actor)msgTables.get(0)).left();
            msgTables.set(0, leftTable);
        }

        for(int i = 0; i < msgTables.size(); ++i) {
            this.add((Actor)msgTables.get(i)).left().padBottom(5.0F);
            this.row().left().padBottom(5.0F);
        }

    }

    private void addLogMessage(ChartMessageDAO msg) {
        if (!this.logFilter) {
            Table msgTable = (new Table()).left();
            msgTable.add(new Label(msg.getDate() + " ", this.logMsgStyle)).left();
            msgTable.add(new Label(msg.getText(), this.logMsgStyle)).left();
            this.add(msgTable).left();
            this.row().left();
        }
    }

    private void addSystemMessage(ChartMessageDAO msg) {
        Table msgTable = (new Table()).left();
        msgTable.add(new Label(msg.getDate() + " ", this.logMsgStyle)).left();
        msgTable.add(new Label("[" + msg.getText() + "]", this.systemMsgStyle)).left();
        this.add(msgTable).left();
        this.row().left();
    }

    private void addBlankMessage() {
        Label blank = new Label("", Styles.labelYellow);
        Table msgTable = (new Table()).left();
        msgTable.add(blank);
        this.add(msgTable);
        this.row().left();
    }

    private ArrayList<Table> createSmileTable(String text, float tableWidth, float startWidth) {
        ArrayList<Table> tables = new ArrayList();
        Table table = (new Table()).left();
        tables.add(table);
        StringBuilder builder = new StringBuilder(text);
        int start = builder.indexOf(":");
        int end = builder.indexOf(":", start + 1);
        int lastTextPosition = 0;

        float width;
        Label label;
        float lastWidth;
        for(width = startWidth; end > 0 && start >= 0 && start < builder.length(); end = builder.indexOf(":", start + 1)) {
            String smile = builder.substring(start + 1, end);
            MyAnimatedActor replacement;
            if ((replacement = (MyAnimatedActor)this.smiles.get(smile)) != null) {
                label = new Label(builder.substring(lastTextPosition, start), this.simpleStyle);
                lastWidth = width;
                width += label.getWidth();
                if (width >= tableWidth) {
                    while(width >= tableWidth) {
                        label = this.splitLongLabel(table, label, tableWidth - lastWidth);
                        table = new Table();
                        tables.add(table);
                        width = label.getWidth();
                        lastWidth = 0.0F;
                    }
                }

                table.add(label);
                width += replacement.getWidth();
                if (replacement == this.smiles.get("beer")) {
                    width += 6.0F;
                }

                if (width >= tableWidth) {
                    table = new Table();
                    tables.add(table);
                    width = 10.0F;
                }

                table.add(replacement.instance());
                lastTextPosition = end + 1;
                start = builder.indexOf(":", end + 1);
            } else {
                start = end;
            }
        }

        label = new Label(builder.substring(lastTextPosition), this.simpleStyle);
        lastWidth = width;
        width += label.getWidth();
        if (width >= tableWidth) {
            while(width >= tableWidth) {
                label = this.splitLongLabel(table, label, tableWidth - lastWidth);
                table = new Table();
                tables.add(table);
                width = label.getWidth();
                lastWidth = 0.0F;
            }
        }

        table.add(label);
        return tables;
    }

    private Label splitLongLabel(Table table, Label oldLabel, float prefWidth) {
        StringBuilder newText = new StringBuilder("");
        Label newLabel = new Label("", this.simpleStyle);

        for(float newWidth = 0.0F; prefWidth > newWidth; newWidth = newLabel.getWidth()) {
            StringBuilder oldText = new StringBuilder(oldLabel.getText());
            if (oldText.length() <= 0) {
                break;
            }

            newText.insert(newText.length(), oldText.substring(0, 1));
            oldText.delete(0, 1);
            newLabel = new Label(newText, this.simpleStyle);
            oldLabel = new Label(oldText, this.simpleStyle);
        }

        table.add(newLabel);
        System.out.println("prefWidth " + prefWidth);
        System.out.println("newWidth " + newLabel.getWidth());
        System.out.println("oldLabelWidth " + oldLabel.getWidth());
        return oldLabel;
    }

    private Table getLeftTable(ChartMessageDAO msg) {
        Table lineTable = (new Table()).left();
        if (msg.getSender().equals(Const.game.getGame().getPlayer().getName())) {
            lineTable.add(new BtnPlayerInfo(msg.getSenderId())).left();
            lineTable.add(new Label(" ", this.simpleStyle)).left();
        } else {
            lineTable.add(new BtnPlayerInfo(msg.getSenderId())).left();
            lineTable.add(new Label(" ", this.simpleStyle)).left();
            lineTable.add(new BtnAddressed(new SpriteDrawable(GuiAtlasLoader.btnaddresed), msg.getSender(), this.inputMessage)).left();
            lineTable.add(new Label(" ", this.simpleStyle)).left();
            lineTable.add(new BtnPrivate(new SpriteDrawable(GuiAtlasLoader.btnprivate), msg.getSender(), this.inputMessage)).left();
            lineTable.add(new Label(" ", this.simpleStyle)).left();
        }

        return lineTable;
    }

    public void addMessageArray(JSONArray messages) throws ParseException {
        JSONParser parser = new JSONParser();

        for(int i = 0; i < messages.size(); ++i) {
            Object obj = parser.parse(messages.get(i).toString());
            JSONObject jsonObj = (JSONObject)obj;
            this.addMessage(jsonObj);
        }

    }

    private void loadSmiles(TextField inputMessage) {
        this.smiles.put("aggressive", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/aggressive.gif").read()), "aggressive", inputMessage));
        this.smiles.put("angry", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/angry.gif").read()), "angry", inputMessage));
        this.smiles.put("bb", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/bb.gif").read()), "bb", inputMessage));
        this.smiles.put("beee", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/beee.gif").read()), "beee", inputMessage));
        this.smiles.put("beer", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/beer.gif").read()), "beer", inputMessage));
        this.smiles.put("big_boss", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/big_boss.gif").read()), "big_boss", inputMessage));
        this.smiles.put("blum", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/blum.gif").read()), "blum", inputMessage));
        this.smiles.put("blush", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/blush.gif").read()), "blush", inputMessage));
        this.smiles.put("boredom", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/boredom.gif").read()), "boredom", inputMessage));
        this.smiles.put("cray", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/cray.gif").read()), "cray", inputMessage));
        this.smiles.put("crazy", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/crazy.gif").read()), "crazy", inputMessage));
        this.smiles.put("dance", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/dance.gif").read()), "dance", inputMessage));
        this.smiles.put("dance2", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/dance2.gif").read()), "dance2", inputMessage));
        this.smiles.put("dntknw", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/dntknw.gif").read()), "dntknw", inputMessage));
        this.smiles.put("download", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/download.gif").read()), "download", inputMessage));
        this.smiles.put("dwarf", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/dwarf.gif").read()), "dwarf", inputMessage));
        this.smiles.put("flirt", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/flirt.gif").read()), "flirt", inputMessage));
        this.smiles.put("girl_cray", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/girl_cray.gif").read()), "girl_cray", inputMessage));
        this.smiles.put("girl_devil", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/girl_devil.gif").read()), "girl_devil", inputMessage));
        this.smiles.put("girl_in_love", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/girl_in_love.gif").read()), "girl_in_love", inputMessage));
        this.smiles.put("give_heart", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/give_heart.gif").read()), "give_heart", inputMessage));
        this.smiles.put("give_rose", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/give_rose.gif").read()), "give_rose", inputMessage));
        this.smiles.put("good", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/good.gif").read()), "good", inputMessage));
        this.smiles.put("grin", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/grin.gif").read()), "grin", inputMessage));
        this.smiles.put("hag", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/hag.gif").read()), "hag", inputMessage));
        this.smiles.put("help", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/help.gif").read()), "help", inputMessage));
        this.smiles.put("hunter", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/hunter.gif").read()), "hunter", inputMessage));
        this.smiles.put("hysteric", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/hysteric.gif").read()), "hysteric", inputMessage));
        this.smiles.put("ireful", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/ireful.gif").read()), "ireful", inputMessage));
        this.smiles.put("joke", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/joke.gif").read()), "joke", inputMessage));
        this.smiles.put("kiss", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/kiss.gif").read()), "kiss", inputMessage));
        this.smiles.put("man_in_love", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/man_in_love.gif").read()), "man_in_love", inputMessage));
        this.smiles.put("pardon", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/pardon.gif").read()), "pardon", inputMessage));
        this.smiles.put("popcorm", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/popcorm.gif").read()), "popcorm", inputMessage));
        this.smiles.put("rofl", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/rofl.gif").read()), "rofl", inputMessage));
        this.smiles.put("rtfm", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/rtfm.gif").read()), "rtfm", inputMessage));
        this.smiles.put("sad", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/sad.gif").read()), "sad", inputMessage));
        this.smiles.put("scenic", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/scenic.gif").read()), "scenic", inputMessage));
        this.smiles.put("shock", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/shock.gif").read()), "shock", inputMessage));
        this.smiles.put("shok", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/shok.gif").read()), "shok", inputMessage));
        this.smiles.put("sick", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/sick.gif").read()), "sick", inputMessage));
        this.smiles.put("skull", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/skull.gif").read()), "skull", inputMessage));
        this.smiles.put("sleep", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/sleep.gif").read()), "sleep", inputMessage));
        this.smiles.put("slow_en", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/slow_en.gif").read()), "slow_en", inputMessage));
        this.smiles.put("smile", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/smile.gif").read()), "smile", inputMessage));
        this.smiles.put("smilez", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/smilez.gif").read()), "smilez", inputMessage));
        this.smiles.put("spiteful", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/spiteful.gif").read()), "spiteful", inputMessage));
        this.smiles.put("umnik", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/umnik.gif").read()), "umnik", inputMessage));
        this.smiles.put("vinsent", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/vinsent.gif").read()), "vinsent", inputMessage));
        this.smiles.put("wink", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/wink.gif").read()), "wink", inputMessage));
        this.smiles.put("yes", new Smile(GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("smiles/yes.gif").read()), "yes", inputMessage));
    }

    public void setPane(ChartScrollPane pane) {
        this.pane = pane;
    }

    public Map<String, Smile> getSmiles() {
        return this.smiles;
    }

    public void clearMessages() {
        this.messages.clear();
        this.clear();
    }

    public void checkLogFilter(boolean filter) {
        this.logFilter = filter;
        this.drawMessages();
    }
}

