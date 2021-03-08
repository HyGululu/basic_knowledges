责任链模式 chain of responsibility
    23种设计模式之一

    使很多对象都有机会处理请求
    
    一个抽象处理类和它的一组实现类组成
    
    抽象处理类两个方法：
        1、nextHandler（）指向下一个处理类的成员变量
        2、handlerRequest（）处理请求的方法
    
    "灵活版的if……else……"