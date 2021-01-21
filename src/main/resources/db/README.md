Flyway Commands

--How to rebuild schema from scratch
mvn compile -P SYS -Dflyway.password=TryAgain flyway:info
mvn compile -P SYS -Dflyway.password=TryAgain flyway:clean
mvn compile -P SYS -Dflyway.password=TryAgain flyway:migrate
mvn compile -P SYS -Dflyway.password=TryAgain flyway:repair