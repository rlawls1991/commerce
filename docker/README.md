# 리뷰 도커
* mysql:5.7 (master/slave)
* redis:5.0 (cluster)
* mongo:4.2

# 도커 실행
* Intel CPU
```
$docker-compose up
```
* M1 CPU
```
$docker-compose -f docker-compose-m1.yaml up
```

# 몽고DB 샘플
```
$docker exec -it {container ID of mongo} /bin/bash
$mongo -u root -p 1234

show dbs
use test
db
db.createCollection("ep_review")
db.createUser({
user:"coupon_review_dev",
pwd:"coupon123!@#",
roles:["readWrite","userAdmin"]
})
```

