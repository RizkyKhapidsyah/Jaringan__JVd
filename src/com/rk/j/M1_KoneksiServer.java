package com.rk.j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class M1_KoneksiServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client;

        try {
            server = new ServerSocket(1234);
            //1234 adalah nomor port yang tidak terpakai
        } catch (IOException ie) {
            System.out.println("Tidak dapat membuka Soket");
            System.exit(1);
        }

        while (true) {
            try {
                client = server.accept();
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                pw.println(br.readLine());
            } catch (IOException ie) {
                System.out.println(ie);
            }
        }

    }
}
