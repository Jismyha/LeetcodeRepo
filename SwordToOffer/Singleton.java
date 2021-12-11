package SwordToOffer;

/**
 * 剑指 offer 2.java单例模式
 * 
 * @author KureNaii
 * @since 2021-09-11 13:55:57
 */
public class Singleton {
    // 主要有四种实现方式：
    // 饿汉式、懒汉式、双检锁、静态内部类实现

    // 此处给出静态内部类实现

    // 构造函数私有化，防止外部new
    private Singleton() {
    };

    // 使用静态内部类实现懒加载和线程安全（基于jvm类加载策略）
    private static class SingletonInstance {
        private static Singleton INCETENCE = new Singleton();
    }

    // 提供外部访问方法
    public static Singleton getInstence() {
        return SingletonInstance.INCETENCE;
    }

}