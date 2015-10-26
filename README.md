# Enterprise Distrubuted System class project: Refrig

## The System Architecture

![alt text](https://github.com/chenglongwei/refrig/blob/master/server/src/main/resources/static/system_architecture.png "System Architecture")

## Database Architecture Design

Use mongodb in bootstrap server, server and Client. Followings are the database architecture design 

### BootStrap

#### BootStrap Server Storage Design
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
