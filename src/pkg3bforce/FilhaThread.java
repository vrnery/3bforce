/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3bforce;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

/**
 *
 * @author vanderson
 */
public class FilhaThread implements Runnable {

    private static final String Algoritmo = "AES";
    public String dicionario;
    public String chave;
    public String textoEncriptado;
    public String textoDecriptado = "";
    public volatile boolean parado = false;
    public long tentativas = 0;
    public long inicio;
    public String controladora;

    public FilhaThread(String dicionario, String chave, String mensagem, long inicio, String controladora) {
        this.dicionario = dicionario;
        this.chave = chave;
        this.textoEncriptado = mensagem;
        this.inicio = inicio;
        this.controladora = controladora;
    }

    @Override
    public void run() {
        try {
            for (int a = 0; a < 62; a++) {
                for (int b = 0; b < 62; b++) {
                    for (int c = 0; c < 62; c++) {
                        for (int d = 0; d < 62; d++) {
                            this.tentativas++;
                            String key = this.chave + this.controladora + this.dicionario.charAt(a) + this.dicionario.charAt(b) + this.dicionario.charAt(c) + this.dicionario.charAt(d);
                            if (this.parado) {
                                try {
                                    System.out.println("Morrendo: " + Thread.currentThread().getName());
                                    Thread.currentThread().wait();
                                } catch (InterruptedException ex) {
                                    //Logger.getLogger(FilhaThread.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                byte[] cod = null;
                                try {
                                    cod = key.getBytes("UTF-8");
                                } catch (UnsupportedEncodingException ex) {
                                    //Logger.getLogger(FilhaThread.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    textoDecriptado = decrypt(textoEncriptado, cod);
                                } catch (Exception ex) {
                                    //Logger.getLogger(FilhaThread.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if ((!textoDecriptado.equals("")) && (!textoDecriptado.contains("�"))) {
                                    try {
                                        this.parado = true;
                                        try {
                                            FileWriter arq = new FileWriter("dados.txt");
                                            PrintWriter gravar = new PrintWriter(arq);
                                            gravar.println("Decriptar Mensagem\n");
                                            gravar.println("Texto Encriptado: " + textoEncriptado + "\n");
                                            gravar.println("Texto Descriptado: " + this.textoDecriptado + "\n");
                                            gravar.println("Chave: " + key);
                                            gravar.println("Inicio: " + new Date(this.inicio));
                                            gravar.println("Parcial (Achou) " + new Date(System.currentTimeMillis()));
                                            arq.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        Thread.currentThread().wait();
                                    } catch (InterruptedException ex) {
                                        //Logger.getLogger(FilhaThread.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                    }

                }
                String key = this.chave + this.dicionario.charAt(a);
                System.out.println("Thread: " + Thread.currentThread().getName() + " Chave: " + key);
            }
        } catch (Exception ex) {

        }
    }

    public void parar() {
        this.parado = true;
    }

    //funcao para gerar key de encriptação a partir da chave do usuário
    private static Key generateKey(byte[] chave) throws Exception {
        Key key = new SecretKeySpec(chave, Algoritmo);
        return key;
    }

    public String encrypt(String texto, byte[] chave) throws Exception {
        Key key = generateKey(chave); //gera a "key" a partir da chave passada pelo usuário
        Cipher c = Cipher.getInstance(Algoritmo); //cria o algortimo de criptografia no modo escolhido, ex:AES
        c.init(Cipher.ENCRYPT_MODE, key);//inicia o algoritmo no modo encriptação com a chave criada
        //System.out.println(c.getAlgorithm());
        byte[] resultadoEncriptado = c.doFinal(texto.getBytes()); //encripta o texto passado
        String teste = new String(resultadoEncriptado);
        System.out.println("isso em binario " + teste);
        String encriptadoEmBase64 = new BASE64Encoder().encode(resultadoEncriptado); //transforma para Base 64 para poder exibir na tela

        return encriptadoEmBase64;
    }

    public String decrypt(String textoEncriptado, byte[] chave) throws Exception {
        Key key = generateKey(chave); //gera a "key" a partir da chave passada pelo usuário
        Cipher c = Cipher.getInstance(Algoritmo); //cria o algortimo de criptografia no modo escolhido, ex:AES
        c.init(Cipher.DECRYPT_MODE, key); //inicia o algoritmo no modo decriptação com a chave criada
        byte[] decodificadoBase64paraByte = new BASE64Decoder().decodeBuffer(textoEncriptado); //transforma de Base 64 para bytes

        byte[] resultadoDecriptado = c.doFinal(decodificadoBase64paraByte); //decripta valor em byte
        String decriptadoEmString = new String(resultadoDecriptado); //passa vetor de bytes decriptados para string
        return decriptadoEmString;
    }
}
