## API Endpoints

### 1. Add New User

- **Endpoint**: `http://localhost:8080/addNewUser`
- **Method**: POST
- **Description**: Roles (Admin, User)
- **Request Body**:
  ```json
  {
      "name": "a",
      "password": "a",
      "email": "a@a.com",
      "roles": "User"
  }
  ```
- **Response**:
```
    Status: OK (200)
    Body:
    User Added Successfully
```

### 2. Login
- **Endpoint**: http://localhost:8080/login
- **Method**: POST
- **Description**: Login with username and password, take Bearer Token for add and list flights, airport
- **Request Body**:
 ```json
 
{
    "username": "a",
    "password": "a"
}
 ```
- **Response**:
 ```
Status: OK (200)
Body: Bearer Token (example)
```
### 3. Add Airport
- **Endpoint**: http://localhost:8080/addAirport
- **Method**: POST
- **Description**: Success airport: Airports(id=2, location=IST)
- **Request Body**:
 ```json

{
    "location": "IST"
}
```
- **Response**:
 ```
Status: OK (200)
Body: Success airport: Airports(id=2, location=IST)
```
### 4. Add Flights
- **Endpoint**: http://localhost:8080/addFlights
- **Method**: POST
- **Description**: Success
- **Request Body**:
 ```json
 
{
    "deporteAirport": "ANK",
    "arrivalAirport": "IST",
    "price": 1000,
    "departureDate": "2024-02-04T12:00:00Z",
    "returnDate": "2024-02-07T15:30:00Z"
}
```
- **Response**:
```
Status: OK (200)
Body: Success
```
### 5. Search Flights
- **Endpoint**: http://localhost:8080/flights?departureAirport=ANK&arrivalAirport=IST&departureDate=2024-02-04T15:00:00Z
- **Method**: GET
- **Description**: Search for flights based on the provided parameters
- **Response**:
 
 ```json
 
[
    {
        "id": 1,
        "departureAirport": {
            "id": 1,
            "location": "ANK"
        },
        "arrivalAirport": {
            "id": 2,
            "location": "IST"
        },
        "departureDate": "2024-02-04T12:00:00.000+00:00",
        "returnDate": "2024-02-07T15:30:00.000+00:00",
        "price": 1000
    },
    {
        "id": 2,
        "departureAirport": {
            "id": 1,
            "location": "ANK"
        },
        "arrivalAirport": {
            "id": 2,
            "location": "IST"
        },
        "departureDate": "2024-02-04T12:00:00.000+00:00",
        "returnDate": "2024-02-07T15:30:00.000+00:00",
        "price": 1000
    },
    {
        "id": 3,
        "departureAirport": {
            "id": 1,
            "location": "ANK"
        },
        "arrivalAirport": {
            "id": 2,
            "location": "IST"
        },
        "departureDate": "2024-02-04T12:00:00.000+00:00",
        "returnDate": "2024-02-07T15:30:00.000+00:00",
        "price": 1000
    }
]
```
