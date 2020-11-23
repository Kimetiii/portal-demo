###一 、 启动本地环境
####1. 配置jdk 1.8

####2. 配置maven，可以使用阿里镜像

  ```
  <mirror>
  
  	  <id>alimaven</id>
  
  	  <name>aliyun maven</name>      
  
  	  <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
  
  	  <mirrorOf>central</mirrorOf>
  
  </mirror>
  
  ```
####3. 配置node
    本地安装node环境 用于 npm 的相关命令启动

####4. 配置数据库，dev.yml文件中引入本地数据库

   ```
     datasource:
       druid:
         url: jdbc:mysql://localhost:3306/daily?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
         username: root
         password: 123456
         driver-class-name: com.mysql.jdbc.Driver
   ```

   

####5. install 前台工程

   ```
   npm  install
   ```

####6. 启动前后台

####7. 使用域名访问本地项目 需要修改host文件 hosts文件加入下面代码

   ```
   127.0.0.1 dut.portal.com
   ```
####8. 配置一下drools规则文件路径

   ```
     D:\_Temp 默认放在这里
   ```
###二 、 drools 规则文件逻辑梳理
#### 1. pom文件引入 drools 第三方整理坐标 可以直接调用现成的 api
   ```
        <dependency>
            <groupId>com.github.hongwen1993</groupId>
            <artifactId>fast-drools-spring-boot-starter</artifactId>
            <version>7.37.0.Final</version>
        </dependency>

        <dependency>
            <groupId>org.drools</groupId>
            <artifactId>drools-core</artifactId>
            <version>7.6.0.Final</version>
        </dependency>
        <dependency>
            <groupId>org.drools</groupId>
            <artifactId>drools-compiler</artifactId>
            <version>7.6.0.Final</version>
        </dependency>
        <dependency>
            <groupId>org.drools</groupId>
            <artifactId>drools-templates</artifactId>
            <version>7.6.0.Final</version>
        </dependency>
        <dependency>
            <groupId>org.kie</groupId>
            <artifactId>kie-api</artifactId>
            <version>7.6.0.Final</version>
        </dependency>
   ```
#### 2. 编写 drools 文件模板
        文件路径：portal-back/src/main/resources/demo-rule-template.drt
        模板文件用于生成规则文件 语法为 drools 规则文件语法
        @{} 用于引入变量
