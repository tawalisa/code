package com.lijia.code;

import java.io.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
 
   private String message;
   static AtomicInteger i  = new AtomicInteger(0);

   public void init() throws ServletException {
      // Do required initialization
      message = "Hello World";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      int currentI = i.getAndIncrement();
      System.out.println(new Date()+ "++++++++++" + currentI);

//      try {
//         Thread.sleep(1000 * 60 * 60);
//      } catch (InterruptedException e) {
//         e.printStackTrace();
//      }

      System.out.println(new Date()+ "-------------" + currentI);
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      int i = 0;
      while(true){
         try {
            Thread.sleep(100 );
            out.println(""+i++);
            out.flush();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }

   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      super.doGet(req, resp);
   }

   public void destroy() {
      // do nothing.
   }

   public static void main(String[] args) {
      System.out.println(123);
   }
}