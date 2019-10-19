# twilight-lib
A library containing essential year-to-year code. Designed by and for Team 2220.

# How to Add This Library to Your Robot Code
This library is set up with [jitpack](https://jitpack.io). To add this to your robot code, you have to add the following code snippets to the correct locations in your `build.gradle` file.

1. The first step is to **add** the following code snippet to the `repositories` code block.
```groovy
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```

2. The second step is to again, **add** the following code snippet to the `dependencies` code block.
```groovy
dependencies {
    ...
    implementation 'com.github.Team2220:twilight-lib:<exact tag name of library release>'
}
```

One final note: each time we make a significant change in the library, after it is tested, it will need to be "released" as a version on GitHub and then rewritten into the `dependencies` code block.