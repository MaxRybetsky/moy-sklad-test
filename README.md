# moy-sklad-test

Для запуска проекта необходима БД Postgres 12.6 и выше. Необходимо создать базу данных "birdsappdb".

Далее выполнить команды в корневой директории проекта:

<code>mvn clean package</code>

<code>java -jar target/birds-app-0.0.1-SNAPSHOT.jar</code>

Приложение запустится на <a href="http://localhost:5000/swagger-ui.html">localhost:5000</a>

Для удобной работы с приложением можно перейти на страницу <a href="http://localhost:5000/swagger-ui.html">http://localhost:5000/swagger-ui.html</a> - там описаны все доступные функции приложения.

Также можно загрузить Docker-образ (идет уже вместе с базой данных, БД крнфигурировать не нужно). Для этого нужно выполнить команду <code>docker-compose up</code>, используя файл docker-compose.yml. Все необходимые образы подтянутся сами.
