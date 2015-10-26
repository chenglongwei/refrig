# Refrig: Chenglong Wei 010396464

## The System Architecture

![alt text](https://github.com/chenglongwei/refrig/blob/master/server/src/main/resources/static/system_architecture.png "System Architecture")

The system is implemented by Spring Framework, built by Gradle and Deployed on Tomcat.

## Database Architecture Design

Use mongodb in bootstrap server, server and Client. Followings are the database architecture design 

### BootStrap

#### BootStrap Server Storage Design
Database name bsserver.
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
#### Client Storage Design
Database name client.
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
### Register
Database name client.
Both Server Side and Client Side Store like this
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
### Data Sent

Both Server Side and Client Side Store like this
```json
{
	"endpointClientName" : "uuid:00000000-0000-0000-000000000001",
	"temperatue" : 72
	"timestamp" : 1445890741
}
```

## Method Definded for C.R.U.D

### BootStrap Server Side
[BootStrap Controller](https://github.com/chenglongwei/refrig/blob/master/bsserver/src/main/java/com/longyi/dist/bsserver/controller/BootstrapController.java)

### Server Side
[Server Controller](https://github.com/chenglongwei/refrig/blob/master/server/src/main/java/com/longyi/dist/server/controller/RegisterController.java)

## Demo
### Deployment
After gradle build, there are three war packges (client-1.0.war, bsserver-1.0.war, server-1.0.war). Deploy them on Tomcat.
[http://localhost:8080/manager/html](http://localhost:8080/manager/html)

### Control Client to Perform Actions
#### Bootstrap
[http://localhost:8080/client-1.0/api/do/bs/read](http://localhost:8080/client-1.0/api/do/bs/read)

[http://localhost:8080/client-1.0/api/do/bs/create](http://localhost:8080/client-1.0/api/do/bs/create)
#### Register
[http://localhost:8080/client-1.0/api/do/rd/create](http://localhost:8080/client-1.0/api/do/rd/create)

[http://localhost:8080/client-1.0/api/do/rd/read](http://localhost:8080/client-1.0/api/do/rd/read)

[http://localhost:8080/client-1.0/api/do/rd/update](http://localhost:8080/client-1.0/api/do/rd/update)

[http://localhost:8080/client-1.0/api/do/rd/delete](http://localhost:8080/client-1.0/api/do/rd/delete)
#### Send data
[http://localhost:8080/client-1.0/api/do/send](http://localhost:8080/client-1.0/api/do/send)
