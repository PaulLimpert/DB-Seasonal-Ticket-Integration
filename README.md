# Seasonal Ticket Integration for Deutsche Bahn connections
This project is a **Java Spring Boot application** which integrates any seasonal ticket (eg. the "**Deutschlandticket**" or any **Semester ticket**) into **Deutsche Bahn connection searches**. It helps users to determine which additional tickets are required to purchase based on the selected seasonal tickets the user owns. 


## Features
#### Currently implemented
Search for connections by selected one or multiple of these seasonal tickets:
- **Deutschlandticket**
- **Semester ticket**

#### Upcoming
The additinal search-modes `DAILY` and `PERIODIC` are being worked on and soon to be added.
- `DAILY` : Scanning every connection for an entire given day.
- `PERIODIC` : Scanning every connection for an entire time frame.


## Prerequisites
Heres what you need to run the application:
- **Java version 23** or higher.
- A **Maven** build tool.

## API Reference

When running, the application acts as an **REST-API** with the following endpoints:
1. **GET /** 
- **Description**: Returns a friendly welcome message.
- **Response**: A simple string with the welcome message.

2. **POST /search** 
- **Description**: Accepts a search request and returns the calculated connection results based on the provided seasonal ticket details.
- **Request Body**: Must conform to the `FahrplanResponse.java` model.
- **Response**: The search results are formatted as the `SearchResponse.java` model.

## How to add new seasonal tickets
Implementing any new seasonal ticket(for example a semester ticket) is very easy, you can do so by following these steps:


1. Create a new class that implements the `SeasonalTicket` interface.
2. Override the `validateStop()` method and implement the logic for the new seasonal ticket. (Look at the `SemesterTicketMarburg` as an example for this implementation)
## Known issues (Work in progress)
This project is very much work in progress. There are a lot of features in need of improvement, or even to be added.

Heres a list of all the known issues or missing features so far:
- **Missing search-modes**: There are two missing search-modes: `DAILY` and `PERIODIC`, they are being worked on. Until the rate limiting isnt implemented there are too many cases where the error occures on these modes. 
- **Exception handler**: Some exceptions(eg. `TrainNotFoundException`) arent handled via the `GlobalExceptionHandler` yet, that needs to be changed.
- **Rate limiting**: When too many connections are requested by the `ExternalApiClient` it receives a `429 TOO_MANY_REQUESTS`. To fix this issue rate limiting needs to be implemented aswell as an better retry mechanism.
- **Missing documentation**: Some classes are in need of better or additinal documentation.
- **Missing tests**: Tests needs to be added for different scenarios.


If you found an issue thats not in here you can help by making a pull request or opening an issue.
## Contributing

If you want to contribute to this project, first of all thank you!
At [Known issues](#known-issues-work-in-progress) you can find some issues which needs to be worked on, maybe you are the one who can fix them.


## License

[Apache-2.0](https://www.apache.org/licenses/LICENSE-2.0)

