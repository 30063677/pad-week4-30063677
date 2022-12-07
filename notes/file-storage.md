# Persistant File Storage

## Internal and external storage

Android apps may save text or binary data to files in two general storage areas:

- Internal storage is the device's internal, physical storage area.
- External storage is memory storage on an SD card or USB device.

Internal storage is generally much smaller than external storage, but internal storage is always available. Apps are stored on internal storage by default.

Android apps that target Android 10 (API level 29) or above are granted scoped storage by default. Scoped storage is a directory on internal or external storage where an app can read and write files only accessible to the app. When the user uninstalls an app, the app's scoped storage on internal and external storage is removed as well.

### Saving to internal storage

Two Context methods are used to write and read from internal storage:

- The Context method `openFileOutput()` opens a private output file in the app's internal directory and returns a `FileOutputStream`.
  - The method throws a SecurityException if the second argument is not `Context.MODE_PRIVATE`.
- The Context method `openFileInput()` opens a private input file in the app's internal directory and returns a `FileInputStream`.
  - The method throws a `FileNotFoundException` if the file does not exist.

The Device File Explorer shows the files written to the device in the /data/data/packagename/files directory.

Reading and writing to files can potentially take a second or more when an Android device is busy doing lots of reads and writes to the file system. Good practice is to read and write to files on a background thread to keep the UI thread responsive during periods of heavy file system use.
