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
        int nTentativas = 0;
        String textoEncriptado = "IZSsvLk8Z2C3NrbqP6GlQ791puzvLAuWtBCpriJ3gp47/qlf61+H0/FtNe/plKB5ooEzsT9iSskqEUqOl0JBDg==";
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
            n4 = n1Possibilidade / 4;
        } else {
            n4 = (n1Possibilidade - 1) / 4;
            System.out.println("n4*4, n4*4+1");
            BruteForce bf4 = new BruteForce(dicionario, textoEncriptado, (n4 * 4), (n4 * 4 + 1));
            nBruteForce.add(bf4);
            nThread.add(new Thread(bf4));
        }

        System.out.println("0, n4");
        BruteForce bf0 = new BruteForce(dicionario, textoEncriptado, 0, n4);
        nBruteForce.add(bf0);
        nThread.add(new Thread(bf0));

        System.out.println("n4, n4*2");
        BruteForce bf1 = new BruteForce(dicionario, textoEncriptado, n4, (n4 * 2));
        nBruteForce.add(bf1);
        nThread.add(new Thread(bf1));

        System.out.println("n4*2, n4*3");
        BruteForce bf2 = new BruteForce(dicionario, textoEncriptado, (n4 * 2), (n4 * 3));
        nBruteForce.add(bf2);
        nThread.add(new Thread(bf2));

        System.out.println("n4*3, n4*4");
        BruteForce bf3 = new BruteForce(dicionario, textoEncriptado, (n4 * 3), (n4 * 4));
        nBruteForce.add(bf3);
        nThread.add(new Thread(bf3));
        
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
                    nBruteForce.remove(bf);
                    break;
                }
            }
        }

        for (BruteForce bf : nBruteForce) {
            bf.pausa();
        }
        
        for (Thread th : nThread) {
            try {
                th.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Mensagem: " + textoDecriptado);
        System.out.println("Chave: " + chave);
        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }

}
