# TicketApplication

1. Users can register with username, password and email.
```diff
POST http://localhost:8082/api/auth/register
```

```json
{
    "username":"admin",
    "password":"admin123.",
    "role":"ADMIN"
}
```

```json
{
    "username":"Gizem",
    "password":"Gizem123.",
    "email":"gizem@gmail.com",
    "role": "USER"
}
```
2. Users can login with username and password.
```diff
POST http://localhost:8082/api/auth/login
```
```json
{
    "username":"Gizem",
    "password":"Gizem123.",
}
```
```json
{
    "accessToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJHaXplbSIsImlzcyI6InRpY2tldEFwcCIsImV4cCI6MTY3NDYyMTY1NX0.gAL8IYBCD5y2nlEACXFfriHVvYtrtee9sDqJx3drYYE",
    "userDto": {
        "id": 18,
        "username": "Gizem",
        "email": "gizem@gmail.com",
        "role": "USER"
    }
}
```

```diff
GET http://localhost:8082/api/user/getUser/?id=20
```
```json
{
    {
    "id": 20,
    "username": "admin",
    "email": "admin@gmail.com",
    "password": "$2a$10$iAdhmyoVVmbI0b.vzbaSLuhC4i9Z22SN5ezlW4KYoMQ.SI8v/xnXC",
    "role": "ADMIN",
    "firstName": null,
    "lastName": null,
    "phoneNumber": null
}
}
```


```diff
GET http://localhost:8082/api/user/getUser/?id=20](http://localhost:8082/api/user/getAll
```
```json
[
    {
        "userName": "Sinem",
        "firstName": "Sinem",
        "lastName": "Türkçü",
        "email": "sinemturkcu@gmail.com",
        "phoneNumber": "1542562569",
        "role": "USER"
    },
    {
        "userName": "admin",
        "firstName": null,
        "lastName": null,
        "email": "admin@gmail.com",
        "phoneNumber": null,
        "role": "ADMIN"
    },
    {
        "userName": "Mehmet",
        "firstName": "Mehmet",
        "lastName": "Yıldız",
        "email": "mehmet@gmail.com",
        "phoneNumber": "5858585858",
        "role": "USER"
    },
    {
        "userName": "Kaan",
        "firstName": "Kaan",
        "lastName": "Yıldırım",
        "email": "kaan@gmail.com",
        "phoneNumber": "5858585858",
        "role": "USER"
    },
    {
        "userName": "Büşra",
        "firstName": "Büşra",
        "lastName": "Yıldırım",
        "email": "büşra@gmail.com",
        "phoneNumber": "5858585858",
        "role": "USER"
    }
]
```

```diff
PUT http://localhost:8082/api/user/updateUser
```
```json
{
   "email": "sinemturkcu@gmail.com",
   "firstName":"Sinemsu",
   "lastName":"Türkçü",
   "phoneNumber":"2586396857"
}
```
```json
{
    "message": "User updated successfully"
}
```


