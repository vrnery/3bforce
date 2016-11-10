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
 * @author 10070124
 */
public class MaeThread implements Runnable {

    public List<Thread> fTh = new ArrayList<Thread>();
    public List<FilhaThread> filhaThread = new ArrayList<FilhaThread>();

    public String dicionario;
    public String chave;
    public String textoEncriptado;
    public String textoDecriptado = "";
    public volatile boolean parado = false;
    public long tentativas = 0;
    public long inicio;

    public MaeThread(String dicionario, String character, String mensagem, long inicio) {
        this.dicionario = dicionario;
        this.chave = character;
        this.textoEncriptado = mensagem;
        this.inicio = inicio;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 62; i++) {
                this.filhaThread.add(new FilhaThread(this.dicionario, this.chave, this.textoEncriptado, this.inicio, (this.dicionario.charAt(i) + "")));
                this.fTh.add(new Thread(filhaThread.get(i)));
                this.fTh.get(i).start();
            }

            while (!this.parado) {
                for (FilhaThread ft : this.filhaThread) {
                    if (ft.parado) {
                        this.tentativas += ft.tentativas;
                        this.parado = true;
                        this.filhaThread.remove(ft);
                        break;
                    }
                }
            }

            finalizando();
        } catch (Exception ex) {

        }
    }

    public void parar() {
        finalizando();
        this.parado = true;
    }

    public void finalizando() {
        for (FilhaThread ft : this.filhaThread) {
            ft.parar();
            this.tentativas += ft.tentativas;
        }

        for (Thread th : this.fTh) {
            try {
                th.join();
            } catch (InterruptedException ex) {
                //Logger.getLogger(MaeThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
