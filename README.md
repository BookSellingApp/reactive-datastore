# Book Store App Backend - Microservice

This is a Spring Reactive application to connect to Mongo DB reactively and allows Book Store, User Profile access.


Intall **MongoDB**

Start **MongoDB** using `mongod`

* Install **MongoDB 3.4.10 Community** for exploring and manipulating the Mondo DB
data

    Start Mongo shell using `mongo --host localhost:27017`

```
> use bookStoreApp
switched to db bookStoreApp
```

* Or use **MongoDB Compass Community** with a UI for documents viewing and modifications.


Update the `application.properties` with relevant DB settings.

Run the application using `mvn spring-boot:run`

We can test the usage of this Microservice using `POSTMAN` more details on [POSTMAN are here](www.getpostman.com)

Example POST message body can be put as below:

```json
{
	"title": "A brief history of time...",
	"author": "Stephen Hawking",
	"description": "A brief history of time.",
	"url": "https://en.wikipedia.org/wiki/A_Brief_History_of_Time#/media/File:BriefHistoryTime.jpg",
	"cost": 234
}
```

URL for making the POST request - http://localhost:8080/api/books

Set the Headers in POSTMAN as below:

* Accept: application/json
* Content-Type: application/json

Upon clicking the SEND button, we shall see the responce as below:

```json
{
    "id": "5a3403d5b0522f622c57d378",
    "title": "A brief history of time...",
    "author": "Stephen Hawking",
    "description": "A brief history of time.",
    "createdAt": "2017-12-15T17:18:13.317+0000",
    "updatedAt": "2017-12-15T17:18:13.317+0000",
    "imageUrl": null,
    "cost": 234
}

```
## More details

### Data Model

The below are the Document Object models persisted in Mondo DB.

    * Book
    * Customer
    * Order
    * Stock
    * Address

##### Relationships between object models is as below

    1. Each Customer can have Many Orders (One to Many)
    2. Each Order can have Many Books (One to Many)
    3. Each Book will have One stock details (One to One)
    4. Each Customer will have One Address (One to One)
