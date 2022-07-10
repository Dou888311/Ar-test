# Ar-test

# Запуск
1) При наличии грейдла, клонируете репозиторий, переходите в директорию проекта - gradle bootRun или через вашу IDE.
2) Приложенный JAR

### API 

### POST ```/api/user/registration```
Example Request:

Consumes JSON:
```javascript
{
  "username": "admin", // Must not unique. If not, app throw 400 BAD_REQUEST
  "password": "supersecret" 
}
```

Response:

1) If name is already taken

```javascript
{
 "error":"Your username is already taken. Registration failed."
}
```

2) If name is free

```javascript
 Your user id is: 14
```

### Post ```/api/animal/registration```

!Все айди животных в формате UUID. Сделано чтобы нельзя было подбором посмотреть чужое животное, доступа к которому у пользователя нет. Только если хозяин передаст айди живонтого


Example Request: 

```javascript
{
    "gender":"FEMALE",
    "birthDate":"2022-07-10",
    "name":"f44",
    "kind":"Cat"
}
```

Response: 

```javascript
{
    "Your Animal id": "d7355120-bbf6-40f6-981d-6084f368d037"
}
```


Repeatable Request:

```javascript
{
    "gender":"FEMALE",
    "birthDate":"2022-07-10",
    "name":"f44g",
    "kind":"Cat"
}
```


Response:

```javascript
{
    "error": "Current animal name is already taken. Registration failed."
}
```

### Put ```/api/animal/update/{id}```



### Delete ```/api/animal/delete/{id}```

#### Put и Delete методы будут обрабатывать запрос, только если попытка изменить\удалить свое животное. 

```javascript
{
    "error": "Animal with id: f0203d4c-367a-44df-a910-f971e1b2fc17is not yours. You can`t update him. Update failing."
}
```


### Get ```/api/animal/showall```

Показывает список всех ваших животных.

```javascript
[
    {
        "id": "737cc79b-aced-485c-b77b-7086e8b9929f",
        "birthDate": "2022-07-09",
        "gender": "FEMALE",
        "name": "cat14564",
        "kind": "Cat"
    },
    {
        "id": "932afc42-8b92-4162-aff6-a597db2ab4c7",
        "birthDate": "2022-07-09",
        "gender": "FEMALE",
        "name": "cat1",
        "kind": "Cat"
    }
]
```


### Post ```/api/animal/find```

показывает животное по переданному айди

Request 

```javascript
{
    "id":"737cc79b-aced-485c-b77b-7086e8b9929f"
}
```


Response 

```javascript
{
    "id": "737cc79b-aced-485c-b77b-7086e8b9929f",
    "birthDate": "2022-07-09",
    "gender": "FEMALE",
    "name": "cat14564",
    "kind": "Cat"
}
```


### WEB

![image](https://user-images.githubusercontent.com/91428346/178155209-bdc90cbf-4752-488f-bdb6-7b56f8bcf79f.png)

![image](https://user-images.githubusercontent.com/91428346/178155874-e9d8edcb-85d9-41c8-a0c5-d943f6231d0b.png)


![image](https://user-images.githubusercontent.com/91428346/178155893-618bd37b-4dad-4e73-97c6-8e849cd41808.png)






