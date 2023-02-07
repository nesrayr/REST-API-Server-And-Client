# REST API Сервис + Клиент

### Сервис принимает данные от предполагаемого метрологического сенсора, измеряющего температуру воздуха и определяет, идет дождь или нет 

![img.png](util_images/img.png)

## Пример работы сервиса

### Отправляем POST-запрос на адрес ```/sensors/registration```. Таким образом, регистрируем новый сенсор

![img_1.png](util_images/img_1.png)

![img_2.png](util_images/img_2.png)

### POST-запрос на адрес ```/measurements/add``` добавляет новое измерение для сенсора

![img_3.png](util_images/img_3.png)

![img_4.png](util_images/img_4.png)

### Получим все измерения, отправив GET-запрос на адрес ```/meausurements```

![img_5.png](util_images/img_5.png)

### Также можно получить количество дождливых дней, отправив GET-запрос на адрес ```/measurements/rainyDaysCount```

![img_6.png](util_images/img_6.png)

## Пример работы клиента

При помощи клиента мы можем отправлять огромное количество запросов сервису для получения или отправки данных сенсору.
К примеру, отправив 500 измерений со случайными значениями, можно построить график температур

![img_7.png](util_images/img_7.png)
