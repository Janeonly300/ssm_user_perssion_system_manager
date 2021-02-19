# SSM详细整合教程
> 因为XML+注解方式实现更加方便，所以我门选用它

[TOC]
## 一、整合思路
1. 先将搭建Web开发的总体三层目录结构
2. 编写Spring框架
3. 编写SpringMvc框架
4. Spring与Mvc整合
5. 编写Mybatis框架
6. Spring与Mbatis整合
## 二、整合步骤
### 0. 前期准备引入Jar包与Web目录创建
```java
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <spring.version>5.2.2.RELEASE</spring.version>
    <slf4j.version>1.6.6</slf4j.version>
    <mysql.version>5.1.6</mysql.version>
    <mybatis.version>3.4.5</mybatis.version>
  </properties>

  <dependencies>
	  
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.2</version>
    </dependency>

    <!-- Spring   -->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>1.6.8</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>${mysql.version}</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.0</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>

    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>1.2.17</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>${slf4j.version}</version>
    </dependency>

    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-nop</artifactId>
      <version>${slf4j.version}</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${mybatis.version}</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.3.0</version>
    </dependency>

    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.2.4</version>
    </dependency>

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.9.5</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.5</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.9.5</version>
    </dependency>
  </dependencies>
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210208142235520.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0phbnlpXw==,size_16,color_FFFFFF,t_70)

### 1. Spring框架编写
#### 1.1 创建Application配置文件
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210208142948674.png)


- 因为Controller后续会交给SpringMvc管理，所以我们这的配置文件不需要管理Controller注解
- > 关于为什么要向这样做，我们最后做解释:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx
        https://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
<!-- 注解扫描，忽略Controller   -->
    <context:component-scan base-package="com.atjianyi">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
```

### 2. SpringMvc框架编写
#### 2.1 创建Springmvc-config文件
	- 同样在resources目录下
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210208143259397.png)-  编写Springmvc配置文件
> 关于SpringMvc，我们只需要管理controller就可以了，所以配置注解包扫描时候，只需要关注Controller注即可。
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spri ng-context.xsd
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc.xsd">
<!-- 配置注解扫描   -->
    <context:component-scan base-package="com.atjianyi">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>

<!--  配置视图解析器  -->
    <bean id="is" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/pages/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
<!--  静态资源过滤  -->
    <mvc:resources mapping="/js/**" location="/js/"/>
    <mvc:resources mapping="/css/**" location="/css/"/>
    <mvc:resources mapping="/img/**" location="/img/"/>
<!-- 支持Springmvc框架   -->
    <mvc:annotation-driven/>
</beans>
```
#### 2. 2 配置前端控制器
```xml
<!-- Spring Mvc start前端控制器 -->
  <servlet>
    <servlet-name>springmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springmvc-config.xml</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
<filter>
  <filter-name>charsetFilter</filter-name>
  <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  <init-param>
    <param-name>encoding</param-name>
    <param-value>UTF-8</param-value>
  </init-param>
</filter>
  <filter-mapping>
    <filter-name>charsetFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
<!-- SpringMvc end -->
```
### 3. Spring与SpringMvc整合
#### 3.1 Spring与SpringMvc整合说明
> 当我们的服务器启动时候，我们需要服务器去帮助我们创建IOC容器，也就是需要去加载我们的applicationContext配置文件。

#### 3.2 Spring与SpringMvc整合思路
- ServletContext域对象
	- 服务器启动时候，就创建，服务器关闭，就执行销毁
- 一类监听器
	- 能监听ServletContext域对象的创建和销毁
- ContextLoadListen.对象
#### 3.3 在webXML中注册监听并且去加载Spring配置文件
```xml
<!-- Spring -->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
<!-- Spring End -->
```
> 默认他会去WEB-INF目录下找applicationContext.xml文件，但是我们的配置文件同一在resources下管理，所以我们使用context-param去更改。
### 4. Mybatis框架编写
> 直接跳过，看5.因为我们Spring与Mybatis整合，Mybatis将其中的SqlSeesionFactory对象，连接池对象等。同一交给Spring去管理就行，省去了我们手动编写环境标签的步骤..
### 5.  Spring与Mybatis框架整合
#### 5. 1. 创建Mybatis-config的配置文件。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210208144921545.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0phbnlpXw==,size_16,color_FFFFFF,t_70)
##### 5.1.1 编写mybatis-config配置文件配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
        <package name="com.atjianyi.domain"/>
    </typeAliases>
    <!--与Spring整合，我们无需去编写环境，甚至将mapper都交给了Spring-->
</configuration>    
```
#### 5.2 applciationContext.xml文件新增配置
```xml
<!--Mybatis-->
<!--  配置连接池  -->
<!-- 我们目前使用的druid数据库连接池，此处可以根据不同数据库连接池而定   -->
<bean id="ds" class="com.alibaba.druid.pool.DruidDataSourceFactory" factory-method="createDataSource">
    <constructor-arg name="properties">
        <props>
            <prop key="url">jdbc:mysql://localhost:3306/ssmbuild</prop>
            <prop key="driverClassName">com.mysql.jdbc.Driver</prop>
            <prop key="username">root</prop>
            <prop key="password">root</prop>
        </props>
    </constructor-arg>
</bean>
<!--  配置SqlSession工厂  -->
   <bean class="org.mybatis.spring.SqlSessionFactoryBean">
       <property name="dataSource" ref="ds"/>
   </bean>
<!--  配置包扫描  -->
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="com.atjianyi.dao"/>
</bean>
```


