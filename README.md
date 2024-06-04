# [Clock Register]()

My work hours were recorded manually using spreadsheets, which was an inefficience system. To solve that, I developed this service so it is possible to better manage this information.

#### [Initialization with Docker]()

To init the postgres database, go to the root of the project and execute this command:

```docker
  docker compose up
```
#### [API Documentation]()

#### Authorization endpoint to get the JWT token

```http
  POST /api/auth/login
```

| Parameter   | Type       | Description                                  |
| :---------- | :--------- | :------------------------------------------ |
| `username`      | `string` | **Required**|
| `password`      | `string` | **Required**|


#### Create an user

```http
  POST /api/user/register
```

| Parameter   | Type       | Description                                  |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | Optional|
| `username`      | `string` | **Required**|
| `password`      | `string` | **Required**|
| `role`      | `string` | **Required** Define its permissions|


#### Set the clock automatically

```http
  POST /api/clock/set-auto
```

| Parameter   | Type       | Description                                  |
| :---------- | :--------- | :------------------------------------------ |
| `id_user`      | `int` | **Required**|