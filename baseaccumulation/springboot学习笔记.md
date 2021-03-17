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