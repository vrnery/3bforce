/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3bforce;

import java.util.ArrayList;
import java.util.List;

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
    public long parcial = 0;

    public MaeThread(String dicionario, String character, String mensagem) {
        this.dicionario = dicionario;
        this.chave = character;
        this.textoEncriptado = mensagem;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 62; i++) {
                this.filhaThread.add(new FilhaThread(this.dicionario, (this.chave + this.dicionario.charAt(i)), this.textoEncriptado));
                this.fTh.add(new Thread(filhaThread.get(i)));
                this.fTh.get(i).start();
            }

            while (!this.parado) {
                for (FilhaThread ft : this.filhaThread) {
                    if (this.parado) {
                        System.out.println("Morrendo M: " + Thread.currentThread().getName());
                        break;
                    } else {
                        if (ft.parado) {
                            this.parcial = ft.parcial;
                            this.chave = ft.chave;
                            this.textoDecriptado = ft.textoDecriptado;
                            this.tentativas += ft.tentativas;
                            this.parado = true;
                            this.filhaThread.remove(ft);
                            break;
                        }
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
