[![-----------------------------------------------------](
https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/aqua.png)](https://github.com/berkaypab?tab=repositories)
<br/>
# cicek.com Jmeter Load Tests


## API Request

1-)HomePage
```https
  GET ${BASE_URL_1}/
```


2-)GetLoginOrLogoutEvent
```https
  GET ${BASE_URL_1}/Ani/GetLoginOrLogoutEvent
```

3-)UserMenu
```https
  GET ${BASE_URL_1}/user-menu
```

4-)AjaxHomePageProducts
```https
  GET ${BASE_URL_1}/Product/AjaxHomePageProducts
```

5-)SuggesttedProducts
```https
  GET ${BASE_URL_1}/Suggest/Get/
```
Parameters Getting From CSV File

| Parameter | Value     | 
| :--------- | :--------- |
| `${search_keyword}` | `papatya`   | 
| `${search_keyword}` | `gül` |
| `${search_keyword}` | `bonsai` |


6-)SearchProduct
```https
  GET ${BASE_URL_1}/Arama
```
Parameters Getting From CSV File

| Parameter | Value     | 
| :--------- | :--------- |
| `${search_keyword}` | `papatya`   | 
| `${search_keyword}` | `gül` |
| `${search_keyword}` | `bonsai` |

7-)UserMenu
```https
  GET ${BASE_URL_1}/user-menu
```
8-)ListofProductsSearched
```https
  GET ${BASE_URL_1}/Catalog/AjaxCategory
```
Parameters Getting From CSV File

| Parameter | Value     | 
| :--------- | :--------- |
| `${search_keyword}` | `papatya`   | 
| `${search_keyword}` | `gül` |
| `${search_keyword}` | `bonsai` |

## Assertion Types
- Response Code Assertion
- Xpath Assertion 
- Json Assertion
![](sc1.png)


## Tests
#### reviewDtos response type check

- reviewDtos.name typeof==string 
- reviewDtos.comment typeof==string 
- reviewDtos.rating typeof==integer
- reviewDtos.createOn typeof==string
- reviewDtos.regionName typeof==string
- reviewDtos.cityName typeof==string

#### reviewDtos instance size should be 6

- is reviewDtos object size equal to 6 ? 

#### reviewDtos cityName check 

- is reviewDtos cityName value euqal to {cityName} parameter ?

#### reviewDtos rating check

- is reviewDtos rating range between 0-10 ?

#### Response time check
- is Response time is less than 200ms ?

2-) 
```http
  GET baseURL/?cityName=van
```


| Parameter  | Value     | 
| :--------  | :-------- |
| `cityName` | `van`     | 


#### Response status code check
- is Response code value 404 ?
#### Message value check
- is message value equal to 'Not found' ?
#### Response object contains
- is response object equal to given structure "message": "Not found" ?
#### Response time check
- is Response time less then 1000ms ?

3-)
```http
  GET baseURL/?cityName=
```
| Parameter | Value    | 
| :-------- | :------- |
| `cityName`|          | 

#### response status code check
- is Response status code 400 ?
#### cityName value check
- cityName value equal to 'cityName' can not be null.'  ?
#### Response object contains
- is response object equal to given structure "cityName": ["'cityName' can not be null."] ?
#### Response time check
- is Response time less then 1000ms ?

## Test Results
[![-----------------------------------------------------](
https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/aqua.png)](https://github.com/berkaypab?tab=repositories)
<br/>
# SUMMARY
![](newman/Screenshot_1.png)

# TOTAL REQUESTS
![](newman/Screenshot_2.png)

# FAILED TESTS
![](newman/Screenshot_3.png)

[![-----------------------------------------------------](
https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/aqua.png)](https://github.com/berkaypab?tab=repositories)
<br/>
