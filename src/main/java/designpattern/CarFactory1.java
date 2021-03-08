package designpattern;

/**
 * 工厂方法模式
 *
 * 简单工厂模式vs工厂方法模式
 * 结构复杂度：simple
 * 代码复杂度：simple
 * 客户端编程复杂度：simple
 * 管理复杂度：simple
 *
 * 根据设计原则，要使用工厂方法模式
 * 根据实际业务，多数使用简单工厂模式
 */
public interface CarFactory1 {
    Car1 getCar();
}
