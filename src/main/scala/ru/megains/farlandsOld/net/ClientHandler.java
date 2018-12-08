package ru.megains.farlandsOld.net;


import com.badlogic.gdx.Gdx;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.GameScreen;
import ru.megains.farlandsOld.base.Const;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ClientHandler extends SimpleChannelUpstreamHandler {
    public ClientHandler() {
    }

    public static boolean init() {
        try {
            ClientBootstrap bootstrap = new ClientBootstrap(new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
            bootstrap.setPipelineFactory(new ClientPipelineFactory());
            ChannelFuture future = bootstrap.connect(new InetSocketAddress("91.201.42.21", 15453));
            Const.channel = future.awaitUninterruptibly().getChannel();
            if (!future.isSuccess()) {
                future.getCause().printStackTrace();
                bootstrap.releaseExternalResources();
                return false;
            } else {
                return true;
            }
        } catch (Exception var2) {
            return false;
        }
    }

    public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println("Bound: " + e.getChannel().isBound());
    }

    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println("Connected: " + e.getChannel().isConnected());
        System.out.println("Connected: " + e.getChannel().getRemoteAddress());
    }

    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println("Closed: " + e.getChannel());
    }

    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println("Disconnected: " + e.getChannel());
    }

    public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println("Open: " + e.getChannel().isOpen());
    }

    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
        System.out.println("Error: " + e.getCause());
    }

    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse((String)e.getMessage());
        final JSONObject jsonObj = (JSONObject)obj;
        int message = ((Long)jsonObj.get("message")).intValue();
        System.out.println("incoming message! Message ID = " + message + ", value: " + jsonObj);
        switch(message) {
            case 1:
                if (((Long)jsonObj.get("status")).intValue() == 888) {
                    if (Const.mainMenu != null) {
                        Const.mainMenu.setMessageText((String)jsonObj.get("response"));
                    }

                    return;
                }

                if (((Long)jsonObj.get("status")).intValue() == 999) {
                    Gdx.app.postRunnable(new Runnable() {
                        public void run() {
                            String playerName = (String)jsonObj.get("name");
                            Const.game.getGame().getPlayer().loadPlayerAtlas(true);
                            Const.game.getGame().getPlayer().loadAnimations();
                            Const.game.setScreen(new GameScreen(((Long)((JSONObject)jsonObj.get("position")).get("location")).intValue(), ((Long)jsonObj.get("locCellType")).intValue(), (String)jsonObj.get("locName")));
                            Const.game.getGame().getPlayer().init(playerName, (Long)jsonObj.get("id"));
                            Const.game.getGame().getPlayer().initPosition((JSONObject)jsonObj.get("position"));
                            Const.game.getGame().centerCam();
                        }
                    });
                }
                break;
            case 2:
                if (((Long)jsonObj.get("status")).intValue() == 999) {
                    if (Const.mainMenu != null) {
                        Const.mainMenu.setMessageText("регистрация прошла успешно");
                    }

                    return;
                }

                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        if (Const.mainMenu != null) {
                            Const.mainMenu.setMessageText("Ошибка регистрации");
                        }

                    }
                });
                break;
            case 3:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.screen.stopMove(((Long)jsonObj.get("x")).intValue(), ((Long)jsonObj.get("y")).intValue());
                    }
                });
                break;
            case 4:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGame().playerMove(jsonObj);
                        Const.screen.removePathPoint();
                    }
                });
                break;
            case 6:
                if (Const.game.getGame().getPlayer() == null || Const.game.getGame().getPlayer().getName().length() <= 0) {
                    return;
                }

                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGame().playerChangeLoc(jsonObj);
                    }
                });
                break;
            case 7:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGame().getLevel().setLevelRectangle(jsonObj);
                    }
                });
                break;
            case 8:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGame().getPlayer().stopMove();
                    }
                });
                break;
            case 14:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGui().incSystemMessage((String)jsonObj.get("title"), (String)jsonObj.get("text"));
                    }
                });
                break;
            case 15:
                System.out.println(jsonObj);
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGame().getPlayer().getInventory().load((JSONArray)jsonObj.get("items"));
                        } catch (ParseException var3) {
                            var3.printStackTrace();
                        }

                        try {
                            Const.game.getGame().getPlayer().getEquipped().load((JSONObject)jsonObj.get("equiped"));
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                        if (Const.game.getGui().getInventoryWindow() != null) {
                            Const.game.getGui().getInventoryWindow().notifyListeners();
                        }

                        Const.game.getGame().getPlayer().initParameters((JSONObject)jsonObj.get("parameters"), (JSONObject)jsonObj.get("money"));
                    }
                });
                break;
            case 16:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGui().openSclad(((Long)jsonObj.get("id")).intValue());
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                break;
            case 17:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        if (Const.game.getGui().getScladWindow() != null) {
                            try {
                                Const.game.getGui().getScladWindow().loadCellList(jsonObj);
                            } catch (ParseException var2) {
                                var2.printStackTrace();
                            }
                        }

                    }
                });
                break;
            case 19:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGui().getScladWindow().openScladCell(jsonObj);
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                break;
            case 22:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGui().openShop(((Long)jsonObj.get("locId")).intValue());
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                break;
            case 23:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGui().getShop().loadShopInventory((JSONArray)jsonObj.get("items"));
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                break;
            case 26:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGui().getShop().getTbg().selectClass();
                    }
                });
                break;
            case 29:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGame().setVisibleEnemies((JSONArray)jsonObj.get("visiblers"));
                        } catch (ParseException var3) {
                            var3.printStackTrace();
                        }

                        try {
                            Const.game.getGui().setPlayersInLoc((JSONArray)jsonObj.get("alllist"));
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                break;
            case 30:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGame().getPlayer().initParameters((JSONObject)jsonObj.get("parameters"), (JSONObject)jsonObj.get("money"));
                    }
                });
                break;
            case 31:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGame().getPlayer().stopRest();
                    }
                });
                break;
            case 32:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGame().setWarps((JSONArray)jsonObj.get("warps"));
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                break;
            case 33:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGui().openArena(((Long)jsonObj.get("locId")).intValue());
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                break;
            case 35:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGui().arenaCancel();
                    }
                });
                break;
            case 36:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGui().startArenaTimer();
                    }
                });
                break;
            case 37:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGui().startBattle(((Long)jsonObj.get("battleid")).intValue(), ((Long)jsonObj.get("round")).intValue(), (JSONObject)jsonObj.get("enemyparameters"), (JSONObject)jsonObj.get("enemyequiped"), (String)jsonObj.get("enemyname"));
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                break;
            case 38:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGui().getBattle().finishRound(((Long)jsonObj.get("round")).intValue(), (String)jsonObj.get("playerstr"), (String)jsonObj.get("enemystr"), (JSONObject)jsonObj.get("enemyparameters"), (JSONObject)jsonObj.get("enemyequiped"));
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                break;
            case 39:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGui().stopBattle();
                    }
                });
                break;
            case 40:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        if ((Long)jsonObj.get("playerid") == Const.game.getGame().getPlayer().getId()) {
                            Const.game.getGui().getInventoryWindow().loadProfileAndSkills(jsonObj);
                        } else {
                            try {
                                Const.game.getGui().openEnemyInfoWindow(jsonObj);
                            } catch (ParseException var2) {
                                var2.printStackTrace();
                            }
                        }

                    }
                });
                break;
            case 200:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        Const.game.getGui().getChartTable().addMessage(jsonObj);
                    }
                });
                break;
            case 201:
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            Const.game.getGui().getChartTable().addMessageArray((JSONArray)jsonObj.get("messages"));
                        } catch (ParseException var2) {
                            var2.printStackTrace();
                        }

                    }
                });
        }

    }
}

