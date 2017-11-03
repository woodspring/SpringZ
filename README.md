# SpringZ
---
server:
  port: 5832
  contextPath: /SpringZ
---
spring:
  profiles: local, default
datasource:
  woodspring:
      url: jdbc:mysql://localhost:3306/TORONTO?autoReconnect=true&useSSL=false
      username: root
      password: 87mosedale
      driverClassName: com.mysql.jdbc.Driver
      defaultSchema:
      maxPoolSize: 20
      hibernate:
         dialect: org.hibernate.dialect.MySQL5Dialect
         hbm2ddl.method: update
         show_sql: true
         format_sql: true
      jpa:
         database: MYSQL
         database-platform: org.hibernate.dialect.MySQL5Dialect
         hibernate:
            ddl-auto: update
         properties:
            hibernate:
               hibenate.dialect: org.hibernate.dialect.MySQL5Dialect
               show_sql: true
               use_sql_comments: true
               format_sql: true
               hbm2ddl:
                      method: update
                      import_files: 
---
spring:
  profiles: develop
datasource:
  woodspring:
      url: jdbc:h2:~/test
      username: SA
      password:
      driverClassName: org.h2.Driver
      defaultSchema:
      maxPoolSize: 10
      console:
          enabled: true
          path: /console
          settings:
              trace: false
          web-allow-others: false
      hibernate:
          hbm2ddl.method: create
          show_sql: true
          format_sql: true
          dialect: org.hibernate.dialect.H2Dialect       
 
