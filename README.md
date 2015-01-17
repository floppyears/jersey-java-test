# Jersey Java Test

Test implementation of RESTful API with Jersey and Java.


## Usage

### Get all Employees

    $ curl --request GET \
           --header "Accept: application/json" \
           --include \
           --write-out "\n" \
           http://localhost:8888/api/v1/employee

### Get Employee by ID

    $ curl --request GET \
           --header "Accept: application/json" \
           --include \
           --write-out "\n" \
           http://localhost:8888/api/v1/employee/123

### Set Employee by ID

    $ curl --request POST \
           --header "Content-Type: application/json" \
           --include \
           --data "{\"osuId\":\"987654321\"}" \
           --write-out "\n" \
           http://localhost:8888/api/v1/employee/456
