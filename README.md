 # 📚💻SearchEngineProject - поисковый движок на Spring Boot, работающий с локально установленной базой данных MySQL.
 ![Java](https://img.shields.io/badge/-Java-0a0a0a?style=for-the-badge&logo=Java) ![Spring](https://img.shields.io/badge/-Spring-0a0a0a?style=for-the-badge&logo=Spring)
 ---
 Принцип работы:
- В конфигурационном файле перед запуском приложения задаются адреса сайтов, по которым движок должен осуществлять поиск
- Поисковый движок самостоятельно обходить все страницы заданных сайтов и индексирует их так, чтобы потом находить наиболее релевантные страницы по любому поисковому запросу
- Запрос определённым образом трансформируется в список слов, переведённых в базовую форму. Например, для существительных — именительный падеж, единственное число
- В индексе ищутся те страницы, на которых встречаются все эти слова
- Результаты поиска ранжируются, сортируются и отдаются пользователю

 
