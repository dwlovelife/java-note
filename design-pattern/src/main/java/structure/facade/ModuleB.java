package structure.facade;

/**
 * @description: 模式B
 * @author: dingwei17@jd.com
 * @date : 2023/8/8 16:13
 */
public class ModuleB {

    /**
     * 提供给子系统外部使用的方法
     */
    public void b1(){};

    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    private void b2(){};
    private void b3(){};

}
