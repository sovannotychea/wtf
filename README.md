"# wtf" 


#http://localhost:8080/api/user

{
  "_embedded" : {
    "user" : [ {
      "userName" : "tester01",
      "firstName" : "Frodo",
      "lastName" : "Baggins",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/api/user/1"
        },
        "user" : {
          "href" : "http://localhost:8080/api/user/1"
        }
      }
    }, {
      "userName" : "admin",
      "firstName" : "Sovannoty",
      "lastName" : "Chea",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/api/user/2"
        },
        "user" : {
          "href" : "http://localhost:8080/api/user/2"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/api/user"
    },
    "profile" : {
      "href" : "http://localhost:8080/api/profile/user"
    },
    "search" : {
      "href" : "http://localhost:8080/api/user/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 2,
    "totalPages" : 1,
    "number" : 0
  }
}