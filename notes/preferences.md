# Shared Preferences

## Saving State

The state of an Android activity is

- the property values of the controls currently displayed
- any other information required to get the activity back to its current condition

State information is lost when the activity is closed or when the screen is rotated

Two options for saving state information

- Store data only for application lifetime  by saving to the instance state bundle
- Store data between application instances by using shared preferences

### Persistent Storage

This data is written to the database on the device and is available all the time.

Data storage options:

- Shared Preferences
- Internal storage (app specific)
- External storage (shared)
- Local database
- Cloud

[Android Developer - Storage Options](https://developer.android.com/guide/topics/data/data-storage.html)

### SharedPreferences

SharedPreferences allows you to save and retrieve persistent key-value pairs of primitive data types.

Two methods are used to create or access a preferences file.

- `getSharedPreferences()`   opens or creates a preference file using a given filename (used multiple preferences files)
- `getPreferences()` opens or creates a default preference file (single preferences file)

## Application Settings

Using Android's [Preference API](https://developer.android.com/guide/topics/ui/settings.html) simplifies saving user application preferences
