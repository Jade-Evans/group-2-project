# ✅👤Manual Testing Phase

Below we have provided information of the manual testing plan implemented throughout the various stages of development of our
group project:

## 🎬PHASE 1: Does the application start up successfully?

We incorporated the following output messages to clearly indicate if the SpringBoot app
successfully starts:
```
ConfigurableApplicationContext context = SpringApplication.run(CoffeeApp.class, args);
String serverPort = context.getEnvironment().getProperty("server.port", "8080");
System.out.println("Welcome to the Beans and Grounds Coffee store!");
System.out.println("You can see our API docs at http://localhost:" + serverPort + "/swagger-ui.html");
```
## 🛢️PHASE 2: Does the app connect to the MySQL Database?

Manual test: Use a test GET endpoint i.e. /hello in browser to call "Hello from Coffee API".

## ✉️PHASE 3: Manually test endpoints using POSTMAN:

Once we had each completed the coding for the endpoint, we each picked an endpoint by another
group member and manually tested valid, invalid and boundary inputs. We recorded anything
that did/didn't work to be used by each developer to apply robust error handling and as e.g to later use in unit testing.
Using POSTMAN, we will manually each other's endpoints to make sure they work as we would expect:

### Test Endpoint: adjustStock()
- *URL Tested:* `http://localhost:8080/products/adjustStock/1?amount=5`
- *Purpose:* Increase stock level of product with ID 1 by a specified amount.
- *Expected Result:* Stock increases from 50 → 55.
- *Actual Result:* Stock correctly adjusted to 55.

<img width="1442" height="947" alt="image" src="https://github.com/user-attachments/assets/c05814af-2252-4e29-b996-780fe114a921" />


### Test Endpoint: updateStock()
- *URL Tested:* `http://localhost:8080/products/updateStock/1?quantity=50`
- *Purpose:* Set the stock level of product with ID 1 to a specific quantity.
- *Expected Result:* Stock resets to 50.
- *Actual Result:* Stock correctly updated to 50.

<img width="1440" height="940" alt="image" src="https://github.com/user-attachments/assets/0997007c-8258-4da9-959c-89312aaaca57" />


### Test Endpoint: findByBlendTypeAndStrength()
- *URL Tested:* `http://localhost:8080/products/GROUND/3`
- *Purpose:* Search and return coffee products matching both blend and strength.
- *Expected Result:* Products with blend type `GROUND` and `Strength` 3 should be returned.
- *Actual Result:* Four matching products were successfully returned, including Colombian Gold and House Blend products with strength 3 and blend type GROUND.

<img width="1447" height="947" alt="image" src="https://github.com/user-attachments/assets/851974ed-8980-40a0-acf0-410cf052af07" />


-

### Test Endpoint: addNewProduct()
- *URL Tested:* * `http://localhost:8080/products`
- *Method* POST
- *Purpose:* To add a new coffee product to the catalogue and store it in the database.
- *Expected Result:* A new coffee product should be created successfully, saved in the database and returned with a generated product ID.
- *Actual Result:* A new product was successfully added.The API returned HTTP 201 created with the created product details,including the generated ID (61). The product was successfully stored in the MYSQL database.
- *Response*
```json
{
    "id": 61,
    "name": "Test Blend",
    "weightInGrams": 250,
    "strength": 3,
    "decaf": false,
    "price": 8.99,
    "orderTotal": 0,
    "stockTotal": 25,
    "coffeeType": "BEAN"
}
```

<img width="1438" height="951" alt="image" src="https://github.com/user-attachments/assets/7aacea70-f4ca-4e1d-a894-104ffa034efc" />


### Test Endpoint: updatePrice()

- *URL Tested:* `http://localhost:8080/products/11/price?price=14.50`
- *(Replace **11** with a valid product ID.)*
- *Purpose:* Update only the price of an existing coffee product without modifying any other product details.
- *Expected Result:* The product price is updated while all other product information remains unchanged.
- *Actual Result:* The product price was successfully updated and all remaining fields were unchanged.

<img width="1435" height="938" alt="image" src="https://github.com/user-attachments/assets/98e4eb78-1382-4629-ae42-110f6f7150da" />


### Test Endpoint: deleteProduct
-*URL Tested:* `http://localhost:8080/products/27`
- *Purpose:* Deletes a coffee product from the catalogue using its ID.
- *Expected Result:* The product with 27 should be removed and the API should return HTTP 204 No Content.
- *Actual Result:* Product with ID 27 was successfully deleted and HTTP 204 No Content was returned.

# Rough Notes for Automated Testing:
Once the manual tests above had been completed and we were satisfied that the methods all worked with the "happy paths",
we move on to creating unit testing using JUNIt and Mockito.
We first created mock database using Mockito, which is accessible globally from whichever test.
We created tests in correspondence to the endpoint methods we had each created.
We took into account: valid, invalid and boundary/edge case inputs relevant to the particular method.
Wr ran the automated tests to see if they passed or failed.
WE debug/ made amendments where the tests fail, and retest until all tests pass.
![img.png](img.png)
✔ valid inputs
✔ input normalisation (case/whitespace)
✔ invalid strings
✔ invalid strength values
✔ boundary value (5)
✔ no-results scenario
<img width="1437" height="942" alt="image" src="https://github.com/user-attachments/assets/290cf2be-72bf-4b34-8df4-8850b2c5d350" />
