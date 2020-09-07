###启动本地环境
1. 配置jdk 1.8

2. 配置maven，可以使用阿里镜像

  ```
  <mirror>
  
  	  <id>alimaven</id>
  
  	  <name>aliyun maven</name>      
  
  	  <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
  
  	  <mirrorOf>central</mirrorOf>
  
  </mirror>
  
  ```

  

3. 配置node

4. 配置数据库，dev.yml文件中引入本地数据库

   ```
     datasource:
       druid:
         url: jdbc:mysql://localhost:3306/daily?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
         username: root
         password: 123456
         driver-class-name: com.mysql.jdbc.Driver
   ```

   

5. install 前台工程

   ```
   npm  install
   ```

6. 启动前后台

7. 使用域名访问本地项目 需要修改host文件 hosts文件加入下面代码

   ```
   127.0.0.1 dut.portal.com
   ```
8. 配置一下drools规则文件路径

   ```
     D:\_Temp 默认放在这里
   ```