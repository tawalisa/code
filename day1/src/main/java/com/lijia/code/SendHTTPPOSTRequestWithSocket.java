package com.lijia.code;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class SendHTTPPOSTRequestWithSocket {
     
    public static void main(String[] args) throws InterruptedException {
         
        try {
             
//            String params = URLEncoder.encode("param1", "UTF-8")
//+ "=" + URLEncoder.encode("value1", "UTF-8");
//            params += "&" + URLEncoder.encode("param2", "UTF-8")
//+ "=" + URLEncoder.encode("value2", "UTF-8");
//            String body = "{\"query\":\"{\\n  OrganizationReference(objectIds: [\\\"4295863589\\\"]) {\\n    Names {\\n      Name {\\n        OrganizationName {\\n          OrganizationName\\n        }\\n      }\\n    }\\n  }\\n}\",\"variables\":null}";
//
            String hostname = "localhost";
            int port = 8080;
             
            InetAddress addr = InetAddress.getByName(hostname);
//            Socket socket = new Socket(addr, port);
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(hostname, port), 1000* 10);
            String path = "/info/test";
//            socket.setSoTimeout(1);
            socket.setSoLinger(true, 0);
            // Send headers
            System.out.println("===================");
            BufferedWriter wr =
     new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
            String stream = "GET /test HTTP/1.1\r\n" +
                    "Host: localhost:8080\r\n" +
                    "Accept-Language: en-US,en;q=0.5\r\n" +
                    "Accept-Encoding: gzip, deflate\r\n" +
                    "Content-Type: application/json\r\n" +
                    "Connection: keep-alive\r\n\r\n" +
                    "1";
            wr.write(stream);
//            wr.write("POST "+path+" HTT;/1.0rn");
//            wr.write("Content-Length: "+params.length()+"rn");
//            wr.write("Content-Type: application/json");
//            wr.write("rn");
 
            // Send parameters
//            wr.write(body);
            wr.flush();
//            Thread.sleep(100);
//
//            socket.close();
//            socket.close();
//            System.exit(0);
            // Get response
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
//            socket.close();
//            System.exit(0);
//            socket.close();
             int i = 0;
            while ((line = rd.readLine()) != null) {
                socket.close();
//                System.exit(0);


                System.out.println(line);
//                i++;
//                if(i > 10000){
//                    socket.close();
//
//                }
            }
             
            wr.close();
            rd.close();
             
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        Thread.sleep(1000 * 80);
         
    }
 
}