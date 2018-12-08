package ru.megains.farlandsOld.base;


public abstract class ExpTable {
    public static final float[] expTable = new float[]{0.0F, 1.0F, 250.0F, 500.0F, 1000.0F, 2250.0F, 3750.0F, 5250.0F, 7500.0F, 10500.0F, 20000.0F, 25000.0F, 34000.0F, 44000.0F, 60000.0F, 80000.0F, 100000.0F, 130000.0F, 170000.0F, 220000.0F, 362500.0F, 500000.0F, 625000.0F, 800000.0F, 1050000.0F, 1375000.0F, 1750000.0F, 2250000.0F, 3000000.0F, 5000000.0F, 1.0E7F, 2.0E7F, 5.0E7F, 6.0E7F, 6.8E7F, 7.5E7F, 8.2E7F, 9.2E7F, 1.0E8F, 1.1E8F, 1.11000003E10F, 2.0E10F, 3.8999998E10F, 7.1999996E10F, 1.33000004E11F, 2.49999999E11F};

    public ExpTable() {
    }

    public static int getCurrentLevel(float exp) {
        if (exp >= expTable[1] && exp < expTable[2]) {
            return 1;
        } else if (exp >= expTable[2] && exp < expTable[3]) {
            return 2;
        } else if (exp >= expTable[3] && exp < expTable[4]) {
            return 3;
        } else if (exp >= expTable[4] && exp < expTable[5]) {
            return 4;
        } else if (exp >= expTable[5] && exp < expTable[6]) {
            return 5;
        } else if (exp >= expTable[6] && exp < expTable[7]) {
            return 6;
        } else if (exp >= expTable[7] && exp < expTable[8]) {
            return 7;
        } else if (exp >= expTable[8] && exp < expTable[9]) {
            return 8;
        } else if (exp >= expTable[9] && exp < expTable[10]) {
            return 9;
        } else if (exp >= expTable[10] && exp < expTable[11]) {
            return 10;
        } else if (exp >= expTable[11] && exp < expTable[12]) {
            return 11;
        } else if (exp >= expTable[12] && exp < expTable[13]) {
            return 12;
        } else if (exp >= expTable[13] && exp < expTable[14]) {
            return 13;
        } else if (exp >= expTable[14] && exp < expTable[15]) {
            return 14;
        } else if (exp >= expTable[15] && exp < expTable[16]) {
            return 15;
        } else if (exp >= expTable[16] && exp < expTable[17]) {
            return 16;
        } else if (exp >= expTable[17] && exp < expTable[18]) {
            return 17;
        } else if (exp >= expTable[18] && exp < expTable[19]) {
            return 18;
        } else if (exp >= expTable[19] && exp < expTable[20]) {
            return 19;
        } else if (exp >= expTable[20] && exp < expTable[21]) {
            return 20;
        } else if (exp >= expTable[21] && exp < expTable[22]) {
            return 21;
        } else if (exp >= expTable[22] && exp < expTable[23]) {
            return 22;
        } else if (exp >= expTable[23] && exp < expTable[24]) {
            return 23;
        } else if (exp >= expTable[24] && exp < expTable[25]) {
            return 24;
        } else if (exp >= expTable[25] && exp < expTable[26]) {
            return 25;
        } else if (exp >= expTable[26] && exp < expTable[27]) {
            return 26;
        } else if (exp >= expTable[27] && exp < expTable[28]) {
            return 27;
        } else if (exp >= expTable[28] && exp < expTable[29]) {
            return 28;
        } else {
            return exp >= expTable[29] && exp < expTable[30] ? 29 : 0;
        }
    }

    public static int getCurentLevel(float exp) {
        if (exp >= expTable[1] && exp < expTable[2]) {
            return 1;
        } else if (exp >= expTable[2] && exp < expTable[3]) {
            return 2;
        } else if (exp >= expTable[3] && exp < expTable[4]) {
            return 3;
        } else if (exp >= expTable[4] && exp < expTable[5]) {
            return 4;
        } else if (exp >= expTable[5] && exp < expTable[6]) {
            return 5;
        } else if (exp >= expTable[6] && exp < expTable[7]) {
            return 6;
        } else if (exp >= expTable[7] && exp < expTable[8]) {
            return 7;
        } else if (exp >= expTable[8] && exp < expTable[9]) {
            return 8;
        } else if (exp >= expTable[9] && exp < expTable[10]) {
            return 9;
        } else if (exp >= expTable[10] && exp < expTable[11]) {
            return 10;
        } else if (exp >= expTable[11] && exp < expTable[12]) {
            return 11;
        } else if (exp >= expTable[12] && exp < expTable[13]) {
            return 12;
        } else if (exp >= expTable[13] && exp < expTable[14]) {
            return 13;
        } else if (exp >= expTable[14] && exp < expTable[15]) {
            return 14;
        } else if (exp >= expTable[15] && exp < expTable[16]) {
            return 15;
        } else if (exp >= expTable[16] && exp < expTable[17]) {
            return 16;
        } else if (exp >= expTable[17] && exp < expTable[18]) {
            return 17;
        } else if (exp >= expTable[18] && exp < expTable[19]) {
            return 18;
        } else if (exp >= expTable[19] && exp < expTable[20]) {
            return 19;
        } else if (exp >= expTable[20] && exp < expTable[21]) {
            return 20;
        } else if (exp >= expTable[21] && exp < expTable[22]) {
            return 21;
        } else if (exp >= expTable[22] && exp < expTable[23]) {
            return 22;
        } else if (exp >= expTable[23] && exp < expTable[24]) {
            return 23;
        } else if (exp >= expTable[24] && exp < expTable[25]) {
            return 24;
        } else if (exp >= expTable[25] && exp < expTable[26]) {
            return 25;
        } else if (exp >= expTable[26] && exp < expTable[27]) {
            return 26;
        } else if (exp >= expTable[27] && exp < expTable[28]) {
            return 27;
        } else if (exp >= expTable[28] && exp < expTable[29]) {
            return 28;
        } else {
            return exp >= expTable[29] && exp < expTable[30] ? 29 : 0;
        }
    }

    public static float getLevelExp(int level) {
        return level == 1 ? 0.0F : expTable[level];
    }

    public static int getClassbyLevel(int level) {
        return level / 5 + 1;
    }
}

