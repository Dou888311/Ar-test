<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Animals</title>
    </head>
    <body>
        <#list animals as animal>
            <span id="name">Name ${animal.name}</span>
            <br>
            <span id='kind'>Kind ${animal.kind}</span>
            <br>
            <span id="birthdate">Birthday ${animal.birthDate}</span>
            <br>
            <span id="gender">Gender ${animal.gender}</span>
            <br>
            <span id="id"> id ${animal.id}</span>
            <br>
            <br>
            <br>
        </#list>
    </body>
</html>