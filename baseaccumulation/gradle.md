
Gradle目录结构
├── build.gradle  ❶
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar    ➋
│       └── gradle-wrapper.properties  ➌
├── gradlew    ➍
├── gradlew.bat  ➎
└── settings.gradle  ➏
❶ 当前项目的配置脚本
➋ Gradle Wrapper 的执行jar包（后续介绍）
➌ Gradle Wrapper 的配置文件
➍ Gradle Wrapper Unix 系执行脚本
➎ Gradle Wrapper Windows 系执行脚本
➏ 项目脚本设置

gradle插件仓库：
https://plugins.gradle.org/m2/

修改根目录(root project)的settings.gradle来添加其它仓库

依赖管理
和 Maven 类似，Gradle 也会将依赖缓冲在本地中，方便在无网的环境使用，和依赖管理相关的有两个参数，举个例子。
repositories { mavenCentral()// 定义仓库 }
dependencies { compile 'org.springframework:spring-web:5.0.2.RELEASE' // 定义依赖 }

Gradle支持以下仓库格式：
Ivy仓库（通过URL地址或本地文件系统地址，将Ivy仓库加入到我们的构建中）
Maven仓库
（加入Maven仓库时，Gradle提供了三种“别名”供我们使用，它们分别是
mavenCentral()别名，表示依赖是从Central Maven 2 仓库中获取的。
jcenter()别名，表示依赖是从Bintary’s JCenter Maven 仓库中获取的。
mavenLocal()别名，表示依赖是从本地的Maven仓库中获取的。）
Flat directory仓库

声明项目依赖
最普遍的依赖称为外部依赖，这些依赖存放在外部仓库中。一个外部依赖可以由以下属性指定：
group属性指定依赖的分组（在Maven中，就是groupId）
name属性指定依赖的名称（在Maven中，就是artifactId）
version属性指定外部依赖的版本（在Maven中，就是version）

Gradle常用指令
枚列所有可用任务(gradle tasks)
构建配置属性（gradle properties）
显示构建详情(gradle build -- stacktrace )
    或者 build.gradle配置文件中配置logging . level = LogLevel . DEBUG
