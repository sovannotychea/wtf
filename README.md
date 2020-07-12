"# wtf" 

## All API

curl -v http://localhost:8080/api

```
{
  "_links" : {
    "shop" : {
      "href" : "http://localhost:8080/api/shop{?page,size,sort}",
      "templated" : true
    },
    "category" : {
      "href" : "http://localhost:8080/api/category{?page,size,sort}",
      "templated" : true
    },
    "customer" : {
      "href" : "http://localhost:8080/api/customer{?page,size,sort}",
      "templated" : true
    },
    "deliver" : {
      "href" : "http://localhost:8080/api/deliver{?page,size,sort}",
      "templated" : true
    },
    "item" : {
      "href" : "http://localhost:8080/api/item{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/api/profile"
    }
  }

```

## browser

http://localhost:8080/api/browser/index.html#/api


##TODO: 02 a.




##TODO: 02 b.

curl -i -X POST -H "Content-Type:application/json" -d '{ "userName" : "test" , "phoneNumber":"011202074" }' http://localhost:8080/api/customer


##TODO: 03

```
http://localhost:8080/api/item/search/findByNameContainingIgnoreCase?name=sendwich
```





## License
[MIT](https://choosealicense.com/licenses/mit/)
