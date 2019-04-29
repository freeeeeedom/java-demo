package demo.design.SingletonPattern;

/**
 * @Description: 登记模式 内部静态类单例
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：一般
 * @Date: 2019/4/25 14:50
 */
class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/**
 * @Description: 懒汉模式
 * 是否 Lazy 初始化：是
 * 是否多线程安全：否
 * 实现难度：易
 * @Date: 2019/4/25 14:40
 */
class SlackerMode {
    private static SlackerMode instance;

    private SlackerMode() {
    }

    public static SlackerMode getInstance() {
        if (instance == null) {
            instance = new SlackerMode();
        }
        return instance;
    }
}

/**
 * @Description: 懒汉模式线程安全
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：易
 * @Date: 2019/4/25 14:40
 */
class SlackerModeThreadSafety {
    private static SlackerModeThreadSafety instance;

    private SlackerModeThreadSafety() {
    }

    public static synchronized SlackerModeThreadSafety getInstance() {
        if (instance == null) {
            instance = new SlackerModeThreadSafety();
        }
        return instance;
    }
}

/**
 * @Description: 饿汉模式
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 实现难度：易
 * @Date: 2019/4/25 14:45
 */
class StarvingModel {
    private static StarvingModel instance = new StarvingModel();

    private StarvingModel() {
    }

    public static StarvingModel getInstance() {
        return instance;
    }
}

/**
 * @Description: 懒汉 dcl模式 双重检索
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * @Date: 2019/4/25 14:47
 */
class DoubleCheckedLocking {
    private volatile static DoubleCheckedLocking singleton;

    private DoubleCheckedLocking() {
    }

    public static DoubleCheckedLocking getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckedLocking();
                }
            }
        }
        return singleton;
    }
}

/**
 * @Description: 枚举
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 实现难度：易
 * @Date: 2019/4/25 14:48
 */
enum SingletonEnum {
    INSTANCE;

    SingletonEnum() {

    }

    public void whateverMethod() {
        //do something...
    }
}
