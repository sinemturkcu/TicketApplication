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
3. Admin role should be able to add, delete and update users, routes and vehicles, but users cannot.

