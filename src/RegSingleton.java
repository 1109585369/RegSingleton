import java.util.HashMap;

public class RegSingleton {

    static private HashMap registry = new HashMap();

    static {
        RegSingleton regSingleton = new RegSingleton();
        registry.put(regSingleton.getClass().getName(),regSingleton);
    }

    //受保护的默认构造函数,如果为继承关系,则可以调用,克服了单例类不能继承的缺点
    protected RegSingleton() {

    }

    //静态工厂方法,返回此类的唯一实例
    public static RegSingleton getInstance(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(name == null){
            name = "RegSingleton";
        }if(registry.get(name) == null){
         registry.put(name,Class.forName(name).newInstance());
        }
        return (RegSingleton) registry.get(name);
    }
}
