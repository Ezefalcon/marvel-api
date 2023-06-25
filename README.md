## Install dependencies

    mvn clean install

## This properties are necessary

    marvel.private.key=YourPrivateKey
    marvel.public.key=YourPublicKey

`Note: JAR of marvel service can be found at libs folder`

Swagger can be found here:

http://localhost:8080/api/swagger-ui/index.html#/

##Basic Authentication is required:

Username: admin

Password: admin

##Request curl example

    curl --location 'http://localhost:8080/api/log?page=0&limit=5' \
    --header 'Authorization: Basic YWRtaW46YWRtaW4='