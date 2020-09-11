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