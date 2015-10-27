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
		"serialNumber" : "x1234"
	}
}
```
#### 2.2 Server
Database name **server**, collection **registerInfo**, **temperature**.
```json
{
	"endpointClientName" : "uuid:00000000-0000-0000-000000000001",
	"oid_0":{
			"rid_0" : "localhost:8080/server-1.0/api/rd"
	},
	"oid_3":{
			"rid_0" : "Samsung",
			"rid_1" : "1234",
			"rid_2" : "x1234",
			"rid_3" : "1.0.0"
	}
}
```
```json
{
	"endpointClientName" : "uuid:00000000-0000-0000-000000000001",
	"temperatue" : 72,
	"timestamp" : 1445890741
}
```
#### 2.3 Client
Database name **client**. Collections **refrig**, **temperature**
```json
{
	"endpointClientName" : "uuid:00000000-0000-0000-000000000001",
	"oid_0":{
			"rid_0" : "localhost:8080/server-1.0/api/rd"
	},
	"oid_3":{
			"rid_0" : "Samsung",
			"rid_1" : "1234",
			"rid_2" : "x1234",
			"rid_3" : "1.0.0"
	}
}
```
```json
{
	"endpointClientName" : "uuid:00000000-0000-0000-000000000001",
	"temperatue" : 72,
	"timestamp" : 1445890741
}
```

### 3. Method Definded for C.R.U.D

#### 3.1 BootStrap Server Side
[BootStrap Controller](https://github.com/chenglongwei/refrig/blob/master/bsserver/src/main/java/com/longyi/dist/bsserver/controller/BootstrapController.java)

#### 3.2 Server Side
[Server Controller](https://github.com/chenglongwei/refrig/blob/master/server/src/main/java/com/longyi/dist/server/controller/RegisterController.java)

### 4. Demo
#### 4.1 Deployment
After gradle build, there are three war packges (**client-1.0.war**, **bsserver-1.0.war**, **server-1.0.war**). Deploy them on **Tomcat**.
[http://localhost:8080/manager/html](http://localhost:8080/manager/html)

#### 4.2 Control Client to Perform Actions
[Client Controller Bootstrap](https://github.com/chenglongwei/refrig/blob/master/client/src/main/java/com/longyi/dist/client/controller/BootstrapController.java)

[Client Controller Register](https://github.com/chenglongwei/refrig/blob/master/client/src/main/java/com/longyi/dist/client/controller/RegisterController.java)

##### 4.2.1 Bootstrap
[http://localhost:8080/client-1.0/api/do/bs/read](http://localhost:8080/client-1.0/api/do/bs/read)

[http://localhost:8080/client-1.0/api/do/bs/bootstrap](http://localhost:8080/client-1.0/api/do/bs/bootstrap)
##### 4.2.2 Register
[http://localhost:8080/client-1.0/api/do/rd/create](http://localhost:8080/client-1.0/api/do/rd/create)

[http://localhost:8080/client-1.0/api/do/rd/read](http://localhost:8080/client-1.0/api/do/rd/read)

[http://localhost:8080/client-1.0/api/do/rd/update?version=1.0.5](http://localhost:8080/client-1.0/api/do/rd/update?version=1.0.5)

[http://localhost:8080/client-1.0/api/do/rd/delete](http://localhost:8080/client-1.0/api/do/rd/delete)
##### 4.2.3 Send data
[http://localhost:8080/client-1.0/api/do/send](http://localhost:8080/client-1.0/api/do/send)
