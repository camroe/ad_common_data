Compiled with Java 8.211 JDK Make sure this is set in the IDE

1. Download and install postgres 11
2. psql -u postgres
3. create database addb template 'template0' encoding 'utf8';
4. create user whoever with encrypted password 'whatever';
5. grant all privileges on database addb to whoever;
ALTER DATABASE name OWNER TO new_owner

mvn liquibase:status
mvn liquibase:update

Database is ready to go.



