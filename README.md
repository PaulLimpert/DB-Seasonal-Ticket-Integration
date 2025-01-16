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
At [Known issues](#known-issues--work-in-progress-) you can find some issues which needs to be worked on, maybe you are the one who can fix them. If you have some new features on your mind feel free to make an pull request aswell.


## API Reference

When running, the application acts as an **REST-API** with the following endpoints:
1. **GET /** 
- **Description**: Returns a friendly welcome message.
- **Response**: A simple string with the welcome message.

2. **POST /search** 
- **Description**: Accepts a search request and returns the calculated connection results based on the provided seasonal ticket details.
- **Request Body**: Must conform to the `FahrplanResponse.java` model.
- **Response**: The search results are formatted as the `SearchResponse.java` model.

## Example Request/Response

#### Request Body:
```json
{
  "API_KEY": "abc123key",
  "searchMode": "STANDARD",
  "origin": "Hamburg Hbf",
  "destination": "Frankfurt(Main)Hbf",
  "specificTime": "2025-24-02T10:00:00",
  "specificDay": null,
  "fromDate": null,
  "toDate": null,
  "klasse" : "KLASSE_2",
  "ankunftSuche": "ABFAHRT",
  "passengers": [
    {
      "typ": "JUGENDLICHER",
      "ermaessigungen": [
        {
          "art": "BAHNCARD50",
          "klasse": "KLASSE_2"
        }
      ],
      "alter": [],
      "anzahl": 1
    }
  ],
  "seasonalTickets": [
    "DEUTSCHLAND_TICKET",
    "UMR_TICKET"
  ],
  "nurDeutschlandTicketVerbindungen": false,
  "produktgattungen": ["ICE", "EC_IC", "REGIONAL"],
  "maxUmstiege": 3
}
```

#### Response Body:
```json
{
    "requestAt": "2025-01-15T19:18:43.986504",
    "responseAt": "2025-01-15T19:18:45.74087",
    "connections": [
        {
            "tripId": "a8e730e9_3",
            "umstiegsAnzahl": 1,
            "verbindungsDauerInSeconds": 13860,
            "angebotsPreis": {
                "betrag": 20.99,
                "waehrung": "EUR"
            },
            "tickets": [
                {
                    "tripId": "ec0663d8_3",
                    "umstiegsAnzahl": 0,
                    "verbindungsDauerInSeconds": 8400,
                    "angebotsPreis": {
                        "betrag": 14.99,
                        "waehrung": "EUR"
                    },
                    "tickets": null,
                    "totalPrice": 0.0,
                    "sections": [
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T10:01:00",
                            "abfahrtsOrt": "Hamburg Hbf",
                            "abschnittsDauer": 8400,
                            "abschnittsAnteil": 100.0,
                            "ankunftsZeitpunkt": "2025-01-22T12:21:00",
                            "ankunftsOrt": "Kassel-Wilhelmshöhe",
                            "verkehrsmittel": {
                                "produktGattung": "ICE",
                                "name": "ICE 787",
                                "richtung": "München Hbf"
                            },
                            "stops": [
                                {
                                    "abfahrtsZeitpunkt": "2025-01-22T10:01:00",
                                    "gleis": "14",
                                    "name": "Hamburg Hbf"
                                },
                                {
                                    "abfahrtsZeitpunkt": "2025-01-22T10:13:00",
                                    "gleis": "4",
                                    "name": "Hamburg-Harburg"
                                },
                                {
                                    "abfahrtsZeitpunkt": "2025-01-22T11:26:00",
                                    "gleis": "3",
                                    "name": "Hannover Hbf"
                                },
                                {
                                    "abfahrtsZeitpunkt": "2025-01-22T12:02:00",
                                    "gleis": "10",
                                    "name": "Göttingen"
                                },
                                {
                                    "abfahrtsZeitpunkt": null,
                                    "gleis": "2",
                                    "name": "Kassel-Wilhelmshöhe"
                                }
                            ]
                        }
                    ]
                }
            ],
            "totalPrice": 14.99,
            "sections": [
                {
                    "abfahrtsZeitpunkt": "2025-01-22T10:01:00",
                    "abfahrtsOrt": "Hamburg Hbf",
                    "abschnittsDauer": 8400,
                    "abschnittsAnteil": 62.78,
                    "ankunftsZeitpunkt": "2025-01-22T12:21:00",
                    "ankunftsOrt": "Kassel-Wilhelmshöhe",
                    "verkehrsmittel": {
                        "produktGattung": "ICE",
                        "name": "ICE 787",
                        "richtung": "München Hbf"
                    },
                    "stops": [
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T10:01:00",
                            "gleis": "14",
                            "name": "Hamburg Hbf"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T10:13:00",
                            "gleis": "4",
                            "name": "Hamburg-Harburg"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T11:26:00",
                            "gleis": "3",
                            "name": "Hannover Hbf"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T12:02:00",
                            "gleis": "10",
                            "name": "Göttingen"
                        },
                        {
                            "abfahrtsZeitpunkt": null,
                            "gleis": "2",
                            "name": "Kassel-Wilhelmshöhe"
                        }
                    ]
                },
                {
                    "abfahrtsZeitpunkt": "2025-01-22T12:29:00",
                    "abfahrtsOrt": "Kassel-Wilhelmshöhe",
                    "abschnittsDauer": 4980,
                    "abschnittsAnteil": 37.22,
                    "ankunftsZeitpunkt": "2025-01-22T13:52:00",
                    "ankunftsOrt": "Gießen",
                    "verkehrsmittel": {
                        "produktGattung": "REGIONAL",
                        "name": "RE 4159",
                        "richtung": "Frankfurt(Main)Hbf"
                    },
                    "stops": [
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T12:29:00",
                            "gleis": "7",
                            "name": "Kassel-Wilhelmshöhe"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T12:49:00",
                            "gleis": "4",
                            "name": "Wabern(Bz Kassel)"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T12:55:00",
                            "gleis": "2",
                            "name": "Borken(Hess)"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T13:07:00",
                            "gleis": "1",
                            "name": "Treysa"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T13:13:00",
                            "gleis": "2",
                            "name": "Neustadt(Kr Marburg)"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T13:21:00",
                            "gleis": "1",
                            "name": "Stadtallendorf"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T13:26:00",
                            "gleis": "1",
                            "name": "Kirchhain(Bz Kassel)"
                        },
                        {
                            "abfahrtsZeitpunkt": "2025-01-22T13:36:00",
                            "gleis": "4",
                            "name": "Marburg(Lahn)"
                        },
                        {
                            "abfahrtsZeitpunkt": null,
                            "gleis": "3",
                            "name": "Gießen"
                        }
                    ]
                }
            ]
        }
    ]
}
```


## License

[MIT](https://choosealicense.com/licenses/mit/)
