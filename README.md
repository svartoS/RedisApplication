# Барахолка товаров: Исследование Redis и NoSQL
Этот репозиторий содержит исходный код проекта "Барахолка товаров", разработанного в рамках научно-исследовательской работы на 3 курсе.
# О проекте
Целью проекта было изучение возможностей Redis и особенностей хранения данных в NoSQL базах данных на практике. Для этого была разработана "барахолка товаров" - веб-приложение, где данные о пользователях, товарах и другие сущности хранятся в Redis.
## Технологии
Проект реализован с использованием следующих технологий:  
Java Core: Язык программирования для backend логики.  
Spring Boot: Фреймворк для упрощения разработки веб-приложений на Java.  
Spring Security: Модуль Spring для обеспечения безопасности приложения (аутентификация, авторизация).  
Thymeleaf: Шаблонный движок для Java, используемый для динамической генерации HTML.  
Bootstrap: Фронтенд фреймворк для создания отзывчивого и адаптивного дизайна.  
Redis: In-memory хранилище данных, используемое как NoSQL база данных.  
Maven: Инструмент для управления зависимостями и сборки проекта.  
## Функциональность
"Барахолка товаров" предоставляет базовый функционал:  
Регистрация и аутентификация пользователей.  
Создание, редактирование и удаление объявлений о продаже товаров.  
Просмотр объявлений с возможностью поиска и фильтрации.  
Просмотр информации о товарах и продавцах.  
## Запуск проекта
Установите необходимые зависимости: Java JDK 8+, Redis, Maven.
Клонируйте репозиторий: git clone https://github.com/your-username/барахолка-товаров.git
Настройте подключение к Redis в файле application.properties.
Запустите приложение: mvn spring-boot:run
