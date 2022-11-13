import java.util.*;
import java.io.*;

public class aes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Plain text to be sent");
        String pt = sc.nextLine();
        String p[][] = new String[4][4];
        int k = 0;
        System.out.println("Plain text matrix");
        for (int i = 0; i < 4; i++) {
            // System.out.println(i);
            for (int j = 0; j < 4; j++) {
                // System.out.println(j);
                int t = pt.charAt(k);
                String te = Integer.toHexString(t);
                p[j][i] = te;
                k++;
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(p[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println("Enter the key");
        String s[][] = new String[4][4];
        String key = sc.nextLine();
        k = 0;
        System.out.println("Key matrix");
        for (int i = 0; i < 4; i++) {
            // System.out.println(i);
            for (int j = 0; j < 4; j++) {
                // System.out.println(j);
                int t = key.charAt(k);
                String te = Integer.toHexString(t);
                s[j][i] = te;
                k++;
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(s[i][j] + " ");
            }
        }
        // exor key and pt
        System.out.println();
        System.out.println("New State matrix");
        String s1[][] = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int ss = Integer.parseInt(s[i][j], 16);
                int ps = Integer.parseInt(p[i][j], 16);
                int xor = ss ^ ps;

                s1[i][j] = Integer.toHexString(xor);
                // System.out.print(s1[i][j]+" ");
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(s1[i][j] + " ");
            }
        }
        String sbox[][] = {
                { "63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67", "2B", "FE", "D7", "AB", "76" },
                { "CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2", "AF", "9C", "A4", "72", "C0" },
                { "B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5", "F1", "71", "D8", "31", "15" },
                { "04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80", "E2", "EB", "27", "B2", "75" },
                { "09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6", "B3", "29", "E3", "2F", "84" },
                { "53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE", "39", "4A", "4C", " 58", "CF" },
                { "D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02", "7F", "50", "3C", "9F", "A8" },
                { "51", "A3", "40", "8F", "92", "9D", "38", "F5", "BC", "B6", "DA", "21", "10", "FF", "F3", "D2" },
                { "CD", "0C", "3", "EC", "5F", "97", "44", "7", "C4", "A7", "7E", "3D", "64", "5D", "19", "73" },
                { "60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8", "14", "DE", "5E", "0B", "DB" },
                { "E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC", "62", "91", "95", "E4", "79" },
                { "E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4", "EA", "65", "7A", "AE", "08" },
                { "BA", "78", "25", "2E", "1C", "A6", "B4", "C6", "E8", "DD", "74", "1F", "4B", "BD", "8B", "8A" },
                { "70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57", "B9", "86", "C1", "1D", "9E" },
                { "E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87", "E9", "CE", "55", "28", "DF" },
                { "8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D", "0F", "B0", "54", "BB", "16" } };
        String bs[][] = new String[4][4];
        // byte substitution
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int r, c;
                if (s1[i][j].length() < 2) {
                    r = 0;

                    if (s1[i][j].equals("a") || s1[i][j].equals("b") || s1[i][j].equals("c") || s1[i][j].equals("d")
                            || s1[i][j].equals("e") || s1[i][j].equals("f")) {
                        c = s1[i][j].charAt(0) - 97 + 10;
                    } else {
                        c = s1[i][j].charAt(0) - 48;
                    }
                } else {

                    if (s1[i][j].charAt(0) == 'a' || s1[i][j].charAt(0) == 'b' || s1[i][j].charAt(0) == 'c'
                            || s1[i][j].charAt(0) == 'd' || s1[i][j].charAt(0) == 'e' || s1[i][j].charAt(0) == 'f') {
                        r = s1[i][j].charAt(0) - 97 + 10;
                    } else {
                        r = s1[i][j].charAt(0) - 48;
                    }
                    if (s1[i][j].charAt(1) == 'a' || s1[i][j].charAt(1) == 'b' || s1[i][j].charAt(1) == 'c'
                            || s1[i][j].charAt(1) == 'd' || s1[i][j].charAt(1) == 'e' || s1[i][j].charAt(1) == 'f') {
                        c = s1[i][j].charAt(1) - 97 + 10;
                    } else {
                        c = s1[i][j].charAt(1) - 48;
                    }
                }
                bs[i][j] = sbox[r][c];
            }
        }
        System.out.println();
        System.out.println("After byte substitution:");
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(bs[i][j] + " ");
            }
        }
        // shift rows
        String t;
        t = bs[1][0];
        for (int i = 0; i < 3; i++) {
            bs[1][i] = bs[1][i + 1];
        }
        bs[1][3] = t;
        String temp;
        temp = bs[2][0];
        t = bs[2][1];
        bs[2][0] = bs[2][2];
        bs[2][1] = bs[2][3];
        bs[2][2] = temp;
        bs[2][3] = t;

        temp = bs[3][0];
        t = bs[3][1];
        String te;
        te = bs[3][2];
        bs[3][0] = bs[3][3];
        bs[3][1] = temp;
        bs[3][2] = t;
        bs[3][3] = te;
        System.out.println();
        System.out.println("After Shift rows");
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(bs[i][j] + " ");
            }
        }
        // mixcolumns

        int mix[][] = { { 2, 3, 1, 1 }, { 1, 2, 3, 1 }, { 1, 1, 2, 3 }, { 3, 1, 1, 2 } };
        int mc[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mc[i][j] = Integer.parseInt(bs[i][j], 16);
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(mc[i][j] + " ");
            }
        }
        int y = 283;
        int r[][] = new int[4][4];
        int x;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                r[i][j] = 0;
                for (int ki = 0; ki < 4; ki++) {
                    System.out.println("value of i n j is " + i + j);
                    x = mc[ki][j];
                    switch (mix[i][ki]) {

                        case 2:

                            // System.out.println("value of mc is " + mc[ki][j] + " value of mix is " +
                            // mix[i][ki]);
                            // x = x << 1;
                            if (mc[ki][j] % 2 != 0) {
                                x = (x << 1) ^ y;
                                // System.out.println("Before Xor with 11b x=" + x);
                                // x = x ^ y;
                                // System.out.println("After Xor with 11b x=" + x);
                            } else {
                                x = x << 1;
                            }
                            break;
                        case 3:
                            // System.out.println("value of mc is " + mc[ki][j] + " value of mix is " +
                            // mix[i][ki]);

                            // x = x << 1;
                            if (mc[ki][j] % 2 != 0) {
                                x = ((x << 1) ^ y) ^ x;
                                // System.out.println("Before Xor with 11b x=" + x);
                                // x = x ^ y;
                                // System.out.println("After Xor with 11b x=" + x);
                            } else {
                                x = (x << 1) ^ x;
                            }
                            // x = x ^ mc[ki][j];
                            break;
                        default:
                            break;
                    }
                    r[i][j] = r[i][j] ^ x;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(r[i][j] + " ");
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                bs[i][j] = Integer.toHexString(r[i][j]);
            }
        }
        System.out.println();
        System.out.println("After mix columns");
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(bs[i][j] + " ");
            }
        }
    }

}
