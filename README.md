# Redis demonstration with Spring Boot (+ Redis cli commands)


# Used technologies:
* Java 1.8
* Spring Framework (Spring Boot)
* Redis
* Jedis (other libs for handling Redis: https://redis.io/clients#java)
* Maven


# Redis commands
##### Run Redis server:
    redis-server
##### Run command line interface
    redis-cli
    
##### By default, Redis starts on 127.0.0.1:6379 port

### Redis-cli basic data types examples:
    Mikheils-MacBook-Pro:~ misho$ redis-cli
    127.0.0.1:6379> set first "Hello World!"
    OK
    127.0.0.1:6379> get first
    "Hello World!" 
    127.0.0.1:6379> keys *
    1) "first"
    127.0.0.1:6379> set second "Hello BOG!"
    OK
    127.0.0.1:6379> keys *
    1) "second"
    2) "first"
    127.0.0.1:6379> del first
    (integer) 1
    127.0.0.1:6379> keys *
    1) "second"
    127.0.0.1:6379> BGSAVE
    Background saving started
    127.0.0.1:6379> set name misho
    OK
    127.0.0.1:6379> set age 24
    OK
    127.0.0.1:6379> get name
    "misho"
    127.0.0.1:6379> get age
    "24"
    127.0.0.1:6379> incr age
    (integer) 25
    127.0.0.1:6379> incrby age 10
    (integer) 35
    127.0.0.1:6379> set name "tmp" EX 5
    OK
    127.0.0.1:6379> ttl name
    (integer) 3
    127.0.0.1:6379> ttl name
    (integer) -2
    127.0.0.1:6379> ttl name

### Redis Publish Subscribe
Subscribing:

    127.0.0.1:6379> SUBSCRIBE test_redis
    Reading messages... (press Ctrl-C to quit)
    1) "subscribe"
    2) "test_redis"
    3) (integer) 1
    1) "message"
    2) "test_redis"
    3) "Hello Test Channel"
    
Publishing:

    Mikheils-MacBook-Pro:~ misho$ redis-cli
    127.0.0.1:6379> PUBLISH test_redis "Hello Test Channel"
    (integer) 1
