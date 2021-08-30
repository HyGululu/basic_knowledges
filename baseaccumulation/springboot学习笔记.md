二、spring加载应用上下文的五种方式：
1.AnnotationConfigApplicationContext：从一个或多个基于java的配置类中加载spring的上下文；
2.AnnotationConfigWebApplicationContext:从一个或多个基于java的配置类中加载spring web的上下文；
3.ClassPathXmlApplicationContext:从类路径下的一个或多个xml加载spring的上下文；
4.FileSystemXmlapplicationContext:从系统文件中的一个或多个xml加载spring的上下文；
5.XmlWebApplicationContext：基于web的xml架子加载上下文


Spring中常见的bean创建异常
解决这种类型的问题——首先, 确保bean已经声明了
在XML配置文件使用< bean / >元素
或通过@bean注释Java @ configuration类
或注释:@Component,@Repository,@Service,@Controller和类路径是否扫描包中。
同时检查配置文件或类文件是否真的已经被spring装载到上下文中。
加载这些容器的配置文件的xml有一下几种常见的方法：
1：引用资源用XmlBeanFactory（不能实现多个文件相互引用）

Resource resource = new ClassPathResource("appcontext.xml");  
BeanFactory factory = new XmlBeanFactory(resource);

      从factory中获取相应资源文件中的bean，但是这种bean读不到引用了其他文件中的bean！ 
2：引用应用上下文用ClassPathXmlApplicationContext

ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");   
ApplicationContext factory=new ClassPathXmlApplicationContext("conf/userConfig.xml");   // src/conf 目录下的   
ApplicationContext factory=new ClassPathXmlApplicationContext("file:G:/Test/src/appcontext.xml");

3：用文件系统的路径引用应用上下文用FileSystemXmlApplicationContext

ApplicationContext factory=new FileSystemXmlApplicationContext("src/applicationContext.xml");        
ApplicationContext factory=new FileSystemXmlApplicationContext("classpath:appcontext.xml");  
ApplicationContext factory=new FileSystemXmlApplicationContext("file:G:/Test/src/appcontext.xml");  
ApplicationContext factory=new FileSystemXmlApplicationContext("G:/Test/src/appcontext.xml");


使用spring开发时，进行配置主要有两种方式，一是xml的方式，二是java config的方式。

@Autowired 为 Spring 的注解，含义是将某类动态的注入到当前类中
这个注解的功能就是为我们注入一个定义好的bean

@Autowired注解的用法：
将@Autowired注解应用于构造函数
将@Autowired注释应用于setter方法
将@Autowired注释应用于具有任意名称和多个参数的方法
也可以将@Autowired应用于字段，或者将其与构造函数混合
直接应用于字段是我们使用的最多的一种方式，但是使用构造方法注入从代码层面却是更加好的
还有以下不太常见的几种方式
将@Autowired注释添加到需要该类型数组的字段或方法，则spring会从ApplicationContext中搜寻符合指定类型的所有bean

spring注解作用
首先，我们从所属范围来看，事实上这个注解是属于spring的容器配置的一个注解，与它同属容器配置的注解还有：@Required,@Primary, @Qualifier等等。因此@Autowired注解是一个用于容器(container)配置的注解。
其次，我们可以直接从字面意思来看，@autowired注解来源于英文单词autowire,这个单词的意思是自动装配的意思。自动装配又是什么意思？这个词语本来的意思是指的一些工业上的用机器代替人口，自动将一些需要完成的组装任务，或者别的一些任务完成。而在spring的世界当中，自动装配指的就是使用将Spring容器中的bean自动的和我们需要这个bean的类组装在一起。
因此，笔者个人对这个注解的作用下的定义就是:将Spring容器中的bean自动的和我们需要这个bean的类组装在一起协同使用。
接下来，我们就来看一下这个注解背后到底做了些什么工作。
@Autowired注解是如何实现的
事实上，要回答这个问题必须先弄明白的是java是如何支持注解这样一个功能的。
java的注解实现的核心技术是反射，让我们通过一些例子以及自己实现一个注解来理解它工作的原理。
例如注解@Override
@Override注解的定义如下:
@Override注解使用java官方提供的注解，它的定义里面并没有任何的实现逻辑。注意，所有的注解几乎都是这样的，注解只能是被看作元数据，它不包含任何业务逻辑。　注解更像是一个标签，一个声明，表面被注释的这个地方，将具有某种特定的逻辑。
那么，问题接踵而至，注解本身不包含任何逻辑，那么注解的功能是如何实现的呢？答案必然是别的某个地方对这个注解做了实现。以@Override注解为例，他的功能是重写一个方法，而他的实现者就是JVM，java虚拟机，java虚拟机在字节码层面实现了这个功能。
但是对于开发人员，虚拟机的实现是无法控制的东西，也不能用于自定义注解。所以，如果是我们自己想定义一个独一无二的注解的话，则我们需要自己为注解写一个实现逻辑，换言之，我们需要实现自己注解特定逻辑的功能。
自己实现一个注解
在自己写注解之前我们有一些基础知识需要掌握，那就是我们写注解这个功能首先是需要java支持的，java在jdk5当中支持了这一功能，并且在java.lang.annotation包中提供了四个注解，仅用于编写注解时使用，他们是：
我们不妨自己来想一想。首先，我想给标注了这个注解的方法或字段实现功能，我们必须得知道，到底有哪些方法，哪些字段使用了这个注解吧，因此，这里我们很容易想到，这里应该会用到反射。
其次，利用反射，我们利用反射拿到这样目标之后，得为他实现一个逻辑，这个逻辑是这些方法本身逻辑之外的逻辑，这又让我们想起了代理，aop等知识，我们相当于就是在为这些方法做一个增强。事实上的实现主借的逻辑也大概就是这个思路。梳理一下大致步骤如下:
利用反射机制获取一个类的Class对象
通过这个class对象可以去获取他的每一个方法method，或字段Field等等
Method，Field等类提供了类似于getAnnotation的方法来获取这个一个字段的所有注解
拿到注解之后，我们可以判断这个注解是否是我们要实现的注解，如果是则实现注解逻辑
现在我们来实现一下这个逻辑，代码如下:


|                 | @ConfigrationProperties  | @Value       |
| --------------- | ------------------------ | ------------ |
| 功能            | 批量注入配置文件中的属性 | 一个一个指定 |
| 松散绑定RexBind | 支持                     | 不支持       |
| SpEL            | 不支持                   | 支持         |
| JSR303s数据校验 | 支持                     | 不支持       |

如果，只是在业务逻辑中获取一下配置文件的某项值，使用@Value

如果，专门编写了一个javaBean来和配置文件

配置文件yml还是properties都可以获取到值



@PropertySource

@importResource

SpringBoot推荐给容器中添加组件的方式，使用全注解的方式

1、配置类----spring配置文件

@Configuration，指明当前类是个配置类，替代之前Spring配置文件

2、使用@Bean添加组件

在配置文件中用<bean></bean>标签添加组件，这里使用@Bean



配置文件占位符

1、随机数

2、占位符获取之前配置的值，如果没有使用:指定默认值



Profile多环境支持

1、多Profile文件，默认使用application.properties文件

2、yml文件，文档块---

3、激活指定profile

​	在配置文件中指定 spring.

​    命令行

​	虚拟机参数 VM 



6、配置文件加载位置

-file：/config/

-file:/

-classpath:/config/

-classpath:/

优先级由高到低，高优先级覆盖低优先级的配置

SpringBoot会从这四个位置全部加载主配置文件：互补配置



spring.config.location 改变配置文件位置，项目打包好以后，使用命令行参数形式，启动项目时来指定配置文件的新位置，也是互补配置

7、外部配置加载顺序

1、命令行参数



8、springboot自动配置原理

boot-autoconfiguration包下，的spring-factories下自动配置类

1）开启自动配置功能@EnableAutoConfiguration

/MET

3）每一个自动配置类进行自动配置功能

4）@Configuration 配置类，可以给容器添加组件

@EnableConfigurationProperties  启动指定类

@ConfigurationProperties 从配置文件中获取指定的值和bean属性进行指定

@ConditionOnWebApplication  @Condition 判断当前应用是否是web应用



@Bean 给容器中添加一个组件，这个组件的某些值需要从Properties中获取



1）Springboot启动会加载大量的自动配置类

2）看需要的功能有没有springboot默认写好的自动配置类

3）自动配置类中配置了哪些组件，有没有需要的组件，没有再配置

4）给容器中自动配置类添加组件，会从Properties类中获取属性，可以在配置文件中指定这些属性值

xxxAutoConfiguration：自动配置类

给容器中添加组件

xxxProperties：封装配置文件相关属性



细节

1、@Condition派生注解（Spring原生注解@Condition）

作用：必须是@Condition指定的条件成立，才给容器中添加组件，配置里的所有内容才生效

自动配置类需要在一定条件下才能生效



怎么知道哪些自动配置类生效了，

在配置文件中，开启SpringBoot的debug

debug=true ，让控制台打印自动配置报告



# 三、SpringBoot与日志

## 1、日志框架

异步模式、自动归档（功能）

JDBC-数据库驱动，统一的接口层（日志的一个抽象层）

市面上的日志框架：

JUL、JCL、JBoss-logging、logback、log4j、log4j2、slf4j

日志门面：SEL4j

日志实现：Logback



SpringBoot：底层是Spring框架，Spring框架默认是用JCL

SpringBoot选用 SEL4j和logback



# SpringBoot web开发

## 静态资源导入

```java
WebMvcAutoConfiguration.addResourceHandlers
webjars
classpath:/META-INF/resources/webjars/
welcomePageHandlerMapping
```

## 首页和图标定制

## 模板引擎

Thymeleaf

Thymeleaf语法

## MVC配置原理