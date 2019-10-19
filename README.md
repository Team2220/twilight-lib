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
    implementation('com.github.Team2220:twilight-lib:master-SNAPSHOT') {
        changing = true
    }
}
```

3. The third step is to **add** the following code snippet to the `build.gradle` file. A good place to put this is in between the repositories and dependencies code blocks.
```groovy
configurations.all {
    resolutionStrategy.cacheChangingModulesFor 0, 'seconds'
}
```

One final note: every time you build your robot code, this repository will refresh. If changes are found, it will be redownloaded into your project. So, any changes that occur in the library will be downloaded on build time. This may seem inconvenient. However, once build season rolls around the library should be largely perfected and not change often.