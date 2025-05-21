# Parking Lot Management System

A Spring Boot-based RESTful API for managing a multi-floor parking lot. Supports user and vehicle management, ticketing, parking space and rate management.

## Features
- User registration (Admin, Regular)
- Vehicle registration
- Ticket creation (entry/exit)
- Parking space and rate management (admin only)
- Query available spaces and rates

## Getting Started

### Prerequisites
- Java 17 or above
- Maven

### Setup
1. Clone the repository
2. Navigate to the `ParkingLot` directory
3. Build and run:
   ```powershell
   mvn spring-boot:run
   ```

### API Endpoints

#### User
- `POST /api/users` - Register a user

#### Vehicle
- `POST /api/vehicles` - Register a vehicle

#### Ticket
- `POST /api/tickets/entry` - Create entry ticket
- `POST /api/tickets/exit` - Mark exit and calculate fee

#### Parking Space (Admin)
- `GET /api/parking-spaces` - List available spaces
- `POST /api/parking-spaces` - Update spaces

#### Parking Rate (Admin)
- `GET /api/parking-rates` - List rates
- `POST /api/parking-rates` - Update rates

## Example Usage
Register a user:
```bash
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{"userName":"admin","email":"admin@lot.com","userType":"ADMIN"}'
```

## License
MIT
