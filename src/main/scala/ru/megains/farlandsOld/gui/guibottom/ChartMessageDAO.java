package ru.megains.farlandsOld.gui.guibottom;


import ru.megains.farlandsOld.base.Const;

public class ChartMessageDAO {
    private static final String LOG_MESSAGE = "logmessagesender";
    private static final String SYSTEM_MESSAGE = "systemmessagesender";
    private String sender = "";
    private String responser = "";
    private long senderId = -1L;
    private long responserId = -1L;
    private String text = "";
    private String date;
    private boolean isPrivate = false;
    private boolean isAdresed = false;

    public ChartMessageDAO(String line) {
        if (line.substring(0, 1).equals("#")) {
            StringBuilder builder = new StringBuilder(line);
            int start;
            int end;
            if (builder.substring(0, 16).equals("#Приватно для >>")) {
                this.isPrivate = true;
                this.isAdresed = false;
                start = builder.indexOf(">") + 2;
                end = builder.indexOf(":");
                if (start <= 0 || end <= 0) {
                    return;
                }

                this.responser = builder.substring(start, end).trim();
                this.text = builder.substring(end + 1).trim();
            } else if (builder.substring(0, 19).equals("#Адресно для для >>")) {
                this.isAdresed = true;
                this.isPrivate = false;
                start = builder.indexOf(">") + 2;
                end = builder.indexOf(":");
                if (start <= 0 || end <= 0) {
                    return;
                }

                this.responser = builder.substring(start, end).trim();
                this.text = builder.substring(end + 1).trim();
            }
        } else {
            this.text = line;
        }

        this.sender = Const.game.getGame().getPlayer().getName();
        this.senderId = Const.game.getGame().getPlayer().getId();
    }

    public ChartMessageDAO(String sender, long senderId, String responser, long responserId, String text, String date, boolean isAdresed, boolean isPrivate) {
        this.sender = sender;
        this.senderId = senderId;
        this.responser = responser;
        this.responserId = responserId;
        this.text = text;
        this.date = date;
        this.isPrivate = isPrivate;
        this.isAdresed = isAdresed;
    }

    public String getSender() {
        return this.sender;
    }

    public String getResponser() {
        return this.responser;
    }

    public long getSenderId() {
        return this.senderId;
    }

    public long getResponserId() {
        return this.responserId;
    }

    public String getText() {
        return this.text;
    }

    public String getDate() {
        return this.date;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isAdresed() {
        return this.isAdresed;
    }

    public boolean isLogMessage() {
        return this.sender.equals("logmessagesender");
    }

    public boolean isSystemMessage() {
        return this.sender.equals("systemmessagesender");
    }
}

