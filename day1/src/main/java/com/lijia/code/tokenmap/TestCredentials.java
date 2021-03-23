package com.lijia.code.tokenmap;

import com.google.common.base.Supplier;

public class TestCredentials {
//    public static void main(String[] args) {
//        TokenMap<Credentials> tokenMap = new TokenMap();
//        for( int i = 0; i < 10; i++){
//            int finalI = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while(true){
//                        CredentialsWrapper<Credentials> c = tokenMap.get("a");
//                        if(c == null || c.getT().get().isExpried()){
//                            c = tokenMap.put("a", ()->{
//                                System.out.println(finalI +"start create ");
//                                try {
//                                    Thread.sleep(1000L);
//                                } catch (InterruptedException e) {
//                                }
//                                System.out.println(finalI +"end create ");
//                                return new Credentials(finalI+"");
//                            }, c);
//                        }
//                        System.out.println(finalI +"==>"+ c.getT());
//                        try {
//                            Thread.sleep(500L);
//                        } catch (InterruptedException e) {
//                        }
//                    }
//
//                }
//            }).start();
//        }
//    }
}
