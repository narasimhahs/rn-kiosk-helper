
# react-native-kiosk-helper

## Getting started

`$ npm install react-native-kiosk-helper --save`

### Mostly automatic installation

`$ react-native link react-native-kiosk-helper`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNKioskHelperPackage;` to the imports at the top of the file
  - Add `new RNKioskHelperPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-kiosk-helper'
  	project(':react-native-kiosk-helper').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-kiosk-helper/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-kiosk-helper')
  	```

## Usage
```javascript
import RNKioskHelper from 'react-native-kiosk-helper';

// TODO: What to do with the module?
RNKioskHelper;
```
  
