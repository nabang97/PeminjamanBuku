# PeminjamanBuku

## User Service End Point 
/api/registration
```
{
    "identityNumber" : (string),
    "subDistrictHome": (string),
    "maritalStatus": (string),
    "addressHome": (String),
    "gender": (int),
    "password": (string),
    "role": (string),
    "dateOfBirth": (string),
    "fullName": (string),
    "placeOfBirth": (string),
    "phoneNumber": (string),
    "zipCodeHome": (int),
    "lastEducation": (int),
    "cityHome": (string),
    "email":(string),
    "villageHome": (string)
}
```

/signin
```
{
    "username": (string),
    "password" : (string)
}
```

## Borrow Service End Point 
/book/add
```
{ 
 "title" : (string)
 "code" :(string)
 "writer" :(int)
 "publisher" : (int)
 "publishCity" :  (string)
 "pagesNumber": (int)
 "stock" : (int) 
 "bookType" : (int)
 "bookshelf : (int)
 "publishYear : (int)
 "publishMonth  : (int)
```

/api/borrownow
```
{
    "member" : (string),
    "books" : (string[])
}
```
