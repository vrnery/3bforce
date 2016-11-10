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
import java.util.Date;
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
        long parcialThread = 0;
        List<Thread> mTh = new ArrayList<Thread>();
        List<MaeThread> maeThread = new ArrayList<MaeThread>();
        String dicionario = "";
        String chave = "12pingpongQ";
        String textoEncriptado = "6j7W7b51dLus8COS0tVzf8t4Qf7Ch2sO5wBP7eeyEmkW+mIT4eEdk+CejhqT7/t/Dbo2lQZlias7AMqw0OD9NNkkaZSRd2qbrxjlzClLdVClBf877N90JutLjxw7d9q9+MYbRzYJGkCEvUWFHF7gvg==";
        String textoDecriptado = "";
        long tentativas = 0;

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

//        for (int i = 0; i < 62; i++) {
//            maeThread.add(new MaeThread(dicionario, (chave + dicionario.charAt(i)), textoEncriptado));
//            mTh.add(new Thread(maeThread.get(i)));
//            mTh.get(i).start();
//        }

        MaeThread mae = new MaeThread(dicionario, chave, textoEncriptado, tempoInicial);
        Thread maeTh = new Thread(mae);
        maeTh.start();

        boolean parar = false;
        while (!parar) {
//            for (MaeThread mt : maeThread) {
//                if (mt.parado) {
//                    tentativas += mt.tentativas;
//                    chave = mt.chave;
//                    textoDecriptado = mt.textoDecriptado;
//                    parar = true;
//                    maeThread.remove(mt);
//                    break;
//                }
//            }
            if (mae.parado) {
                tentativas += mae.tentativas;
//                chave = mae.chave;
//                textoDecriptado = mae.textoDecriptado;
                parar = true;
                break;
            }
        }

//        for (MaeThread mt : maeThread) {
//            mt.parar();
//            tentativas += mt.tentativas;
//        }

//        for (Thread th : mTh) {
//            try {
//                th.join();
//            } catch (InterruptedException ex) {
//                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

        long tempoFinal = System.currentTimeMillis();

        try {
            FileWriter arq = new FileWriter("dados.txt", true);
            PrintWriter gravar = new PrintWriter(arq);
//            gravar.println("Decriptar Mensagem");
//            gravar.println("Texto Encriptado: " + textoEncriptado);
//            gravar.println("Texto Descriptado: " + textoDecriptado);
//            gravar.println("Chave: " + chave);
            gravar.println("Termino: " + new Date(tempoFinal));
            gravar.println("Número de tentativas: " + tentativas);
            gravar.printf("Tempo de execução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
