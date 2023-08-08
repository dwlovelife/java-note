package structure.facade;

/**
 * @description: 门面层
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 16:14
 */
public class ModuleFacade {

    ModuleA a = new ModuleA();
    ModuleB b = new ModuleB();
    ModuleC c = new ModuleC();
    /**
     * 下面这些是A、B、C模块对子系统外部提供的方法
     */
    public void a1(){
        a.a1();
    }
    public void b1(){
        b.b1();
    }
    public void c1(){
        c.c1();
    }

}
