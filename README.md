# Ar-test
# API

### API 

### POST ```/api/user/registration```
Example Request:

![image](https://user-images.githubusercontent.com/91428346/178154625-1be536cf-90c1-4271-90c2-a80fb49c46ab.png)

Response:

1) If name is already taken

![image](https://user-images.githubusercontent.com/91428346/178154680-2af73db1-3797-458b-90e5-5497ab1664d1.png)

2) If name is free

![image](https://user-images.githubusercontent.com/91428346/178154696-e95d51ff-be97-494e-9c31-819b70c51f85.png)

### Post ```/api/animal/registration```

!Все айди животных в формате UUID. Сделано чтобы нельзя было подбором посмотреть чужое животное, доступа к которому у пользователя нет. Только если хозяин передаст айди живонтого


Example Request: 

![image](https://user-images.githubusercontent.com/91428346/178154749-da08f4c5-c4d7-454d-a9da-3564f4af3718.png)


Response: 

![image](https://user-images.githubusercontent.com/91428346/178154754-b912e332-6f5f-4180-8499-0afb8a6f4ff5.png)


Request:

![image](https://user-images.githubusercontent.com/91428346/178154814-d24105f3-c3df-4a07-b389-b7692840e67a.png)


Response:

![image](https://user-images.githubusercontent.com/91428346/178154818-96965d53-2721-4ff8-b4ee-809a12693380.png)

### Put ```/api/animal/update/{id}```



### Delete ```/api/animal/delete/{id}```

#### Put и Delete методы будут обрабатывать запрос, только если попытка изменить\удалить свое животное. 

![image](https://user-images.githubusercontent.com/91428346/178154956-1b16e1c8-8925-4243-aac1-7accd53efb96.png)


### Get ```/api/animal/showall```

Показывает список всех ваших животных.

![image](https://user-images.githubusercontent.com/91428346/178155000-2837e463-bbad-4166-9bbf-9bdda818e7d0.png)


### Get ```/api/animal/find```

Request 

![image](https://user-images.githubusercontent.com/91428346/178155058-6b5db8a6-9704-4c7a-b40d-9d70a680731a.png)


Response 

![image](https://user-images.githubusercontent.com/91428346/178155068-e62b238e-210d-4c3e-95cd-6dd3a63e8849.png)


### WEB

![image](https://user-images.githubusercontent.com/91428346/178155209-bdc90cbf-4752-488f-bdb6-7b56f8bcf79f.png)





