## Refrig -- Enterprised Distributed Systems Project
### Chenglong Wei 010396464

### 1. The System Architecture

![alt text](https://github.com/chenglongwei/refrig/blob/master/server/src/main/resources/static/system_architecture.png "System Architecture")

The system is implemented by **Spring Framework**, built by **Gradle** and Deployed on **Tomcat**.

### 2. Database Architecture Design

Use **Mongodb** in **Bootstrap Server**, **Server** and **Client**. Followings are the database architecture design 

#### 2.1 BootStrap Sever
Database name **bsserver**, collection name **refrig**.
```json
{
	"ep": "uuid:00000000-0000-0000-000000000001" ,
	"clientInfo" : {
		"manufacture" : "Vikin",
		"reguri" : "http://localhost:8080/server-1.0/api/rd",
		"firmwareVersion" : "1.0.0",
		"modelNumber" : "1234",
		"serialNumber" : "x1234",
		"accessOwner":"chenglong",
        "temperature":"temperature",
        "bacteria":"bacteria"
	}
}
```

#### 2.2 Client
Database name **client**. Collections **refrig**, **temperature**, **bacteria**, **command**, ****attributes****
#### 2.2.1 refrig

```json
{
	"endpointClientName" : "uuid:00000000-0000-0000-000000000001",
	"oid_0":{
			"rid_0" : "localhost:8080/server-1.0/api/rd"
	},
	"oid_2":{
    		"rid_0" : "chenglong(access control owner)"
    },
	"oid_3":{
			"rid_0" : "Samsung",
			"rid_1" : "1234",
			"rid_2" : "x1234",
			"rid_3" : "1.0.0"
	},
	"oid_4": {
    		"rid_0":"temperature"
    },
    "oid_5": {
    		"rid_0":"bacteria"
    }
}
```
#### 2.2.2 temperature

```json
{
	"endpointClientName" : "uuid:00000000-0000-0000-000000000001",
	"temperatue" : 42,
	"timestamp" : 1445890741
}
```
#### 2.2.3 bacteria

```json
{
    "endpointClientName" : "uuid:00000000-0000-0000-000000000001",
    "bacteria" : 32,
    "timestamp" : 1445890741
}
```

#### 2.2.4 command

```json
{
  "temperature": "20",
  "bacteria": "30"
}
```
#### 2.2.5 attributes

```json
{
	"temperature": {
    	"minimumPeriod" : "5",
		"maximumPeriod" : "10",
		"greaterThan" : "40",
		"cancel": true
    },
	"bacteria" : {
		"minimumPeriod" : "5",
        "maximumPeriod" : "10",
        "greaterThan" : "40",
        "cancel": true
 	}	
}
```

#### 2.3 Server
Database name **server**, collection **registerInfo**, **temperature**, **bacteria**.
##### 2.3.1 registerInfo
```json
{
	"endpointClientName" : "uuid:00000000-0000-0000-000000000001",
	"oid_0":{
			"rid_0" : "localhost:8080/server-1.0/api/rd"
	},
	"oid_2":{
    		"rid_0" : "chenglong(access control owner)"
    },
	"oid_3":{
			"rid_0" : "Samsung",
			"rid_1" : "1234",
			"rid_2" : "x1234",
			"rid_3" : "1.0.0"
	},
	"oid_4": {
    		"rid_0":"temperature"
    },
    "oid_5": {
    		"rid_0":"bacteria"
    }
}
```
##### 2.3.2 temperature
```json
{
	"endpointClientName" : "uuid:00000000-0000-0000-000000000001",
	"temperatue" : 72,
	"timestamp" : 1445890741
}
```

##### 2.3.3 bacteria
```json
{
    "endpointClientName" : "uuid:00000000-0000-0000-000000000001",
    "bacteria" : 42,
    "timestamp" : 1445890741
}
```

### 3. Method Definded for C.R.U.D and Device Management

#### 3.1 BootStrap Server Side
[BootStrap Controller](https://github.com/chenglongwei/refrig/blob/master/bsserver/src/main/java/com/longyi/dist/bsserver/controller/BootstrapController.java)

#### 3.2 Server Side
[Server Controller](https://github.com/chenglongwei/refrig/blob/master/server/src/main/java/com/longyi/dist/server/controller/RegisterController.java)

#### 3.3 Device Management
[Device Management Controller](https://github.com/chenglongwei/refrig/blob/master/client/src/main/java/com/longyi/dist/client/controller/DeviceManagementController.java)

#### 3.4 Information Reporting
[Information Reporting Controller](https://github.com/chenglongwei/refrig/blob/master/client/src/main/java/com/longyi/dist/client/controller/InformationReportingController.java)

### 4. Demo
#### 4.1 Deployment
After gradle build, there are three war packges (**client-1.0.war**, **bsserver-1.0.war**, **server-1.0.war**). Deploy them on **Tomcat**.
[http://localhost:8080/manager/html](http://localhost:8080/manager/html)

#### 4.2 Bootstrap and Register (C.R.U.D)
##### 4.2.1 Control Client to Perform Actions
[Client Controller Bootstrap](https://github.com/chenglongwei/refrig/blob/master/client/src/main/java/com/longyi/dist/client/controller/BootstrapController.java)

[Client Controller Register](https://github.com/chenglongwei/refrig/blob/master/client/src/main/java/com/longyi/dist/client/controller/RegisterController.java)

##### 4.2.2 Bootstrap
[http://localhost:8080/client-1.0/api/do/bs/read](http://localhost:8080/client-1.0/api/do/bs/read)

[http://localhost:8080/client-1.0/api/do/bs/bootstrap](http://localhost:8080/client-1.0/api/do/bs/bootstrap)
##### 4.2.3 Register
[http://localhost:8080/client-1.0/api/do/rd/create](http://localhost:8080/client-1.0/api/do/rd/create)

[http://localhost:8080/client-1.0/api/do/rd/read](http://localhost:8080/client-1.0/api/do/rd/read)

[http://localhost:8080/client-1.0/api/do/rd/update?version=1.0.5](http://localhost:8080/client-1.0/api/do/rd/update?version=1.0.5)

[http://localhost:8080/client-1.0/api/do/rd/delete](http://localhost:8080/client-1.0/api/do/rd/delete)

#### 4.3 Device Management and Information Reporting

##### 4.3.1 Control Server to Perform Actions
[Server Controller Do Device Management](https://github.com/chenglongwei/refrig/blob/develop/server/src/main/java/com/longyi/dist/server/controller/DeviceManagementController.java)

[Server Controller Information Reporting](https://github.com/chenglongwei/refrig/blob/develop/server/src/main/java/com/longyi/dist/server/controller/InformationController.java)

##### 4.3.2 Device Management

**OP1:** Read temperature

[http://localhost:8080/server-1.0/api/do/dm/read/4/0](http://localhost:8080/server-1.0/api/do/dm/read/4/0)

**OP1:** Read bacteria

[http://localhost:8080/server-1.0/api/do/dm/read/5/0](http://localhost:8080/server-1.0/api/do/dm/read/5/0)

**OP2:** Discover object 3

[http://localhost:8080/server-1.0/api/do/dm/discover/3](http://localhost:8080/server-1.0/api/do/dm/discover/3)

**OP3:** Write object 3 resource 3

[http://localhost:8080/server-1.0/api/do/dm/write/3/3?newValue=1.2.4](http://localhost:8080/server-1.0/api/do/dm/write/3/3?newValue=1.2.4)

**OP4:** Write attributes 4 (temperature)

[http://localhost:8080/server-1.0/api/do/dm/write/attributes/4?minimumPeriod=5&maximumPeriod=10&greaterThan=40&cancel=false]
(http://localhost:8080/server-1.0/api/do/dm/write/attributes/4?minimumPeriod=5&maximumPeriod=10&greaterThan=40&cancel=false)

**OP4:** Write attributes 5 (bacteria)

[http://localhost:8080/server-1.0/api/do/dm/write/attributes/4?minimumPeriod=5&maximumPeriod=10&greaterThan=20&cancel=false]
(http://localhost:8080/server-1.0/api/do/dm/write/attributes/4?minimumPeriod=5&maximumPeriod=10&greaterThan=20&cancel=false)

**OP5:** Execute Command 4 (set temperature)

[http://localhost:8080/server-1.0/api/do/dm/execute/command/4?newValue=40](http://localhost:8080/server-1.0/api/do/dm/execute/command/4?newValue=40)

**OP5:** Execute Command 5 (set bacteria)

[http://localhost:8080/server-1.0/api/do/dm/execute/command/5?newValue=20](http://localhost:8080/server-1.0/api/do/dm/execute/command/5?newValue=20)

**OP6:** Create (access control owner)

[http://localhost:8080/server-1.0/api/do/dm/create/2/0?newValue=chenglong](http://localhost:8080/server-1.0/api/do/dm/create/2/0?newValue=chenglong)

**OP7:** Delete (access control owner)

[http://localhost:8080/server-1.0/api/do/dm/delete/2/0](http://localhost:8080/server-1.0/api/do/dm/delete/2/0)

##### 4.3.3 Information Reporting

**OP8:** Observation Temperature

[http://localhost:8080/server-1.0/api/info/observe/4](http://localhost:8080/server-1.0/api/info/observe/4)

**OP8:** Observation Bacteria

[http://localhost:8080/server-1.0/api/info/observe/5](http://localhost:8080/server-1.0/api/info/observe/5)


**OP9:** Cancel Observation Temperature

[http://localhost:8080/server-1.0/api/info/cancel/observe/4](http://localhost:8080/server-1.0/api/info/cancel/observe/4)

**OP9:** Cancel Observation Bacteria

[http://localhost:8080/server-1.0/api/info/cancel/observe/5](http://localhost:8080/server-1.0/api/info/cancel/observe/5)

**OP10:** Notification

[http://localhost:8080/client-1.0/api/report/start](http://localhost:8080/client-1.0/api/report/start)

#### 4.4 Team Project Demo

**Read Temperature**

[http://localhost:8080/server-1.0/api/do/dm/read/4/0](http://localhost:8080/server-1.0/api/do/dm/read/4/0)

**Set Temperature**

[http://localhost:8080/server-1.0/api/do/dm/execute/command/4?newValue=40](http://localhost:8080/server-1.0/api/do/dm/execute/command/4?newValue=40)

**Notification of High Temperature**

[http://localhost:8080/client-1.0/api/report/start](http://localhost:8080/client-1.0/api/report/start)
