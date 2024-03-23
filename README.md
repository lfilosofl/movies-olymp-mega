# How to start app
GIT repo: https://github.com/lfilosofl/movies-olymp-mega
```
./gradlew bootRun
```
# Available REST operations:

## Directors API
1. Add director
```
curl --location 'http://localhost:8080/api/directors' \
--header 'Content-Type: application/json' \
--data '{
    "director": {
        "fio": "Ivanov Petr"
    }
}'
```
Response:
```
{
    "director": {
        "id": 102,
        "fio": "Ivanov Petr"
    }
}
```

2. Update Director
```
curl --location --request PATCH 'http://localhost:8080/api/directors/102' \
--header 'Content-Type: application/json' \
--data '{
    "director": {
        "fio": "Ivanov Petr"
    }
}'
```
Response the same as for create director 
3. Delete director
```
curl --location --request DELETE 'http://localhost:8080/api/directors/102' \
--header 'Content-Type: application/json' \
--data '{
    "director": {
        "fio": "Ivanov Petr"
    }
}'
```
4. Get all directors
```
curl --location 'http://localhost:8080/api/directors'
```
Response:
```
{
    "list": [
        {
            "id": 52,
            "fio": "Ivanov Petr"
        },
        {
            "id": 53,
            "fio": "Ivanov Petr"
        },
        {
            "id": 54,
            "fio": "Ivanov Petr"
        },
        {
            "id": 55,
            "fio": "Ivanov Petr"
        },
        {
            "id": 56,
            "fio": "Ivanov Petr"
        },
        {
            "id": 57,
            "fio": "Ivanov Petr"
        },
        {
            "id": 1,
            "fio": "sdad"
        },
        {
            "id": 102,
            "fio": "Ivanov Petr"
        },
        {
            "id": 103,
            "fio": "Ivanov Petr"
        }
    ]
}
```
5. Get director by id
```
curl --location 'http://localhost:8080/api/directors/102'
```
Response:
```
{
    "director": {
        "id": 102,
        "fio": "Ivanov Petr"
    }
}
```
## Movies API
1. Add Movie
```
curl --location 'http://localhost:8080/api/movies' \
--header 'Content-Type: application/json' \
--data '{
    "movie": {
        "title:":"Movie titel",
        "year":2022,
        "length":"02:30:00",
        "rating":3,
        "director": {
            "id":1
        }
    }
}'
```

Response:
```
{
    "movie": {
        "title:":"Movie titel",
        "year":2022,
        "length":"02:30:00",
        "rating":3,
        "director": {
            "id":1,
            "fio":"Ivanov"
        }
    }
}
```
2. Update movie
```
curl --location --request PATCH 'http://localhost:8080/api/movies' \
--header 'Content-Type: application/json' \
--data '{
    "movie": {
        "title:":"Movie titel",
        "year":2022,
        "length":"02:30:00",
        "rating":3,
        "director": {
            "id":102
        }
    }
}'
```
Response the same as for create
3. Delete movie
```
curl --location --request DELETE 'http://localhost:8080/api/movies/52'
```
4. Get all movies
```
curl --location 'http://localhost:8080/api/movies'
```
Response:
```
{
    "list": [
        {
            "id": 52,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 53,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 54,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 55,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 56,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 57,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 58,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 59,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 60,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 61,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        },
        {
            "id": 62,
            "title": "sad",
            "year": 2022,
            "director": {
                "id": 1,
                "fio": "sdad"
            },
            "length": "02:30:00",
            "rating": 3
        }
    ]
}
```
5. Get movie
```
curl --location 'http://localhost:8080/api/movies/52'
```

Response:
```
{
    "movie": {
        "id": 52,
        "title": "sad",
        "year": 2022,
        "director": {
            "id": 1,
            "fio": "sdad"
        },
        "length": "02:30:00",
        "rating": 3
    }
}
```