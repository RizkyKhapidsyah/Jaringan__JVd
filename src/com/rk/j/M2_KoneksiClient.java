package com.rk.j;

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class M2_KoneksiClient {
    public static void main(String[] args) {
        try {
            //Socket Client = new Socket("133.0.0.1", 1234);
            Socket client = new Socket(InetAddress.getLocalHost(), 1234);
            InputStream clientIn = client.getInputStream();
            OutputStream clientOut = client.getOutputStream();
            PrintWriter pw = new PrintWriter(clientOut, true);
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Type a message for the server: ");
            pw.println(stdIn.readLine());
            System.out.println("Server message: ");
            System.out.println(br.readLine());
            pw.close();
            br.close();
            client.close();
        } catch (ConnectException | UnknownHostException ce) {
            System.out.println("Tidak dapat terhubung ke server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
