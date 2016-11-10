/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3bforce;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 10070124
 */
public class Threads6 implements Runnable {

    List<Thread> nThread = new ArrayList<Thread>();
    List<BruteForce> nBruteForce = new ArrayList<BruteForce>();
    String dicionario = "";
    String textoEncriptado = "";
    long nTentativas = 0;
    String textoDecriptado = "";
    String chave = "";
    public volatile boolean finalizado = false;
    int i6 = 0;
    int f6 = 0;

    public Threads6(String dic, String texto, int in, int out) {
        this.dicionario = dic;
        this.textoEncriptado = texto;
        this.i6 = in;
        this.f6 = out;
    }

    @Override
    public void run() {
        try {
            for (int c = this.i6; c < this.f6; c++) {
                if (!this.finalizado) {
                    String cha6 = dicionario.charAt(c) + "";
                    int n4 = 0;
                    int n1Possibilidade = dicionario.length();
                    n4 = n1Possibilidade / 62;

                    System.out.println("0 = " + dicionario.charAt(0) + ", n4 = " + dicionario.charAt(n4));
                    BruteForce bf0 = new BruteForce(dicionario, textoEncriptado, 0, n4, cha6 + "0");
                    nBruteForce.add(bf0);
                    nThread.add(new Thread(bf0));

                    System.out.println("n4 = " + dicionario.charAt(n4) + ", n4*2 = " + dicionario.charAt((n4 * 2)));
                    BruteForce bf1 = new BruteForce(dicionario, textoEncriptado, n4, (n4 * 2), cha6 + "1");
                    nBruteForce.add(bf1);
                    nThread.add(new Thread(bf1));

                    System.out.println("n4*2 = " + dicionario.charAt((n4 * 2)) + ", n4*3 = " + dicionario.charAt((n4 * 3)));
                    BruteForce bf2 = new BruteForce(dicionario, textoEncriptado, (n4 * 2), (n4 * 3), cha6 + "2");
                    nBruteForce.add(bf2);
                    nThread.add(new Thread(bf2));

                    System.out.println("n4*3 = " + dicionario.charAt((n4 * 3)) + ", n4*4 = " + dicionario.charAt((n4 * 4)));
                    BruteForce bf3 = new BruteForce(dicionario, textoEncriptado, (n4 * 3), (n4 * 4), cha6 + "3");
                    nBruteForce.add(bf3);
                    nThread.add(new Thread(bf3));

                    System.out.println("n4*4 = " + dicionario.charAt((n4 * 4)) + ", n4*5 = " + dicionario.charAt((n4 * 5)));
                    BruteForce bf4 = new BruteForce(dicionario, textoEncriptado, (n4 * 4), (n4 * 5), cha6 + "4");
                    nBruteForce.add(bf4);
                    nThread.add(new Thread(bf4));

                    System.out.println("n4*5 = " + dicionario.charAt((n4 * 5)) + ", n4*6 = " + dicionario.charAt((n4 * 6)));
                    BruteForce bf5 = new BruteForce(dicionario, textoEncriptado, (n4 * 5), (n4 * 6), cha6 + "5");
                    nBruteForce.add(bf5);
                    nThread.add(new Thread(bf5));

                    System.out.println("n4*6 = " + dicionario.charAt((n4 * 6)) + ", n4*7 = " + dicionario.charAt((n4 * 7)));
                    BruteForce bf6 = new BruteForce(dicionario, textoEncriptado, (n4 * 6), (n4 * 7), cha6 + "6");
                    nBruteForce.add(bf6);
                    nThread.add(new Thread(bf6));

                    System.out.println("n4*7 = " + dicionario.charAt((n4 * 7)) + ", n4*8 = " + dicionario.charAt((n4 * 8)));
                    BruteForce bf7 = new BruteForce(dicionario, textoEncriptado, (n4 * 7), (n4 * 8), cha6 + "7");
                    nBruteForce.add(bf7);
                    nThread.add(new Thread(bf7));

                    System.out.println("n4*8 = " + dicionario.charAt((n4 * 8)) + ", n4*9 = " + dicionario.charAt((n4 * 9)));
                    BruteForce bf8 = new BruteForce(dicionario, textoEncriptado, (n4 * 8), (n4 * 9), cha6 + "8");
                    nBruteForce.add(bf8);
                    nThread.add(new Thread(bf8));

                    System.out.println("n4*9 = " + dicionario.charAt((n4 * 9)) + ", n4*10 = " + dicionario.charAt((n4 * 10)));
                    BruteForce bf9 = new BruteForce(dicionario, textoEncriptado, (n4 * 9), (n4 * 10), cha6 + "9");
                    nBruteForce.add(bf9);
                    nThread.add(new Thread(bf9));

                    System.out.println("n4*10 = " + dicionario.charAt((n4 * 10)) + ", n4*11 = " + dicionario.charAt((n4 * 11)));
                    BruteForce bf10 = new BruteForce(dicionario, textoEncriptado, (n4 * 10), (n4 * 11), cha6 + "A");
                    nBruteForce.add(bf10);
                    nThread.add(new Thread(bf10));

                    System.out.println("n4*11 = " + dicionario.charAt((n4 * 11)) + ", n4*12 = " + dicionario.charAt((n4 * 12)));
                    BruteForce bf11 = new BruteForce(dicionario, textoEncriptado, (n4 * 11), (n4 * 12), cha6 + "B");
                    nBruteForce.add(bf11);
                    nThread.add(new Thread(bf11));

                    System.out.println("n4*12 = " + dicionario.charAt((n4 * 12)) + ", n4*13 = " + dicionario.charAt((n4 * 13)));
                    BruteForce bf12 = new BruteForce(dicionario, textoEncriptado, (n4 * 12), (n4 * 13), cha6 + "C");
                    nBruteForce.add(bf12);
                    nThread.add(new Thread(bf12));

                    System.out.println("n4*13 = " + dicionario.charAt((n4 * 13)) + ", n4*14 = " + dicionario.charAt((n4 * 14)));
                    BruteForce bf13 = new BruteForce(dicionario, textoEncriptado, (n4 * 13), (n4 * 14), cha6 + "D");
                    nBruteForce.add(bf13);
                    nThread.add(new Thread(bf13));

                    System.out.println("n4*14 = " + dicionario.charAt((n4 * 14)) + ", n4*15 = " + dicionario.charAt((n4 * 15)));
                    BruteForce bf14 = new BruteForce(dicionario, textoEncriptado, (n4 * 14), (n4 * 15), cha6 + "E");
                    nBruteForce.add(bf14);
                    nThread.add(new Thread(bf14));

                    System.out.println("n4*15 = " + dicionario.charAt((n4 * 15)) + ", n4*16 = " + dicionario.charAt((n4 * 16)));
                    BruteForce bf15 = new BruteForce(dicionario, textoEncriptado, (n4 * 15), (n4 * 16), cha6 + "F");
                    nBruteForce.add(bf15);
                    nThread.add(new Thread(bf15));

                    System.out.println("n4*16 = " + dicionario.charAt((n4 * 16)) + ", n4*17 = " + dicionario.charAt((n4 * 17)));
                    BruteForce bf16 = new BruteForce(dicionario, textoEncriptado, (n4 * 16), (n4 * 17), cha6 + "G");
                    nBruteForce.add(bf16);
                    nThread.add(new Thread(bf16));

                    System.out.println("n4*17 = " + dicionario.charAt((n4 * 17)) + ", n4*18 = " + dicionario.charAt((n4 * 18)));
                    BruteForce bf17 = new BruteForce(dicionario, textoEncriptado, (n4 * 17), (n4 * 18), cha6 + "H");
                    nBruteForce.add(bf17);
                    nThread.add(new Thread(bf17));

                    System.out.println("n4*18 = " + dicionario.charAt((n4 * 18)) + ", n4*19 = " + dicionario.charAt((n4 * 19)));
                    BruteForce bf18 = new BruteForce(dicionario, textoEncriptado, (n4 * 18), (n4 * 19), cha6 + "I");
                    nBruteForce.add(bf18);
                    nThread.add(new Thread(bf18));

                    System.out.println("n4*19 = " + dicionario.charAt((n4 * 19)) + ", n4*20 = " + dicionario.charAt((n4 * 20)));
                    BruteForce bf19 = new BruteForce(dicionario, textoEncriptado, (n4 * 19), (n4 * 20), cha6 + "J");
                    nBruteForce.add(bf19);
                    nThread.add(new Thread(bf19));

                    System.out.println("n4*20 = " + dicionario.charAt((n4 * 20)) + ", n4*21 = " + dicionario.charAt((n4 * 21)));
                    BruteForce bf20 = new BruteForce(dicionario, textoEncriptado, (n4 * 20), (n4 * 21), cha6 + "K");
                    nBruteForce.add(bf20);
                    nThread.add(new Thread(bf20));

                    System.out.println("n4*21 = " + dicionario.charAt((n4 * 21)) + ", n4*22 = " + dicionario.charAt((n4 * 22)));
                    BruteForce bf21 = new BruteForce(dicionario, textoEncriptado, (n4 * 21), (n4 * 22), cha6 + "L");
                    nBruteForce.add(bf21);
                    nThread.add(new Thread(bf21));

                    System.out.println("n4*22 = " + dicionario.charAt((n4 * 22)) + ", n4*23 = " + dicionario.charAt((n4 * 23)));
                    BruteForce bf22 = new BruteForce(dicionario, textoEncriptado, (n4 * 22), (n4 * 23), cha6 + "M");
                    nBruteForce.add(bf22);
                    nThread.add(new Thread(bf22));

                    System.out.println("n4*23 = " + dicionario.charAt((n4 * 23)) + ", n4*24 = " + dicionario.charAt((n4 * 24)));
                    BruteForce bf23 = new BruteForce(dicionario, textoEncriptado, (n4 * 23), (n4 * 24), cha6 + "N");
                    nBruteForce.add(bf23);
                    nThread.add(new Thread(bf23));

                    System.out.println("n4*24 = " + dicionario.charAt((n4 * 24)) + ", n4*25 = " + dicionario.charAt((n4 * 25)));
                    BruteForce bf24 = new BruteForce(dicionario, textoEncriptado, (n4 * 24), (n4 * 25), cha6 + "O");
                    nBruteForce.add(bf24);
                    nThread.add(new Thread(bf24));

                    System.out.println("n4*25 = " + dicionario.charAt((n4 * 25)) + ", n4*26 = " + dicionario.charAt((n4 * 26)));
                    BruteForce bf25 = new BruteForce(dicionario, textoEncriptado, (n4 * 25), (n4 * 26), cha6 + "P");
                    nBruteForce.add(bf25);
                    nThread.add(new Thread(bf25));

                    System.out.println("n4*26 = " + dicionario.charAt((n4 * 26)) + ", n4*27 = " + dicionario.charAt((n4 * 27)));
                    BruteForce bf26 = new BruteForce(dicionario, textoEncriptado, (n4 * 26), (n4 * 27), cha6 + "Q");
                    nBruteForce.add(bf26);
                    nThread.add(new Thread(bf26));

                    System.out.println("n4*27 = " + dicionario.charAt((n4 * 27)) + ", n4*28 = " + dicionario.charAt((n4 * 28)));
                    BruteForce bf27 = new BruteForce(dicionario, textoEncriptado, (n4 * 27), (n4 * 28), cha6 + "R");
                    nBruteForce.add(bf27);
                    nThread.add(new Thread(bf27));

                    System.out.println("n4*28 = " + dicionario.charAt((n4 * 28)) + ", n4*29 = " + dicionario.charAt((n4 * 29)));
                    BruteForce bf28 = new BruteForce(dicionario, textoEncriptado, (n4 * 28), (n4 * 29), cha6 + "S");
                    nBruteForce.add(bf28);
                    nThread.add(new Thread(bf28));

                    System.out.println("n4*29 = " + dicionario.charAt((n4 * 29)) + ", n4*30 = " + dicionario.charAt((n4 * 30)));
                    BruteForce bf29 = new BruteForce(dicionario, textoEncriptado, (n4 * 29), (n4 * 30), cha6 + "T");
                    nBruteForce.add(bf29);
                    nThread.add(new Thread(bf29));

                    System.out.println("n4*30, n4*31");
                    BruteForce bf30 = new BruteForce(dicionario, textoEncriptado, (n4 * 30), (n4 * 31), cha6 + "U");
                    nBruteForce.add(bf30);
                    nThread.add(new Thread(bf30));

                    System.out.println("n4*31, n4*32");
                    BruteForce bf31 = new BruteForce(dicionario, textoEncriptado, (n4 * 31), (n4 * 32), cha6 + "V");
                    nBruteForce.add(bf31);
                    nThread.add(new Thread(bf31));

                    System.out.println("n4*32, n4*33");
                    BruteForce bf32 = new BruteForce(dicionario, textoEncriptado, (n4 * 32), (n4 * 33), cha6 + "W");
                    nBruteForce.add(bf32);
                    nThread.add(new Thread(bf32));

                    System.out.println("n4*33, n4*34");
                    BruteForce bf33 = new BruteForce(dicionario, textoEncriptado, (n4 * 33), (n4 * 34), cha6 + "X");
                    nBruteForce.add(bf33);
                    nThread.add(new Thread(bf33));

                    System.out.println("n4*34, n4*35");
                    BruteForce bf34 = new BruteForce(dicionario, textoEncriptado, (n4 * 34), (n4 * 35), cha6 + "Y");
                    nBruteForce.add(bf34);
                    nThread.add(new Thread(bf34));

                    System.out.println("n4*35, n4*36");
                    BruteForce bf35 = new BruteForce(dicionario, textoEncriptado, (n4 * 35), (n4 * 36), cha6 + "Z");
                    nBruteForce.add(bf35);
                    nThread.add(new Thread(bf35));

                    System.out.println("n4*36, n4*37");
                    BruteForce bf36 = new BruteForce(dicionario, textoEncriptado, (n4 * 36), (n4 * 37), cha6 + "a");
                    nBruteForce.add(bf36);
                    nThread.add(new Thread(bf36));

                    System.out.println("n4*37, n4*38");
                    BruteForce bf37 = new BruteForce(dicionario, textoEncriptado, (n4 * 37), (n4 * 38), cha6 + "b");
                    nBruteForce.add(bf37);
                    nThread.add(new Thread(bf37));

                    System.out.println("n4*38, n4*39");
                    BruteForce bf38 = new BruteForce(dicionario, textoEncriptado, (n4 * 38), (n4 * 38), cha6 + "c");
                    nBruteForce.add(bf38);
                    nThread.add(new Thread(bf38));

                    System.out.println("n4*39, n4*40");
                    BruteForce bf39 = new BruteForce(dicionario, textoEncriptado, (n4 * 39), (n4 * 40), cha6 + "d");
                    nBruteForce.add(bf39);
                    nThread.add(new Thread(bf39));

                    System.out.println("n4*40, n4*41");
                    BruteForce bf40 = new BruteForce(dicionario, textoEncriptado, (n4 * 40), (n4 * 41), cha6 + "e");
                    nBruteForce.add(bf40);
                    nThread.add(new Thread(bf40));

                    System.out.println("n4*41, n4*42");
                    BruteForce bf41 = new BruteForce(dicionario, textoEncriptado, (n4 * 41), (n4 * 42), cha6 + "f");
                    nBruteForce.add(bf41);
                    nThread.add(new Thread(bf41));

                    System.out.println("n4*42, n4*43");
                    BruteForce bf42 = new BruteForce(dicionario, textoEncriptado, (n4 * 42), (n4 * 43), cha6 + "g");
                    nBruteForce.add(bf42);
                    nThread.add(new Thread(bf42));

                    System.out.println("n4*43, n4*44");
                    BruteForce bf43 = new BruteForce(dicionario, textoEncriptado, (n4 * 43), (n4 * 44), cha6 + "h");
                    nBruteForce.add(bf43);
                    nThread.add(new Thread(bf43));

                    System.out.println("n4*44, n4*45");
                    BruteForce bf44 = new BruteForce(dicionario, textoEncriptado, (n4 * 44), (n4 * 45), cha6 + "i");
                    nBruteForce.add(bf44);
                    nThread.add(new Thread(bf44));

                    System.out.println("n4*45, n4*46");
                    BruteForce bf45 = new BruteForce(dicionario, textoEncriptado, (n4 * 45), (n4 * 46), cha6 + "j");
                    nBruteForce.add(bf45);
                    nThread.add(new Thread(bf45));

                    System.out.println("n4*46, n4*47");
                    BruteForce bf46 = new BruteForce(dicionario, textoEncriptado, (n4 * 46), (n4 * 47), cha6 + "k");
                    nBruteForce.add(bf46);
                    nThread.add(new Thread(bf46));

                    System.out.println("n4*47, n4*48");
                    BruteForce bf47 = new BruteForce(dicionario, textoEncriptado, (n4 * 47), (n4 * 48), cha6 + "l");
                    nBruteForce.add(bf47);
                    nThread.add(new Thread(bf47));

                    System.out.println("n4*48, n4*49");
                    BruteForce bf48 = new BruteForce(dicionario, textoEncriptado, (n4 * 48), (n4 * 49), cha6 + "m");
                    nBruteForce.add(bf48);
                    nThread.add(new Thread(bf48));

                    System.out.println("n4*49, n4*50");
                    BruteForce bf49 = new BruteForce(dicionario, textoEncriptado, (n4 * 49), (n4 * 50), cha6 + "n");
                    nBruteForce.add(bf49);
                    nThread.add(new Thread(bf49));

                    System.out.println("n4*50, n4*51");
                    BruteForce bf50 = new BruteForce(dicionario, textoEncriptado, (n4 * 50), (n4 * 51), cha6 + "o");
                    nBruteForce.add(bf50);
                    nThread.add(new Thread(bf50));

                    System.out.println("n4*51, n4*52");
                    BruteForce bf51 = new BruteForce(dicionario, textoEncriptado, (n4 * 51), (n4 * 52), cha6 + "p");
                    nBruteForce.add(bf51);
                    nThread.add(new Thread(bf51));

                    System.out.println("n4*52, n4*53");
                    BruteForce bf52 = new BruteForce(dicionario, textoEncriptado, (n4 * 52), (n4 * 53), cha6 + "q");
                    nBruteForce.add(bf52);
                    nThread.add(new Thread(bf52));

                    System.out.println("n4*53, n4*54");
                    BruteForce bf53 = new BruteForce(dicionario, textoEncriptado, (n4 * 53), (n4 * 54), cha6 + "r");
                    nBruteForce.add(bf53);
                    nThread.add(new Thread(bf53));

                    System.out.println("n4*54, n4*55");
                    BruteForce bf54 = new BruteForce(dicionario, textoEncriptado, (n4 * 54), (n4 * 55), cha6 + "s");
                    nBruteForce.add(bf54);
                    nThread.add(new Thread(bf54));

                    System.out.println("n4*55, n4*56");
                    BruteForce bf55 = new BruteForce(dicionario, textoEncriptado, (n4 * 55), (n4 * 56), cha6 + "t");
                    nBruteForce.add(bf55);
                    nThread.add(new Thread(bf55));

                    System.out.println("n4*56, n4*57");
                    BruteForce bf56 = new BruteForce(dicionario, textoEncriptado, (n4 * 56), (n4 * 57), cha6 + "u");
                    nBruteForce.add(bf56);
                    nThread.add(new Thread(bf56));

                    System.out.println("n4*57, n4*58");
                    BruteForce bf57 = new BruteForce(dicionario, textoEncriptado, (n4 * 57), (n4 * 58), cha6 + "v");
                    nBruteForce.add(bf57);
                    nThread.add(new Thread(bf57));

                    System.out.println("n4*58, n4*59");
                    BruteForce bf58 = new BruteForce(dicionario, textoEncriptado, (n4 * 58), (n4 * 59), cha6 + "w");
                    nBruteForce.add(bf58);
                    nThread.add(new Thread(bf58));

                    System.out.println("n4*59, n4*60");
                    BruteForce bf59 = new BruteForce(dicionario, textoEncriptado, (n4 * 59), (n4 * 60), cha6 + "x");
                    nBruteForce.add(bf59);
                    nThread.add(new Thread(bf59));

                    System.out.println("n4*60, n4*61");
                    BruteForce bf60 = new BruteForce(dicionario, textoEncriptado, (n4 * 60), (n4 * 61), cha6 + "y");
                    nBruteForce.add(bf60);
                    nThread.add(new Thread(bf60));

                    System.out.println("n4*61, n4*62");
                    BruteForce bf61 = new BruteForce(dicionario, textoEncriptado, (n4 * 61), (n4 * 62), cha6 + "z");
                    nBruteForce.add(bf61);
                    nThread.add(new Thread(bf61));

                    for (Thread th : nThread) {
                        th.start();
                    }

                    boolean terminado = false;
                    while (!terminado) {
                        for (BruteForce bf : nBruteForce) {
                            if (bf.finalizado) {
                                terminado = true;
                                textoDecriptado = bf.textoDecriptado;
                                chave = bf.chave;
                                nTentativas += bf.tentativas;
                                this.finalizado = true;
                                nBruteForce.remove(bf);
                                break;
                            }
                            //System.out.println("Tentativas: " + bf.tentativas);
                        }
                    }

                    for (BruteForce bf : nBruteForce) {
                        bf.pausa();
                        nTentativas += bf.tentativas;
                    }

                    for (Thread th : nThread) {
                        try {
                            th.join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } catch (Exception ex) {

        }
    }

}
