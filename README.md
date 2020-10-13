# JavaFX performance test using FXGL

Based on this blog post ["Getting started with FXGL game development"](https://webtechie.be/post/2020-05-07-getting-started-with-fxgl/)

![Default 50 dots](screenshot/50dots.png)

## Build

```
$ mvn clean package
```

## Run

```
$ cd target/distribution
$ java --module-path . --module be.webtechie.performancetest/be.webtechie.performancetest.App $@
```

By providing a number argument, the number of dots can be defined at startup. Default value is 50.

![250 dots](screenshot/250dots.png)
![5 dots](screenshot/5dots.png)