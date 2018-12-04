# spring 学习
## maven-parent
parent maven project with child maven project
* maven相关学习测试；
```
两个常用内置属性 ${basedir} 表示项目跟目录，即包含pom.xml文件的目录；${version} 表示项目版本
用户可以使用该类属性引用POM文件中对应元素的值。如${project.artifactId}就对应了<project> <artifactId>元素的值，常用的POM属性包括：
${project.build.sourceDirectory}:项目的主源码目录，默认为src/main/java/
${project.build.testSourceDirectory}:项目的测试源码目录，默认为src/test/java/
${project.build.directory} ： 项目构建输出目录，默认为target/
${project.outputDirectory} : 项目主代码编译输出目录，默认为target/classes/
${project.testOutputDirectory}：项目测试主代码输出目录，默认为target/testclasses/
${project.groupId}：项目的groupId
${project.artifactId}：项目的artifactId
${project.version}：项目的version,与${version} 等价
${project.build.finalName}：项目打包输出文件的名称，默认为${project.artifactId}-${project.version}
```

## spring hello,world


## spring config配置相关

## spring ioc/aop学习
* ioc:https://zhuanlan.zhihu.com/p/29344811 

## 路由注册与发现--eureka

## 负载均衡--feign/ribbon

## spring的bug复现--spring_frame_test

## spring shell 制作工具


## spring boot和logback结合测试
* 参考：https://github.com/souyunku/SpringBootExamples/tree/master/spring-boot-logback
* https://juejin.im/post/5a1f86f0f265da4326529c61
* traceid的原理详解：https://blog.csdn.net/u013039300/article/details/79577356
* 用法--官网：https://spring.io/projects/spring-cloud-sleuth

## web安全


## spring-kafka学习
* kafka安装-基本测试:https://blog.csdn.net/u010046908/article/details/62229015


## spring性能优化
* undertow替换tomcat