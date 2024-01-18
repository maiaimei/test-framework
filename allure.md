# Allure

[Allure](https://allurereport.org/)是一个开源的测试报告框架。

Allure生成测试报告分两步：

1. 收集测试结果数据。Allure适配器保存测试执行信息到XML文件中。其适配器支持与Java、Python等语言中流行的测试框架集成。对于Java而言，Allure可与JUnit4、JUnit5、Cucumber JVM集成。
2. 生成测试报告。通过命令行工具、CI插件或构建工具将XML文件转换为HTML测试报告。

## 安装Allure

[https://allurereport.org/docs/gettingstarted-installation/](https://allurereport.org/docs/gettingstarted-installation/)

## 收集测试结果数据

Allure JUnit 5：[https://allurereport.org/docs/junit5/](https://allurereport.org/docs/junit5/)

执行测试用例

```shell
# 执行所有符合条件的测试用例
mvn test

# 执行某个class文件
mvn test -Dtest=xxxx
mvn clean test -Dtest=UserServiceTest
```

## 生成测试报告

### 使用命令行工具生成测试报告

allure 常用命令

```shell
allure --help 帮助
allure --version 查看版本信息  
allure serve 生成在线版本的测试
allure generate <allure-result中间文件> -o 输出目录 (默认路径：allure-report)
```

```shell
cd target
allure serve allure-results
```

使用以上命令生成并打开测试报告时，Allure会默认使用Jetty作为服务器，并使用默认浏览器打开测试报告。