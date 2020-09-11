# enrollmentService
Run the application by using __mvn spring-boot:run__

Alternatively, you can build the JAR file with __mvn clean package__ and then run the JAR file, as follows:

__java -jar target/enrollment-service-0.0.1.jar__

Once the application is running, you can visit it at __http://localhost:8080/greeting__

MongoDB monitoring URL: https://cloud.mongodb.com/freemonitoring/cluster/FD6YI6ZV7PTMFS4XM5SU7OYXXWAVK6ZE







<br>
<br>
<br>


***Requirements:***
- Enrollees must have an id, name, and activation status (true or false), and a birth date

- Enrollees may have a phone number (although they do not have to supply this)

- Enrollees may have zero or more dependents

- Each of an enrollee's dependents must have an id, name, and birth date

- Add a new enrollee

- Modify an existing enrollee

- Remove an enrollee entirely

- Add dependents to an enrollee

- Remove dependents from an enrollee

- Modify existing dependents



Sample Data:

```
[
  {
    "_id": "5f5bd489d217b4c3fb9dd261",
    "firstName": "Helga",
    "lastName": "Hurst",
    "active": false,
    "birthDate": "2014-04-22",
    "phone": "+1 (933) 442-3030",
    "dependents": [
      {
        "id": 0,
        "firstName": "Reid",
        "lastName": "Bruce",
        "birthDate": "2014-07-21"
      },
      {
        "id": 1,
        "firstName": "Merle",
        "lastName": "Ray",
        "birthDate": "2015-08-24"
      },
      {
        "id": 2,
        "firstName": "Tammy",
        "lastName": "Huff",
        "birthDate": "2016-11-21"
      }
    ]
  },
  {
    "_id": "5f5bd4890bfa750ff5f1dd4e",
    "firstName": "Rose",
    "lastName": "Bass",
    "active": true,
    "birthDate": "2018-02-22",
    "phone": "+1 (840) 600-2872",
    "dependents": [
      {
        "id": 0,
        "firstName": "Kline",
        "lastName": "Whitaker",
        "birthDate": "2015-01-21"
      },
      {
        "id": 1,
        "firstName": "Anthony",
        "lastName": "Key",
        "birthDate": "2015-05-09"
      },
      {
        "id": 2,
        "firstName": "Cannon",
        "lastName": "Vega",
        "birthDate": "2014-02-17"
      }
    ]
  },
  {
    "_id": "5f5bd48964ba124e0aeed84b",
    "firstName": "Ramsey",
    "lastName": "Robertson",
    "active": false,
    "birthDate": "2014-01-29",
    "phone": "+1 (984) 434-2003",
    "dependents": [
      {
        "id": 0,
        "firstName": "Nora",
        "lastName": "Whitehead",
        "birthDate": "2017-05-24"
      },
      {
        "id": 1,
        "firstName": "Alice",
        "lastName": "Kirkland",
        "birthDate": "2014-06-30"
      },
      {
        "id": 2,
        "firstName": "Gross",
        "lastName": "Vance",
        "birthDate": "2015-11-20"
      }
    ]
  },
  {
    "_id": "5f5bd4896f61bd657e63701a",
    "firstName": "Alisha",
    "lastName": "Maddox",
    "active": false,
    "birthDate": "2015-01-17",
    "phone": "+1 (934) 470-2793",
    "dependents": [
      {
        "id": 0,
        "firstName": "Hull",
        "lastName": "Fernandez",
        "birthDate": "2015-05-27"
      },
      {
        "id": 1,
        "firstName": "Annmarie",
        "lastName": "Clark",
        "birthDate": "2020-08-28"
      },
      {
        "id": 2,
        "firstName": "Gail",
        "lastName": "Wyatt",
        "birthDate": "2018-05-30"
      }
    ]
  },
  {
    "_id": "5f5bd489016546327382cf0f",
    "firstName": "Moody",
    "lastName": "Reid",
    "active": true,
    "birthDate": "2017-02-21",
    "phone": "+1 (914) 456-3962",
    "dependents": [
      {
        "id": 0,
        "firstName": "Pennington",
        "lastName": "Michael",
        "birthDate": "2016-04-04"
      },
      {
        "id": 1,
        "firstName": "Reyna",
        "lastName": "Nguyen",
        "birthDate": "2016-09-26"
      },
      {
        "id": 2,
        "firstName": "Erickson",
        "lastName": "Maxwell",
        "birthDate": "2020-03-05"
      }
    ]
  },
  {
    "_id": "5f5bd4899fcdf1c7fb090c96",
    "firstName": "Claudine",
    "lastName": "Mcmillan",
    "active": false,
    "birthDate": "2014-10-06",
    "phone": "+1 (998) 540-2114",
    "dependents": [
      {
        "id": 0,
        "firstName": "Bartlett",
        "lastName": "Gaines",
        "birthDate": "2016-01-30"
      },
      {
        "id": 1,
        "firstName": "Beard",
        "lastName": "Perkins",
        "birthDate": "2019-06-09"
      },
      {
        "id": 2,
        "firstName": "David",
        "lastName": "Wheeler",
        "birthDate": "2016-08-06"
      }
    ]
  },
  {
    "_id": "5f5bd489d1b28a29de34703a",
    "firstName": "Rivas",
    "lastName": "Henderson",
    "active": false,
    "birthDate": "2018-03-27",
    "phone": "+1 (966) 596-3746",
    "dependents": [
      {
        "id": 0,
        "firstName": "Sonia",
        "lastName": "Hester",
        "birthDate": "2020-03-02"
      },
      {
        "id": 1,
        "firstName": "Johns",
        "lastName": "Pennington",
        "birthDate": "2018-03-07"
      },
      {
        "id": 2,
        "firstName": "Corrine",
        "lastName": "Gomez",
        "birthDate": "2014-06-30"
      }
    ]
  }
]
```