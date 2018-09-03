package main.java.com.jzwx.spring.demo.pojo;

/**
 * @Author:jzwx
 * @Desicription: PeopleTalkAop
 * @Date:Created in 2018-08-31 16:46
 * @Modified By:
 */
public class PeopleTalkAop {
    public void talk(String msg) {
        System.out.println("people talk" + msg);
    }

    public void spreak(String msg){
        System.out.println("spreak chinese"+msg);
    }
}
