# Preferences extension
Preferences extension is a library that simplifies the use and extends the capabilities of SharedPreferences.
With this library, using SharedPreferences has become much easier, saving and getting data is implemented using extensions.

# Advantages
In this library, saving and getting is carried out using extensions, which makes it easier to SharedPreferences.
The Preferences extension also allows you to store lists, arrays, and more.


# Install
To install the library you need to add the JitPack repository to your build file:

```Groovy DSL
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}

```
And also add the dependency to build.gradle:

```Groovy DSL
implementation 'com.github.Logcat78:preferences-extension:1.0.4'
```

# Supported data types

- Int
- Short
- Long
- Boolean
- String
- Set
- List
- ArrayList
- MutableList


# Basic usage
```kotlin
// Save data
val text = "text"
text.saveData("your-key", context, "your-preferences")
```
```kotlin
// Get data
val text = "".getData("your-key", context, "your-preferences")
```


# Async data saving
The library supports async saving of data from Shared Preferences

```kotlin
// Save data
val text = "text"
text.asyncSaveData("your-key", this, "your-preferences")
```

# Using configurations
In this library, you can use configurations to customize the use of preferences.
In the configuration list, you must specify the following parameters

- Context
- Preferences name
- Context mode
- Async status

The configuration is created using a list:

```kotlin
// Create a configuration
val config: List<Any> = listOf(
            this,
            "your-preferences",
            Context.MODE_PRIVATE,
            true
        )
```
After that, you can save and get data.

```kotlin
// Save data
val text = "text"
text.saveDataWithConfig(config, "your-key")
```

```kotlin
// Get data
val text = "text"
text.getDataWithConfig(config, "your-key")
```

# Logging

