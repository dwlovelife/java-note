package structure.decorator.example2;

/**
 * @description: 人
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 15:14
 */
public class Man {

    private String name;


    public Man(){

    }

    public Man(String name) {
        this.name = name;
    }

    public void dress() {
        System.out.println("装扮的" + name);
    }

}
