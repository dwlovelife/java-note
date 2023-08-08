package structure.facade;

/**
 * @description: TODO
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 16:14
 */
public class ModuleC {

    /**
     * 提供给子系统外部使用的方法
     */
    public void c1(){};

    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    private void c2(){};
    private void c3(){};

}
