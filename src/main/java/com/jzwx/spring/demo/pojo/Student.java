package main.java.com.jzwx.spring.demo.pojo;

/**
 * @Author:jzwx
 * @Desicription: Student
 * @Date:Created in 2018-08-31 10:33
 * @Modified By:
 */
public class Student {
    private String name;
    private String add;

    public void selfIntroDuction(){
        System.out.println("我的姓名: " + name + " 我来自: " + add);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
