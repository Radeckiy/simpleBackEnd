## SimpleBackEnd
Version: 1.0
## Описание
Пример простого back-end'а с использованием Spring.
## О проекте
Язык программирования: **Java**

Сборщик: **Maven**

Используемые технологии: 
- **Spring Boot**
- **Mongo DB**

Настройки подключения к БД находятся по пути: `src/main/resources/application.properties`. По умолчанию там выставлены настройки для подключения к локальной БД, которой можно изменить при необходимости.

Рабочая зона (`src/main/java/com.jobhunter.simpleBackEnd/`) содержит 2 java каталога:
- ***models*** - содержит модели объектов;
- ***repositories*** - содержит интерфейсы репозиториев для объектов.

Также рабочая зона содержит 2 контроллера и один основной класс, из которого происходит запуск проекта.

Запуск можно произвести как с терминала (командой - `mvn spring-boot:run`), так и посредством обычного запуска из IDE.

После запуска будут доступны следующие запросы (***адрес для запроса*** - описание запроса):
 
*Вместо `localhost` можеть быть другой хост, который вы указали в настройках подключения к бд.*

GET:
- ***localhost/employers/*** - в ответе будут ***все*** объекты типа Employer;
- ***localhost/employers/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве ответа придет конкретный объект типа Employer;
- ***localhost/potential_employees/*** - в ответе будут ***все*** объекты типа PotentialEmployees;
- ***localhost/potential_employees/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве ответа придет конкретный объект типа PotentialEmployees.

POST:
- ***localhost/employers/*** - запрос на добавление объекта типа Employer. Шаблон для тела запроса выглядит следующим образом:
`{
     "companyName": "Test_company",
     "companyDescription": "Test",
     "vacancyRequired": "Test",
     "vacancyDescription": "Test",
     "contacts": "Test",
     "wageMin": 10000,
     "wageMax": 20000
 }`;
- ***localhost/potential_employees/*** - запрос на добавление объекта типа PotentialEmployees. Шаблон для тела запроса выглядит следующим образом:
`{
 	"fullName": "Teeest",
 	"aboutYourself": "Test",
 	"vacancyRequired": "Test",
 	"contacts": "Test",
 	"age": 21,
 	"desiredWage": 10
 }`.
 
 PUT:
 - ***localhost/employers/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве положительного ответа придет сообщение `Updated!`. Тело запросто такое же как в POST запросе;
 - ***localhost/potential_employees/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве положительного ответа придет сообщение `Updated!`. Тело запросто такое же как в POST запросе.
 
 DELETE:
 - ***localhost/employers/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве положительного ответа придет сообщение `Deleted!`;
  - ***localhost/potential_employees/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве положительного ответа придет сообщение `Deleted!`.