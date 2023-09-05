# Preferences extension
Preferences extension is a library that simplifies the use and extends the capabilities of SharedPreferences.
With this library, using SharedPreferences has become much easier, saving and getting data is implemented using extensions.

Let's see how it works with a simple example 😉:

```kotlin
// Save data
val text = "text"
text.saveData("your-key", this, "your-preferences")
```
```kotlin
// Get data
val text = "text"
text.getData("your-key", this, "your-preferences")
