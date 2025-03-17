Running the Project
After cloning the repository, follow these steps to run the project:

1. Build the application
Inside the project root folder, run:
./mvnw clean package -DskipTests

2. Navigate to the deployment folder
cd deployment/

3. Start the required services using Docker
docker-compose up -d

4. Set up the database
The root folder contains a database/ directory with ddl.sql and dml.sql files.
Open phpMyAdmin at http://localhost:8081/.
Create a new database named teletrade.
Execute both ddl.sql and dml.sql to set up the schema and initial data.

5. Access the demo application
Open http://localhost:8070/index.html.
Stock ID 1 has enough orders to display the Top 10 Sell and Buy Orders.
Other stocks exist for a more realistic appearance.

6. Testing WebSocket with Postman
To create a new order and test real-time WebSocket updates:

Send a POST request to:
http://localhost:8070/api/v1/orders
Request body (JSON):
{
  "stockId": 1,
  "userId": 1,
  "quantity": 1000,
  "price": 173.99,
  "type": "BUY"
}

Expected response:
{
  "success": true,
  "errors": [],
  "data": {
    "orderId": 123,
    "price": 173.99,
    "quantity": 1000,
    "type": "BUY"
  }
}

The WebSocket should automatically update with the new order details.

If validation fails API should return 400 response:
Request body (JSON):
{
    "userId": 1,
    "quantity": 1000,
    "price": 173.99,
    "type": "BUY"
}

Expected response:
{
    "success": false,
    "errors": [
        {
            "key": "stockId",
            "value": "StockID is required"
        }
    ],
    "data": null
}

7. Additional API calls:
Get all stocks: http://localhost:8070/api/v1/stocks
Get single stock http://localhost:8070/api/v1/stocks/1

8. Order book endpoint for specific stock is shown within index.html page 
