# Spring Boot RabbitMQ

This project is a Spring Boot application that demonstrates how to integrate RabbitMQ for message publishing and consuming. It covers creating a message queue, defining a topic exchange, and binding the queue to the exchange using routing keys. The application also includes a publisher service to send messages and a consumer service to receive them.


## Features

- **Message Publishing and Consuming:** Sends and receives messages using RabbitMQ.
- **Exchange and Queue Configuration:** Configures a topic exchange and binds it to a queue with a specific routing key.
- **Error Handling and Retries:** Allows for configuration of message retry on failure.
- **REST API Integration:** Provides a REST API for publishing messages.


## Technologies Used

- **Spring Boot**: Java-based framework for building web applications.
- **RabbitMQ**: A message broker for asynchronous communication between services.
- **Java**: Programming language used for developing the application.
- **Docker**: Containerization platform used for RabbitMQ setup.
- **Gradle**: Build automation tool.


## Running the Application

### Prerequisites

- Docker
- Java 17+
- Gradle

### Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/nihadamirov/spring-boot-rabbitmq.git
   cd spring-boot-rabbitmq
   ```

2. **Start RabbitMQ using Docker**:
   ```bash
   docker-compose up -d
   ```

3. **Run the Application**:
   ```bash
   ./gradlew bootRun
   ```

## Endpoints

- **Publish Message**: `POST /api/v1/subscribe`

  **Request Body**:
  ```json
  {
    "id": 1,
    "name": "John Doe",
    "channel": "Email"
  }
  ```

## How It Works

1. **Configuration**: `RabbitmqConfig.java` sets up the queue, exchange, and routing key.
2. **Publishing Messages**: `PublisherService.java` uses `AmqpTemplate` to send messages to RabbitMQ.
3. **Consuming Messages**: `ConsumerService.java` listens to the queue and processes incoming messages.
4. **REST API**: `SubscribeController.java` exposes an endpoint to publish messages.

## Docker Setup

The `docker-compose.yml` file sets up RabbitMQ with the management UI:

```yaml
version: "3.2"
services:
  rabbitmq:
    image: rabbitmq:3-management-alpine
    container_name: 'rabbitmq'
    environment:
      RABBITMQ_USERNAME: guest
      RABBITMQ_PASSWORD: guest
    ports:
      - '5672:5672'
      - '15672:15672'
```

- **RabbitMQ Management UI**: Access it at `http://localhost:15672` using username `guest` and password `guest`.

