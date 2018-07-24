package clone;


/**
 * 一定要实现Cloneable接口
 */
public class CloneExample implements Cloneable {

    @Override
    protected CloneExample clone() throws CloneNotSupportedException {
        return (CloneExample)super.clone();
    }

}
