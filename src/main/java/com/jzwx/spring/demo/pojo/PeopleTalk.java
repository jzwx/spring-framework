package main.java.com.jzwx.spring.demo.pojo;

import main.java.com.jzwx.spring.demo.service.impl.ITalk;

/**
 * @Author:jzwx
 * @Desicription: PeopleTalk
 * @Date:Created in 2018-08-31 15:29
 * @Modified By:
 */
public class PeopleTalk implements ITalk {
    public String username;
    public String age;

    public PeopleTalk(){

    }

    public PeopleTalk(String username, String age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public void talk(String msg) {
        System.out.println(msg + "!你好,我是" + username + "，我年龄是" + age);
    }
}
