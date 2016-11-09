/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3bforce;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

/**
 *
 * @author vanderson
 */
public class BruteForce implements Runnable {

    private static final String Algoritmo = "AES";
    
    public String dicionario;
    public String textoEncriptado;
    public String chave = "";
    public int nInicio;
    public int nFinal;
    public volatile int tentativas = 0;
    public volatile boolean finalizado = false;
    public volatile String textoDecriptado = "";

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public int getTentativas() {
        return tentativas;
    }

    public BruteForce(String dic, String texto, int nInicio, int nFinal) {
        this.dicionario = dic;
        this.textoEncriptado = texto;
        this.nInicio = nInicio;
        this.nFinal = nFinal;
    }

    @Override
    public void run() {
        try {
            force(nInicio, nFinal);
        } catch (Exception ex) {
            //System.out.println("Exeção " + Thread.currentThread().getName());
        }
    }

    public void force(int inicio, int fim) {
        for (int k = inicio; k < fim; k++) {
            for (int l = 0; l < dicionario.length(); l++) {
                for (int m = 0; m < dicionario.length(); m++) {
                    for (int n = 0; n < dicionario.length(); n++) {
                        for (int o = 0; o < dicionario.length(); o++) {
                            for (int p = 0; p < dicionario.length(); p++) {
                                for (int q = 0; q < dicionario.length(); q++) {
                                    for (int r = 0; r < dicionario.length(); r++) {
                                        for (int s = 0; s < dicionario.length(); s++) {
                                            for (int t = 0; t < dicionario.length(); t++) {
                                                for (int u = inicio; u < fim; u++) {
//                                                for (int u = 0; u < dicionario.length(); u++) {
                                                    for (int v = 0; v < dicionario.length(); v++) {
                                                        for (int w = 0; w < dicionario.length(); w++) {
                                                            for (int x = 0; x < dicionario.length(); x++) {
                                                                for (int y = 0; y < dicionario.length(); y++) {
                                                                    for (int z = 0; z < dicionario.length(); z++) {
//                                                                        this.chave = dicionario.charAt(k) + ""
//                                                                                + dicionario.charAt(l) + ""
//                                                                                + dicionario.charAt(m) + ""
//                                                                                + dicionario.charAt(n) + ""
//                                                                                + dicionario.charAt(o) + ""
//                                                                                + dicionario.charAt(p) + ""
//                                                                                + dicionario.charAt(q) + ""
//                                                                                + dicionario.charAt(r) + ""
//                                                                                + dicionario.charAt(s) + ""
//                                                                                + dicionario.charAt(t) + ""
                                                                        this.chave = "12pingpong"                
                                                                                + dicionario.charAt(u) + ""
                                                                                + dicionario.charAt(v) + ""
                                                                                + dicionario.charAt(w) + ""
                                                                                + dicionario.charAt(x) + ""
                                                                                + dicionario.charAt(y) + ""
                                                                                + dicionario.charAt(z);
                                                                        this.tentativas++;
                                                                            //System.out.println("Chave: " + String.copyValueOf(this.chave));
                                                                        byte[] cod = null;
                                                                        try {
                                                                            cod = this.chave.getBytes("UTF-8");
                                                                        } catch (UnsupportedEncodingException ex) {
                                                                            //Logger.getLogger(BruteForce.class.getName()).log(Level.SEVERE, null, ex);
                                                                        }
                                                                        try {
                                                                            textoDecriptado = decrypt(textoEncriptado, cod);
                                                                        } catch (Exception ex) {
                                                                            //Logger.getLogger(BruteForce.class.getName()).log(Level.SEVERE, null, ex);
                                                                        }
                                                                        if ((!textoDecriptado.equals("")) && (textoDecriptado.contains("teste"))) {
                                                                            this.finalizado = true;
                                                                            try {
                                                                                Thread.currentThread().wait();
                                                                            } catch (InterruptedException ex) {
                                                                                //Logger.getLogger(BruteForce.class.getName()).log(Level.SEVERE, null, ex);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.finalizado = true;
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
    
    public void pausa() {
        try {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException ex) {
                //Logger.getLogger(BruteForce.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IllegalMonitorStateException exs) {
            
        }
    }
}
