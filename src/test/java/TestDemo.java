import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhaoqi
 * @version 1.8
 */
public class TestDemo implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
