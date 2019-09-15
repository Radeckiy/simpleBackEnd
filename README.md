## SimpleBackEnd
Version: 1.1
## Описание
Пример back-end'а с использованием Spring.
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
 
*Вместо `localhost:8080` могут быть другие хост и/или порт, которые установите вы.*

GET:
- ***localhost:8080/employers/*** - в ответе будут ***первые 10*** объектов типа Employer. Есть возможость добавить параметры (описание ниже);
- ***localhost:8080/employers/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве ответа придет конкретный объект типа Employer;
- ***localhost:8080/potential_employees/*** - в ответе будут ***первые 10*** объектов типа PotentialEmployees. Есть возможость добавить параметры (описание ниже);
- ***localhost:8080/potential_employees/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве ответа придет конкретный объект типа PotentialEmployees.

Также присутсвую параметры:
- ***page*** - индекс необходимой страницы. В качестве значения параметра передается номер страницы (начиная от нуля). Если параметр не указан, по умолчанию будет передана 0 страница. Размер страницы - 10 объектов.
- ***sortDirection*** - фильтр. В качестве значения параметра передается название необходимого фильтра. Доступные фильтры: `A-Z` - в алфавитном порядке по возрастанию (по полю `vacancyRequired`), `Z-A` - в алфавитном порадке по убыванию (по полю `vacancyRequired`), `newFirst` - сначала новые, `newOld` - сначала старые.
- ***contains*** - поиск. В качестве значения параметра передается строка с ключевыми словами для поиска. Для `localhost:8080/employers/` поиск происходит по полям `companyDescription и vacancyRequired`, для `localhost:8080/potential_employees/` поиск происходит по полям `aboutYourself и vacancyRequired`.

Пример запросов с параметрами: 
- **`localhost:8080/employers/?page=0`** - в ответе будут первые 10 объектов типа Employers.
- **`localhost:8080/employers/?page=1&sortDirection=A-Z`** - в ответе будут вторые 10 (вторая страница) объектов типа Employers, отсортированные  по полю `vacancyRequired` в алфавитном порядке по возрастанию.
- **`localhost:8080/potential_employees/?contains=Developer`** - в ответе будут объекты типа PotentialEmployees, в полях (`vacancyRequired или aboutYourself`) которых будет слово `developer` в любом регистре.

Параметры можно комбинировать в любом порядке.

POST:
- ***localhost:8080/employers/*** - запрос на добавление объекта типа Employer. Шаблон для тела запроса выглядит следующим образом:
`{
     "companyName": "Test_company",
     "companyDescription": "Test",
     "vacancyRequired": "Test",
     "vacancyDescription": "Test",
     "contacts": "Test",
     "wageMin": 10000,
     "wageMax": 20000
 }`;
- ***localhost:8080/potential_employees/*** - запрос на добавление объекта типа PotentialEmployees. Шаблон для тела запроса выглядит следующим образом:
`{
 	"fullName": "Teeest",
 	"aboutYourself": "Test",
 	"vacancyRequired": "Test",
 	"contacts": "Test",
 	"age": 21,
 	"desiredWage": 10
 }`.
 
 PUT:
 - ***localhost:8080/employers/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве положительного ответа придет обновленный объект типа Employers. Тело запросто такое же как в POST запросе;
 - ***localhost:8080/potential_employees/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве положительного ответа придет обновленный объект типа PotentialEmployees. Тело запросто такое же как в POST запросе.
 
 DELETE:
 - ***localhost:8080/employers/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве положительного ответа придет сообщение `Deleted!`;
  - ***localhost:8080/potential_employees/{id}*** - вместо {id} должен быть подставлен id объекта и в качестве положительного ответа придет сообщение `Deleted!`.