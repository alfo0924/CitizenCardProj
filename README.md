

# tizenCardProj市民卡 | 系統架構

## 前端架構 (Vue.js + Bootstrap)

### 主要功能模塊

1. **會員管理**
   - 註冊頁面
   - 登入頁面
   - 個人資料管理頁面

2. **CityMovie 功能**
   - 電影列表頁面
   - 場次選擇頁面
   - 座位預訂頁面
   - 訂單確認頁面

3. **好康優惠**
   - 優惠列表頁面
   - 優惠詳情頁面
   - 優惠使用頁面

4. **電子錢包**
   - 餘額查詢頁面
   - 儲值頁面
   - 交易記錄頁面

### 技術棧

- Vue.js 3
- Bootstrap 5
- Axios (用於 API 請求)
- Vuex (狀態管理)
- Vue Router (路由管理)

## 後端架構 (Java JDK 17 + Spring Boot)

### 主要模塊

1. **會員管理模塊**
   - 註冊服務
   - 登入服務
   - 個人資料更新服務

2. **CityMovie 模塊**
   - 電影管理服務
   - 場地管理服務
   - 訂位服務

3. **優惠管理模塊**
   - 優惠創建和管理服務
   - 優惠使用服務

4. **電子錢包模塊**
   - 餘額管理服務
   - 交易服務

### 技術棧

- Java JDK 17
- Spring Boot 2.7.14
- Spring Data JPA
- Spring Security
- MariaDB (數據庫)
- JWT (用於身份驗證)
- Lombok (簡化 Java 代碼)

### 主要依賴

```xml
<dependencies>
    <!-- Spring Boot Starters -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

    <!-- MariaDB Java Client -->
    <dependency>
        <groupId>org.mariadb.jdbc</groupId>
        <artifactId>mariadb-java-client</artifactId>
        <version>3.1.4</version>
    </dependency>

    <!-- JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>0.9.1</version>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```



## POM.XML核心依賴

### Spring Boot Starters
1. **spring-boot-starter-web**
   - 用於構建 Web 應用，包含 RESTful 應用程序
2. **spring-boot-starter-data-jpa**
   - 用於 Java Persistence API 的數據訪問
3. **spring-boot-starter-security**
   - 提供安全性功能，如身份驗證和授權
4. **spring-boot-starter-validation**
   - 用於數據驗證

### 數據庫
- **mariadb-java-client** (版本 3.1.4)
  - MariaDB 的 JDBC 驅動，用於連接 MariaDB 數據庫

### 安全性
- **jjwt** (版本 0.9.1)
  - JSON Web Token (JWT) 庫，用於生成和驗證 JWT

### JSON 處理
1. **jackson-databind** (版本 2.15.2)
   - Jackson 庫的核心數據綁定功能
2. **json-simple** (版本 1.1.1)
   - 簡單的 JSON 解析和生成庫

## 開發工具

1. **spring-boot-devtools**
   - Spring Boot 開發工具，提供熱重載等功能
2. **lombok**
   - 用於減少樣板代碼的工具庫

## 代碼質量
- **pmd-java** (版本 7.0.0)
  - PMD 靜態代碼分析工具

## 測試依賴

1. **spring-boot-starter-test**
   - Spring Boot 測試框架
2. **spring-security-test**
   - Spring Security 的測試支持
3. **junit-jupiter** (版本 5.9.2)
   - JUnit 5 測試框架

## 構建插件

1. **spring-boot-maven-plugin**
   - Spring Boot Maven 插件，用於打包可執行 jar
2. **maven-pmd-plugin** (版本 3.25.0)
   - PMD 代碼分析 Maven 插件
3. **maven-deploy-plugin** (版本 3.1.2)
   - Maven 部署插件
4. **maven-jxr-plugin** (版本 3.3.0)
   - 源代碼交叉引用插件
5. **maven-surefire-plugin** (版本 3.2.5)
   - 用於運行單元測試的插件
6. **maven-site-plugin** (版本 3.12.1)
   - 生成項目站點的插件
7. **maven-project-info-reports-plugin** (版本 3.5.0)
   - 生成項目信息報告的插件

## 報告插件

1. **maven-pmd-plugin** (版本 3.25.0)
   - 用於生成 PMD 報告
2. **maven-jxr-plugin** (版本 3.3.0)
   - 用於生成源代碼交叉引用報告




## 數據庫設計

使用 MariaDB 作為數據庫，主要表格包括：

1. 會員表 (Members)
2. 電影表 (Movies)
3. 場地表 (Venues)
4. 訂位表 (Bookings)
5. 優惠表 (Discounts)
6. 電子錢包表 (Wallets)
7. 交易記錄表 (Transactions)

## 安全性考慮

- 使用 Spring Security 進行身份驗證和授權
- 實現 JWT 來處理無狀態身份驗證
- 密碼加密存儲
- 實施 HTTPS 以確保數據傳輸安全


