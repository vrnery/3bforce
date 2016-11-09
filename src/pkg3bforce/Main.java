/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3bforce;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanderson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Quebrar por Força Bruta v.1");
        String dicionario = "";
        long nTentativas = 0;
        String textoEncriptado = "6j7W7b51dLus8COS0tVzf8t4Qf7Ch2sO5wBP7eeyEmkW+mIT4eEdk+CejhqT7/t/Dbo2lQZlias7AMqw0OD9NNkkaZSRd2qbrxjlzClLdVClBf877N90JutLjxw7d9q9+MYbRzYJGkCEvUWFHF7gvg==";
        //String textoEncriptado = "IZSsvLk8Z2C3NrbqP6GlQ791puzvLAuWtBCpriJ3gp47/qlf61+H0/FtNe/plKB5ooEzsT9iSskqEUqOl0JBDg==";
        String textoDecriptado = "";
        String chave = "";
        List<BruteForce> nBruteForce = new ArrayList<BruteForce>();
        List<Thread> nThread = new ArrayList<Thread>();

        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 48; i < 58; i++) {
            dicionario += ((char) i);
        }
        // A, ... Z
        for (int i = 65; i < 91; i++) {
            dicionario += ((char) i);
        }
        // a, ... z
        for (int i = 97; i < 123; i++) {
            dicionario += ((char) i);
        }

        int n4 = 0;
        int n1Possibilidade = dicionario.length();

        if (n1Possibilidade % 2 == 0) {
            n4 = n1Possibilidade / 30;
        } else {
            n4 = (n1Possibilidade - 1) / 30;
            System.out.println("n4*30, n4*30+1");
            BruteForce bf60 = new BruteForce(dicionario, textoEncriptado, (n4 * 30), (n4 * 30 + 1));
            nBruteForce.add(bf60);
            nThread.add(new Thread(bf60));
        }

        System.out.println("0 = " + dicionario.charAt(0) + ", n4 = " + dicionario.charAt(n4));
        BruteForce bf0 = new BruteForce(dicionario, textoEncriptado, 0, n4);
        nBruteForce.add(bf0);
        nThread.add(new Thread(bf0));

        System.out.println("n4 = " + dicionario.charAt(n4) + ", n4*2 = " + dicionario.charAt((n4 * 2)));
        BruteForce bf1 = new BruteForce(dicionario, textoEncriptado, n4, (n4 * 2));
        nBruteForce.add(bf1);
        nThread.add(new Thread(bf1));

        System.out.println("n4*2 = " + dicionario.charAt((n4 * 2)) + ", n4*3 = " + dicionario.charAt((n4 * 3)));
        BruteForce bf2 = new BruteForce(dicionario, textoEncriptado, (n4 * 2), (n4 * 3));
        nBruteForce.add(bf2);
        nThread.add(new Thread(bf2));

        System.out.println("n4*3 = " + dicionario.charAt((n4 * 3)) + ", n4*4 = " + dicionario.charAt((n4 * 4)));
        BruteForce bf3 = new BruteForce(dicionario, textoEncriptado, (n4 * 3), (n4 * 4));
        nBruteForce.add(bf3);
        nThread.add(new Thread(bf3));
        
        System.out.println("n4*4 = " + dicionario.charAt((n4 * 4)) + ", n4*5 = " + dicionario.charAt((n4 * 5)));
        BruteForce bf4 = new BruteForce(dicionario, textoEncriptado, (n4 * 4), (n4 * 5));
        nBruteForce.add(bf4);
        nThread.add(new Thread(bf4));
        
        System.out.println("n4*5 = " + dicionario.charAt((n4 * 5)) + ", n4*6 = " + dicionario.charAt((n4 * 6)));
        BruteForce bf5 = new BruteForce(dicionario, textoEncriptado, (n4 * 5), (n4 * 6));
        nBruteForce.add(bf5);
        nThread.add(new Thread(bf5));
        
        System.out.println("n4*6 = " + dicionario.charAt((n4 * 6)) + ", n4*7 = " + dicionario.charAt((n4 * 7)));
        BruteForce bf6 = new BruteForce(dicionario, textoEncriptado, (n4 * 6), (n4 * 7));
        nBruteForce.add(bf6);
        nThread.add(new Thread(bf6));
        
        System.out.println("n4*7 = " + dicionario.charAt((n4 * 7)) + ", n4*8 = " + dicionario.charAt((n4 * 8)));
        BruteForce bf7 = new BruteForce(dicionario, textoEncriptado, (n4 * 7), (n4 * 8));
        nBruteForce.add(bf7);
        nThread.add(new Thread(bf7));
        
        System.out.println("n4*8 = " + dicionario.charAt((n4 * 8)) + ", n4*9 = " + dicionario.charAt((n4 * 9)));
        BruteForce bf8 = new BruteForce(dicionario, textoEncriptado, (n4 * 8), (n4 * 9));
        nBruteForce.add(bf8);
        nThread.add(new Thread(bf8));
        
        System.out.println("n4*9 = " + dicionario.charAt((n4 * 9)) + ", n4*10 = " + dicionario.charAt((n4 * 10)));
        BruteForce bf9 = new BruteForce(dicionario, textoEncriptado, (n4 * 9), (n4 * 10));
        nBruteForce.add(bf9);
        nThread.add(new Thread(bf9));
        
        System.out.println("n4*10 = " + dicionario.charAt((n4 * 10)) + ", n4*11 = " + dicionario.charAt((n4 * 11)));
        BruteForce bf10 = new BruteForce(dicionario, textoEncriptado, (n4 * 10), (n4 * 11));
        nBruteForce.add(bf10);
        nThread.add(new Thread(bf10));
        
        System.out.println("n4*11 = " + dicionario.charAt((n4 * 11)) + ", n4*12 = " + dicionario.charAt((n4 * 12)));
        BruteForce bf11 = new BruteForce(dicionario, textoEncriptado, (n4 * 11), (n4 * 12));
        nBruteForce.add(bf11);
        nThread.add(new Thread(bf11));
        
        System.out.println("n4*12 = " + dicionario.charAt((n4 * 12)) + ", n4*13 = " + dicionario.charAt((n4 * 13)));
        BruteForce bf12 = new BruteForce(dicionario, textoEncriptado, (n4 * 12), (n4 * 13));
        nBruteForce.add(bf12);
        nThread.add(new Thread(bf12));
        
        System.out.println("n4*13 = " + dicionario.charAt((n4 * 13)) + ", n4*14 = " + dicionario.charAt((n4 * 14)));
        BruteForce bf13 = new BruteForce(dicionario, textoEncriptado, (n4 * 13), (n4 * 14));
        nBruteForce.add(bf13);
        nThread.add(new Thread(bf13));
        
        System.out.println("n4*14 = " + dicionario.charAt((n4 * 14)) + ", n4*15 = " + dicionario.charAt((n4 * 15)));
        BruteForce bf14 = new BruteForce(dicionario, textoEncriptado, (n4 * 14), (n4 * 15));
        nBruteForce.add(bf14);
        nThread.add(new Thread(bf14));
        
        System.out.println("n4*15 = " + dicionario.charAt((n4 * 15)) + ", n4*16 = " + dicionario.charAt((n4 * 16)));
        BruteForce bf15 = new BruteForce(dicionario, textoEncriptado, (n4 * 15), (n4 * 16));
        nBruteForce.add(bf15);
        nThread.add(new Thread(bf15));
        
        System.out.println("n4*16 = " + dicionario.charAt((n4 * 16)) + ", n4*17 = " + dicionario.charAt((n4 * 17)));
        BruteForce bf16 = new BruteForce(dicionario, textoEncriptado, (n4 * 16), (n4 * 17));
        nBruteForce.add(bf16);
        nThread.add(new Thread(bf16));
        
        System.out.println("n4*17 = " + dicionario.charAt((n4 * 17)) + ", n4*18 = " + dicionario.charAt((n4 * 18)));
        BruteForce bf17 = new BruteForce(dicionario, textoEncriptado, (n4 * 17), (n4 * 18));
        nBruteForce.add(bf17);
        nThread.add(new Thread(bf17));
        
        System.out.println("n4*18 = " + dicionario.charAt((n4 * 18)) + ", n4*19 = " + dicionario.charAt((n4 * 19)));
        BruteForce bf18 = new BruteForce(dicionario, textoEncriptado, (n4 * 18), (n4 * 19));
        nBruteForce.add(bf18);
        nThread.add(new Thread(bf18));
        
        System.out.println("n4*19 = " + dicionario.charAt((n4 * 19)) + ", n4*20 = " + dicionario.charAt((n4 * 20)));
        BruteForce bf19 = new BruteForce(dicionario, textoEncriptado, (n4 * 19), (n4 * 20));
        nBruteForce.add(bf19);
        nThread.add(new Thread(bf19));
        
        System.out.println("n4*20 = " + dicionario.charAt((n4 * 20)) + ", n4*21 = " + dicionario.charAt((n4 * 21)));
        BruteForce bf20 = new BruteForce(dicionario, textoEncriptado, (n4 * 20), (n4 * 21));
        nBruteForce.add(bf20);
        nThread.add(new Thread(bf20));
        
        System.out.println("n4*21 = " + dicionario.charAt((n4 * 21)) + ", n4*22 = " + dicionario.charAt((n4 * 22)));
        BruteForce bf21 = new BruteForce(dicionario, textoEncriptado, (n4 * 21), (n4 * 22));
        nBruteForce.add(bf21);
        nThread.add(new Thread(bf21));
        
        System.out.println("n4*22 = " + dicionario.charAt((n4 * 22)) + ", n4*23 = " + dicionario.charAt((n4 * 23)));
        BruteForce bf22 = new BruteForce(dicionario, textoEncriptado, (n4 * 22), (n4 * 23));
        nBruteForce.add(bf22);
        nThread.add(new Thread(bf22));
        
        System.out.println("n4*23 = " + dicionario.charAt((n4 * 23)) + ", n4*24 = " + dicionario.charAt((n4 * 24)));
        BruteForce bf23 = new BruteForce(dicionario, textoEncriptado, (n4 * 23), (n4 * 24));
        nBruteForce.add(bf23);
        nThread.add(new Thread(bf23));
        
        System.out.println("n4*24 = " + dicionario.charAt((n4 * 24)) + ", n4*25 = " + dicionario.charAt((n4 * 25)));
        BruteForce bf24 = new BruteForce(dicionario, textoEncriptado, (n4 * 24), (n4 * 25));
        nBruteForce.add(bf24);
        nThread.add(new Thread(bf24));
        
        System.out.println("n4*25 = " + dicionario.charAt((n4 * 25)) + ", n4*26 = " + dicionario.charAt((n4 * 26)));
        BruteForce bf25 = new BruteForce(dicionario, textoEncriptado, (n4 * 25), (n4 * 26));
        nBruteForce.add(bf25);
        nThread.add(new Thread(bf25));
        
        System.out.println("n4*26 = " + dicionario.charAt((n4 * 26)) + ", n4*27 = " + dicionario.charAt((n4 * 27)));
        BruteForce bf26 = new BruteForce(dicionario, textoEncriptado, (n4 * 26), (n4 * 27));
        nBruteForce.add(bf26);
        nThread.add(new Thread(bf26));
        
        System.out.println("n4*27 = " + dicionario.charAt((n4 * 27)) + ", n4*28 = " + dicionario.charAt((n4 * 28)));
        BruteForce bf27 = new BruteForce(dicionario, textoEncriptado, (n4 * 27), (n4 * 28));
        nBruteForce.add(bf27);
        nThread.add(new Thread(bf27));
        
        System.out.println("n4*28 = " + dicionario.charAt((n4 * 28)) + ", n4*29 = " + dicionario.charAt((n4 * 29)));
        BruteForce bf28 = new BruteForce(dicionario, textoEncriptado, (n4 * 28), (n4 * 29));
        nBruteForce.add(bf28);
        nThread.add(new Thread(bf28));
        
        System.out.println("n4*29 = " + dicionario.charAt((n4 * 29)) + ", n4*30 = " + dicionario.charAt((n4 * 30)));
        BruteForce bf29 = new BruteForce(dicionario, textoEncriptado, (n4 * 29), (n4 * 30));
        nBruteForce.add(bf29);
        nThread.add(new Thread(bf29));
        
//        System.out.println("n4*30, n4*31");
//        BruteForce bf30 = new BruteForce(dicionario, textoEncriptado, (n4 * 30), (n4 * 31));
//        nBruteForce.add(bf30);
//        nThread.add(new Thread(bf30));
//        
//        System.out.println("n4*31, n4*32");
//        BruteForce bf31 = new BruteForce(dicionario, textoEncriptado, (n4 * 31), (n4 * 32));
//        nBruteForce.add(bf31);
//        nThread.add(new Thread(bf31));
//        
//        System.out.println("n4*32, n4*33");
//        BruteForce bf32 = new BruteForce(dicionario, textoEncriptado, (n4 * 32), (n4 * 33));
//        nBruteForce.add(bf32);
//        nThread.add(new Thread(bf32));
//        
//        System.out.println("n4*33, n4*34");
//        BruteForce bf33 = new BruteForce(dicionario, textoEncriptado, (n4 * 33), (n4 * 34));
//        nBruteForce.add(bf33);
//        nThread.add(new Thread(bf33));
//        
//        System.out.println("n4*34, n4*35");
//        BruteForce bf34 = new BruteForce(dicionario, textoEncriptado, (n4 * 34), (n4 * 35));
//        nBruteForce.add(bf34);
//        nThread.add(new Thread(bf34));
//        
//        System.out.println("n4*35, n4*36");
//        BruteForce bf35 = new BruteForce(dicionario, textoEncriptado, (n4 * 35), (n4 * 36));
//        nBruteForce.add(bf35);
//        nThread.add(new Thread(bf35));
//        
//        System.out.println("n4*36, n4*37");
//        BruteForce bf36 = new BruteForce(dicionario, textoEncriptado, (n4 * 36), (n4 * 37));
//        nBruteForce.add(bf36);
//        nThread.add(new Thread(bf36));
//        
//        System.out.println("n4*37, n4*38");
//        BruteForce bf37 = new BruteForce(dicionario, textoEncriptado, (n4 * 37), (n4 * 38));
//        nBruteForce.add(bf37);
//        nThread.add(new Thread(bf37));
//        
//        System.out.println("n4*38, n4*39");
//        BruteForce bf38 = new BruteForce(dicionario, textoEncriptado, (n4 * 38), (n4 * 38));
//        nBruteForce.add(bf38);
//        nThread.add(new Thread(bf38));
//        
//        System.out.println("n4*39, n4*40");
//        BruteForce bf39 = new BruteForce(dicionario, textoEncriptado, (n4 * 39), (n4 * 40));
//        nBruteForce.add(bf39);
//        nThread.add(new Thread(bf39));
//        
//        System.out.println("n4*40, n4*41");
//        BruteForce bf40 = new BruteForce(dicionario, textoEncriptado, (n4 * 40), (n4 * 41));
//        nBruteForce.add(bf40);
//        nThread.add(new Thread(bf40));
//        
//        System.out.println("n4*41, n4*42");
//        BruteForce bf41 = new BruteForce(dicionario, textoEncriptado, (n4 * 41), (n4 * 42));
//        nBruteForce.add(bf41);
//        nThread.add(new Thread(bf41));
//        
//        System.out.println("n4*42, n4*43");
//        BruteForce bf42 = new BruteForce(dicionario, textoEncriptado, (n4 * 42), (n4 * 43));
//        nBruteForce.add(bf42);
//        nThread.add(new Thread(bf42));
//        
//        System.out.println("n4*43, n4*44");
//        BruteForce bf43 = new BruteForce(dicionario, textoEncriptado, (n4 * 43), (n4 * 44));
//        nBruteForce.add(bf43);
//        nThread.add(new Thread(bf43));
//        
//        System.out.println("n4*44, n4*45");
//        BruteForce bf44 = new BruteForce(dicionario, textoEncriptado, (n4 * 44), (n4 * 45));
//        nBruteForce.add(bf44);
//        nThread.add(new Thread(bf44));
//        
//        System.out.println("n4*45, n4*46");
//        BruteForce bf45 = new BruteForce(dicionario, textoEncriptado, (n4 * 45), (n4 * 46));
//        nBruteForce.add(bf45);
//        nThread.add(new Thread(bf45));
//        
//        System.out.println("n4*46, n4*47");
//        BruteForce bf46 = new BruteForce(dicionario, textoEncriptado, (n4 * 46), (n4 * 47));
//        nBruteForce.add(bf46);
//        nThread.add(new Thread(bf46));
//        
//        System.out.println("n4*47, n4*48");
//        BruteForce bf47 = new BruteForce(dicionario, textoEncriptado, (n4 * 47), (n4 * 48));
//        nBruteForce.add(bf47);
//        nThread.add(new Thread(bf47));
//        
//        System.out.println("n4*48, n4*49");
//        BruteForce bf48 = new BruteForce(dicionario, textoEncriptado, (n4 * 48), (n4 * 49));
//        nBruteForce.add(bf48);
//        nThread.add(new Thread(bf48));
//        
//        System.out.println("n4*49, n4*50");
//        BruteForce bf49 = new BruteForce(dicionario, textoEncriptado, (n4 * 49), (n4 * 50));
//        nBruteForce.add(bf49);
//        nThread.add(new Thread(bf49));
//        
//        System.out.println("n4*50, n4*51");
//        BruteForce bf50 = new BruteForce(dicionario, textoEncriptado, (n4 * 50), (n4 * 51));
//        nBruteForce.add(bf50);
//        nThread.add(new Thread(bf50));
//        
//        System.out.println("n4*51, n4*52");
//        BruteForce bf51 = new BruteForce(dicionario, textoEncriptado, (n4 * 51), (n4 * 52));
//        nBruteForce.add(bf51);
//        nThread.add(new Thread(bf51));
//        
//        System.out.println("n4*52, n4*53");
//        BruteForce bf52 = new BruteForce(dicionario, textoEncriptado, (n4 * 52), (n4 * 53));
//        nBruteForce.add(bf52);
//        nThread.add(new Thread(bf52));
//        
//        System.out.println("n4*53, n4*54");
//        BruteForce bf53 = new BruteForce(dicionario, textoEncriptado, (n4 * 53), (n4 * 54));
//        nBruteForce.add(bf53);
//        nThread.add(new Thread(bf53));
//        
//        System.out.println("n4*54, n4*55");
//        BruteForce bf54 = new BruteForce(dicionario, textoEncriptado, (n4 * 54), (n4 * 55));
//        nBruteForce.add(bf54);
//        nThread.add(new Thread(bf54));
//        
//        System.out.println("n4*55, n4*56");
//        BruteForce bf55 = new BruteForce(dicionario, textoEncriptado, (n4 * 55), (n4 * 56));
//        nBruteForce.add(bf55);
//        nThread.add(new Thread(bf55));
//        
//        System.out.println("n4*56, n4*57");
//        BruteForce bf56 = new BruteForce(dicionario, textoEncriptado, (n4 * 56), (n4 * 57));
//        nBruteForce.add(bf56);
//        nThread.add(new Thread(bf56));
//        
//        System.out.println("n4*57, n4*58");
//        BruteForce bf57 = new BruteForce(dicionario, textoEncriptado, (n4 * 57), (n4 * 58));
//        nBruteForce.add(bf57);
//        nThread.add(new Thread(bf57));
//        
//        System.out.println("n4*58, n4*59");
//        BruteForce bf58 = new BruteForce(dicionario, textoEncriptado, (n4 * 58), (n4 * 59));
//        nBruteForce.add(bf58);
//        nThread.add(new Thread(bf58));
//        
//        System.out.println("n4*59, n4*60");
//        BruteForce bf59 = new BruteForce(dicionario, textoEncriptado, (n4 * 59), (n4 * 60));
//        nBruteForce.add(bf59);
//        nThread.add(new Thread(bf59));
        
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

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Mensagem: " + textoDecriptado);
        System.out.println("Chave: " + chave);
        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
        
        try {
            FileWriter arq = new FileWriter("dados.txt");
            PrintWriter gravar = new PrintWriter(arq);
            gravar.println("Decriptar Mensagem");
            gravar.println("Texto Encriptado: " + textoEncriptado);
            gravar.println("Texto Descriptado: " + textoDecriptado);
            gravar.println("Chave: " + chave);
            gravar.println("Número de tentativas: " + nTentativas);
            gravar.printf("Tempo de execução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
