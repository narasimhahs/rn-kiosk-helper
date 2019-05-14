
# react-native-kiosk-helper

## Getting started

`$ npm install react-native-kiosk-helper --save`

### Mostly automatic installation

`$ react-native link react-native-kiosk-helper`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-kiosk-helper` and add `RNKioskHelper.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNKioskHelper.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

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

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNKioskHelper.sln` in `node_modules/react-native-kiosk-helper/windows/RNKioskHelper.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Kiosk.Helper.RNKioskHelper;` to the usings at the top of the file
  - Add `new RNKioskHelperPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNKioskHelper from 'react-native-kiosk-helper';

// TODO: What to do with the module?
RNKioskHelper;
```
  