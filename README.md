Консольное клиент-серверное приложение для управления проектами и задачами (проект может содержать несколько задач, задача принадлежит только одному проекту).
Реализована авторизация пользователя (сущность User)
Ввод команд осуществлятся с консоли со стороны клиента.

Команды не требующие регистрации пользователя: 
"help" - отображается перечень команд 
"login" - вход пользователя посредством последовательного ввода Логина и Пароля
"reg" - регистрация нового пользователя

Приложение реализует функции CRUD для проктов (Projects) и задач (Task) - добавление новых, просмотр по имени, просмотр всех, создание,
удаление, обновление. Реализована возможность просмотра только тех задач, исполнителем которых является текущий зарегистрированный пользователь.

Используемые технологии:

- Java 8,
- Maven 3,
- Lombok 1.18,
- JDBC, MyBatis 3.1, Hibernate 5.3
- SOAP 
- CDI (API 2.0, Weld 3.0.5, DeltaSpike)
- Spring (Context 5.1.5, DataJpa 2.1.4)
 
База данных MySQL 5
