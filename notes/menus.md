# Menus

## App Bar

The purpose is to provide a dedicated space for identifying the application brand and user location.  It also provides consistent navigation and view refinement across different applications. The app bar makes key actions for the activity prominent and accessible to the user in a predictable way.

The app bar text color is determined using an AppCompat library theme. Commonly used themes include:

- `Theme.AppCompat`
- `Theme.AppCompat.Light`
- `Theme.AppCompat.Light.DarkActionBar`

## Application Menus

Menus are important part of the UI

## Menu Types

- Options
  - Accessed through the menu button or presented by the ActionBar
  - Provides actions and operations for the app's current screen
- Context
  - Accessed using a long press (usually on a list view or grid view item)
  - Brings up options related to the object pressed
- Popup
  - A modal menu anchored to a View

## Options Menu

- Override Activity's `onCreateOptionsMenu` method
- Override the `onOptionsItemSelected` method to respond to user selections

### XML Menus

- Some attributes that you can use to define an item's appearance and behavior:
  - android:id
  - android:icon
  - android:title
  - android:showAsAction
