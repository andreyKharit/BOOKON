# BOOKON Project
### Роли
- клиент
- сотрудник
- администратор
### Описание проекта
Онлайн сервис некой библиотеки, который:
* позволяет клиентам
   - просмотреть базу книжных изданий
   - оставить заявку на книгу для получения её на руки
* позволяет сотруднику
   - просмотреть базу книжных изданий и добавить новые
   - обработать заявку (одобрить, отклонить)
   - просмотреть список клиентов с возможностью их бана
* позволяет администратору
   - полностью редактировать базу книжных изданий (все поля, удаление, добавление)
   - иметь полный доступ к списку клиентов и сотрудников
   - удалять пользователей, менять статус (клиент -> сотрудник и т.д.)
### Ready
* user login/logout/registration
* admin access to user list with basic CRUD
* basic UI
* hibernate settings
* password encryption
### TODO
* full database structure
* finish UI
* CRUD for all entities