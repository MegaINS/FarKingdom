package ru.megains.farlandsOld.net;


import org.json.simple.JSONObject;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gui.guibottom.ChartMessageDAO;

public abstract class SendPasket {
    public SendPasket() {
    }

    public static void sendLogin(String login, String pass) {
        if (!ClientHandler.init()) {
            Const.mainMenu.setMessageText("Отсутствует соединение с сервером");
        } else {
            JSONObject pasket = new JSONObject();
            pasket.put("message", 1);
            pasket.put("version", "0.11");
            pasket.put("nickname", login);
            pasket.put("password", pass);
            Const.channel.write(pasket + "\u0000");
        }
    }

    public static void sendRegister(String login, String pass) {
        if (!ClientHandler.init()) {
            Const.mainMenu.setMessageText("Отсутствует соединение с сервером");
        } else {
            JSONObject pasket = new JSONObject();
            pasket.put("message", 2);
            pasket.put("version", "0.11");
            pasket.put("nickname", login);
            pasket.put("password", pass);
            Const.channel.write(pasket + "\u0000");
        }
    }

    public static void playerMove(int x, int y, int locId) {
        System.out.println("move");
        JSONObject pasket = new JSONObject();
        pasket.put("message", 4);
        pasket.put("x", x);
        pasket.put("y", y);
        pasket.put("locId", locId);
        Const.channel.write(pasket + "\u0000");
    }

    public static void sendChartMessage(ChartMessageDAO dao) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 200);
        pasket.put("sender", dao.getSender());
        pasket.put("responser", dao.getResponser());
        pasket.put("senderId", dao.getSenderId());
        pasket.put("responserId", dao.getResponserId());
        pasket.put("text", dao.getText());
        pasket.put("isPrivate", dao.isPrivate());
        pasket.put("isAdresed", dao.isAdresed());
        Const.channel.write(pasket + "\u0000");
    }

    public static void changeLoc(int warpPointId) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 6);
        pasket.put("warppointid", warpPointId);
        Const.channel.write(pasket + "\u0000");
    }

    public static void getLocRectangle() {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 7);
        Const.channel.write(pasket + "\u0000");
    }

    public static void extractGameCell(int cellX, int cellY) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 8);
        pasket.put("x", cellX);
        pasket.put("y", cellY);
        Const.channel.write(pasket + "\u0000");
    }

    public static void equipItem(long mid) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 10);
        pasket.put("mId", mid);
        Const.channel.write(pasket + "\u0000");
    }

    public static void takeOffItem(int slotId) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 13);
        pasket.put("slotid", slotId);
        Const.channel.write(pasket + "\u0000");
    }

    public static void buyScladCell(int wear, int skladId) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 18);
        pasket.put("wear", wear);
        pasket.put("skladid", skladId);
        Const.channel.write(pasket + "\u0000");
    }

    public static void openScladCell(long cellId, int skladId) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 19);
        pasket.put("skladid", skladId);
        pasket.put("cellid", cellId);
        Const.channel.write(pasket + "\u0000");
    }

    public static void putItemToSclad(long itemId, int skladId, long cellId, int count) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 20);
        pasket.put("skladid", skladId);
        pasket.put("itemid", itemId);
        pasket.put("cellid", cellId);
        pasket.put("count", count);
        Const.channel.write(pasket + "\u0000");
    }

    public static void takeItemFromSclad(long itemId, int skladId, long cellId, int count) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 21);
        pasket.put("skladid", skladId);
        pasket.put("itemid", itemId);
        pasket.put("cellid", cellId);
        pasket.put("count", count);
        Const.channel.write(pasket + "\u0000");
    }

    public static void loadShopInventory(int locId, int itemClass, String tag, String subTag) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 23);
        pasket.put("locId", locId);
        pasket.put("itemClass", itemClass);
        pasket.put("tag", tag);
        pasket.put("subTag", subTag);
        Const.channel.write(pasket + "\u0000");
    }

    public static void buyItemInShop(int locId, long itemTemplateId, int count) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 24);
        pasket.put("locId", locId);
        pasket.put("itemTemplateId", itemTemplateId);
        pasket.put("count", count);
        Const.channel.write(pasket + "\u0000");
    }

    public static void sellItemToShop(int locId, long itemId, int count) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 25);
        pasket.put("locId", locId);
        pasket.put("itemId", itemId);
        pasket.put("count", count);
        Const.channel.write(pasket + "\u0000");
    }

    public static void updateStats() {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 12);
        Const.channel.write(pasket + "\u0000");
    }

    public static void getInventory() {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 15);
        Const.channel.write(pasket + "\u0000");
    }

    public static void useItem(long itemId) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 27);
        pasket.put("itemId", itemId);
        Const.channel.write(pasket + "\u0000");
    }

    public static void dropItem(long itemId, int count) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 9);
        pasket.put("itemId", itemId);
        pasket.put("count", count);
        Const.channel.write(pasket + "\u0000");
    }

    public static void applyStats(int strenght, int stamina, int conc, int intellect) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 28);
        pasket.put("strenght", strenght);
        pasket.put("stamina", stamina);
        pasket.put("conc", conc);
        pasket.put("intellect", intellect);
        Const.channel.write(pasket + "\u0000");
    }

    public static void rest() {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 31);
        Const.channel.write(pasket + "\u0000");
    }

    public static void arenaRequestBattle(int locId) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 34);
        pasket.put("locid", locId);
        Const.channel.write(pasket + "\u0000");
    }

    public static void arenaCancel(int arenaId) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 35);
        pasket.put("arenaId", arenaId);
        Const.channel.write(pasket + "\u0000");
    }

    public static void finishRound(int attackId, int battleId) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 38);
        pasket.put("attackid", attackId);
        pasket.put("battleid", battleId);
        Const.channel.write(pasket + "\u0000");
    }

    public static void getProfile(long playerId, boolean isMy) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 40);
        pasket.put("playerId", playerId);
        pasket.put("isMy", isMy);
        Const.channel.write(pasket + "\u0000");
    }

    public static void attackEnemy(long enemyId) {
        JSONObject pasket = new JSONObject();
        pasket.put("message", 41);
        pasket.put("enemyId", enemyId);
        Const.channel.write(pasket + "\u0000");
    }
}

